package assessment;

public class MapElement {
    private String symbol;
    private String imgFileName;
    public boolean canBePushed;
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

    public boolean getIsDestination() {
        return isDestination;
    }

    public boolean getObs() {
        return obs;
    }

    public String getSymbol() {
        return symbol;
    }

    public MapElement getUnderneath() {
        return underneath;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCanBePushed(boolean value) {
        this.canBePushed = value;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public void setIsDestionation(boolean isDestination) {
        this.isDestination = isDestination;
    }

    public void setObs(boolean value) {
        int x = getX();
        int y = getY();
        this.obs = value;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setUnderneath(MapElement underneath) {
        this.underneath = underneath;
    }

    public void setX(int value) {
        this.x = value;
    }

    public void setY(int value) {
        this.y = value;
    }

}
