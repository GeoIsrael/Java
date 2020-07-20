package telran.model;

public class MyThreadImplements implements Runnable {

	String name;
	int max;



	public MyThreadImplements(String name, int max) {
		this.name = name;
		this.max = max;
	}
	
	
	@Override
	public void run() {

		System.out.println(name + " thread start");
		for (int i = 0; i < max; i++) {
			System.out.println("In thread " + name + ", count is" + i);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(name + " thread finish");
	}

}
