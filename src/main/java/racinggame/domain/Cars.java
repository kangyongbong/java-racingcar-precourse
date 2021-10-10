package racinggame.domain;

import racinggame.constant.ErrorMessageConstant;
import racinggame.constant.InputDefinitionConstant;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = createName(carList);
    }

    private List<Car> createName(List<Car> carList) {
        validateEmptyList(carList);
        for (Car carName : carList) {
            validateEmptyName(carName.getCarName());
            validateNameLength(carName.getCarName());
        }

        return carList;
    }

    public void validateEmptyList(List<Car> carList) {
        if (carList == null || carList.size() <= 0) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_LIST);
        }
    }

    private void validateEmptyName(String carName) {
        if (carName == null || carName.replaceAll(" ", "").equals("")) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_EMPTY);
        }
    }

    private void validateNameLength(String carName) {
        if (carName.length() > InputDefinitionConstant.CAR_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_SIZE);
        }
    }

    public List<Car> getCars() {
        return this.carList;
    }
}
