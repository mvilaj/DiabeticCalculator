package service;

import com.github.mikephil.charting.data.LineData;

/**
 * Created by nikra on 08/21/17.
 */

public interface StatisticChartData {
    public LineData getNatasteChartData();
    public LineData getBeforeMealChartData();
    public LineData getAfterMealChartData();
}
