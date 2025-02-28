# 🎱 **로또**

# **⛳️ 학습 목표**

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- [2주 차 공통 피드백](https://docs.google.com/document/d/1QW_762N0WC6JvAiDHNBYXzLJ60y1Azex1d7tID0BggM/edit?usp=sharing)을 최대한 반영한다.

# **💡 기능 요구 사항**

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "`[ERROR]`"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

# **📋 기능 목록**

## 로또 구입 금액 입력 안내 메시지 출력

- [x]  `"구입금액을 입력해 주세요."`를 출력한다.

## 로또 구입 금액 입력

- [x]  사용자로부터 로또 구입 금액을 입력 받는다.
- [x]  로또 구입 금액이 1,000원으로 나누어 떨어지는지 확인한다.
- [x]  구입 금액으로 구매 가능한 로또의 개수를 저장한다.
    - [x]  로또 한장의 가격은 1,000원이다.

## 로또 구매 및 구매한 로또 번호 출력

- [x]  “`8개를 구매했습니다.`”와 같이 구입한 로또 개수를 출력한다.
    - [x]  최대로 구매 가능한 로또를 구매한다.
- [x]  로또 번호를 1~45사이의 중복되지 않은 양의 정수로 7개 생성한다.
    - [x]  생성한 로또 번호는 리스트로 저정한다.
- [x]  구매한 로또의 번호는 “`[8, 21, 23, 41, 42, 43]`“의 형식으로 출력한다.

## 당첨 번호 입력 안내 메시지 출력

- [x]  `"당첨 번호를 입력해 주세요."`를 출력한다.

## 당첨 번호 입력

- [x]  사용자로부터 당첨 번호를 문자열로 입력 받는다.

## **문자열을 구분자로 나눈 후, 각 부분을 숫자로 변환하면서 유효값 검증**

- [x]  쉼표(`,`)를 사용하여 연산할 문자열을 분리하여 숫자 문자열 리스트를 생성한다.
- [x]  당첨 번호가 6개인지 확인한다.
- [x]  숫자 문자열 배열을 순회하며 각 요소를 정수로 변환하면서 1~45사이의 중복되지 않은 양의 정수인지 검증한다.

## 보너스 번호 입력 안내 메시지 출력

- [x]  `"보너스 번호를 입력해 주세요."`를 출력한다.

## 보너스 번호 입력

- [x]  사용자로부터 보너스 번호를 입력 받는다.
- [x]  보너스 번호가 기존의 당첨 번호와 일치하는지 확인한다.

## 로또 당첨내역 확인

- [x]  당첨 번호 리스트와 구매한 로또의 번호 리스트와 비교한다.
    - [x]  당첨 내역을 다음과 같은 형식으로 출력한다.

   ```bash
   당첨 통계
   ---
   3개 일치 (5,000원) - 1개
   4개 일치 (50,000원) - 0개
   5개 일치 (1,500,000원) - 0개
   5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
   6개 일치 (2,000,000,000원) - 0개
   ```

- [x]  로또로 얻은 수익금의 총 합을 저장한다.

## 수익률 계산 및 출력

- [x]  로또 구매 비용과 수익금을 기반으로 수익률을 계산한다.
    - [x]  수익률을 소수점 둘째 자리에서 반올림한다.
- [x]  “`총 수익률은 62.5%입니다.`”의 형식으로 수익률을 출력한다.

# **⚡ 예외 처리 사항**

- [x]  입력된 문자열이 `null`인 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] null은 입력할 수 없습니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 문자열의 앞 뒤 공백을 제거한 후 빈 문자열인 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 빈 문자열은 입력할 수 없습니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 로또 구입 금액에 숫자 이외의 문자가 포함된 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 숫자만 입력해야 합니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 로또 구입 금액이 1,000원 미만인 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 구매금액은 1,000원 이상이어야 합니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 로또 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 구매금액은 1,000원 단위여야 합니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 로또 구입 금액이 `int`의 범위가 아닌경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 입력된 숫자가 너무 큽니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 당첨 번호 문자열 배열의 크기가 6이 아닌 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 로또 번호는 6개여야 합니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  숫자 문자열 배열에 숫자 문자열이 1~45사이의 숫자가 아닌 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`" 라는 오류 메시지와 오류가 발생한 값을 출력한 후 입력을 다시 받는다.
- [x]  숫자 문자열 배열에 숫자 문자열에 중복된 숫자가 있는 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 로또 번호는 중복을 허용하지 않습니다.`" 라는 오류 메시지와 오류가 발생한 값을 출력한 후 입력을 다시 받는다.
- [x]  입력된 보너스 번호가 `int`의 범위가 아닌경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 입력된 숫자가 너무 큽니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 보너스 번호에 숫자 이외의 문자가 포함된 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 숫자만 입력해야 합니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 보너스 번호가 1~45사이의 숫자가 아닌 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.
- [x]  입력된 보너스 번호가 당첨 번호와 중복되는 경우 `IllegalArgumentException`을 발생시키고 "`[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.`" 라는 오류 메시지를 출력한 후 입력을 다시 받는다.

# **📦 역할 별 패키지 분리**

## **[ model ]**

### **Buyer**

- 로또를 구입하는 기능 담당

### **Lotto**

- 로또 티켓 관리

### **LottoNumberGenerator**

- 로또 번호 생성

### **LottoPrize**

- 로또 당첨 등수 및 상금 관리

### **LottoReport**

- 당첨 결과 계산 및 정보 제공

### **NumberStringConverter**

- 문자열을 숫자로 변환

### **WinnerLotto**

- 당첨 번호 보유 및 당첨 여부 확인

### **YieldAnalyst**

- 구입 비용 대비 수익률 계산

## **[ view ]**

### **InputView**

- 사용자로부터 문자열을 입력받음

### **OutputView**

- 결과나 메시지를 사용자에게 출력

## **[ controller ]**

### **LottoController**

- 로또의 전체 과정을 관리

## **[exception]**

### **ErrorMessage**

- 에러 메시지를 관리

### **LottoException**

- 로또의 전체 과정에서 발생하는 예외를 관리

## **[validator]**

### **DTOValidator**

- DTO에 대한 검증 로직을 담당

### **LottoValidator**

- 당첨 번호와 보너스 번호에 대한 검증 로직을 담당

## **[dto]**

### **BonusLottoNumberInput**

- 보너스 당첨 번호를 저장

### **LottoPurchasedAmountInput**

- 로또 구입 금액을 저장

### **WinnerLottoNumbersInput**

- 당첨 번호를 저장


# **📝 테스트 케이스**

## **정상적으로 처리되는 케이스**

- [x]  수익률이 0%인 경우
- [x]  수익률이 100% 이상인 경우

## **예외가 발생하는 케이스**

- [x]  입력된 문자열이 `null`인 경우
- [x]  입력된 문자열의 앞 뒤 공백을 제거한 후 빈 문자열인 경우
- [x]  입력된 로또 구입 금액에 숫자 이외의 문자가 포함된 경우
- [x]  입력된 로또 구입 금액이 1,000원 미만인 경우
- [x]  입력된 로또 구입 금액이 1,000원으로 나누어떨어지지 않는 경우
- [x]  입력된 로또 구입 금액이 `int`의 범위가 아닌경우
- [x]  입력된 당첨번호 문자열 배열의 크기가 6이 아닌 경우
- [x]  숫자 문자열 배열에 숫자 문자열이 1~45사이의 숫자가 아닌 경우
- [x]  숫자 문자열 배열에 숫자 문자열에 중복된 숫자가 있는 경우
- [x]  입력된 보너스 번호에 숫자 이외의 문자가 포함된 경우
- [x]  입력된 보너스 번호가 1~45사이의 숫자가 아닌 경우
- [x]  입력된 보너스 번호가 당첨번호와 중복되는 경우

# **✅ 과제 진행 요구 사항**

- [x]  [java-lotto-7](https://github.com/woowacourse-precourse/java-lotto-7) 저장소를 Fork & Clone
- [x]  `README.md`에 구현할 기능 목록을 정리해 추가
- [x]  Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- [x]  완료 후 Pull Request
- [x]  우아한테크코스 지원 플랫폼에 소감 작성 후 제출
- [x]  제출한 후 결과 확인, 통과하지 못했다면 수정해 다시 제출

# **✅ 프로그래밍 요구 사항**

- [x]  JDK 21 버전에서 실행 가능해야 한다.
- [x]  애플리케이션 실행의 시작점은`Application`의`main()`이다.
- [x]  `build.gradle`파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x]  애플리케이션 종료 시`System.exit()`를 호출하지 않는다.
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x]  [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 프로그래밍한다.
- [x]  indent(인덴트, 들여쓰기) depth를 `3`이 넘지 않도록 구현한다. `2`까지만 허용한다.
- [x]  3항 연산자를 쓰지 않는다.
- [x]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x]  JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)
- [x]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [x]  else 예약어를 쓰지 않는다.
- [x]  Java Enum을 적용하여 프로그램을 구현한다.
- [x]  구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 `LottoTest`를 참고하여 학습한 후 테스트를 작성한다.

## **라이브러리 요구 사항**

- [x]  `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
- [x]  Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- [x]  사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## **Lotto 클래스**

- [x]  제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
- [x]  `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- [x]  `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- [x]  `Lotto`의 패키지를 변경할 수 있다.

```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
```

# **✅ 2주차 공통 피드백**

- [x]  README를 상세하게 작성한다
- [x]  기능 목록을 구현해야 할 기능 목록 뿐만 아니라 예외 상황도 함께 정리한다
- [x]  기능 목록을 업데이트한다
- [x]  코드 내에서 문자열이나 숫자 값을 하드 코딩하지 않는다
- [x]  클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성한다
- [x]  변수 이름에 자료형은 사용하지 않는다
- [x]  한 메서드가 한 가지 기능만 담당하게 한다.
- [x]  메서드가 한 가지 기능을 하는지 확인하는 기준을 세운다.
- [x]  테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다.
- [x]  처음부터 큰 단위의 테스트를 만들지 않는다.

# **⛳️ 3주차 목표**

- [x]  MVC 패턴 적용
- [x]  TDD 개발 방법론 준수
- [x]  자바의 Streams API 연습 및 활용
- [x]  람다 표현식을 효과적으로 코드에 적용
- [x]  SOLID 원칙 준수
