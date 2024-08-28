package templateMethod.demo2;

public class Main {
    public static void main(String[] args) {
        System.out.println("取钱操作");
        BankTemplate withdrawMoney = new WithdrawMoney();
        withdrawMoney.template();

        System.out.println("存钱操作");
        BankTemplate saveMoney = new SaveMoney();
        saveMoney.template();
    }
}
