package ua.com.juja.week06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * В классе Lab42 реализован односвязный список.
 * В этом классе реализован интерфейс Iterator.
 * Необходимо реализовать поиск K-элемента с конца списка при помощи Iterator.
 * Для этого нужно реализовать метод Integer findElement(SinglyLinkedList singleList, int k)
 * На вход принимает экземпляр SinglyLinkedList и номер элемента который необходимо найти с конца списка.
 * Отсчет элементов с конца начинается с 0.
 * На выходе метод возвращает найденный элемент, если элемента не существует - IndexOutOfBoundsException.
 */

public class Lab42<T> {
    private Node<T> first = null;

    public void add(T element) {
        if (first == null) {
            first = new Node<T>(element);

        } else {
            Node<T> current = getLast();
            current.next = new Node<T>(element);
        }
    }

    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) throw new IndexOutOfBoundsException();
            if (current.element == null) throw new NoSuchElementException();
            T element = current.element;
            current = current.next;
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node<T> getLast() {
        Node<T> last = first;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    private class Node<T> {
        T element;
        Node<T> next;

        Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}

class FinderElements {
    public static Integer findElement(Lab42<Integer> singlyLinkedList, int k) {
        Iterator<Integer> iterator = singlyLinkedList.iterator();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (iterator.hasNext()){
            arrayList.add(iterator.next());
        }

        int result = 1;
        for (int index = arrayList.size() - 1; index >= 0; index--) {
            if(arrayList.get(index).equals(k)){
                return result;
            }
            result++;
        }

        throw new IndexOutOfBoundsException();
    }
}
