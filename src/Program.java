import java.util.Iterator;

public class Program {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);
        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);
        list.insertLast(77);

        System.out.println(list.size());
        System.out.println(list.find(22));
        System.out.println(list.find(7));
        list.delete(7);
        System.out.println(list.find(7));

        /*Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()){
            Integer current = iter.next();
            System.out.println(current);
        }*/

        for (Integer current:
             list) {
            System.out.println(current);
        }
    }
}
