package com.dsabyte.dsa.algo.searching;

public class LinearSearch<T> implements Searching<T> {
    T[] elements;

    LinearSearch(T[] elements) {
        this.elements = elements;
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(t)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean exist(T t) {
        for (T el : elements) {
            if (el.equals(t)) {
                return true;
            }
        }

        return false;
    }
}
