package templateMethod.demo2;

public class SaveMoney extends BankTemplate{
    @Override
    public void operation() {
        System.out.println("第三步：存钱");
    }
}
