package st1;

import javax.swing.table.TableColumn;

//������ : ��Ƽ �½�ŷ�� �������� ���� ���ÿ� �����Ͽ� ������ ���̴� ���
//1���� ��õX, 2,3,4���ٽ� ��õ

// 1 Tread�� ��ӹ޾� �ϳ��� �۾��� Ŭ������ ����� run�� ������
class MyThreadFunc extends Thread{
	@Override
	public void run() {
		for(int i =0; i<100;i++) {
			System.out.println("1������="+i + "(" +Thread.activeCount()+")");
		}
	}
}

// 2 Runnable interface�� ������ Ŭ������ ����� Ȱ��
class MyRunnableFunc implements Runnable{
	@Override
	public void run() {
		for(int i =0; i<100;i++) {
			System.out.println("2���ʺ� �������̽�="+i + "(" +Thread.activeCount()+")");
		}
	}
}

//3. runnable ���� Ŭ����
public class a20 {
	
//	public static void func() {
//		for(int i =0; i<100;i++) {
//			System.out.println("i="+i);
//		}
//	}
	public static void main(String[] args) {

		System.out.println("---main start!!");
		
		//1���
		MyThreadFunc t1 = new MyThreadFunc();
		t1.start(); // start�� run�� ȣ����
		//t.run(); // ���� run�� ȣ��
		//func();
		
		//2���
		MyRunnableFunc r = new MyRunnableFunc();
		Thread t2 = new Thread(r);
		t2.start();
		
		//3.
		Thread t3 = new Thread(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i =0; i<100;i++) {
					System.out.println("3���� Ŭ����="+ i + "(" +Thread.activeCount()+")");
				}
			}
		});
		t3.start();
		
		//4
		Thread t4 = new Thread(()->{
			for(int i =0; i<100;i++) {
				System.out.println("4���ٽ�="+i + "(" +Thread.activeCount()+")");
			}
		});
		t4.start();
		
		for(int j =0; j<100;j++) {
			System.out.println("0����="+j + "(" +Thread.activeCount()+")");
		}
		
		System.out.println("---return!!");
	}
}