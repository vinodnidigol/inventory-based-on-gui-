package numbertowords;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRDefaultScriptlet;

public class Numbertowords
  extends JRDefaultScriptlet
{
  public static String convertToIndianCurrency(double num)
  {
    BigDecimal bd = new BigDecimal(num);
    long number = bd.longValue();
    long no = bd.longValue();
    int decimal = (int)(bd.remainder(BigDecimal.ONE).doubleValue() * 100.0D);
    int digits_length = String.valueOf(no).length();
    int i = 0;
    ArrayList<String> str = new ArrayList();
    HashMap<Integer, String> words = new HashMap();
    words.put(Integer.valueOf(0), "");
    words.put(Integer.valueOf(1), "One");
    words.put(Integer.valueOf(2), "Two");
    words.put(Integer.valueOf(3), "Three");
    words.put(Integer.valueOf(4), "Four");
    words.put(Integer.valueOf(5), "Five");
    words.put(Integer.valueOf(6), "Six");
    words.put(Integer.valueOf(7), "Seven");
    words.put(Integer.valueOf(8), "Eight");
    words.put(Integer.valueOf(9), "Nine");
    words.put(Integer.valueOf(10), "Ten");
    words.put(Integer.valueOf(11), "Eleven");
    words.put(Integer.valueOf(12), "Twelve");
    words.put(Integer.valueOf(13), "Thirteen");
    words.put(Integer.valueOf(14), "Fourteen");
    words.put(Integer.valueOf(15), "Fifteen");
    words.put(Integer.valueOf(16), "Sixteen");
    words.put(Integer.valueOf(17), "Seventeen");
    words.put(Integer.valueOf(18), "Eighteen");
    words.put(Integer.valueOf(19), "Nineteen");
    words.put(Integer.valueOf(20), "Twenty");
    words.put(Integer.valueOf(30), "Thirty");
    words.put(Integer.valueOf(40), "Forty");
    words.put(Integer.valueOf(50), "Fifty");
    words.put(Integer.valueOf(60), "Sixty");
    words.put(Integer.valueOf(70), "Seventy");
    words.put(Integer.valueOf(80), "Eighty");
    words.put(Integer.valueOf(90), "Ninety");
    String[] digits = { "", "Hundred", "Thousand", "Lakh", "Crore" };
    while (i < digits_length)
    {
      int divider = i == 2 ? 10 : 100;
      number = no % divider;
      no /= divider;
      i += (divider == 10 ? 1 : 2);
      if (number > 0L)
      {
        int counter = str.size();
        String plural = (counter > 0) && (number > 9L) ? "s" : "";
        String tmp = (String)words.get(Integer.valueOf((int)Math.floor(number / 10L) * 10)) + " " + (String)words.get(Integer.valueOf((int)(number % 10L))) + " " + digits[counter] + plural;
        str.add(tmp);
      }
      else
      {
        str.add("");
      }
    }
    Collections.reverse(str);
    String Rupees = String.join(" ", str).trim();
    
    String paise = decimal >= 00 ? " And Paise " + (String)words.get(Integer.valueOf(decimal - decimal % 10)) + " " + (String)words.get(Integer.valueOf(decimal % 10)) : "";
    return "Rupees " + Rupees + paise;
  }
  
  public static void main(String[] args)
  {
  System.out.println("56721351.61 = " + convertToIndianCurrency(63.92));
  }
}
