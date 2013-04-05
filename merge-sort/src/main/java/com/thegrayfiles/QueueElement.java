package com.thegrayfiles;

public class QueueElement<T extends Comparable> implements Comparable<QueueElement<T>> {

    private T value;

    public QueueElement(T value) {
        this.value = value;
    }

    public int compareTo(QueueElement<T> t) {
        if (this.getValue() == null) {
            return t.getValue() == null ? 0 : 1;
        } else {
            return t.getValue() == null ? -1 : getValue().compareTo(t.getValue());
        }
    }

    public T getValue() {
        return value;
    }
}
