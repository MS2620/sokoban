package assessment;

public class MapElement {
    private String symbol;
    private String imgFileName;
    public boolean canBePushed;
    private boolean obs;
    private MapElement underneath;

    public boolean getCanBePushed() {
        return canBePushed;
    }

    public String getImgFileName() {
        return imgFileName;
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

    public void setCanBePushed(boolean value) {
        this.canBePushed = value;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    
    public void setObs(boolean value) {
        this.obs = value;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setUnderneath(MapElement under) {
        this.underneath = under;
    }


}
