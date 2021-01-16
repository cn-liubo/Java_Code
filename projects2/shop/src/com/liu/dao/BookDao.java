package com.liu.dao;

import com.liu.entity.Book;
import com.liu.entity.BuyBook;
import com.liu.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    JdbcUtil util = new JdbcUtil();
    //查询所有书籍
    public List find() {
        String sql = "select * from book";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            rs = ps.executeQuery();
            while(rs.next()) {
                Integer bookId = rs.getInt("id");
                String bookName = rs.getString("bookname");
                Integer price = rs.getInt("price");
                Integer number = rs.getInt("number");
                Book book = new Book(bookId, bookName, price, number);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return list;
    }

    //将书籍加入购物车
    public int add(String bookId) {

        String sql1 = "insert into buy_book(id, bookname, totalprice, number) value(?, ?, ?, ?)";//将book信息添加到buy_book中
        String sql2 = "update buy_book set totalprice=?, number=? where id=?";//更新buy_book表中的totalprice和number
        //String sql3 = "update book set number=? where id=?";//更新book表中的number
        int result = 0;
        int number = 0;

        //将buy_book表中的number拿出来
        List<BuyBook> books = this.check();
        for(int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == Integer.parseInt(bookId)) {
                if(books.get(i).getNumber() == 0) {
                    number = 0;
                    break;
                }else {
                    number = books.get(i).getNumber();
                    break;
                }
            }
        }

        //将book信息添加到buy_book表中
        Book book = null;
        List<Book> list = this.find();
        for(int i = 0; i < list.size(); i++) {
            if(Integer.parseInt(bookId) == (list.get(i).getId())) {
                book = new Book(list.get(i).getId(), list.get(i).getBookName(), list.get(i).getPrice(), list.get(i).getNumber());
                break;
            }
        }
        try {
            if(number == 0) {
                PreparedStatement ps = util.createStatement(sql1);
                ps.setInt(1, book.getId());
                ps.setString(2, book.getBookName());
                ps.setInt(3, book.getPrice());
                ps.setInt(4, ++number);
                result = ps.executeUpdate();
            }else {
                PreparedStatement ps = util.createStatement(sql2);
                ps.setInt(1, book.getPrice() * (++number));
                ps.setInt(2, number);
                ps.setString(3, bookId);
                result = ps.executeUpdate();
            }
            this.subtract(bookId, 1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
    //book表中将bookId的书的数量减少
    public int subtract(String bookId, int number) {
        String sql = "update book set number=? where id=?";
        List<Book> bookList = this.find();
        int result = 0;
        int count = 0;
        for(int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getId() == Integer.parseInt(bookId)) {
                count = bookList.get(i).getNumber();
            }
        }

        try {
            PreparedStatement ps = util.createStatement(sql);
            ps.setInt(1, count - number);
            ps.setString(2, bookId);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //查看购物车
    public List check() {
        String sql = "select * from buy_book";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            rs = ps.executeQuery();
            while(rs.next()) {
                Integer bookId = rs.getInt("id");
                String bookName = rs.getString("bookname");
                Integer totalPrice = rs.getInt("totalprice");
                Integer number = rs.getInt("number");
                BuyBook buyBook = new BuyBook(bookId, bookName, totalPrice, number);
                list.add(buyBook);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return list;
    }
}
