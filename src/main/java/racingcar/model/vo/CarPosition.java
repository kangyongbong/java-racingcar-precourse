package racingcar.model.vo;

public class CarPosition {

    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void carMove(int move) {
        this.position += move;
    }
}
