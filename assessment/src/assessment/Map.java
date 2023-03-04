package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Map {
    private MapElement[][] myMap = new MapElement[12][12];
    private int length = 8;
    private int breadth = 4;
    private Boolean complete;
    private boolean isPushable;
    private int noOfMoves;
    String line;

    Map() {
        InputStreamReader map1 = new InputStreamReader(getClass().getResourceAsStream("/maps/map1.txt"));
        BufferedReader buffer = new BufferedReader(map1);

        int row = 0;
        try {
            while ((line = buffer.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.substring(i, i + 1).equals("W")) {
                        myMap[row][i] = new Wall();
                    } else if (line.substring(i, i + 1).equals("F")) {
                        myMap[row][i] = new Floor();
                    } else if (line.substring(i, i + 1).equals("C")) {
                        myMap[row][i] = new Crate();
                        isPushableObject(row, i);
                    }
                    if (line.substring(i, i + 1).equals("P")) {
                        myMap[row][i] = new Player();
                    } else if (line.substring(i, i + 1).equals("D")) {
                        myMap[row][i] = new Diamond();
                    }
                }
                row++;
            }
        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            System.out.println("Finished Reading!");
        }
    }

    public Boolean checkForWin() {
        return complete;
    }

    public void displayMap() {

    }

    public void findPlayer() {

    }

    public int getBreadth() {
        return breadth;
    }

    public int getLength() {
        return length;
    }

    // public MapElement getElement(int x, int y){
    // return ;
    // }

    public MapElement[][] getMyMap() {
        return myMap;
    }

    // public int getNumMoves(){
    // retun noOfMoves;
    // }

    // public boolean isObstacleAhead(int x, int y){
    //
    // }

    public boolean isPushableObject(int x, int y) {
        String row = String.valueOf(x);
        String col = String.valueOf(y);

        if (row == "C" || col == "C") {
            return complete = true;
        }

        return complete = true;
    }

    public void loadMap(String mapName) {

    }

    public void move(int currX, int currY, int newX, int newY) {

    }

    public void movePlayer(int dir) {
        switch (dir) {
            case 1 -> {
                if (complete == true) {
                    myMap[--breadth][length] = new Player();
                    myMap[--breadth][length] = new Crate();
                } else {
                    myMap[breadth][length] = new Floor();
                    myMap[--breadth][length] = new Player();
                }
            }
            case 2 -> {
                if (complete == true) {
                    myMap[++breadth][length] = new Player();
                    myMap[++breadth][length] = new Crate();
                } else {
                    myMap[breadth][length] = new Floor();
                    myMap[++breadth][length] = new Player();
                }
            }
            case 3 -> {
                if (complete == true) {
                    myMap[breadth][--length] = new Player();
                    myMap[breadth][--length] = new Crate();
                } else {
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][--length] = new Player();
                }
            }
            case 4 -> {
                if (complete == true) {
                    myMap[breadth][++length] = new Player();
                    myMap[breadth][++length] = new Crate();
                } else {
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][++length] = new Player();
                }
            }
            default -> {
            }
        }

    }

    public void resetNoMoves() {

    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setLocation(int x, int y) {

    }

}
