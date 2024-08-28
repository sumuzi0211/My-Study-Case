package templateMethod.demo1;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.templateMethod();
    }
}
