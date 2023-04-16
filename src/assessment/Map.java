package assessment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author mauro
 */
public class Map extends MapElement {
    private final MapElement[][] myMap;
    private int length;
    private int breadth;
    private Boolean complete;
    private int totalDiamonds;
    private int noOfMoves;
    String line;
    int lvlCount = 1;

    Map() {
        this.myMap = new MapElement[12][12];

        loadMap("/maps/map1.txt");
    }

    /**
     *
     * @param x
     * @param y
     */
    public void findPlayer(int x, int y) {
        breadth = x;
        length = y;
        System.out.println("row: " + x + " col:" + y);
    }

    /**
     *
     * @return
     */
    public int getBreadth() {
        return breadth;
    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @return
     */
    public MapElement[][] getMyMap() {
        return myMap;
    }

    /**
     *
     * @return
     */
    public int getNumMoves() {
        return noOfMoves;
    }

    /**
     *
     * @param mapName
     */
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
                        totalDiamonds += 1;
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

    /**
     *
     * @param dir
     */
    public void movePlayer(int dir) {
        boolean diamondPresent = false, replace = false;
        boolean stopPushing = false, stop = false;

        switch (dir) {
            case 1 -> {
                noOfMoves = noOfMoves + 1;
                stopPushing = myMap[breadth - 2][length].getSymbol().equals("D");

                stop = myMap[breadth - 1][length].getUnderneath() instanceof Diamond;

                if (myMap[breadth - 1][length].getCanBePushed()) {
                    if (myMap[breadth - 2][length].getObs() == false) {
                        if (stopPushing == true) {
                            myMap[breadth][length] = new Floor();
                            myMap[breadth - 2][length] = new Crate();
                            myMap[--breadth][length] = new Player();
                            myMap[breadth - 1][length].setUnderneath(new Diamond());
                            totalDiamonds -= 1;
                        } else {
                            if (stop) {
                                setCanBePushed(false);
                            } else {
                                myMap[breadth][length] = new Floor();
                                myMap[breadth - 2][length] = new Crate();
                                myMap[--breadth][length] = new Player();
                            }
                        }
                    }
                }

                if (myMap[breadth - 1][length].getObs() == false) {
                    diamondPresent = myMap[breadth - 1][length].getSymbol().equals("D");
                }

                replace = myMap[breadth][length].getUnderneath() instanceof Diamond;

                if (diamondPresent == true) {
                    myMap[breadth][length] = new Floor();
                    myMap[--breadth][length] = new Player();
                    myMap[breadth][length].setUnderneath(new Diamond());
                } else {
                    if (replace) {
                        myMap[breadth][length] = new Diamond();
                        myMap[--breadth][length] = new Player();
                    } else {
                        if (myMap[breadth - 1][length].getObs() == false) {
                            myMap[breadth][length] = new Floor();
                            myMap[--breadth][length] = new Player();
                        }
                    }
                }

            }
            case 2 -> {
                noOfMoves = noOfMoves + 1;
                stopPushing = myMap[breadth + 2][length].getSymbol().equals("D");

                stop = myMap[breadth + 1][length].getUnderneath() instanceof Diamond;

                if (myMap[breadth + 1][length].getCanBePushed()) {
                    if (myMap[breadth + 2][length].getObs() == false) {
                        if (stopPushing == true) {
                            myMap[breadth][length] = new Floor();
                            myMap[breadth + 2][length] = new Crate();
                            myMap[++breadth][length] = new Player();
                            myMap[breadth + 1][length].setUnderneath(new Diamond());
                            totalDiamonds -= 1;
                        } else {
                            if (stop) {
                                setCanBePushed(false);
                            } else {
                                myMap[breadth][length] = new Floor();
                                myMap[breadth + 2][length] = new Crate();
                                myMap[++breadth][length] = new Player();
                            }
                        }
                    }
                }

                if (myMap[breadth + 1][length].getObs() == false) {
                    diamondPresent = myMap[breadth + 1][length].getSymbol().equals("D");
                }

                replace = myMap[breadth][length].getUnderneath() instanceof Diamond;

                if (diamondPresent == true) {
                    myMap[breadth][length] = new Floor();
                    myMap[++breadth][length] = new Player();
                    myMap[breadth][length].setUnderneath(new Diamond());
                } else {
                    if (replace) {
                        myMap[breadth][length] = new Diamond();
                        myMap[++breadth][length] = new Player();
                    } else {
                        if (myMap[breadth + 1][length].getObs() == false) {
                            myMap[breadth][length] = new Floor();
                            myMap[++breadth][length] = new Player();
                        }
                    }
                }
            }
            case 3 -> {
                noOfMoves = noOfMoves + 1;
                stopPushing = myMap[breadth][length - 2].getSymbol().equals("D");

                stop = myMap[breadth][length - 1].getUnderneath() instanceof Diamond;

                if (myMap[breadth][length - 1].getCanBePushed()) {
                    if (myMap[breadth][length - 2].getObs() == false) {
                        if (stopPushing == true) {
                            myMap[breadth][length] = new Floor();
                            myMap[breadth][length - 2] = new Crate();
                            myMap[breadth][--length] = new Player();
                            myMap[breadth][length - 1].setUnderneath(new Diamond());
                            totalDiamonds -= 1;
                        } else {
                            if (stop) {
                                setCanBePushed(false);
                            } else {
                                myMap[breadth][length] = new Floor();
                                myMap[breadth][length - 2] = new Crate();
                                myMap[breadth][--length] = new Player();
                            }
                        }
                    }
                }

                if (myMap[breadth][length - 1].getObs() == false) {
                    diamondPresent = myMap[breadth][length - 1].getSymbol().equals("D");
                }

                replace = myMap[breadth][length].getUnderneath() instanceof Diamond;

                if (diamondPresent == true) {
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][--length] = new Player();
                    myMap[breadth][length].setUnderneath(new Diamond());
                } else {
                    if (replace) {
                        myMap[breadth][length] = new Diamond();
                        myMap[breadth][--length] = new Player();
                    } else {
                        if (myMap[breadth][length - 1].getObs() == false) {
                            myMap[breadth][length] = new Floor();
                            myMap[breadth][--length] = new Player();
                        }
                    }
                }
            }
            case 4 -> {
                noOfMoves = noOfMoves + 1;
                stopPushing = myMap[breadth][length + 2].getSymbol().equals("D");

                //stop = myMap[breadth][length + 1].getUnderneath() instanceof Diamond;

                if (myMap[breadth][length + 1].getCanBePushed()) {
                    if (myMap[breadth][length + 2].getObs() == false) {
                        if (stopPushing == true) {
                            myMap[breadth][length] = new Floor();
                            myMap[breadth][length + 2] = new Crate();
                            myMap[breadth][++length] = new Player();
                            myMap[breadth][length + 1].setUnderneath(new Diamond());
                            totalDiamonds -= 1;
                        } else {
                            if (stop) {
                                setCanBePushed(false);
                            } else {
                                myMap[breadth][length] = new Floor();
                                myMap[breadth][length + 2] = new Crate();
                                myMap[breadth][++length] = new Player();
                            }
                        }
                    }
                }

                if (myMap[breadth][length + 1].getObs() == false) {
                    diamondPresent = myMap[breadth][length + 1].getSymbol().equals("D");
                }

                replace = myMap[breadth][length].getUnderneath() instanceof Diamond;

                if (diamondPresent == true) {
                    myMap[breadth][length] = new Floor();
                    myMap[breadth][++length] = new Player();
                    myMap[breadth][length].setUnderneath(new Diamond());
                } else {
                    if (replace) {
                        myMap[breadth][length] = new Diamond();
                        myMap[breadth][++length] = new Player();
                    } else {
                        if (myMap[breadth][length + 1].getObs() == false) {
                            myMap[breadth][length] = new Floor();
                            myMap[breadth][++length] = new Player();
                        }
                    }
                }
            }
        }
         
    }

    /**
     *
     */
    public void resetNoMoves() {
        noOfMoves = 0;
    }

    /**
     *
     * @param breadth
     */
    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    /**
     *
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     *
     * @return
     */
    public Boolean checkForWin() {
        System.out.println("TD: " + totalDiamonds);
        if(totalDiamonds <= 0) {
            JOptionPane.showMessageDialog(null, "Level Complete in " + noOfMoves + " moves.");
            resetNoMoves();
            lvlCount+=1;
            loadMap("/maps/map"+ lvlCount + ".txt");
        }
        
        if(lvlCount == 5 && totalDiamonds <= 0){
            JOptionPane.showMessageDialog(null, "Level Complete in " + noOfMoves + " moves.");
            JOptionPane.showMessageDialog(null, "Game Complete!!");
            System.exit(0);
        }
        
        return this.complete;
    }
    
}
