/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Moduls.Result;

import java.awt.Color; 
import java.awt.BasicStroke; 
import java.util.ArrayList;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
/**
 *
 * @author ThinkPad
 */
public class DiscChart extends ApplicationFrame {
    
    private ArrayList<DiscModul> data;
    private String applicationTitle, chartTitle;
    
    public DiscChart( String applicationTitle, String chartTitle, ArrayList<DiscModul> data ) {
        super(applicationTitle);
        this.applicationTitle = applicationTitle;
        this.chartTitle = chartTitle;
        this.data = data;
   }
    
    public JFreeChart getPanel() {
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
            this.chartTitle ,
            "Category" ,
            "Score" ,
            this.createDataset() ,
            PlotOrientation.VERTICAL ,
            true , true , false);
        
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        return xylineChart;
    }
    
    public XYDataset createDataset( ) {
        final XYSeriesCollection dataset = new XYSeriesCollection( );
        for(DiscModul item: data){
            XYSeries i = new XYSeries(item.getDescription()); 
            i.add(new Double(1), new Double(item.getDominance()));
            i.add(new Double(2), new Double(item.getInfluence()));
            i.add(new Double(3), new Double(item.getSteadiness()));
            i.add(new Double(4), new Double(item.getCompliance()));
            dataset.addSeries(i);
        } 
        
        return dataset;
    }
    
}
