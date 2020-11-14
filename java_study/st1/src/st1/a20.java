package st1;

import javax.swing.table.TableColumn;

//스레드 : 멀티 태스킹은 여러개의 앱을 동시에 실행하여 성능을 높이는 기법
//1번은 추천X, 2,3,4람다식 추천

// 1 Tread를 상속받아 하나의 작업용 클래스를 만들고 run을 재정의
class MyThreadFunc extends Thread{
	@Override
	public void run() {
		for(int i =0; i<100;i++) {
			System.out.println("1쓰레드="+i + "(" +Thread.activeCount()+")");
		}
	}
}

// 2 Runnable interface를 구현한 클래스를 만들고 활용
class MyRunnableFunc implements Runnable{
	@Override
	public void run() {
		for(int i =0; i<100;i++) {
			System.out.println("2러너블 인터페이스="+i + "(" +Thread.activeCount()+")");
		}
	}
}

//3. runnable 무명 클래스
public class a20 {
	
//	public static void func() {
//		for(int i =0; i<100;i++) {
//			System.out.println("i="+i);
//		}
//	}
	public static void main(String[] args) {

		System.out.println("---main start!!");
		
		//1방법
		MyThreadFunc t1 = new MyThreadFunc();
		t1.start(); // start가 run을 호출함
		//t.run(); // 직접 run을 호출
		//func();
		
		//2방법
		MyRunnableFunc r = new MyRunnableFunc();
		Thread t2 = new Thread(r);
		t2.start();
		
		//3.
		Thread t3 = new Thread(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i =0; i<100;i++) {
					System.out.println("3무명 클래스="+ i + "(" +Thread.activeCount()+")");
				}
			}
		});
		t3.start();
		
		//4
		Thread t4 = new Thread(()->{
			for(int i =0; i<100;i++) {
				System.out.println("4람다식="+i + "(" +Thread.activeCount()+")");
			}
		});
		t4.start();
		
		for(int j =0; j<100;j++) {
			System.out.println("0메인="+j + "(" +Thread.activeCount()+")");
		}
		
		System.out.println("---return!!");
	}
}