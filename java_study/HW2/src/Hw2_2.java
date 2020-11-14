import java.util.Scanner;

abstract class Shape{
	private Shape next;
	public Shape() { next = null; }
	public void setNext(Shape obj) { next = obj; } // ��ũ����
	public Shape getNext() { return next; }
	public abstract void draw(); // �߻� �޼ҵ�
}
class Line extends Shape {
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Line");
	}
	
}
class Rect extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Rect");
	}
	
}
class Circle extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Circle");
	}
	
}
class GraphicEditor {
	Scanner input = new Scanner(System.in);
	private Shape start = null;
	private Shape end = null;
	int size = 0;
	
	GraphicEditor() {
		// TODO Auto-generated constructor stub
		System.out.println("�׷��� ������ beauty�� �����մϴ�.");
	}
	void getShape() { // Shape ����
		System.out.print("Line(1), Rect(2), Circle(3)>>");
		int i = input.nextInt();
		Shape s = null;
        switch(i){
            case 1:
            	s = new Line();
                break;
            case 2:
            	s = new Rect();
                break;
            case 3:
            	s = new Circle();
            default:
                break;
        }
        if(i >= 4 || i <= 0) {
        	System.out.println("���� �޴�");
        }
        if (start == null) { // ����Ʈ�� ����� ��
			start = end = s;
			size++;
		}
		else{
			end.setNext(s); // ������ ���� �ڿ� ����
	        end = s;
	        size++;
	     }
	}
	void delete() { //����
		System.out.print("������ ������ ��ġ>>");
		int i = input.nextInt();
		Shape current = start, previous = start;
		if (start == null || size < i) { // ����Ʈ�� �� ���, ������ ��ȣ�� ���°��
			 System.out.println("������ �� �����ϴ�.");
		}
		else {
			if (start == end) { // ����Ʈ�� ���Ұ� �Ѱ��ۿ� ���� ���
				start = end = null;
			}
			if (current == start) {// ù��° ���Ҹ� �����ϴ� ���
				start = start.getNext(); // ���� ���Ұ� ù��° ���Ұ� ��
			}
			else if (current == end) {// ������ ���Ҹ� �����ϴ� ���
				end = previous; // ���� ���Ұ� ������ ���Ұ� ��
				end.setNext(null);
			}
			else {
				previous.setNext(current.getNext()); // ���� ���Ҹ� ����Ʈ���� ����
			}
			size--;
		}
	}
	void printAll() { // ��ü list ���
		Shape temp = start;
		while(temp != null) {
			temp.draw();
			temp = temp.getNext();
		}
	}
}
public class Hw2_2 {
	public static void main(String[] args) {
		GraphicEditor g = new GraphicEditor();
		
        while(true){
            System.out.print("����(1), ����(2), ��� ����(3), ����(4)>>");
            Scanner input = new Scanner(System.in);
             
            int i = input.nextInt();
            switch(i){
                case 1:
                    g.getShape();
                    break;
                case 2:
                    g.delete();
                    break;
                case 3:
                    g.printAll();
                case 4:
                    break;
                default:
                    System.out.println("���� �޴�");
                    break;
            }
            if(i==4) {
            	System.out.println("beauty�� �����մϴ�.");
                break;
            }
        }
	}
}
