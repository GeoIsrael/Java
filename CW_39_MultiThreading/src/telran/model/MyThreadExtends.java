package telran.model;

public class MyThreadExtends extends Thread {

	String name;
	int max;
	Thread joinedThread;
	
	
	public MyThreadExtends(String name, int max, Thread joinedThread) {
		super();
		this.name = name;
		this.max = max;
		this.joinedThread = joinedThread;
	}
	
	
	public void run() {
		System.out.println(name + " thread start");
		
		try {
			joinedThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < max; i++) {
			System.out.println("In thread "+ name + ", count is " + i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		System.out.println(name + "thread finish");
	}
	
	
	
	
	
}
