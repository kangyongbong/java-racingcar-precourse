package racinggame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.constant.ErrorMessageConstant;
import racinggame.constant.GameMessageConstant;
import racinggame.constant.MoveForwordConstant;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RandomNum;
import racinggame.service.impl.RacingGameServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameServiceTest {

    private RacingGameService racingGameService;

    @BeforeEach
    public void setUp() {
        racingGameService = new RacingGameServiceImpl();
    }

    @Test
    @DisplayName("전진 횟수 검증")
    public void resultMsgTest() {
        Car car = new Car("1번자동차");
        car.getPosition().moveForwod(new RandomNum());

        StringBuilder positionLine = new StringBuilder();
        for (int i = 0; i < car.getPosition().getCarPosition(); i++) {
            positionLine.append(GameMessageConstant.CAR_LINE_MSG);
        }

        System.out.println(car.getPosition().getLastNumber());
        if (car.getPosition().getLastNumber() >= MoveForwordConstant.FORWORD_NUMBER) {
            assertThat(positionLine.toString()).isEqualTo("-");
        }
        if (car.getPosition().getLastNumber() < MoveForwordConstant.FORWORD_NUMBER) {
            assertThat(positionLine.toString()).isNullOrEmpty();
        }
    }

    @Test
    @DisplayName("게임진행 횟수 검증")
    public void validateLoopTest() {
        Car car = new Car("1번자동차");
        car.getPosition().moveForwod(new RandomNum());

        assertThatThrownBy(() -> racingGameService.validateLoop(car, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessageConstant.ERR_MSG_LOOP);
    }

    @Test
    @DisplayName("전진 횟수기준으로 내림차순 정렬 검증")
    public void listSortTest() {
        Cars carList = new Cars("1번,2번,3번");
        for (int i = 0; i < carList.getCarsSize(); i++) {
            carList.moveForword(i, new RandomNum());
        }

        carList.listSort();

        assertThat(carList.getCar(0).getCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("최다 전진횟수 추출 검증")
    public void maxMoveTest() {
        Cars carList = new Cars("1번,2번,3번");
        int loopCount = 5;
        for (int i = 0; i < carList.getCarsSize(); i++) {
            for (int j = 0; j < loopCount; j++) {
                carList.moveForword(i, new RandomNum());
            }
        }

        carList.listSort();
        int max = carList.maxPosition();
        String winnerNames = "";
        for (int i = 0; i < carList.getCarsSize(); i++) {
            Car car = carList.getCar(i);
            racingGameService.validateLoop(car, loopCount);
            winnerNames = racingGameService.makeWinnerNames(car, winnerNames);
        }

        System.out.println(winnerNames);
        if (max <= 0) {
            assertThat(winnerNames).isNullOrEmpty();
        }
        if (max > 0) {
            assertThat(winnerNames).contains("번");
        }
    }

}
