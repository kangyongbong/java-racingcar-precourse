package racinggame.domain;

import racinggame.constant.ErrorMessageConstant;
import racinggame.constant.InputDefinitionConstant;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = createName(carList);
    }

    public Cars(String carNameList) {
        this.carList = makeCarsName(carNameList.split(","));
    }

    private List<Car> createName(List<Car> carList) {
        validateEmptyList(carList);
        for (Car carName : carList) {
            validateNameLength(carName.getCarName());
        }

        return carList;
    }

    private List<Car> makeCarsName(String[] carNamesArr) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNamesArr) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return createName(carList);
    }

    public void validateEmptyList(List<Car> carList) {
        if (carList == null || carList.size() <= 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_LIST);
        }
    }

    private void validateNameLength(String carName) {
        if (carName.length() > InputDefinitionConstant.CAR_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_SIZE);
        }
    }

    public List<Car> getCarsList() {
        return this.carList;
    }

    public Car getCar(int index) {
        return this.carList
                .get(index);
    }

    public Position getPosition(int index) {
        return this.carList
                .get(index)
                .getPosition();
    }

    public void moveForword(int index, RandomNum randomNum) {
        this.carList
                .get(index)
                .getPosition()
                .moveForwod(randomNum);
    }
}
