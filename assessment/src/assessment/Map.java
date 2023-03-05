package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Map extends MapElement {
    private MapElement[][] myMap = new MapElement[12][12];
    private Object[][] player;
    private int length;
    private int breadth;
    private Boolean complete;
    private boolean isPushable;
    private int noOfMoves;
    private boolean obs;
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
                    } else if (line.substring(i, i + 1).equals("P")) {
                        myMap[row][i] = new Player();
                        findPlayer(row, i);
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

    public void findPlayer(int x, int y) {
        breadth = x;
        length = y;
        System.out.println("row: " + x + " col:" + y);
    }

    public int getBreadth() {
        return breadth;
    }

    public int getLength() {
        return length;
    }

    // public MapElement getElement(int x, int y) {
    // }

    public MapElement[][] getMyMap() {
        return myMap;
    }

    public int getNumMoves() {
        return noOfMoves;
    }

    public boolean isObstacleAhead(int x, int y) {

        if (getObs() == true) {
            System.out.println("Its true");
            return true;
        }
        return false;
    }

    // public boolean isPushableObject(int x, int y) {

    // }

    public void loadMap(String mapName) {

    }

    public void move(int currX, int currY, int newX, int newY) {
        System.out.println("Current Row: " + currX + " Current Col: " + currY);
        System.out.println("New Row: " + newX + " New Col: " + newY);
    }

    public void movePlayer(int dir) {
        switch (dir) {
            case 1 -> {
                // isPushableObject(breadth, length);
                isObstacleAhead(breadth, length);
                if (obs == true) {
                    System.out.println("obs ahead cant move.");
                } else {
                    noOfMoves += 1;
                    myMap[breadth][length] = new Floor();
                    myMap[--breadth][length] = new Player();
                }
            }
            case 2 -> {
                if (isPushable == false) {
                    noOfMoves += 1;
                    myMap[breadth][length] = new Floor();
                    myMap[++breadth][length] = new Player();
                } else {
                    noOfMoves += 1;
                    myMap[breadth][length] = new Floor();
                    myMap[++breadth][length] = new Player();
                }
            }
            case 3 -> {
                if (isPushable == false) {
                    noOfMoves += 1;
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][--length] = new Player();
                } else {
                    noOfMoves += 1;
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][--length] = new Player();
                }
            }
            case 4 -> {
                if (isPushable == false) {
                    noOfMoves += 1;
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][++length] = new Player();
                } else {
                    noOfMoves += 1;
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][++length] = new Player();
                }
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
