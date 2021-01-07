package exercise.poker2;

import java.util.*;

public class Game {

    public static void main(String[] args) {
        List<Player> playerList = initializedPlayer();

        List<Card> cardList = initializedCard();
        Collections.shuffle(cardList);
        //System.out.println(cardList);

        drawCard(playerList, cardList);
        System.out.println("摸牌之后");

        printPlayerHandCardList(playerList);

        //把没有手牌的玩家去掉
        Iterator<Player> it = playerList.iterator();
        while(it.hasNext()) {
            Player next = it.next();
            if(next.cardList.isEmpty()) {
                it.remove();
            }
        }
        /*System.out.println("开始游戏之前");
        System.out.println(playerList);*/

        Scanner scanner = new Scanner(System.in);
        //开始游戏
        Random random = new Random();
        while(true) {
            if(playerList.size() == 1) {
                //退出while循环
                break;
            }

            //每名玩家抽取下家的牌
            for(int i = 0; i < playerList.size(); i++) {
                //只剩一名玩家就可以结束
                if(playerList.size() == 1) {
                    //退出for循环
                    break;
                }
                Player current = playerList.get(i);
                int nextIndex = i == playerList.size() - 1 ? 0 : i + 1;
                Player next = playerList.get(nextIndex);
                //current随机抽取next的一张手牌
                int randomIndex = random.nextInt(next.cardList.size());

                System.out.println("目前在游戏中的玩家有：");
                printPlayerHandCardList(playerList);
                scanner.nextLine();
                //先把牌抽出来
                Card card = next.cardList.remove(randomIndex);
                System.out.println(current.name + "抽了" + next.name + "一张牌：" + card);

                //如果下家的手牌为空了，下家为空
                if(next.cardList.isEmpty()) {
                    playerList.remove(nextIndex);
                }

                //尝试把抽出来的牌，加入当前玩家手中，如果有对子，不用加
                boolean flag = true;
                Iterator<Card> it2 = current.cardList.iterator();
                while(it2.hasNext()) {
                    if(it2.next().equalsRank(card)) {
                        it2.remove();
                        flag = false;
                    }
                }
                if(flag) {
                    current.cardList.add(card);
                }
                //如果当前玩家手牌为空，退出循环
                if(current.cardList.isEmpty()) {
                    playerList.remove(i);
                    //由于for循环上有个i++，又因为删除导致之后的元素下标提前了一个
                    //所以先把i - 1
                    i = i - 1;
                }
            }
        }
        System.out.println(playerList);
    }

    private static void drawCard(List<Player> playerList, List<Card> cardList) {
        while(true) {
            //每轮都是依次抽牌
            for(Player player : playerList) {
                if(cardList.isEmpty()) {//cardList.size() == 0
                    //唯一的出口
                    return;
                }

                //抽一张牌
                Card card = cardList.remove(0);

                //把牌插入手牌之前，先判断有没有对子
                boolean flag = true;//是否需要把card加入手牌
                Iterator<Card> it = player.cardList.iterator();
                while(it.hasNext()) {
                    Card everyCard = it.next();
                    if(everyCard.equalsRank(card)) {
                        it.remove();
                        flag = false;
                    }
                }
                if(flag == true) {
                    player.cardList.add(card);
                }
            }
        }
    }

    public static void printPlayerHandCardList(List<Player> playerList) {
        for(Player player : playerList) {
            System.out.printf("玩家[%s]的手牌是：%s%n", player.name, player.cardList);
        }
    }

    private static List<Player> initializedPlayer() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("黎明"));
        playerList.add(new Player("郭富城"));
        playerList.add(new Player("张学友"));
        return playerList;
    }

    private static List<Card> initializedCard() {
        List<Card> cardList = new ArrayList<>();
        for(String suit : new String[]{"♠", "♥", "♦", "♣"}) {
            for(int rank = 1; rank <= 5; rank++) {
                cardList.add(new Card(suit, rank));
            }
        }
        //删掉黑桃A
        cardList.remove(0);
        return cardList;
    }
}
