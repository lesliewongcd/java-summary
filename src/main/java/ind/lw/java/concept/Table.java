package ind.lw.java.concept;

public class Table {

    static Bowl bowl1 = new Bowl(1);


    public Table(int id){
        System.out.printf("Table(%d)\n",id);
    }

    static Bowl bowl2 = new Bowl(2);

    static Bowl bowl3 ;

    static {
        bowl3 = new Bowl(3);
    }

    static void print(){
        System.out.println("print()");
    }
}
