import java.util.Scanner;
import java.lang.Math;

public class Hw1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("ù��° ���� �߽ɰ� ������ �Է�>>");
		
		double x = input.nextInt();
		double y = input.nextInt();
		double r = input.nextInt();
		
		System.out.print("�ι�° ���� �߽ɰ� ������ �Է�>>");

		double x1 = input.nextInt();
		double y1 = input.nextInt();
		double r1 = input.nextInt();
		
		double dis = Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
	
		if(dis < r + r1) {
			System.out.println("�� ���� ���� ��ģ��.");
		}
		else {
			System.out.println("�� ���� ���� ��ġ�� �ʴ´�.");
		}
	}
}

