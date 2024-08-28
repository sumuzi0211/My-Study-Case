package templateMethod.demo1;

public abstract class AbstractClass {
    // 模板方法,提供公共的调用顺序，不允许子类重写，设置为final
    public final void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
        hookMethod();
    }

    // 钩子方法
    public void hookMethod() {
    }

    // 具体方法
    private void specificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    // 抽象方法1
    public abstract void abstractMethod1();

    // 抽象方法2
    public abstract void abstractMethod2();
}
