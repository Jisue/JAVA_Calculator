import java.util.Scanner;
import java.lang.Math;

public class Hw1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("첫번째 원의 중심과 반지름 입력>>");
		
		double x = input.nextInt();
		double y = input.nextInt();
		double r = input.nextInt();
		
		System.out.print("두번째 원의 중심과 반지름 입력>>");

		double x1 = input.nextInt();
		double y1 = input.nextInt();
		double r1 = input.nextInt();
		
		double dis = Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2));
	
		if(dis < r + r1) {
			System.out.println("두 원은 서로 겹친다.");
		}
		else {
			System.out.println("두 원은 서로 겹치지 않는다.");
		}
	}
}

