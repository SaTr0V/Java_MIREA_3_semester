public class GenericStack<E> {
    private E[] elements;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    public void push(E o) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = o;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E o = elements[--size];
        elements[size] = null; // Помощь сборщику мусора
        return o;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length * 2;
        E[] newArray = (E[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("стек: [");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}