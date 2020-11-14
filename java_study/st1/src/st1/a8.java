// 상속 ( inheritance ) : 공통적인 클래스를 확장해서 상속시켜 간결하게 만듦, 기능이 점점 추가.

package st1;

class Point {
	int x = 0;
	int y = 0;
	
	Point(int _x, int _y){
		if(_x<0) _x =0;
		if(_y<0) _y = 0;
		if(_x>100) _x = 100;
		if(_y>100) _y = 100;
		x = _x;
		y = _y;
	}
	void draw()	{
		System.out.print("Point: ("+x+","+y+")");
	}
}

class ColorPoint extends Point{
	String color = "black";
	
	ColorPoint(int _x, int _y, String _c)
	{
		//super();
		super(_x, _y);
		color = _c;
		
	}
	@Override
	void draw() {						// override
		super.draw();
		System.out.print(" Color: "+color);
	}
}

public class a8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point a = new Point(10,30);
		ColorPoint b = new ColorPoint(-30,40,"RED");

		a.draw();
		System.out.println();
		b.draw();
		System.out.println();
		
		Point c = b;					// upcasting
		
		if(c instanceof ColorPoint)
		{
			ColorPoint d = (ColorPoint) c;	// downcasting
			d.color = "blue";
			d.draw();
		}
		System.out.println();
		
		// ""로 String을 선언하면 새로 만든다. 이미 new로 간주한다.
		String str1 = "sejong";				// new String("Sejong")
		String str2 = str1;
		str2 = "software";					// new String("software")
		
		System.out.println(str1);
		System.out.println(str2);
		
		
			
	}

}