package ind.lw.java.concept.polymorphic;

public class Polymorphic {


    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println(a1.show(a2));//1
        System.out.println(a1.show(b));//2
        System.out.println(a1.show(c));//3
        System.out.println(a1.show(d));//4
        System.out.println(a2.show(b));//5
        System.out.println(a2.show(c));
        System.out.println(a2.show(d));
        System.out.println(b.show(b));
        System.out.println(b.show(c));
        System.out.println(b.show(d));
    }

}
