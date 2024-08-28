package templateMethod.demo2;

public class WithdrawMoney extends BankTemplate{
    @Override
    public void operation() {
        System.out.println("第三步：取钱");
    }
}
