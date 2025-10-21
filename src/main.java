import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Тестирование GenericStack с массивом - задание 1
        System.out.println("Задание 1. GenericStack с массивом");
        GenericStack<Integer> arrayStack = new GenericStack<>();

        // Тестирование автоматического увеличения массива
        for (int i = 1; i <= 15; i++) {
            arrayStack.push(i * 10);
        }

        System.out.println("Стек после добавления 15 элементов: " + arrayStack);
        System.out.println("Размер стека: " + arrayStack.getSize());
        System.out.println("Верхний элемент: " + arrayStack.peek());

        // Извлечение нескольких элементов
        System.out.println("Извлеченные элементы:");
        for (int i = 0; i < 5; i++) {
            System.out.print(arrayStack.pop() + " ");
        }
        System.out.println("\nСтек после извлечения 5 элементов: " + arrayStack);

        // Тестирование GenericStack с наследованием от ArrayList - задание 2
        System.out.println("\nЗадание 2. GenericStack с наследованием от ArrayList");
        System.out.println("Введите 5 строк:");

        GenericStackInherited<String> inheritedStack = new GenericStackInherited<>();

        // Ввод 5 строк от пользователя
        for (int i = 1; i <= 5; i++) {
            System.out.print("Строка " + i + ": ");
            String input = scanner.nextLine();
            inheritedStack.push(input);
        }

        // Вывод строк в обратном порядке
        System.out.println("\nСтроки в обратном порядке:");
        while (!inheritedStack.isEmpty()) {
            System.out.println(inheritedStack.pop());
        }

        // Вывод UML-диаграммы для второго задания
        System.out.println("\nUML-диаграмма для задания 2:");
        System.out.println("┌────────────────────┐");
        System.out.println("│   ArrayList<E>     │");
        System.out.println("├────────────────────┤");
        System.out.println("│ +add(e: E)         │");
        System.out.println("│ +get(index: int)   │");
        System.out.println("│ +remove(index: int)│");
        System.out.println("│ +size(): int       │");
        System.out.println("│ +isEmpty(): boolean│");
        System.out.println("└────────────────────┘");
        System.out.println("         △");
        System.out.println("         │ extends");
        System.out.println("┌─────────────────────┐");
        System.out.println("│GenericStackInherited│");
        System.out.println("├─────────────────────┤");
        System.out.println("│ +push(o: E): void   │");
        System.out.println("│ +pop(): E           │");
        System.out.println("│ +peek(): E          │");
        System.out.println("│ +getSize(): int     │");
        System.out.println("└─────────────────────┘");
        System.out.println();
        System.out.println("┌────────────────────┐");
        System.out.println("│   GenericStack<E>  │");
        System.out.println("├────────────────────┤");
        System.out.println("│ -elements: E[]     │");
        System.out.println("│ -size: int         │");
        System.out.println("├────────────────────┤");
        System.out.println("│ +push(o: E): void  │");
        System.out.println("│ +pop(): E          │");
        System.out.println("│ +peek(): E         │");
        System.out.println("│ +getSize(): int    │");
        System.out.println("│ +isEmpty(): boolean│");
        System.out.println("│ -resize(): void    │");
        System.out.println("└────────────────────┘");

        scanner.close();
    }
}