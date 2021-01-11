package com.liu.dao;

import com.liu.entity.Idiom;
import com.liu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdiomDao {

    JdbcUtil util = new JdbcUtil();
    public List<Idiom> queryIdiom() {


        String sql = "select from idiom";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List<Idiom> list = new ArrayList<Idiom>();
        Idiom idiom = null;

        try {
            rs = ps.executeQuery();
            while(rs.next()) {
                Integer id = rs.getInt("id");
                String pinyinE = rs.getString("pinyinE");
                String pinyinS = rs.getString("pinyinS");
                String value = rs.getString("value");
                String wordE = rs.getString("wordE");
                String wordS = rs.getString("wordS");
                String paraphrase = rs.getString("paraphrase");
                idiom = new Idiom(id, pinyinE, pinyinS, value, wordE, wordS, paraphrase);
                list.add(idiom);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return list;
    }
}

