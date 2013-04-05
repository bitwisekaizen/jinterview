package com.thegrayfiles;

public class QueueElement<T extends Comparable> implements Comparable<QueueElement<T>> {

    private T value;

    public QueueElement(T value) {
        this.value = value;
    }

    public int compareTo(QueueElement<T> t) {
        if (this instanceof EndOfQueueElement) {
            return t instanceof EndOfQueueElement ? 0 : 1;
        } else {
            return t instanceof EndOfQueueElement ? -1 : getValue().compareTo(t.getValue());
        }
    }

    public T getValue() {
        return value;
    }
}
