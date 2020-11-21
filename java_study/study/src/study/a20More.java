package study;

public class a20More {
	
	class Bank{
		int money = 0;
		int getMoney() {return money;}
		
		// 하지만 싱크를 남발하면 멀티의미가 없어짐
		// Vector는 씽크가 되어있어서 병렬처리를 못함
		synchronized void add(int v) {
			int temp = money;
			temp += v; 
			money = temp;
			
		}
		void print() {
			System.out.println("money:" + money);
		}
	}
	
	class CustomerThread extends Thread{
		Bank ac;
		public CustomerThread(String name, Bank a) {
			// TODO Auto-generated constructor stub
			super(name);
			ac = a;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//super.run();
			for(int i = 0; i< 10; i++) {
				ac.add(100);
				System.out.println(getName() + ":" + ac.money);
			}
		}
	}
	public a20More() {
		// TODO Auto-generated constructor stub
		Bank ac = new Bank();
		
		//동시에 같은 통장을 이용하고 있음
		CustomerThread c1 = new CustomerThread("AAA", ac);
		CustomerThread c2 = new CustomerThread("BBB", ac);
		c1.start();
		c2.start();
	}

	public static void main(String[] args) {
		new a20More();
	}

}
