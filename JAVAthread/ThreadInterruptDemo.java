
public class ThreadInterruptDemo extends Thread{
	public void run(){
		System.out.println("sleep!");
		try{
			sleep(6000);
		}catch(InterruptedException e){
			System.out.println("wakeup!");
		}
	}
	
	public static void main(String args[]){
		ThreadInterruptDemo t1 = new ThreadInterruptDemo();
		t1.start();
		t1.interrupt();
	}
}
