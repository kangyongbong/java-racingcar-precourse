package racinggame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.constant.ErrorMessageConstant;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {

    private Cars cars;
    private Car car1;
    private Car car2;
    private Car carOverLength;
    private Car carEmpty;
    private List<Car> carList;

    @BeforeEach
    public void setUp() {
        carList = new ArrayList<>();
        car1 = new Car();
        car1.setCarName("1번");
        car2 = new Car();
        car2.setCarName("2번");
        carOverLength = new Car();
        carOverLength.setCarName("5자이상의이름");
        carEmpty = new Car();
        carEmpty.setCarName(" ");
    }

    @Test
    @DisplayName("Cars 일급객체 검증")
    public void carsInit() {
        carList.add(car1);
        carList.add(car2);
        cars = new Cars(carList);

        assertThat(cars.getCars().size()).isEqualTo(2);
        assertThat(cars.getCars().get(0).getCarName()).isEqualTo("1번");
        assertThat(cars.getCars().get(1).getCarName()).isEqualTo("2번");
    }

    @Test
    @DisplayName("5자이상의 이름 검증")
    public void carsOverTest() {
        carList = new ArrayList<>();
        carList.add(carOverLength);

        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstant.ERR_MSG_SIZE);
    }

    @Test
    @DisplayName("자동차 이름 공백")
    public void carsEmptyTest() {
        carList.add(carEmpty);

        assertThatThrownBy(() -> new Cars(carList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstant.ERR_MSG_EMPTY);
    }
}
