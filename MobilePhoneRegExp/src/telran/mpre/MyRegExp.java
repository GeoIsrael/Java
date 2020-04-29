package telran.mpre;

public class MyRegExp {

	public static boolean isMobile(String string) {
		
		boolean res1 = string.matches("053\\d{7}");
		boolean res2 = string.matches("[+]972\\d{9}");
		if (res1||res2) return true;
		return res2;
	}

	public static boolean isIp(String string) {
		return string.matches("(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
	}
	

}
