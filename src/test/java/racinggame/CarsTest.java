package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.constant.ErrorMessageConstant;
import racinggame.domain.Cars;
import racinggame.domain.RandomNum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("Cars 일급객체 검증")
    public void carsInit() {
        Cars cars = new Cars("1번,2번");
        assertThat(cars.getCarsList().size()).isEqualTo(2);
        assertThat(cars.getCar(0).getCarName()).isEqualTo("1번");
        assertThat(cars.getCar(1).getCarName()).isEqualTo("2번");
    }

    @Test
    @DisplayName("5자이상의 이름 검증")
    public void carsOverTest() {
        assertThatThrownBy(() -> new Cars("5자이상의이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstant.ERR_MSG_SIZE);
    }

    @Test
    @DisplayName("자동차 이름 공백")
    public void carsEmptyTest() {
        assertThatThrownBy(() -> new Cars(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstant.ERR_MSG_EMPTY);
    }

    @Test
    @DisplayName("자동차 포지션 검증")
    public void carsPositionTest() {
        Cars cars = new Cars("1번,2번");
        assertThat(cars.getPosition(0).getCarPosition()).isEqualTo(0);
        RandomNum randomNum = new RandomNum();
        cars.moveForword(0, randomNum);
        assertThat(cars.getPosition(0).getGameIndex()).isEqualTo(1);
        assertThat(cars.getPosition(0).getLastNumber()).isEqualTo(randomNum.getRandomNum());
    }

}
