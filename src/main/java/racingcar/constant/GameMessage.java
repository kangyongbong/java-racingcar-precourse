package racingcar.constant;

public enum GameMessage {

    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACE_COUNT("시도할 회수는 몇회인가요?"),

    OUTPUT_RESULT("실행 결과"),
    OUTPUT_RESULT_CAR("%s : %s"),
    OUTPUT_WINNER("최종 우승자: %s");

    GameMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
