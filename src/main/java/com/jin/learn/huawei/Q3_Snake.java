package com.jin.learn.huawei;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q3_Snake {


    public static class Snake {
        public static class Node{
            int x;
            int y;
        }


        public LinkedList<Node> body;




        public Snake(int x,int y){
            this.body = new LinkedList<>();
            Node node = new Node();
            node.x = x;
            node.y = y;
            body.add(node);
        }


        public boolean checkPositionIsSafe(int x,int y){
            for (Node node:body){
                if (node.x == x && node.y == y){
                    return false;
                }
            }
            return true;
        }


        public void eat(int x, int y) {
            Node node = new Node();
            node.x = x;
            node.y = y;
            body.addFirst(node);
        }


        public void move(int x, int y){
            int preX = x;
            int preY = y;
            for (Node node:body){
                int tmpX = node.x;
                int tmpY = node.y;
                node.x = preX;
                node.y = preY;
                preX = tmpX;
                preY = tmpY;
            }
        }


    }


    public int solution(char[][] map, String movement) {


        List<String> movementSteps = Arrays.asList(movement.split(" "));


        // init snake
        int x =0;
        int y = 0;

        for (int i=0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'H') {
                    x = i;
                    y = j;
                }
            }
        }

        Snake snake = new Snake(x, y);

        int directionX = 0;
        int directionY = 0;
        for (String step : movementSteps) {
            if (step.equals("U")) {
                directionX = -1;
                directionY = 0;
            } else if (step.equals("D")) {
                directionX = 1;
                directionY = 0;
            } else if (step.equals("L")) {
                directionX = 0;
                directionY = -1;
            } else if (step.equals("R")) {
                directionX = 0;
                directionY = 1;
            } else if (step.equals("G")){
                x = x + directionX;
                y = y + directionY;

                if (x > map.length - 1 || x < 0 || y > map[0].length - 1 || y < 0) {
                    return snake.body.size();
                }



                boolean isSafe = snake.checkPositionIsSafe(x, y);
                if (!isSafe) {
                    return snake.body.size();
                }
                if (map[x][y] == 'F') {
                    snake.eat(x, y);
                    map[x][y] = 'H';
                } else {
                    snake.move(x, y);
                }
            }


        }

        return snake.body.size();

    }


    @Test

    public void testCase(){

        int size = new Q3_Snake().solution(new char[][]{{'H', 'F'}, {'E', 'E'}}, "R G");

        Assert.assertEquals(size, 2);
    }



}
