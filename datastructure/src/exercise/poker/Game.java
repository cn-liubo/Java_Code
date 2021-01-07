package exercise.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        //5名玩家，使用List
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("黎明"));
        playerList.add(new Player("郭富城"));
        playerList.add(new Player("张学友"));


        //List作为线性表，表现生活中很多有前后关系的物品都可以
        List<Card> cardList = new ArrayList<>();

        //初始化扑克牌
        initializedCards(cardList);


        //调用Collections下的shuffle（洗牌）方法
        //进行洗牌
        Collections.shuffle(cardList);
        System.out.println("抽牌前，牌组中的牌：");
        System.out.println(cardList);
        System.out.println(cardList.size());

        //发牌
        int n = 4;//每名玩家发几张牌
        for(int i = 0; i < n; i++) { //一共发4轮牌
            for(Player player : playerList) { //每名玩家依次抽牌
                //从牌组中，抽一张牌出来
                Card card = cardList.remove(0);

                //把这张牌放到当前玩家的手中
                player.cardList.add(card);
            }
        }

        System.out.println("抽牌后，牌组中剩余的牌：");
        System.out.println(cardList);
        System.out.println(cardList.size());

        System.out.println("交换牌之前：");
        printPlayerHandCardList(playerList);

        //winFaGe(playerList);
        changeCard(new Card("♠", 1), playerList);
        System.out.println("发哥第一次发功之后：");
        printPlayerHandCardList(playerList);


        Random random = new Random();
        //交换牌
        //每名玩家抽取其下一家一张随机的手牌
        for(int i = 0; i < playerList.size(); i++) {
            Player currentPlayer = playerList.get(i);
            //下家就是按照前后关系的下一个，最后一名玩家抽取第0个
            Player nextPlayer = playerList.get(i != playerList.size() - 1 ? i + 1 : 0);

            //要取的牌的下标
            int toDrawIndex = random.nextInt(nextPlayer.cardList.size());
            //取牌
            Card drawCard = nextPlayer.cardList.remove(toDrawIndex);
            //放入当前玩家手中
            currentPlayer.cardList.add(drawCard);
        }

        System.out.println("交换牌之后");
        printPlayerHandCardList(playerList);

        //winFaGe(playerList);
        changeCard(new Card("♠", 1), playerList);
        System.out.println("发哥第二次发功之后：");
        printPlayerHandCardList(playerList);

        //要找的牌
        Card toFoundCard = new Card("♠", 1);
        for(Player player : playerList) {
            /*for(Card card : player.cardList) {
                //比较每张牌和要找的那张牌是否是同一张牌
                if(card.equals(toFoundCard)) {
                    System.out.println(player.name + "获胜");
                    return;
                }
            }*/

            if(player.cardList.indexOf(toFoundCard) != -1) {
            //if(player.cardList.contains(toFoundCard)) {
                System.out.println(player.name + "获胜");
                return;
            }
        }
        System.out.println("无人获胜");
    }


    //升级换牌
    //如果发哥手中没有黑桃A，则发哥把自己的第一张牌和手中有黑桃A的玩家的黑桃A交换
    public static void changeCard(Card toFoundCard, List<Player> playerList) {
        for(Player player : playerList) {
            if(player.name.equals("周润发")) {
                if(!player.cardList.contains(toFoundCard)) {
                    Card card = player.cardList.get(0);
                    player.cardList.set(0, toFoundCard);

                    //找寻手中有黑桃A的玩家替换
                    for(int i = 1; i < playerList.size(); i++) {
                        if(playerList.get(i).cardList.contains(toFoundCard)) {
                            //下标为i的玩家持有黑桃A
                           /*playerList.get(i).cardList.remove(toFoundCard);
                            playerList.get(i).cardList.add(card);*/

                           int index = playerList.indexOf(toFoundCard);
                            playerList.get(i).cardList.set(index, card);
                        }
                    }
                }
            }
        }
    }

    //实现周润发的功能
    //现在判断周润发手上是否有黑桃A，如果没有则把第一张牌换成黑桃A
    public static void winFaGe(List<Player> playerList) {
        Card card = new Card("♠", 1);
        for(Player player : playerList) {
            if(player.name.equals("周润发")) {
                if(player.cardList.contains(card)) {
                    return;
                } else {
                    player.cardList.set(0, card);
                }
            }
        }
    }

    public static void printPlayerHandCardList(List<Player> playerList) {
        for(Player player : playerList) {
            System.out.printf("玩家[%s]的手牌是：%s%n", player.name, player.cardList);
        }
    }

    private static void initializedCards(List<Card> cards) {
        for(String suit : new String[]{"♠", "♥", "♦", "♣"}) {
            for(int rank = 1; rank <= 5; rank++) {
                Card card = new Card(suit, rank);

                //把扑克牌放入牌组中
                cards.add(card);
            }
        }
    }


}
