package lotto;

public class BuyLotto {
    private final int paidMoney;
    public int lottoCount;

    public BuyLotto(int paidMoney) {
        validate(paidMoney);
        this.paidMoney = paidMoney;
        lottoCount = paidMoney / 1000;
    }

    private void validate(int paidMoney) {
        if (paidMoney % 1000 != 0) {
            System.out.println("[Error] 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
}