package ind.lw.java.concept;

public class A {

    //静态成员变量
    static AStaticMember aStaticMember1 = new AStaticMember("A 静态成员变量1");
    //非静态成员变量
    ACommonMember aCommonMember1 = new ACommonMember("A 非静态成员变量1");
    //构造函数
    public A(String marker) {
        System.out.println("A 构造函数");
    }

    //父类静态代码块
    static {
        System.out.println("A 静态代码块1");
    }

    //父类实例代码块
    {
        System.out.println("A 非静态代码块1");
    }

    //静态成员变量
    static AStaticMember aStaticMember2 = new AStaticMember("A 静态成员变量2");
    //非静态成员变量
    ACommonMember aCommonMember2 = new ACommonMember("A 非静态成员变量2");

    //父类静态代码块
    static {
        System.out.println("A 静态代码块2");
    }
    //父类实例代码块
    {
        System.out.println("A 非静态代码块2");
    }
}
