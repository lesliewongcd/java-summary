package ind.lw.java.concept.polymorphic;

public class A {

    public String show(D obj){
        return ("A.D");
    }

    public String show(A obj){
        return ("A.A");
    }

}
