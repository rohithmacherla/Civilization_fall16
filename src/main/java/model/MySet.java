package model;

class MySet<E> implements SimpleSet<E> {
    private E[] data;
    private int size;

    MySet() {
        Object[] k = new Object[10];
        data = (E[]) k;
        size = 0;
    }

    public boolean add(E e) {
        if (size == data.length) {
            Object[] tempO = new Object[size + 1];
            E[] tempE = (E[]) tempO;
            for (int i = 0; i < size; i++) {
                tempE[i] = data[i];
            }
            data = tempE;
        }
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return false;
            }
        }
        data[size] = e;
        size++;
        return true;
    }

    public E remove(E e) throws ElementDoesNotExistException {
        if (size == 0) {
            throw new ElementDoesNotExistException("You cannot "
                + "remove an non-existing element!");
        }
        E temp = null;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                temp = data[i];
                data[i] = data[size - 1];
                data[size - 1] = temp;
                size--;
                break;
            }
            if (temp == null) {
                throw new ElementDoesNotExistException("You cannot"
                + " remove an non-existing element!");
            }
        }
        return temp;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        if (size == 0) {
            throw new ElementDoesNotExistException("You cannot remove elements"
                + " because none exist!");
        }
        return data;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public E getRandomElement() throws ElementDoesNotExistException {
        int temp = (int) (Math.random() * size);
        return data[temp];
    }

    public E[] toArray() {
        return data;
    }

    public String toString() {
        String output = "This set contains: ";
        for (int i = 0; i < size; i++) {
            output += data[i] + " ";
        }
        return output;

    }
}