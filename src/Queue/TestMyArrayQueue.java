package Queue;

public class TestMyArrayQueue {
    public static void main(String[] args) {
        MyArrayQueue<Integer> q = new MyArrayQueue<>();
        q.enqueue(5);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(11);
        q.enqueue(9);
        System.out.println(q);
        System.out.println(q.peek());
        q.dequeue();
        q.dequeue();
        System.out.println(q.peek());
        System.out.println(q);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(q.isEmpty());


    }
}
