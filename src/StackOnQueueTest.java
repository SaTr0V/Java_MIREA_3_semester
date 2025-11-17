public class StackOnQueueTest {
    public static void main(String[] args) {
        StackOnQueue stack = new StackOnQueue();

        // Добавляем два значения
        stack.push(10);
        stack.push(20);

        System.out.println("Top (без удаления): " + stack.top());

        System.out.println("Pop (удаление вершины): " + stack.pop());

        System.out.println("Стек пуст? " + stack.empty());

        System.out.println("Все элементы стека: " + stack.asString());

        stack.push(30);
        System.out.println("После push(30): " + stack);
    }
}
