package racingcar.model;

import racingcar.model.vo.Car;
import racingcar.model.vo.CarName;
import racingcar.model.vo.CarPosition;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> listCar;

    public Cars(List<String> carNames) {
        this.listCar = new ArrayList<>();
        setCars(carNames);
    }

    private void setCars(List<String> carNames) {
        for (String carName : carNames) {
            Car car = new Car(new CarName(carName), new CarPosition(0));
            this.listCar.add(car);
        }
    }

    public List<Car> toList() {
        return this.listCar;
    }

    public Car getCar(int index) {
        return this.listCar.get(index);
    }

    public String getCarName(int index) {
        return getCar(index).getCarName()
                .getName();
    }

    public int getCarPosition(int index) {
        return getCar(index).getCarPosition()
                .getPosition();
    }
}
