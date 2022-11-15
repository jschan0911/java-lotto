package lotto;

import java.util.List;

public class Calculator {
    int first = 0, second = 0, third = 0, fourth = 0, fifth = 0;
    int bonus, cnt = 0;

    private final List<List<Integer>> lottoSet;
    private final List<Integer> winningLotto;

    public Calculator(List<List<Integer>> lottoSet, List<Integer> winningLotto) {
        this.lottoSet = lottoSet;
        this.winningLotto = winningLotto;
        bonus = winningLotto.get(6);
        winningLotto.remove(6);
    }

    public List<Integer> getResult() {
        for (List<Integer> lottoNumber : lottoSet) {
            cnt = 0;
            for (Integer winningNumber : winningLotto) {
                countCalculator(lottoNumber, winningNumber);
            }
            rankCalculator();
        }
        return List.of(first, second, third, fourth, fifth);
    }

    public void countCalculator(List<Integer> lottoNumber, Integer winningNumber) {
        if (lottoNumber.contains(winningNumber)) {
            cnt += 1;
        }
    }

    public void rankCalculator() {
        if (cnt == 6) first += 1;
        if (cnt == 5) {
            if (lottoSet.contains(bonus)){
                second += 1;
            }
            else third += 1;
        }
        if (cnt == 4) fourth += 1;
        if (cnt == 3) fifth += 1;
    }

    public float getRateOfReturn(int money, List<Integer> result) {
        int totalMoney = result.get(0) * 2000000000
                + result.get(1) * 30000000
                + result.get(2) * 1500000
                + result.get(3) * 10000
                + result.get(4) * 5000;

        return totalMoney / (float) money * 100;
    }
}
