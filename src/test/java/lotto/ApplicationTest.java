package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.dto.LottoPurchasedAmountInput;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @DisplayName("수익률이 0%인 경우")
    @Test
    void 수익률_0() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "8개를 구매했습니다.",
                            "[8, 21, 23, 41, 42, 43]",
                            "[3, 5, 11, 16, 32, 38]",
                            "[7, 11, 16, 35, 36, 44]",
                            "[1, 8, 11, 31, 41, 42]",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 8, 14, 22, 45]",
                            "3개 일치 (5,000원) - 0개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 0.00%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 8, 14, 22, 45)
        );
    }

    @DisplayName("수익률이 100% 이상인 경우")
    @Test
    void 수익률_100_이상() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("4000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "4개를 구매했습니다.",
                            "[13, 14, 16, 38, 42, 45]",
                            "[7, 11, 30, 40, 42, 43]",
                            "[2, 13, 22, 32, 38, 45]",
                            "[1, 3, 5, 14, 22, 45]",
                            "3개 일치 (5,000원) - 1개",
                            "4개 일치 (50,000원) - 0개",
                            "5개 일치 (1,500,000원) - 0개",
                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                            "6개 일치 (2,000,000,000원) - 0개",
                            "총 수익률은 125.00%입니다."
                    );
                },
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 입력된_문자열이_null_이면_예외가_발생한다() {
        LottoException exception = assertThrows(LottoException.class, () -> {
            LottoPurchasedAmountInput.from(null);
        });
        assertEquals(ErrorMessage.NULL_INPUT_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    void 입력된_문자열이_빈_문자열이면_예외가_발생한다() {
        LottoException exception = assertThrows(LottoException.class, () -> {
            LottoPurchasedAmountInput.from("");
        });
        assertEquals(ErrorMessage.EMPTY_INPUT_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    void 입력된_로또_구입_금액에_숫자가_아닌_문자열이_포홤되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1200$"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_NUMBER.getMessage());
        });
    }

    @DisplayName("입력된 로또 구입 금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void 입력된_로또_구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("900"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_AT_LEAST_1000.getMessage());
        });
    }

    @DisplayName("입력된 로또 구입 금액이 1,000원으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 입력된_로또_구입_금액이_1000원으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1200"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_MULTIPLE_OF_1000.getMessage());
        });
    }

    @Test
    void 입력된_로또_구입_금액이_int의_범위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, Integer.MAX_VALUE + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_AMOUNT_TOO_LARGE.getMessage());
    }

    @DisplayName("입력된 보너스 번호가 1~45사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 입력된_보너스_번호가_범위_내_숫자가_아니면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,6", "46"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BONUS_NUMBER_MUST_BE_BETWEEN_1_AND_45.getMessage());
        });
    }

    @Test
    void 입력된_보너스_번호가_당첨번호와_중복되면_예외가_발생한다() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("8000", "1,2,3,4,5,6", "6"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BONUS_NUMBER_DUPLICATES_WITH_WINNING_NUMBERS.getMessage());
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
