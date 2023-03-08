package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Map extends MapElement {
    private final MapElement[][] myMap;
    private int length;
    private int breadth;
    private Boolean complete;
    private int noOfMoves;
    String line;

    Map() {
        this.myMap = new MapElement[12][12];
        loadMap("/maps/map1.txt");
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


    public MapElement[][] getMyMap() {
        return myMap;
    }

    public int getNumMoves() {
        return noOfMoves;
    }


    public void loadMap(String mapName) {
        InputStreamReader maps;
        maps = new InputStreamReader(getClass().getResourceAsStream(mapName));
        BufferedReader buffer = new BufferedReader(maps);

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

    public void move(int currX, int currY, int newX, int newY) {
        System.out.println("Current Row: " + currX + " Current Col: " + currY);
        System.out.println("New Row: " + newX + " New Col: " + newY);
    }

    public void movePlayer(int dir) {
        switch (dir) {
            case 1 -> {  
                
                    if(myMap[breadth - 1][length].getCanBePushed()){
                        if(myMap[breadth - 2][length].getObs() == false){
                            myMap[breadth][length] = new Floor();
                            myMap[breadth-2][length] = new Crate();
                            myMap[--breadth][length] = new Player();
                        }
                    } 
                    if (myMap[breadth - 1][length].getObs() == false){
                        if (myMap[breadth - 1][length].getSymbol().equals("D")){
        //                    myMap[breadth][length] = new Floor();
        //                    myMap[breadth][length] = new Player();
                            myMap[breadth][length].setUnderneath(new Diamond());
                            System.out.println(myMap[breadth][length].getUnderneath() + " at " + breadth + " and " + length);
                        }
                        myMap[breadth][length] = new Floor();
                        myMap[--breadth][length] = new Player();  
                        if(myMap[breadth+1][length].getUnderneath() == new Diamond()){
                            System.out.println("diamond to be placed");
                            myMap[++breadth][length] = new Diamond();
                        }
                    } 
                    
                } 
            case 2 -> {
                if(myMap[breadth + 1][length].getCanBePushed()){
                    if(myMap[breadth + 2][length].getObs() == false){
                        myMap[breadth][length] = new Floor();
                        myMap[breadth + 2][length] = new Crate();
                        myMap[++breadth][length] = new Player();
                    }
                } 
                if (myMap[breadth + 1][length].getObs() == false){
                    myMap[breadth][length] = new Floor();
                    myMap[++breadth][length] = new Player();
                }
            }
            case 3 -> {
                if(myMap[breadth][length - 1].getCanBePushed()){
                    if(myMap[breadth][length - 2].getObs() == false){
                        myMap[breadth][length] = new Floor();
                        myMap[breadth][length - 2] = new Crate();
                        myMap[breadth][--length] = new Player();
                    }
                } 
                if (myMap[breadth][length - 1].getObs() == false){
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][--length] = new Player();
                }
            }
            case 4 -> {
                if(myMap[breadth][length + 1].getCanBePushed()){
                    if(myMap[breadth][length + 2].getObs() == false){
                        myMap[breadth][length] = new Floor();
                        myMap[breadth][length + 2] = new Crate();
                        myMap[breadth][++length] = new Player();
                    }
                } 
                if (myMap[breadth][length + 1].getObs() == false){
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
