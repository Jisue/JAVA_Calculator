import java.util.Random;

public class Hw1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = new int[4][4];
		
		int x,y;
		for(int i=0;i<10;i++) {
			x= new Random().nextInt(4);
	        y= new Random().nextInt(4);
	         
	        if(arr[x][y]==0) {
	        	arr[x][y]= new Random().nextInt(10)+1;
	        }
	        else {
	        	i--;
	        }
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
