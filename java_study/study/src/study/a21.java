package study;


//Threand 클래스 : run, start, interrupt, sleep
//runnable 인터페이스로 사용가능

public class a21 implements Runnable{
	
	Thread th;
	
	public static void main(String[] args) {
		new a21();
	}
	
	@Override
	public void run() {
//		for(int i=0;i<10;i++) {
//			System.out.println("running:"+i);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				return;
//			}
//		}
		
		// 이 구문을 더 선호
		// run 시작하자 마다 sleep들어가지 않아서..?
		try {
			for(int i=0;i<10;i++) {
				System.out.println("running:"+i);
				Thread.sleep(100);
				//if(th.isInterrupted()) return;
				//바로 종료하지 않고 쓰레드 작업을 정리하고 나서 나갈 수 있게 됨
			}
			
		} catch (Exception e) {
			// interupt 걸면 catch문으로 빠져 나와서 굳이 return을 쓰지 않아도 된다.
			e.printStackTrace();
			//return;
		}
		
		
	}
	a21(){
		th = new Thread(this);
		th.start(); // 쓰레드 이용하려면 start로 해야함
		
		// 만약 쓰레드가 끝날때가지 기다렸다가 메인 끝나게 하려면...
		// 하지만 실제 코딩할때는 이렇게 while문 굉장히 많이 돌아서 쓰면 안됨 -> 자원 낭비임
		//while(th.isAlive()) {} // th가 돌고있으면 와일문 안에 있음
		  
    	try {
			th.join(500); // 0.5초만 기다려본다! ( 시간도 설정 가능함 )
			th.interrupt(); // 0.5초 지나도 안끝나면 예외로 넣어버림
			// 멈춰 달라고 요청만 할 뿐임
			// 쓰레드는 flag(boolean)값이 있어서 interrupt걸면 flag가 true가 됨
			// run에서 isInterrupted() 로 설정을 해줘야함.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main ends.");
	}

}

//멀티 쓰레드 하면 if 1~500, 500~1000 덧셈 분산해서 하면 sum으로 마지막에 합산해야하는 의존성이 생길 수 있다.
//스레드 동기화 : 여러개 스레드의 동시 접근 문제 해결책
//	점유를 하고있으면 lock을 걸어 준다. -> 열려있으면 들어가게됨

