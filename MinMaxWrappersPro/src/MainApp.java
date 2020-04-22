
public class MainApp {

	public static void main(String[] args) {
		System.out.println("\tDATA \t\tMIN VALUE: \t\tMAX VALUE");
		if (args.length == 0) 
		{
			String[] args1 = {"BYte","shorT","char","int","long","float","double"};
			args = args1;
		}
		
		for (int i=0; i<args.length;i++) {
			String Item = args[i].toLowerCase();
			switch (Item) {
			
			case "byte": System.out.println("\tbyte \t\t" + Byte.MIN_VALUE + "\t\t\t" + Byte.MAX_VALUE );
				break;
			case "short": System.out.println("\tshort \t\t" + Short.MIN_VALUE + "\t\t\t" + Short.MAX_VALUE );
				break;
			case "char": System.out.println("\tchar \t\t" + (int) Character.MIN_VALUE + "\t\t\t" + (int)Character.MAX_VALUE );
			    break;
			case "int": System.out.println("\tint \t\t" + Integer.MIN_VALUE + "\t\t\t" + Integer.MAX_VALUE );
		        break;
			case "long": System.out.println("\tlong \t\t" + Long.MIN_VALUE + "\t\t\t" + Long.MAX_VALUE );
		        break;
			case "float": System.out.println("\tfloat \t\t" + Float.MIN_VALUE + "\t\t\t" + Float.MAX_VALUE );
		        break;
			case "double": System.out.println("\tdouble \t\t" + Double.MIN_VALUE + "\t\t\t" + Double.MAX_VALUE );
		        break;
		
				
			default: System.out.println("\twrong data type  " + args[i]);
			     break;
				
			}
		}
		
		
	}

}
