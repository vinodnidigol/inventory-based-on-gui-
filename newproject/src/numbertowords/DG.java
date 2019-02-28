package numbertowords;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;



public class DG {

	 public static String convertToIndianCurrency(String num) {
//		 double r = 5.1234;
//			System.out.println(num); // r is 5.1234
//
//			int decimalPlaces = 2;
//			BigDecimal bd = new BigDecimal(num);
//
//			// setScale is immutable
//			bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
//			r = bd.doubleValue();
//
//			System.out.println(r); // r is 5.12
//		 
//			double number = Math.round(970967.106*100)/100.0000;
//			
//			System.out.println( number);
//			System.out.println(Double.parseDouble(String.valueOf(970967.106).substring(0,7)));
//		 
			double d =Double.parseDouble(num);
		    DecimalFormat df = new DecimalFormat("0.00");
		    df.setRoundingMode(RoundingMode.DOWN);

		    double outputNum = Double.valueOf(df.format(d));
		    String outpoutString = df.format(d);
		    System.out.println(outpoutString);
			
		return num;
	
	
	 }
	
	public static void main(String[] args) {
		System.out.println("56721351.61 = " + DG.convertToIndianCurrency("970967.267"));
		
		
		
	}
}
