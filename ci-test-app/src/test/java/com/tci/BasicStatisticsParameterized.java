package com.tci;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BasicStatisticsParameterized {

    private static Object[] getBasicStatisticsValues() {
        return $(
                $(1.0, 2.0, 3.0, 4.0, 10.0),
                $(2.0, 2.5, 3.5, 1.5, 9.5),
                $(10.0, 25.0, 35.0, 42.0, 112.0),
                $(1.05, 2.2, 3.25, 4.0, 10.5),
                $(7.0, 2.0, 10.0, 4.0, 23.0)
        );
    }

    @Test
    @Parameters(method = "getBasicStatisticsValues")
    public void sumDataItemsCorrect(double first, double second, double third, double fourth, double sum) {
        BasicStatistic basicStatistic = new BasicStatistic();
        basicStatistic.addDoubleToData(first);
        basicStatistic.addDoubleToData(second);
        basicStatistic.addDoubleToData(third);
        basicStatistic.addDoubleToData(fourth);

        double result = basicStatistic.sum();
        assertThat(result, is(sum));

    }


}
