package templateMethod.demo2;

public abstract class BankTemplate {
    // 模板方法，定义方法执行顺序
    public final void template(){
        insertCard();
        login();
        operation();
        unLogin();
    }

    private void insertCard(){
        System.out.println("第一步：插入银行卡");
    }

    private void login(){
        System.out.println("第二步：登录账户");
    }

    public abstract void operation();

    private void unLogin(){
        System.out.println("第四步：退出登录");
    }
}
