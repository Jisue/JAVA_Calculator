package st1;

class A {
	
	//�ʵ�
	String name;
	int data;
	
	//������ ���� ���ϸ� defult�����ڰ� �����ȴ�. -> error�ȳ� �׷���.
	
	//������ : �ʱ�ȭ ��, return������.
	A() {
		name = "noname";
		data = 1;
	}
	//������ Overloading
	A(String in_name){
		//�������� ���� ó���� �ٸ� ������ ȣ�� ������.( �� �� ���� )
		this();
		name = in_name;
	}
	A(String in_name, int d){
		this();
		name = in_name;
		data = d;
	}
	//�޽��
	void fucn() {
		System.out.println("name=" + name+",data="+data);
	}
	
}
public class a1 {
	public static void main(String[] args) {
		//primitives : int, float , char, double...
		//reference : not primitives...(pointer)
		
		//�ݷ����� �����Ҵ����� ����� ���۷��� ������ ����Ų��.
		A a = new A("sejong"); // �޸𸮰� ������.
		a.fucn();
	}

}

//�޸�leak����, garbage : ����� ������ ����Ű�� ���۷����� ���� ��ü���� ������� ���ϴ� ����
