package com.tci;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BasicStatisticTest {

    @Test
    public void numberOfDataItemsReturnsZeroIfNonePresent() {
        BasicStatistic basicStatistic = new BasicStatistic();
        int nrOfDataItems = basicStatistic.numberOfDataItems();
        Assert.assertEquals(0, nrOfDataItems);
    }

    @Test
    public void numberOfDataItemsIsZeroAfterClearUp() {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.addDoubleToData(1.1);
        basicStatistic.addDoubleToData(2.1);
        basicStatistic.addDoubleToData(3.1);
        basicStatistic.addDoubleToData(4.1);
        basicStatistic.addDoubleToData(5.1);
        basicStatistic.clearData();
        int nrOfDataItems = basicStatistic.numberOfDataItems();
        Assert.assertEquals(0, nrOfDataItems);
    }

    @Test
    public void numberOfDataItemsIsNotZeroAfterAdding() {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.addDoubleToData(1.1);
        basicStatistic.addDoubleToData(2.1);
        basicStatistic.addDoubleToData(3.1);
        basicStatistic.addDoubleToData(4.1);
        basicStatistic.addDoubleToData(5.1);

        int nrOfDataItems = basicStatistic.numberOfDataItems();
        Assert.assertNotEquals(0, nrOfDataItems);
    }

    @Test
    public void numberOfDataItemsIncreasesByAddedValuesCount() {
        BasicStatistic basicStatistic = new BasicStatistic();

        int initialCount = basicStatistic.numberOfDataItems();
        Assert.assertEquals(0, initialCount);

        basicStatistic.addDoubleToData(1.0);
        basicStatistic.addDoubleToData(2.0);
        basicStatistic.addDoubleToData(3.0);
        basicStatistic.addDoubleToData(4.0);

        int secondCount = basicStatistic.numberOfDataItems();
        Assert.assertEquals(4, secondCount);

        basicStatistic.addDoubleToData(1.0);
        basicStatistic.addDoubleToData(2.0);
        basicStatistic.addDoubleToData(3.0);
        basicStatistic.addDoubleToData(4.0);

        int thirdCount = basicStatistic.numberOfDataItems();
        Assert.assertEquals(8, thirdCount);
    }

    @Test(expected = NoDataItemsException.class)
    public void getHighestValueThrowsExceptionIfNoItemsPresent() throws NoDataItemsException {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.highestValue();
    }

    @Test
    public void getHighestValueReturnsCorrect() throws NoDataItemsException {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.addDoubleToData(11.1);
        basicStatistic.addDoubleToData(103.0);
        basicStatistic.addDoubleToData(20.0);
        basicStatistic.addDoubleToData(40.5);
        double highest = basicStatistic.highestValue();
        assertThat(highest, is(103.0));
    }

    @Test(expected = NoDataItemsException.class)
    public void getMeanThrowsExceptionIfNoItemsPresent() throws NoDataItemsException {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.getMean();
    }

    @Test
    public void getMeanReturnsCorrect() throws NoDataItemsException {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.addDoubleToData(10.0);
        basicStatistic.addDoubleToData(20.0);
        basicStatistic.addDoubleToData(30.0);
        basicStatistic.addDoubleToData(40.0);
        double mean = basicStatistic.getMean();
        assertThat(mean, is(25.0));
    }

    @Test(expected = NoDataItemsException.class)
    public void getMedianThrowsExceptionIfNoItemsPresent() throws NoDataItemsException {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.getMedian();
    }

    @Test
    public void getMedianReturnsCorrect() throws NoDataItemsException {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.addDoubleToData(10.0);
        basicStatistic.addDoubleToData(20.0);
        basicStatistic.addDoubleToData(30.0);
        basicStatistic.addDoubleToData(30.0);
        basicStatistic.addDoubleToData(30.0);
        basicStatistic.addDoubleToData(60.0);
        basicStatistic.addDoubleToData(70.0);
        basicStatistic.addDoubleToData(5.0);
        double median = basicStatistic.getMedian();
        assertThat(median, is(30.0));
    }

}