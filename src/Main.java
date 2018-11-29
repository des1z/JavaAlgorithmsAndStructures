import java.util.Random;

/**
 * @version 29.11.2018
 * @author Viktor Chernyaev
 * @JavaAlgorithmsAndStructures homework Lesson-2
 * @link https://github.com/des1z
 */

public class HW2 {
    public static void main(String[] args) {
        int arrSize = 1000000;
        int randomGenerator;
        MyArraylist<Integer> list = new MyArraylist<>();

        for (int i = 0; i < arrSize ; i++) {
            randomGenerator = (int)(Math.random() * arrSize);
            list.insert(randomGenerator);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyArraylist<Integer> myListBubble = new MyArraylist<>();
                for (int i = 0; i < arrSize; i++) {
                    myListBubble.insert(list.get(i));
                }
                long startInsert = System.nanoTime();
                myListBubble.insertionSort();
                System.out.println("Сортировка пузырьком за " + ((System.nanoTime() - startInsert) / 1000000000.0) + " сек");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyArraylist<Integer> myListInsert = new MyArraylist<>();
                for (int i = 0; i < arrSize; i++) {
                    myListInsert.insert(list.get(i));
                }
                long startInsert = System.nanoTime();
                myListInsert.insertionSort();
                System.out.println("Сортировка вставкой за " + ((System.nanoTime() - startInsert) / 1000000000.0) + " сек");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                MyArraylist<Integer> myListSelect = new MyArraylist<>();
                for (int i = 0; i < arrSize; i++) {
                    myListSelect.insert(list.get(i));
                }
                long startSelect = System.nanoTime();
                myListSelect.selectionSort();
                System.out.println("Сортировка выбором за " + ((System.nanoTime() - startSelect) / 1000000000.0) + " сек");
            }
        }).start();
    }
}
