import java.util.ArrayList;

public class GenericStackInherited<E> extends ArrayList<E> {

    public GenericStackInherited() {
        super();
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int getSize() {
        return size();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return get(getSize() - 1);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }

    public void push(E o) {
        add(o);
    }

    @Override
    public String toString() {
        return "стек: " + super.toString();
    }
}