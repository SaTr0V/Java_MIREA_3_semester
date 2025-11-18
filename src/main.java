public class main {
    public static void main(String[] args) {
        StackOnQueue stack = new StackOnQueue();

        stack.push(1);
        stack.push(2);

        System.out.println("Объект на вершине: " + stack.top());
        System.out.println("Удаляем его: " + stack.pop());
        System.out.println("Пуст ли стек? " + stack.empty());
        System.out.println("Все элементы стека: " + stack.asString());

        stack.push(3);
        System.out.println("После добавления нового элемента: " + stack);
    }
}
