package ind.lw.java.concept;

public class B extends A{

    //静态成员变量
    static BStaticMember bStaticMember = new BStaticMember("B 静态成员变量");
    //非静态成员变量
    ACommonMember bCommonMember = new ACommonMember("B 非静态成员变量");
    //构造函数
    public B(String marker) {
        super(marker);
        System.out.println("B 构造函数");
    }

    //父类静态代码块
    static {
        System.out.println("B 静态代码块");
    }

    //父类实例代码块
    {
        System.out.println("B 非静态代码块");
    }




    static void print(){
        System.out.println("print() in B");
    }

}
