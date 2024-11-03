package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.WinnerLottoValidator;

public class WinnerLotto {

    private static final WinnerLottoValidator winnerLottoValidator = new WinnerLottoValidator();
    private static final NumberStringConverter numberStringConverter = new NumberStringConverter();
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    private WinnerLotto(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinnerLotto from(String rawNumbers) {
        List<Integer> winningNumbers = parseNumbers(rawNumbers);

        return new WinnerLotto(winningNumbers);
    }

    private static List<Integer> parseNumbers(String rawNumbers) {
        String[] numberStrings = splitNumbers(rawNumbers);

        winnerLottoValidator.numberCount(numberStrings);

        return convertNumbers(numberStrings);
    }

    private static String[] splitNumbers(String rawNumbers) {
        return rawNumbers.split(",");
    }

    private static List<Integer> convertNumbers(String[] numberStrings) {
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numberStrings) {
            int number = numberStringConverter.convert(numberString.trim());

            winnerLottoValidator.numberRange(number);
            winnerLottoValidator.checkForDuplicate(numbers, number);

            numbers.add(number);
        }

        return numbers;
    }

    public void setBonusNumber(String rawBonusNumber) {
        int bonusNumber = numberStringConverter.convert(rawBonusNumber);

        winnerLottoValidator.numberRange(bonusNumber);
        winnerLottoValidator.bonusNumber(winningNumbers, bonusNumber);

        this.bonusNumber = bonusNumber;
    }
}