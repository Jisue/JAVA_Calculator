// ��� ( inheritance ) : �������� Ŭ������ Ȯ���ؼ� ��ӽ��� �����ϰ� ����, ����� ���� �߰�.

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
		
		// ""�� String�� �����ϸ� ���� �����. �̹� new�� �����Ѵ�.
		String str1 = "sejong";				// new String("Sejong")
		String str2 = str1;
		str2 = "software";					// new String("software")
		
		System.out.println(str1);
		System.out.println(str2);
		
		
			
	}

}