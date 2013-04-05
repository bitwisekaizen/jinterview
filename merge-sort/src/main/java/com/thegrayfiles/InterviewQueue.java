package com.thegrayfiles;

import java.util.Iterator;
import java.util.List;

public class InterviewQueue<T extends Comparable<T>> {

    private Iterator<T> iterator;
    private QueueElement<T> currentElement;

    public InterviewQueue(List<T> list) {
        iterator = list.iterator();
        if (list.size() == 0) {
            currentElement = new EndOfQueueElement();
        }
    }

    public QueueElement<T> shift() {
        currentElement = iterator.hasNext() ? new QueueElement<T>(iterator.next()) : new EndOfQueueElement();
        return currentElement;
    }

    public boolean isEmpty() {
        return currentElement instanceof EndOfQueueElement;
    }
}
