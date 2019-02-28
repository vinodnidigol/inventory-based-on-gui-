package numbertowords;





	import java.io.PrintStream;
	import net.sf.jasperreports.engine.JRDefaultScriptlet;

	public class NUM
	  extends JRDefaultScriptlet
	{
	  String numberInWord = "";
	  String inpstr = "";
	  int inputLength;
	  String temp = "";
	  
	  public String readNumber(double xDouble)
	  {
	    double x = xDouble;
	    this.inpstr = ("" + x);
	    this.inpstr = this.inpstr.trim();
	    this.inputLength = this.inpstr.length();
	    this.numberInWord = "";
	    if (this.inpstr.substring(0, 1).trim().equalsIgnoreCase("-"))
	    {
	      this.inpstr = this.inpstr.substring(1);
	      this.inputLength -= 1;
	    }
	    getDigits(this.inputLength);
	    return this.numberInWord;
	  }
	  
	  public void getDigits(int x)
	  {
	    if (x == 1)
	    {
	      ones(this.inpstr);
	    }
	    else if (x == 2)
	    {
	      tens(this.inpstr);
	    }
	    else if (x == 3)
	    {
	      ones(this.inpstr.substring(0, 1));
	      if (!"0".equals(this.inpstr.substring(0, 1))) {
	        this.numberInWord += " hundred";
	      }
	      tens(this.inpstr.substring(1, 3));
	    }
	    else if (x == 4)
	    {
	      ones(this.inpstr.substring(0, 1));
	      if (!"0".equals(this.inpstr.substring(0, 1))) {
	        this.numberInWord += " thousand";
	      }
	      ones(this.inpstr.substring(1, 2));
	      if (!"0".equals(this.inpstr.substring(1, 2))) {
	        this.numberInWord += " hundred";
	      }
	      tens(this.inpstr.substring(2, 4));
	    }
	    else if (x == 5)
	    {
	      tens(this.inpstr.substring(0, 2));
	      if (!"00".equals(this.inpstr.substring(0, 2))) {
	        this.numberInWord += " thousand";
	      }
	      ones(this.inpstr.substring(2, 3));
	      if (!"0".equals(this.inpstr.substring(2, 3))) {
	        this.numberInWord += " hundred";
	      }
	      tens(this.inpstr.substring(3, 5));
	    }
	    else if (x == 6)
	    {
	      tens(this.inpstr.substring(0, 3));
	      if (!"000".equals(this.inpstr.substring(0, 3))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(3, 6));
	    }
	    else if (x == 7)
	    {
	      ones(this.inpstr.substring(0, 1));
	      if (!"0".equals(this.inpstr.substring(0, 1))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(1, 4));
	      if (!"000".equals(this.inpstr.substring(1, 4))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(4, 7));
	    }
	    else if (x == 8)
	    {
	      tens(this.inpstr.substring(0, 2));
	      if (!"00".equals(this.inpstr.substring(0, 2))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(2, 5));
	      if (!"000".equals(this.inpstr.substring(2, 5))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(5, 8));
	    }
	    else if (x == 9)
	    {
	      tens(this.inpstr.substring(0, 3));
	      if (!"000".equals(this.inpstr.substring(0, 3))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(3, 6));
	      if (!"000".equals(this.inpstr.substring(3, 6))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(6, 9));
	    }
	    else if (x == 10)
	    {
	      ones(this.inpstr.substring(0, 1));
	      if (!"0".equals(this.inpstr.substring(0, 1))) {
	        this.numberInWord += " billion";
	      }
	      tens(this.inpstr.substring(1, 4));
	      if (!"000".equals(this.inpstr.substring(1, 4))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(4, 7));
	      if (!"000".equals(this.inpstr.substring(4, 7))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(7, 10));
	    }
	    else if (x == 11)
	    {
	      tens(this.inpstr.substring(0, 2));
	      if (!"00".equals(this.inpstr.substring(0, 2))) {
	        this.numberInWord += " billion";
	      }
	      tens(this.inpstr.substring(2, 5));
	      if (!"00".equals(this.inpstr.substring(2, 4))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(5, 8));
	      if (!"00".equals(this.inpstr.substring(5, 7))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(8, 11));
	    }
	    else if (x == 12)
	    {
	      tens(this.inpstr.substring(0, 3));
	      if (!"000".equals(this.inpstr.substring(0, 3))) {
	        this.numberInWord += " billion";
	      }
	      tens(this.inpstr.substring(3, 6));
	      if (!"000".equals(this.inpstr.substring(3, 6))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(6, 9));
	      if (!"000".equals(this.inpstr.substring(6, 9))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(9, 12));
	    }
	    else if (x == 13)
	    {
	      ones(this.inpstr.substring(0, 1));
	      if (!"0".equals(this.inpstr.substring(0, 1))) {
	        this.numberInWord += " trillion";
	      }
	      tens(this.inpstr.substring(1, 4));
	      if (!"000".equals(this.inpstr.substring(1, 4))) {
	        this.numberInWord += " billion";
	      }
	      tens(this.inpstr.substring(4, 7));
	      if (!"000".equals(this.inpstr.substring(4, 7))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(7, 10));
	      if (!"000".equals(this.inpstr.substring(7, 10))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(10, 13));
	    }
	    else if (x == 14)
	    {
	      tens(this.inpstr.substring(0, 2));
	      if (!"00".equals(this.inpstr.substring(0, 2))) {
	        this.numberInWord += " trillion";
	      }
	      tens(this.inpstr.substring(2, 5));
	      if (!"000".equals(this.inpstr.substring(2, 5))) {
	        this.numberInWord += " billion";
	      }
	      tens(this.inpstr.substring(5, 8));
	      if (!"000".equals(this.inpstr.substring(5, 8))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(8, 11));
	      if (!"000".equals(this.inpstr.substring(8, 11))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(11, 14));
	    }
	    else if (x == 15)
	    {
	      tens(this.inpstr.substring(0, 3));
	      if (!"000".equals(this.inpstr.substring(0, 3))) {
	        this.numberInWord += " trillion";
	      }
	      tens(this.inpstr.substring(3, 6));
	      if (!"000".equals(this.inpstr.substring(3, 6))) {
	        this.numberInWord += " billion";
	      }
	      tens(this.inpstr.substring(6, 9));
	      if (!"000".equals(this.inpstr.substring(6, 9))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(9, 12));
	      if (!"000".equals(this.inpstr.substring(9, 12))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(12, 15));
	    }
	    else if (x == 16)
	    {
	      ones(this.inpstr.substring(0, 1));
	      if (!"0".equals(this.inpstr.substring(0, 1))) {
	        this.numberInWord += " quadrillion";
	      }
	      tens(this.inpstr.substring(1, 4));
	      if (!"000".equals(this.inpstr.substring(1, 4))) {
	        this.numberInWord += " trillion";
	      }
	      tens(this.inpstr.substring(4, 7));
	      if (!"000".equals(this.inpstr.substring(4, 7))) {
	        this.numberInWord += " billion";
	      }
	      tens(this.inpstr.substring(7, 10));
	      if (!"000".equals(this.inpstr.substring(7, 10))) {
	        this.numberInWord += " million";
	      }
	      tens(this.inpstr.substring(10, 13));
	      if (!"000".equals(this.inpstr.substring(10, 13))) {
	        this.numberInWord += " thousand";
	      }
	      tens(this.inpstr.substring(13, 16));
	    }
	    else
	    {
	      System.out.println("  Your number is too big for me to spell ");
	    }
	  }
	  
	  public void tens2(String x)
	  {
	    this.temp = x;
	    if ((x.length() > 2) && (x.charAt(0) != '0'))
	    {
	      ones(x.substring(0, 1));
	      this.numberInWord += " hundred";
	      tens(x.substring(1, 3));
	      
	      x = "";
	      this.temp = "   ";
	    }
	    else if ((x.length() > 2) && (x.charAt(0) == '0'))
	    {
	      tens(x.substring(1, 3));
	      
	      x = "";
	      this.temp = "   ";
	    }
	    else
	    {
	      x = x.substring(0, 1);
	    }
	    if ("2".equals(x)) {
	      this.numberInWord += " twenty";
	    } else if ("3".equals(x)) {
	      this.numberInWord += " thirty";
	    } else if ("4".equals(x)) {
	      this.numberInWord += " fourty";
	    } else if ("5".equals(x)) {
	      this.numberInWord += " fifty";
	    } else if ("6".equals(x)) {
	      this.numberInWord += " sixty";
	    } else if ("7".equals(x)) {
	      this.numberInWord += " seventy";
	    } else if ("8".equals(x)) {
	      this.numberInWord += " eighty";
	    } else if ("9".equals(x)) {
	      this.numberInWord += " ninety";
	    }
	    ones(this.temp.substring(1, 2));
	  }
	  
	  public void tens(String x)
	  {
	    if ("10".equals(x)) {
	      this.numberInWord += " ten";
	    } else if ("20".equals(x)) {
	      this.numberInWord += " twenty";
	    } else if ("30".equals(x)) {
	      this.numberInWord += " thirty";
	    } else if ("40".equals(x)) {
	      this.numberInWord += " fourty";
	    } else if ("50".equals(x)) {
	      this.numberInWord += " fifty";
	    } else if ("60".equals(x)) {
	      this.numberInWord += " sixty";
	    } else if ("70".equals(x)) {
	      this.numberInWord += " seventy";
	    } else if ("80".equals(x)) {
	      this.numberInWord += " eighty";
	    } else if ("90".equals(x)) {
	      this.numberInWord += " ninty";
	    } else if ("11".equals(x)) {
	      this.numberInWord += " eleven";
	    } else if ("12".equals(x)) {
	      this.numberInWord += " twelve";
	    } else if ("13".equals(x)) {
	      this.numberInWord += " thirteen";
	    } else if ("14".equals(x)) {
	      this.numberInWord += " fourteen";
	    } else if ("15".equals(x)) {
	      this.numberInWord += " fifteen";
	    } else if ("16".equals(x)) {
	      this.numberInWord += " sixteen";
	    } else if ("17".equals(x)) {
	      this.numberInWord += " seventeen";
	    } else if ("18".equals(x)) {
	      this.numberInWord += " eighteen";
	    } else if ("19".equals(x)) {
	      this.numberInWord += " ninteen";
	    } else {
	      tens2(x);
	    }
	  }
	  
	  public void ones(String x)
	  {
	    if ("1".equals(x)) {
	      this.numberInWord += " one";
	    } else if ("2".equals(x)) {
	      this.numberInWord += " two";
	    } else if ("3".equals(x)) {
	      this.numberInWord += " three";
	    } else if ("4".equals(x)) {
	      this.numberInWord += " four";
	    } else if ("5".equals(x)) {
	      this.numberInWord += " five";
	    } else if ("6".equals(x)) {
	      this.numberInWord += " six";
	    } else if ("7".equals(x)) {
	      this.numberInWord += " seven";
	    } else if ("8".equals(x)) {
	      this.numberInWord += " eight";
	    } else if ("9".equals(x)) {
	      this.numberInWord += " nine";
	    }
	  }
	}

	
