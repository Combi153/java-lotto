package lotto.domain.lottomachine.winningnumber;

import java.util.List;

public class WinningNumbers {
    private final List<WinningNumber> winningNumbers;

    public WinningNumbers(List<WinningNumber> winningNumbers) {
        validateDuplication(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateDuplication(List<WinningNumber> numbers) {
        if (hasDuplication(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplication(List<WinningNumber> numbers) {
        return numbers.size() != numbers.stream()
                .distinct()
                .count();
    }

    public boolean contains(int number) {
        return winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber.isSameValue(number));
    }

    public String countSameValue(List<Integer> numbers) {
        long count = winningNumbers.stream()
                .filter(winningNumber -> numbers.stream()
                        .anyMatch(winningNumber::isSameValue))
                .count();
        return String.valueOf(count);
    }
}
