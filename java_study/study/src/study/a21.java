package study;


//Threand Ŭ���� : run, start, interrupt, sleep
//runnable �������̽��� ��밡��

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
		
		// �� ������ �� ��ȣ
		// run �������� ���� sleep���� �ʾƼ�..?
		try {
			for(int i=0;i<10;i++) {
				System.out.println("running:"+i);
				Thread.sleep(100);
				//if(th.isInterrupted()) return;
				//�ٷ� �������� �ʰ� ������ �۾��� �����ϰ� ���� ���� �� �ְ� ��
			}
			
		} catch (Exception e) {
			// interupt �ɸ� catch������ ���� ���ͼ� ���� return�� ���� �ʾƵ� �ȴ�.
			e.printStackTrace();
			//return;
		}
		
		
	}
	a21(){
		th = new Thread(this);
		th.start(); // ������ �̿��Ϸ��� start�� �ؾ���
		
		// ���� �����尡 ���������� ��ٷȴٰ� ���� ������ �Ϸ���...
		// ������ ���� �ڵ��Ҷ��� �̷��� while�� ������ ���� ���Ƽ� ���� �ȵ� -> �ڿ� ������
		//while(th.isAlive()) {} // th�� ���������� ���Ϲ� �ȿ� ����
		  
    	try {
			th.join(500); // 0.5�ʸ� ��ٷ�����! ( �ð��� ���� ������ )
			th.interrupt(); // 0.5�� ������ �ȳ����� ���ܷ� �־����
			// ���� �޶�� ��û�� �� ����
			// ������� flag(boolean)���� �־ interrupt�ɸ� flag�� true�� ��
			// run���� isInterrupted() �� ������ �������.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main ends.");
	}

}

//��Ƽ ������ �ϸ� if 1~500, 500~1000 ���� �л��ؼ� �ϸ� sum���� �������� �ջ��ؾ��ϴ� �������� ���� �� �ִ�.
//������ ����ȭ : ������ �������� ���� ���� ���� �ذ�å
//	������ �ϰ������� lock�� �ɾ� �ش�. -> ���������� ���Ե�

