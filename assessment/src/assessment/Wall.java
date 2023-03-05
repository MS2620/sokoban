package assessment;

public class Wall extends MapElement {
    Wall() {
        setSymbol("W");
        setImgFileName("/graphics/imgw.jpg");
        setCanBePushed(false);
        setObs(true);
        setX(1);
        setY(1);
    }
}
