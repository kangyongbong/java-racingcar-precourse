package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {


    private Cars cars;
    private Cars cars2;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList("car,racing,test".split(",")));
        cars2 = new Cars(Arrays.asList("car2,racing2,test2".split(",")));
    }

    @Test
    @DisplayName("자동차_이름_검증")
    void carsNameValidate() {
        assertThat(cars.toList().size()).isEqualTo(3);
        assertThat(cars.getCarName(0)).isEqualTo("car");
        assertThat(cars.getCarName(1)).isEqualTo("racing");
        assertThat(cars.getCarName(2)).isEqualTo("test");
        assertThat(cars2.toList().size()).isEqualTo(3);
        assertThat(cars2.getCarName(0)).isEqualTo("car2");
        assertThat(cars2.getCarName(1)).isEqualTo("racing2");
        assertThat(cars2.getCarName(2)).isEqualTo("test2");
    }
}
