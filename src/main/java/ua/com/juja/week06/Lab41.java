package ua.com.juja.week06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Интерфейс SimpleList2 < E > - это упрощенная версия java.util.List.
 * В классе Lab41 < E > уже реализована большая часть методов интерфейса SimpleList2 < E > .
 * Необходимо закончить реализацию SimpleList2 < E > и переопределить следующие методы класса Lab41 < E >:
 * 1) public Iterator iterator() - метод возвращает экземпляр класса, который реализовует стандартный интерфейс
 * Iterator < E > из SDK . При попытке удалить элемент итератора до вызова метода next() -
 * кидать java.lang.IllegalArgumentException
 * Код интерфейса:
 *
 * public interface Iterator {
 * boolean hasNext(); - метод возвращает true когда next() может вернуть элемент,
 * иначе - false.
 * E next();          - метод возвращает следующий элемент, если элементов нету
 * NoSuchElementException
 * void remove();     - метод удаляет последний возвращенный элемент, если итератор еще не возвращал
 * элемента еще нету - IllegalStateException
 * }
 * Или детальнее в SDK.
 * 2) public String toString() - метод, который возвращает строку которая является конкатенацией всех элементов
 * коллекции. Ожидается следующий формат "[1, 2, 3, 4, 5]", "[]" - для пустого списка.
 * 3) public boolean equals(Object o) - позволяет сравнить с другим  экземпляром класса.
 * 4) public int hashCode() - метод возвращает хеш-код. Хеш код должен соответствовать следующим правилам:
 * Одинаковые экземпляры класса должны иметь одинаковый хеш-код. Разные экземпляры класса имеют разный хеш-код
 * (минимизировать вероятность возникновения коллизии).
 */

public class Lab41<E> implements SimpleList2<E> {
    private Node<E> first = null; // head
    private Node<E> last = null; // tail
    private int size = 0;

    private static class Node<T> {
        private Node <T> prev;
        private T item;
        private Node <T> next;

        private Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;
            return item != null ? item.equals(node.item) : node.item == null;

        }

        @Override
        public int hashCode() {
            int result = 0;
            result = 31 * result + (item != null ? item.hashCode() : 0);
            return result;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }
    private E unlink(Node<E> x) {
        if(x == null){
            throw new NoSuchElementException();
        }
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }
    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = -1;

            @Override
            public boolean hasNext() {
                if(size == 0){
                    return false;
                }
                return cursor < size - 1;
            }

            @Override
            public E next() {
                int i = ++cursor;
                if (i >= size()){
                    throw new NoSuchElementException();
                }
                return get(i);
            }

            public void remove(){
                if(cursor == -1){
                    throw new IllegalStateException();
                } else {
                    unlink(node(cursor));
                }
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lab41<?> that = (Lab41<?>) o;

        for (int i = 0; i < size(); i++) {
            if(!this.node(i).equals(that.node(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i < size(); i++) {
            result += node(i).hashCode();
        }
        return result;
    }

    @Override
    public String toString() {
        if(size() == 0){
            return "[]";
        }
        String result = "";
        for (int i = 0; i < size(); i++) {
            if(i == 0){
                result +="[" + get(i).toString() + ", ";

            } else if(i == size() - 1){
                result += get(i).toString() + "]";
            } else {
                result += get(i).toString() + ", ";
            }
        }
        return result;
    }
}

interface SimpleList2<T> {
    public boolean add(T newElement);
    public T get(int index);
    public Iterator<T> iterator();
    public int size();
    public boolean isEmpty();
    public T remove(int index);
}

