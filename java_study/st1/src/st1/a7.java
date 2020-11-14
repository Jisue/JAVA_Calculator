package st1;

class Book{
	String title;
	String author;
	int idn;
	int pageNum = 0;
	Book next = null; // ������
	
	//������ȣ�� �ڵ� �ε����� ����
	static int numBook = 0; // total number of books.
	static Book begin = null;
	static Book end = null;
	
	Book(String _title, String _author, int page) {
		title = _title;
		author = _author;
		pageNum = page;
		
		numBook++; // �����ڿ� �־ �ڵ�ȭ ��ų �� ����.
		idn = numBook;
		
		if(begin == null)
			begin = this; // �ڱ� �ڽ��� �ǹ�
		
		if(end != null)
			end.next = this;
		end = this;
	}
	
	void print() {
		System.out.println("id:"+idn+" Title:"+title+" ["+author+"] "+pageNum+"pages");
	}
	static void printAll() {
		
		Book p = begin;
		
		while(true) {
			if(p == null) break;
			p.print();
			p = p.next;
		}

	}
	static Book getAt(int index) {
		Book out = null;
		Book p = begin;
		
		while(true) {
			if(p == null) break;
			if(index == p.idn) out = p;
			p.print();
			p = p.next;
		}
		return out;
	}
}
public class a7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book [] arr = new Book[10]; // 10���� reference ����
		arr[0] = new Book("Java","��",1);
		
		arr[0].print();
		
		Book a = new Book("JAVA BOOK", "��ö��",300); // reference type
		//Book.numBook++;
		a.print();
		
		Book b = new Book("C++","�̼���",200);
		//Book.numBook++;
		b.print();
		
		Book.begin.print();
		Book.end.print();
		
		a.print();
		a.next.print();
		
		Book.printAll();
		
		Book temp =Book.getAt(1);
		temp.author = "������";
		
		Book.printAll();
		
	}

}