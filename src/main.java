import java.util.ArrayList;
import java.util.Arrays;

public class main {

    // 1 Метод для удаления дубликатов из коллекции
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> result = new ArrayList<>();
        for (E item : list) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    // 2 Линейный поиск элемента в массиве
    public static <E> int linearSearch(E[] array, E key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    // 3 Поиск наибольшего элемента в массиве с помощью compareTo()
    public static <E extends Comparable<E>> E findMax(E[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        E max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    // 4 Поиск наибольшего элемента в двумерном массиве с помощью compareTo()
    public static <E extends Comparable<E>> E findMaxIn2DArray(E[][] array2D) {
        if (array2D == null || array2D.length == 0) {
            return null;
        }

        E max = array2D[0][0];
        for (E[] row : array2D) {
            for (E element : row) {
                if (element.compareTo(max) > 0) {
                    max = element;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        // Удаление дубликатов
        System.out.println("Задание 1. Удаление дубликатов");
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        stringList.add("banana");
        stringList.add("apple");
        stringList.add("orange");
        stringList.add("banana");

        ArrayList<String> uniqueList = removeDuplicates(stringList);
        System.out.println("Исходный список: " + stringList);
        System.out.println("Список без дубликатов: " + uniqueList);

        // Линейный поиск
        System.out.println("\nЗадание 2. Линейный поиск");
        Integer[] intArray = {10, 20, 30, 40, 50};
        int searchResult1 = linearSearch(intArray, 30);
        int searchResult2 = linearSearch(intArray, 100);
        System.out.println("Массив: " + Arrays.toString(intArray));
        System.out.println("Поиск 30: позиция " + searchResult1);
        System.out.println("Поиск 100: позиция " + searchResult2);

        // Поиск максимума в массиве объектов Circle
        System.out.println("\nЗадание 3. Поиск наибольшего Circle");
        Circle[] circles = {
                new Circle(5.0),
                new Circle(3.0),
                new Circle(7.5),
                new Circle(2.0)
        };

        Circle maxCircle = findMax(circles);
        System.out.println("Массив кругов: " + Arrays.toString(circles));
        System.out.println("Круг с наибольшим радиусом: " + maxCircle);

        // Поиск максимума в двумерном массиве
        System.out.println("\nЗадание 4. Поиск в двумерном массиве");
        Integer[][] int2DArray = {
                {1, 5, 3},
                {7, 2, 9},
                {4, 6, 8}
        };

        Integer maxIn2D = findMaxIn2DArray(int2DArray);
        System.out.println("Двумерный массив:");
        for (Integer[] row : int2DArray) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("Наибольший элемент: " + maxIn2D);
    }
}