package st1;

class Book{
	String title;
	String author;
	int idn;
	int pageNum = 0;
	Book next = null; // 다음권
	
	//고유번호는 자동 인덱스로 관리
	static int numBook = 0; // total number of books.
	static Book begin = null;
	static Book end = null;
	
	Book(String _title, String _author, int page) {
		title = _title;
		author = _author;
		pageNum = page;
		
		numBook++; // 생성자에 넣어서 자동화 시킬 수 있음.
		idn = numBook;
		
		if(begin == null)
			begin = this; // 자기 자신을 의미
		
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
		
		Book [] arr = new Book[10]; // 10개의 reference 변수
		arr[0] = new Book("Java","김",1);
		
		arr[0].print();
		
		Book a = new Book("JAVA BOOK", "김철수",300); // reference type
		//Book.numBook++;
		a.print();
		
		Book b = new Book("C++","이순희",200);
		//Book.numBook++;
		b.print();
		
		Book.begin.print();
		Book.end.print();
		
		a.print();
		a.next.print();
		
		Book.printAll();
		
		Book temp =Book.getAt(1);
		temp.author = "김지수";
		
		Book.printAll();
		
	}

}