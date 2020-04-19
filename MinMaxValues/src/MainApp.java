//1. Write the application displaying out minimal and maximal values of the primitives containing integer numbers in the following fomat:
//    minimal byte value:   xx
//    maximal byte value:  xx
//    minimal short value:   xx
//    maximal short value:  xx
//    minimal int value:   xx
//    maximal int value:  xx
//    minimal long value:   xx
//    maximal long value:  xx
//    minimal char value:   xx
//    maximal char value:  xx
//xx-just placeholder of the value.
// 
//Minimal and maximal values are computed just based on min=max+1 and all types except char have both positive and negative values.
// 
//Good Luck!




public class MainApp {
	public static void main(String[] args) {		
		byte MaxValueByte = getByteMaxValue();
		System.out.println("Max of Byte = " + MaxValueByte);
		byte MinValueByte = (byte)(MaxValueByte + 1);
        System.out.println("Min of Byte = " + MinValueByte);
	
        short MaxValueShort = getShortMaxValue();
        System.out.println("Max of short = " + MaxValueShort);
        short MinValueShort = (short)(MaxValueShort + 1);
        System.out.println("Min of short = " + MinValueShort);
        
        int MaxValueInt = getIntMaxValue();
        System.out.println("Max of int = " + MaxValueInt);
        int MinValueInt = (int)(MaxValueInt + 1);
        System.out.println("Min of int = " + MinValueInt );
        
        long MaxValueLong = getLongMaxValue();
        System.out.println("Max of long = " + MaxValueLong);
        long MinValueLong = (long) (MaxValueLong + 1);
        System.out.println("Min of long = " + MinValueLong);
        
        char MaxValueChar = getCharMaxValue();
        System.out.println("Max of char = " + MaxValueChar);
        char MinValueChar = (char) (MaxValueChar + 1);
        System.out.println("Min of char = " + MinValueChar);
        
		
	}


	private static char getCharMaxValue() {
		char  res = 1;
		while (res > 0) {
			res *=2;
		}	
		return (char) (res - 1);
	}


	private static long getLongMaxValue() {
		long  res = 1;
		while (res > 0) {
			res *=2;
		}	
		return (long) (res - 1);
	}


	private static int getIntMaxValue() {
		int  res = 1;
		while (res > 0) {
			res *=2;
		}	
		return (int) (res - 1);
	}


	private static short getShortMaxValue() {
		short  res = 1;
		while (res > 0) {
			res *=2;
		}	
		return (short) (res - 1);
	}


	private static byte getByteMaxValue() {
		byte res = 1;
		while (res > 0) {
			res *=2;
		}	
		return (byte) (res - 1);
	}

}
