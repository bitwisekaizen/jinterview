package com.thegrayfiles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

@Test
public class ListMergerTest {

    private static final int MAX_LIST_SIZE = 1000;
    private static final int NUMBER_SORT_ATTEMPTS = 10;

    private Random random = new Random(System.currentTimeMillis());

    private ListMerger<Integer> merger;

    @BeforeMethod
    public void setup() {
        merger = new ListMerger<Integer>();
    }

    @Test(invocationCount = NUMBER_SORT_ATTEMPTS)
    public void canMergeRandomSamplingOfManyLists() {
        canMergeTwoLists(buildRandomSortedList(), buildRandomSortedList());
    }

    @Test(dataProvider = "validTestDataProvider")
    public void canMergeTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> expectedResult = sortMultipleLists(list1, list2);
        List<Integer> result = merger.merge(list1, list2);
        assertEquals(result, expectedResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, dataProvider = "nullInputDataProvider")
    public void nullInputThrowsIllegalArgumentException(List<Integer> listA, List<Integer> listB) {
        merger.merge(listA, listB);
    }

    @DataProvider(name = "validTestDataProvider")
    public Object[][] validTestDataProvider() {
        return new Object[][] {
            { Arrays.asList(), Arrays.asList() },
            { Arrays.asList(), buildRandomSortedList() },
            { buildRandomSortedList(), Arrays.asList() },
        };
    }

    @DataProvider(name = "nullInputDataProvider")
    public Object[][] nullInputDataProvider() {
        return new Object[][] {
                { null, Arrays.asList(1, 2, 3) },
                { Arrays.asList(1, 2, 3), null },
                { null, null },
        };
    }

    private List<Integer> sortMultipleLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<Integer>();
        result.addAll(list1);
        result.addAll(list2);
        Collections.sort(result);
        return result;
    }

    private List<Integer> buildRandomSortedList() {
        List<Integer> result = new ArrayList<Integer>();
        Integer listSize = random.nextInt(MAX_LIST_SIZE);
        for (int i = 0; i < listSize; i++) {
            result.add(random.nextInt());
        }
        Collections.sort(result);
        return result;
    }
}
