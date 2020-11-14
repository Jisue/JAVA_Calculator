import java.util.Scanner;

public class Hw1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int[] arr = new int[100];
		
		System.out.print("정수 몇개?");
		int n = input.nextInt();
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			arr[i] = (int)(Math.random()*100)+1;
			while(cnt<i) {
				if(arr[cnt] == arr[i]) {
					arr[i] = (int)(Math.random()*100)+1;
					cnt = 0;
				}
				cnt++;
			}
			cnt = 0;
		}
		for(int i = 0;i<n;i++) {
			System.out.print(arr[i]+" ");
			if((i+1)%10 == 0) {
				System.out.println();
			}
		}
	}

}
