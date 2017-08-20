package com.foi.dbcal.common.model.service;

import com.github.mikephil.charting.data.LineData;

/**
 * Created by nikra on 08/20/17.
 */

public interface StatisticChartData {
    public LineData getNatasteChartData();
    public LineData getBeforeMealChartData();
    public LineData getAfterMealChartData();
}
