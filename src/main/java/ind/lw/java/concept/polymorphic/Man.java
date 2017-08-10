package ind.lw.java.concept.polymorphic;

public class Man extends Person {

//    @Override
//    public void say() {
//        System.out.println("Man say");
//    }


    public static void main(String[] args) {
        Person person = new Man();

        person.say();
    }
}
