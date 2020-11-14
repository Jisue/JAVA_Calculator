import java.util.Scanner;

public class Hw1_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("연산>>");
		
		double x = input.nextDouble();
		String s = input.next();
		double y = input.nextDouble();
		
		double result = 0;
		
		
		if(s.equals("+")) {	
			result = x + y;
			System.out.println((int)x+s+(int)y+"의 계산 결과는 " + (int)result);
		}
		else if(s.equals("-")) {
			result = x - y;
			System.out.println((int)x+s+(int)y+"의 계산 결과는 " + (int)result);
		}
		else if(s.equals("*")) {
			result = x * y;
			System.out.println((int)x+s+(int)y+"의 계산 결과는 " + (int)result);
		}
		else if(s.equals("/") && y == 0) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		else {
			result = x / y;
			System.out.println((int)x+s+(int)y+"의 계산 결과는 " + (int)result);
		}
	}
}
