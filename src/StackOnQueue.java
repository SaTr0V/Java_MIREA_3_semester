import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


public class StackOnQueue {
    // Основная очередь
    private Queue<Integer> qMain = new LinkedList<>();
    // Вспомогательная очередь (используется при вызове push)
    private Queue<Integer> qHelp = new LinkedList<>();

    // Помещает элемент x в конец стека
    public void push(int x) {
        qHelp.offer(x);  // кладем новый элемент в вспомогательную очередь

        // Перекладываем элементы из основной очереди в вспомогательную
        while (!qMain.isEmpty()) {
            qHelp.offer(qMain.poll());
        }
        // Меняем местами очереди
        Queue<Integer> tmp = qMain;
        qMain = qHelp;
        qHelp = tmp;
    }

    // Удаляет последний элемент и возвращает его
    public int pop() {
        if (qMain.isEmpty()) {
            throw new NoSuchElementException("pop() неприменим к пустому стеку");
        }
        return qMain.poll();
    }

    // Возвращает последний элемент без удаления
    public int top() {
        if (qMain.isEmpty()) {
            throw new NoSuchElementException("top() неприменим к пустому стеку");
        }
        // peek() может вернуть null только если очередь пуста, что уже проверено
        return qMain.peek();
    }

    // Возвращает true, если стек пуст
    public boolean empty() {
        return qMain.isEmpty();
    }

    // Строковое представление элементов стека от вершины к основанию
    public String asString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Стек: [");
        int n = qMain.size();
        for (int i = 0; i < n; i++) {
            Integer v = qMain.poll();
            sb.append(v);
            if (i < n - 1) sb.append(", ");
            qMain.offer(v);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return asString();
    }
}
