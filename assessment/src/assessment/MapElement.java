package assessment;

public class MapElement {
    private String symbol;
    private String imgFileName;
    private boolean canBePushed;
    private boolean isDestination;
    private boolean obs;
    private MapElement underneath;
    private int x;
    private int y;

    public boolean getCanBePushed() {
        return canBePushed;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    // public boolean getIsDestination(){
    //
    // }

    // public boolean getObs(){
    //
    // }

    public String getSymbol() {
        return symbol;
    }

    // public MapElement getUnderneath(){
    //
    // }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCanBePushed() {
        this.canBePushed = symbol.equals("C");
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public void setIsDestionation(boolean isDestination) {
        this.isDestination = true;
    }

    public void setObs(boolean value) {
        this.obs = true;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setUnderneath(MapElement underneath) {

    }

    public void setX(int value) {

    }

    public void setY(int value) {

    }

}
