package racingcar.model;

import racingcar.model.vo.Car;
import racingcar.model.vo.CarName;
import racingcar.model.vo.CarPosition;
import racingcar.service.ValidateService;
import racingcar.service.impl.ValidateServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> listCar;

    public Cars(String carNames) {
        this.listCar = new ArrayList<>();
        setCars(Arrays.asList(carNames.split(",")));
    }

    private void setCars(List<String> carNames) {
        ValidateService validateService = new ValidateServiceImpl();
        for (String carName : carNames) {
            validateService.validateCarName(this, carName.trim());
            Car car = new Car(new CarName(carName.trim()), new CarPosition(0));
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
        return getCar(index).getCarName().getName();
    }

    public List<String> getListCarName() {
        List<String> listCarName = new ArrayList<>();
        for (Car car : toList()) {
            listCarName.add(car.getCarName().getName());
        }
        return listCarName;
    }

    public int getCarPosition(int index) {
        return getCar(index).getCarPosition().getPosition();
    }
}
