package racingcar.model.vo;

public class Car {

    private final CarName carName;
    private final CarPosition carPosition;

    public Car(CarName carName, CarPosition carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public void carMove(int move) {
        carPosition.carMove(move);
    }

    public CarName getCarName() {
        return carName;
    }

    public CarPosition getCarPosition() {
        return carPosition;
    }
}
