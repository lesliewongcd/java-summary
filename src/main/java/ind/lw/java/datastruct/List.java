package ind.lw.java.datastruct;

/**
 * 复习单链表相关知识
 */
public class List<V> {


    public static class Node<V>{

        V v;

        Node<V> next;

        public Node(V v){
            this.v = v;
        }

        @Override
        public String toString() {
            return ""+v;
        }
    }


    Node<V> header;

    int size;

    public int getSize(){
        return size;
    }

    public void insert(V v){
        if (header == null)
            header = new Node<>(v);
        else {
            Node<V> newNode = new Node<>(v);
            newNode.next = header.next;
            header.next = newNode;
        }
        size+=1;
    }

    public V get(int index,boolean fromBackward){

        if (fromBackward){
            return getFromBackward(index);
        }
        return get(index);
    }

    private V get(int index) {
        return null;
    }

    /**
     * 从后往前获取倒序下标为index的结点值
     * 用以解决获取倒数第N个数的问题
     * @param index
     * @return
     */
    private V getFromBackward(int index){

        if (index < 0)
            return null;

        Node<V> p1 = header;

        if (p1 == null)
            return null;

        if (p1.next == null && index == 0)
            return p1.v;

        if (p1.next == null && index > 0)
            return null;

        Node<V> p2 = null;

        int interval=index;
        boolean skip = false;

        do{
            if (!skip && (interval--) == 0){
                p2 = header;
                skip = true;
            }else if (skip){
                p2 = p2.next;
            }

            p1 = p1.next;
        }while (p1 != null);

        return p2 == null ? null : p2.v;
    }

    public void print(){
        if (header != null){
            Node<V> tmp = header;
            do {
                System.out.println(tmp.v);
                tmp = tmp.next;
            }while (tmp != null);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new List<>();

        list.insert(1);
        list.insert(2);
//        list.insert(3);
//        list.insert(4);
//        list.insert(5);

        list.print();

        System.out.println("------");
        System.out.println(list.getFromBackward(0));
        System.out.println(list.getFromBackward(1));
        System.out.println(list.getFromBackward(2));
        System.out.println(list.getFromBackward(3));
        System.out.println(list.getFromBackward(4));
        System.out.println(list.getFromBackward(5));

    }
}
