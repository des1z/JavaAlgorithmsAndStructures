package Queue;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private Object[] queue;
    private int start;
    private int end;
    private int size;

    public MyArrayQueue() {
        start = 0;
        end = 0;
        size = 0;
        queue = new Object[1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        queue[end++] = item;
        end %= queue.length;
        //if (end == queue.length) end = 0;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) queue[start];
        size--;
        start++;
        start %= queue.length;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return  (Item) queue[start];
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(start + i) % size];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(queue[(start + i) % queue.length]).append(", ");
        }
        return s.toString();
    }
}
