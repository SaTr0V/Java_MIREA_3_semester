import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задание 1.1 - MyStack с композицией
        System.out.println("Задание 1.1. MyStack с композицией");
        MyStack stack1 = new MyStack();
        stack1.push("Первый");
        stack1.push("Второй");
        stack1.push("Третий");

        System.out.println("Стек: " + stack1);
        System.out.println("Размер: " + stack1.getSize());
        System.out.println("Верхний элемент: " + stack1.peek());
        System.out.println("Извлечен: " + stack1.pop());
        System.out.println("Стек после извлечения: " + stack1);

        // Задание 1.2 - MyStack с наследованием
        System.out.println("\nЗадание 1.2 - MyStack с наследованием от ArrayList");
        System.out.println("Введите 5 строк:");

        MyStackInherited stack2 = new MyStackInherited();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Строка " + i + ": ");
            String input = scanner.nextLine();
            stack2.push(input);
        }

        System.out.println("\nСтроки в обратном порядке:");
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

        // Задание 2 - Глубокая копия
        System.out.println("\nЗадание 2 - Глубокая копия");
        MyStackDeepCopy originalStack = new MyStackDeepCopy();
        originalStack.push("Оригинал 1");
        originalStack.push("Оригинал 2");

        MyStackDeepCopy clonedStack = originalStack.clone();

        System.out.println("Оригинальный стек: " + originalStack);
        System.out.println("Клонированный стек: " + clonedStack);
        System.out.println("Разные объекты: " + (originalStack != clonedStack));

        // UML-диаграмма для задания 3
        System.out.println("\nUML-диаграмма");
        System.out.println("┌───────────────────┐");
        System.out.println("│   ArrayList       │");
        System.out.println("├───────────────────┤");
        System.out.println("│ +add()            │");
        System.out.println("│ +get()            │");
        System.out.println("│ +remove()         │");
        System.out.println("│ +size()           │");
        System.out.println("└───────────────────┘");
        System.out.println("         △");
        System.out.println("         │");
        System.out.println("┌───────────────────┐");
        System.out.println("│  MyStackInherited │");
        System.out.println("├───────────────────┤");
        System.out.println("│ +push()           │");
        System.out.println("│ +pop()            │");
        System.out.println("│ +peek()           │");
        System.out.println("│ +getSize()        │");
        System.out.println("└───────────────────┘");
        System.out.println();
        System.out.println("┌───────────────────┐");
        System.out.println("│     MyStack       │");
        System.out.println("├───────────────────┤");
        System.out.println("│ -list: ArrayList  │");
        System.out.println("├───────────────────┤");
        System.out.println("│ +push()           │");
        System.out.println("│ +pop()            │");
        System.out.println("│ +peek()           │");
        System.out.println("│ +getSize()        │");
        System.out.println("│ +isEmpty()        │");
        System.out.println("└───────────────────┘");
        System.out.println();
        System.out.println("┌───────────────────┐");
        System.out.println("│  MyStackDeepCopy  │");
        System.out.println("├───────────────────┤");
        System.out.println("│ -list: ArrayList  │");
        System.out.println("├───────────────────┤");
        System.out.println("│ +push()           │");
        System.out.println("│ +pop()            │");
        System.out.println("│ +peek()           │");
        System.out.println("│ +clone():         │");
        System.out.println("│   MyStackDeepCopy │");
        System.out.println("└───────────────────┘");

        scanner.close();
    }
}