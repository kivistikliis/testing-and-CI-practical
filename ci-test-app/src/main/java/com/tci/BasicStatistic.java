package com.tci;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.stat.descriptive.rank.Median;

import java.util.ArrayList;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {

    private ArrayList<Double> dataItems;

    BasicStatistic() {
        dataItems = new ArrayList<>();
    }


    @Override
    public void addDoubleToData(Double valueToAdd){
        dataItems.add(valueToAdd);
    }

    @Override
    public void clearData(){
        dataItems.clear();
    }
	
    @Override
    public int numberOfDataItems(){
        return dataItems.size();
    }

    @Override
    public Double sum(){
        if(this.numberOfDataItems()==0)
            return 0d;

        double sum = 0;
        for (double value : dataItems) {
            sum += value;
        }
        return sum;
    }

    @Override
    public Double highestValue() throws NoDataItemsException {
        if(this.numberOfDataItems()==0)
            throw new NoDataItemsException("No data items to calculate on");

        return dataItems.stream().mapToDouble(Double::byteValue).max().orElse(-1);
    }

    @Override
    public Double getMean() throws NoDataItemsException {
        if(this.numberOfDataItems()==0)
            throw new NoDataItemsException("No data items to calculate on");

        return dataItems.stream().mapToDouble(Double::byteValue).average().orElse(-1);
    }

    @Override
    public double getMedian() throws NoDataItemsException {
        if(this.numberOfDataItems()==0)
            throw new NoDataItemsException("No data items to calculate on");

        double[] values = ArrayUtils.toPrimitive(dataItems.toArray(new Double[dataItems.size()]));
        Median median = new Median();
        return median.evaluate(values);
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        return 0.0;
    }
}
