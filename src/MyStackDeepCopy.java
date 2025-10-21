import java.util.ArrayList;

public class MyStackDeepCopy implements Cloneable {
    private ArrayList<Object> list;

    public MyStackDeepCopy() {
        list = new ArrayList<>();
    }

    public MyStackDeepCopy(ArrayList<Object> list) {
        this.list = new ArrayList<>(list); // Создаем новую коллекцию
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return list.get(getSize() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    // Глубокая копия
    @Override
    public MyStackDeepCopy clone() {
        try {
            MyStackDeepCopy cloned = (MyStackDeepCopy) super.clone();
            // Создаем новую коллекцию для глубокой копии
            cloned.list = new ArrayList<>(this.list);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Не должно произойти
        }
    }

    @Override
    public String toString() {
        return "стек: " + list.toString();
    }
}