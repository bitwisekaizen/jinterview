package com.thegrayfiles;

import java.util.ArrayList;
import java.util.List;

public class ListMerger<T extends Comparable<T>> {

    public List<T> merge(List<T> listA, List<T> listB) {
        if (listA == null || listB == null) {
            throw new IllegalArgumentException("Lists cannot be null");
        }

        List<T> result = new ArrayList<T>();

        InterviewQueue aQueue = new InterviewQueue(listA);
        InterviewQueue bQueue = new InterviewQueue(listB);

        QueueElement<T> aElement = aQueue.shift();
        QueueElement<T> bElement = bQueue.shift();

        while (!aQueue.isEmpty() || !bQueue.isEmpty()) {
            if (aElement.compareTo(bElement) < 0) {
                result.add(aElement.getValue());
                aElement = aQueue.shift();
            } else {
                result.add(bElement.getValue());
                bElement = bQueue.shift();
            }
        }

        return result;
    }
}
