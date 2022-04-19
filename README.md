# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

##구현 목록
###자동차 이름에 대한 구현 목록
* ,로 구분된 자동차 이름 입력 받는다.
* ,를 기준으로 자동차 이름을 분리한다.
* 자동차 이름이 5자 이하인지 검증한다.
* 자동차 이름이 중복되는지 검증한다.
###자동차 이동에 대한 구현 목록
* 자동차가 몇 번 이동할 것인지 입력 받는다.
* 입력받은 횟 수는 숫자인지 검증한다.
###에러발생 시 구현 목록
* 숫자가 아닌 다른 값이 들어오면 illegalArgumentException발생 후 "[ERROR]"로 시작하는 메세지 출력한다.
* 에러가 발생하면 게임 종료가 아닌 중단 시점부터 다시 진행한다.
###게임 진행에 대한 구현 목록
* 랜덤 값을 구한 후 4이상이면 전진 3이상이면 멈춘다.
* 랜덤은 0~9까지이다.
* 우승자는 ,기준으로 자동차 이름을 출력한다.