
public class MainApp {

	public static void main(String[] args) {
        System.out.println("count of args: " + args.length);
        for (String item: args)
        {
        	System.out.println("test is " + Password.passwordCheck(item));
        }

	}

}
