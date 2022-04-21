package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {


    private Cars cars;
    private Cars cars2;

    @BeforeEach
    void setUp() {
        cars = new Cars("car,race,test");
        cars2 = new Cars("car2,race2,test2");
    }

    @Test
    @DisplayName("자동차_이름_검증")
    void carsNameValidate() {
        assertThat(cars.toList().size()).isEqualTo(3);
        assertThat(cars.getCarName(0)).isEqualTo("car");
        assertThat(cars.getCarName(1)).isEqualTo("race");
        assertThat(cars.getCarName(2)).isEqualTo("test");
        assertThat(cars2.toList().size()).isEqualTo(3);
        assertThat(cars2.getCarName(0)).isEqualTo("car2");
        assertThat(cars2.getCarName(1)).isEqualTo("race2");
        assertThat(cars2.getCarName(2)).isEqualTo("test2");
    }

    @Test
    @DisplayName("자동차_이름_검증_Exception")
    void carsNameValidateException() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Cars("car, race, testFive"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Cars("car, test, race, car"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
