package st1;

class A {
	
	//필드
	String name;
	int data;
	
	//생성자 생성 안하면 defult생성자가 생성된다. -> error안남 그래서.
	
	//생성자 : 초기화 함, return값없음.
	A() {
		name = "noname";
		data = 1;
	}
	//생성자 Overloading
	A(String in_name){
		//생성자의 제일 처음에 다른 생성자 호출 가능함.( 딱 한 번만 )
		this();
		name = in_name;
	}
	A(String in_name, int d){
		this();
		name = in_name;
		data = d;
	}
	//메쏘드
	void fucn() {
		System.out.println("name=" + name+",data="+data);
	}
	
}
public class a1 {
	public static void main(String[] args) {
		//primitives : int, float , char, double...
		//reference : not primitives...(pointer)
		
		//콜래스는 동적할당으로 만들고 레퍼런스 변수로 가르킨다.
		A a = new A("sejong"); // 메모리가 잡힌다.
		a.fucn();
	}

}

//메모리leak상태, garbage : 존재는 하지만 가르키는 레퍼런스가 없는 객체여서 사용하지 못하는 상태
