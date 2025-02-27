package de.ptb.dsi.dme_backend.service.plot;

import org.jfree.chart.JFreeChart;

import java.util.List;

public interface IScatterPlot {
    //Creates a plot with the given name, data, range, width and height
    public JFreeChart createPlot(String plotTitle, String axisLabelX, String axisLabelY, List<Double[]> values, Double rangeMin, Double rangeMax);
}