package de.ptb.dsi.dme_backend.service.plot;

import java.awt.*;
import java.util.List;

import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.*;
import org.jfree.data.xy.*;

public class ScatterPlotWithErrorBars implements IScatterPlot{

    public JFreeChart createPlot(String plotTitle, String axisLabelX, String axisLabelY, List<Double[]> values, Double rangeMin, Double rangeMax) {
        //Define Axis
        NumberAxis xAxis = new NumberAxis(axisLabelX);
        xAxis.setRange(rangeMin, rangeMax);
        NumberAxis yAxis = new NumberAxis(axisLabelY);

        //TODO: Create class for named axis
        //Named axis for NMIs
        //String[] labelsForYAxis = {"PTB", "LNE", "NPL"};
        //SymbolAxis yAxis = new SymbolAxis("NMI", labelsForYAxis);

        //Define value and error bar series (K-2-uncertainties)
        XYSeries series = new XYSeries("values");
        YIntervalSeries errorSeries = new YIntervalSeries("uncertainties");

        //Turn data from list into series and error (uncertainty) series
        for(Double[] value : values){
            series.add(value[0], value[1]);
            errorSeries.add(value[0], value[1], value[2], value[3]);
        }

        //Add series
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        //Add error bars
        YIntervalSeriesCollection errorDataset = new YIntervalSeriesCollection();
        errorDataset.addSeries(errorSeries);


        //Render uncertainties; only show shapes, no connecting lines
        XYLineAndShapeRenderer scatterRenderer = new XYLineAndShapeRenderer(false, true);
        scatterRenderer.setSeriesPaint(0, Color.BLUE);

        //Render Error Bars
        XYErrorRenderer errorRenderer = new XYErrorRenderer();
        errorRenderer.setSeriesPaint(0, Color.RED);

        //Create plot
        XYPlot plot = new XYPlot();
        plot.setDataset(0, dataset);
        plot.setRenderer(0, scatterRenderer);
        plot.setDataset(1, errorDataset);
        plot.setRenderer(1, errorRenderer);
        plot.setDomainAxis(xAxis);
        plot.setRangeAxis(yAxis);

        //Return chart
        return new JFreeChart(plotTitle, JFreeChart.DEFAULT_TITLE_FONT, plot, true);
    }

    //TODO: Remove after finished testing class
    //For local testing - will be removed later on!
    /*public static void main(String[] args) {
        JFreeChart chart = createPlot("Messwerte");
        String base64Image = ChartConverter.chartToBase64(chart, 640, 480);
        System.out.println("data:image/png;base64," + base64Image);
    }*/
}
