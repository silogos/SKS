/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Result;

import Moduls.Result.DiscModul;
import Moduls.Result.ResultController;
import java.awt.Color; 
import java.awt.BasicStroke; 
import java.awt.Dimension;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartFrame;
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author ThinkPad
 */
public class chart extends ApplicationFrame {
     public chart( String applicationTitle, String chartTitle ) {
      super(applicationTitle);
//      JFreeChart xylineChart = ChartFactory.createXYLineChart(
//         chartTitle ,
//         "Category" ,
//         "Score" ,
//         createDataset() ,
//         PlotOrientation.VERTICAL ,
//         true , true , false);
//         
//      ChartPanel chartPanel = new ChartPanel( xylineChart );
//      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
//      final XYPlot plot = xylineChart.getXYPlot( );
//      
//      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
//      renderer.setSeriesPaint( 0 , Color.RED );
//      renderer.setSeriesPaint( 1 , Color.GREEN );
//      renderer.setSeriesPaint( 2 , Color.YELLOW );
//      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
//      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
//      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
//      plot.setRenderer( renderer ); 
//      setContentPane( chartPanel ); 
   }
   
   private XYDataset createDataset( ) {
      final XYSeries firefox = new XYSeries( "Firefox" );          
      firefox.add( 1.0 , 1.0 );          
      firefox.add( 2.0 , 4.0 );          
      firefox.add( 3.0 , 3.0 );          
      
      final XYSeries chrome = new XYSeries( "Chrome" );          
      chrome.add( 1.0 , 4.0 );          
      chrome.add( 2.0 , 5.0 );          
      chrome.add( 3.0 , 6.0 );          
      
      final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
      iexplorer.add( 3.0 , 4.0 );          
      iexplorer.add( 4.0 , 5.0 );          
      iexplorer.add( 5.0 , 4.0 );          
      
      final XYSeriesCollection dataset = new XYSeriesCollection( );          
      dataset.addSeries( firefox );          
      dataset.addSeries( chrome );          
      dataset.addSeries( iexplorer );
      return dataset;
   }

    public static void main( String[ ] args ) {
        ResultController dm = new ResultController();
        ArrayList<DiscModul> dataDiscArray = dm.getDiscList();
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (DiscModul item : dataDiscArray) {
            XYSeries i = new XYSeries(item.getDescription());
            i.add(0, item.getDominance());
            i.add(1, item.getInfluence());
            i.add(2, item.getSteadiness());
            i.add(3, item.getCompliance());
            dataset.addSeries(i);
        }
        
        
        JFreeChart chart = ChartFactory.createXYLineChart("DISC", "Categories", "Values", dataset, PlotOrientation.VERTICAL,  true, true, true);
        chart.setBackgroundPaint(Color.GREEN);
        
        final XYPlot plot = chart.getXYPlot( );
 
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesPaint( 3 , Color.BLUE );
        renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );

        ChartFrame frame = new ChartFrame("DISC", chart);
        frame.setVisible(true);
        frame.setSize(new Dimension(300, 500));
    }
}
