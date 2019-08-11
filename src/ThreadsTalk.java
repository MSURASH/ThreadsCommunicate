
public class ThreadsTalk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object lock = new Object();
	    Thread A = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            synchronized (lock) {
	                System.out.println("A 1");
	                try {
	                    lock.wait();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("A 2");
	                System.out.println("A 3");
	                System.out.println("A 4");

	            }
	        }
	    });
	    Thread B = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            synchronized (lock) {
	                System.out.println("B 1");
	                System.out.println("B 2");
	                System.out.println("B 3");
                    try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
                System.out.println("B 4");

	        }
	    });
	    Thread C = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            synchronized (lock) {
	                System.out.println("C 1");
	                System.out.println("C 2");
	                System.out.println("C 3");
	                System.out.println("C 4");
	                System.out.println("C 5");


	                lock.notify();
	            }
	        }
	    });
	    A.start();
	    B.start();
	    C.start();

	}

}
