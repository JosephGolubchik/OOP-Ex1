import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class SimpleGraph {

  public static void main(String[] args) throws Exception {

	  double[][] initdata = getFunctionData(-50, 50);
	  
	  // Create Chart
	  XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", initdata[0], initdata[1]);
	  
	  // Show it
	  new SwingWrapper(chart).displayChart();
	  
	  
  }
	  
  public static double[][] getFunctionData(double x0, double x1) {
	  int length = (int) (x1 - x0);
	  double[] xData = new double[length];
	  double[] yData = new double[length];
	  for (int i = 0; i < length; i++) {
		  xData[i] = x0 + i;
		  yData[i] = f(x0 + i);
	  }
	  return new double[][] { xData, yData };
  }
  
  public static double f(double x) {
	  return x*x;
  }
  
  public static void simpleChart() {
	  double[] xData = new double[] { 0.0, 1.0, 2.0 };
	  double[] yData = new double[] { 2.0, 1.0, 0.0 };

	  // Create Chart
	  XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

	  // Show it
	  new SwingWrapper(chart).displayChart();
//
//	  // Save it
//	  BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);
//
//	  // or save it in high-res
//	  BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
  }
}