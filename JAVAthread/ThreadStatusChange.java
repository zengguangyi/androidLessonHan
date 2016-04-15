class MyRunner implements Runnable{
	public void run(){
		for(int i=0;i<20;i++){
			if(i%5==0 && i!=0){
				try{
					Thread.sleep(3000);
				}catch(InterruptedException e){
					return;
				}
			}
			System.out.println("No."+i);
		}
	}
}
public class ThreadStatusChange{
	public static void main(String args[]){
		MyRunner r = new MyRunner();
		Thread t = new Thread(r);
		
		t.start();
	}
}
