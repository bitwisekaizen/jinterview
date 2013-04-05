package com.thegrayfiles;

public class EndOfQueueElement<T extends Comparable<T>> extends QueueElement<T> {

    public EndOfQueueElement() {
        super(null);
    }
}
