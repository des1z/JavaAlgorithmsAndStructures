package Deque;

import java.util.NoSuchElementException;

public class Deque<Item> {
    private Item[] items = (Item[]) new Object[0];
    private int size;private int head;
    private int tail;

    public Deque() {
        size = 0;
        head = 0;
        tail = -1;
    }

    private void resize(int startingIndex){
        int newLength = (size == 0) ? 4 : size * 2;
        Item[] newArray = (Item[]) new Object[newLength];

        if (size > 0){
            int targetIndex = startingIndex;

            if (tail < head) {
                for (int index = head; index < items.length; index++) {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }

                for (int index = 0; index <= tail; index++) {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }
            } else {
                for (int index = head; index <= tail; index++) {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }
            }

            head = startingIndex;
            tail = targetIndex - 1;
        } else {
            head = 0;
            tail = -1;
        }
        items = newArray;
    }

    public void enqueueFirst(Item item) {
        if (items.length == size) {
            resize(1);
        }
        if (head > 0) {
            head--;
        } else {
            head = items.length - 1;
        }
        items[head] = item;
        size++;

        if (size == 1) {
            tail = head;
        }
    }

    public void enqueueLast(Item item) {
        if (items.length == size) {
            resize(0);
        }

        if (tail == items.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        items[tail] = item;
        size++;

        if (size == 1) {
            head = tail;
        }
    }

    public Item dequeueFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }

        Item value = items[head];

        if (head == items.length - 1) {
            head = 0;
        } else {
            head++;
        }
        size--;
        return value;
    }

    public Item dequeueLast() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }
        Item value = items[tail];

        if (tail == 0) {
            tail = items.length - 1;
        } else {
            tail--;
        }
        size--;
        return value;
    }

    public Item peekFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }
        return items[head];
    }

    public Item peekLast() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }
        return items[tail];
    }

    public int getSize() {
        return size;
    }
}
