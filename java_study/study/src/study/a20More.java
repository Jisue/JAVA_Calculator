package study;

public class a20More {
	
	class Bank{
		int money = 0;
		int getMoney() {return money;}
		
		// ������ ��ũ�� �����ϸ� ��Ƽ�ǹ̰� ������
		// Vector�� ��ũ�� �Ǿ��־ ����ó���� ����
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
		
		//���ÿ� ���� ������ �̿��ϰ� ����
		CustomerThread c1 = new CustomerThread("AAA", ac);
		CustomerThread c2 = new CustomerThread("BBB", ac);
		c1.start();
		c2.start();
	}

	public static void main(String[] args) {
		new a20More();
	}

}
