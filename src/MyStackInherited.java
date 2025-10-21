import java.util.ArrayList;

public class MyStackInherited extends ArrayList<Object> {

    public MyStackInherited() {
        super();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int getSize() {
        return size();
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return get(getSize() - 1);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        add(o);
    }

    @Override
    public String toString() {
        return "стек: " + super.toString();
    }
}