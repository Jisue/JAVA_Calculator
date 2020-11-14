import java.util.Scanner;

abstract class Shape{
	private Shape next;
	public Shape() { next = null; }
	public void setNext(Shape obj) { next = obj; } // 링크연결
	public Shape getNext() { return next; }
	public abstract void draw(); // 추상 메소드
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
		System.out.println("그래픽 에디터 beauty을 실행합니다.");
	}
	void getShape() { // Shape 삽입
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
        	System.out.println("없는 메뉴");
        }
        if (start == null) { // 리스트가 비었을 때
			start = end = s;
			size++;
		}
		else{
			end.setNext(s); // 마지막 원소 뒤에 삽입
	        end = s;
	        size++;
	     }
	}
	void delete() { //삭제
		System.out.print("삭제할 도형의 위치>>");
		int i = input.nextInt();
		Shape current = start, previous = start;
		if (start == null || size < i) { // 리스트가 빈 경우, 삭제할 번호가 없는경우
			 System.out.println("삭제할 수 없습니다.");
		}
		else {
			if (start == end) { // 리스트에 원소가 한개밖에 없는 경우
				start = end = null;
			}
			if (current == start) {// 첫번째 원소를 삭제하는 경우
				start = start.getNext(); // 다음 원소가 첫번째 원소가 됨
			}
			else if (current == end) {// 마지막 원소를 삭제하는 경우
				end = previous; // 이전 원소가 마지막 원소가 됨
				end.setNext(null);
			}
			else {
				previous.setNext(current.getNext()); // 현재 원소를 리스트에서 삭제
			}
			size--;
		}
	}
	void printAll() { // 전체 list 출력
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
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
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
                    System.out.println("없는 메뉴");
                    break;
            }
            if(i==4) {
            	System.out.println("beauty을 종료합니다.");
                break;
            }
        }
	}
}
