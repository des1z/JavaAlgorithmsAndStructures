public class MyLinkedQueue<Item> {
    private MyLinkedList<Item> q = new MyLinkedList<>();

    public void queue(Item item){
        q.insertLast(item);
    }

    public Item pop(){
        return q.deleteFirst();
    }

    public Item peek(){
        return q.getFirst();
    }

    public int size(){
        return q.size();
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }
}
