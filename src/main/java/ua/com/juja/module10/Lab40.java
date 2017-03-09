package ua.com.juja.module10;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Интерфейс SimpleList < E > - это упрощенная версия java.util.List.
 * В классе Lab40 < E > уже реализована большая часть методов интерфейса SimpleList < E > .
 * Необходимо закончить реализацию SimpleList < E > и переопределить следующие методы класса Lab40 < E >:
 * 1) public Iterator iterator() - метод возвращает экземпляр класса, который реализовует стандартный интерфейс
 * Iterator < E > из SDK . При попытке удалить элемент итератора до вызова метода next() - кидать
 * java.lang.IllegalArgumentException
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
 * Одинаковые экземпляры класса должны иметь одинаковый хеш-код. Разные экземпляры класса имеют разный
 * хеш-код (минимизировать вероятность возникновения коллизии).
 */

public class Lab40<E>  implements SimpleList<E>{

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public Lab40() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Lab40(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        data[size] = newElement;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
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
                E[] data2 = data;
                if (i > data2.length){
                    throw new ConcurrentModificationException();
                }

                return get(i);
            }

            public void remove(){
                if(cursor == -1){
                    throw new IllegalStateException();
                } else {
                    int numMoved = size - cursor - 1;
                    System.arraycopy(data, cursor + 1, data, cursor, numMoved);
                    data[--size] = null;
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
        rangeCheck(index);
        E oldValue = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lab40<?> that = (Lab40<?>) o;

        if (size != that.size) return false;
        return Arrays.equals(data, that.data);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        if (size() == 0){
            return "[]";
        }
        String result = "";
        for (int i = 0; i < size(); i++) {
            if(i == 0){
                result +="[" + data[i].toString() + ", ";

            } else if(i == size() - 1){
                result += data[i].toString() + "]";
            } else {
                result += data[i].toString() + ", ";
            }
        }
        return result;
    }
}

interface SimpleList<E> {
    public boolean add(E newElement);
    public E get(int index);
    public Iterator<E> iterator();
    public int size();
    public boolean isEmpty();
    public E remove(int index);
}
