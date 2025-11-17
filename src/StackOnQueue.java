import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;


public class StackOnQueue {
    // Основная очередь хранит элементы так, что "голова" = вершина стека
    private Queue<Integer> qMain = new LinkedList<>();
    // Вспомогательная очередь используется при операции push
    private Queue<Integer> qHelp = new LinkedList<>();

    /** Помещает элемент x на вершину стека. */
    public void push(int x) {
        // 1) Кладём новый элемент во вспомогательную очередь
        qHelp.offer(x);
        // 2) Перегружаем в неё все старые элементы, сохраняя порядок
        while (!qMain.isEmpty()) {
            qHelp.offer(qMain.poll());
        }
        // 3) Меняем местами очереди — теперь qMain снова "главная"
        Queue<Integer> tmp = qMain;
        qMain = qHelp;
        qHelp = tmp;
    }

    /** Удаляет верхний элемент и возвращает его. */
    public int pop() {
        if (qMain.isEmpty()) {
            throw new NoSuchElementException("pop() from empty stack");
        }
        return qMain.poll();
    }

    // Возвращает верхний элемент без удаления
    public int top() {
        if (qMain.isEmpty()) {
            throw new NoSuchElementException("top() from empty stack");
        }
        Integer v = qMain.peek();
        // peek() может вернуть null только если очередь пуста, что уже проверено
        return v;
    }

    // Возвращает true, если стек пуст
    public boolean empty() {
        return qMain.isEmpty();
    }

    // Строковое представление элементов стека от вершины к основанию
    public String asString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack[top->bottom]: [");
        int n = qMain.size();
        for (int i = 0; i < n; i++) {
            Integer v = qMain.poll();   // снять голову
            sb.append(v);
            if (i < n - 1) sb.append(", ");
            qMain.offer(v);             // вернуть в хвост (вращаем очередь)
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return asString();
    }
}
