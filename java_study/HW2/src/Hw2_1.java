abstract class PairMap {
	protected String keyArray [];
	protected String valueArray [];
	abstract String get(String key);
	abstract void put(String key, String value);
	abstract String delete(String key); 
	abstract int length(); 
}

class Dictionary extends PairMap {
	
	int len = 0;
	
	Dictionary(int n){
		len = n;
		keyArray = new String [len];
		valueArray = new String [len];
	}

	@Override // key ���� ���� value ����. ������ null
	String get(String key) {
		// TODO Auto-generated method stub
		for(int i=0;i<length();i++) {
			if(keyArray[i] == key) {
				return valueArray[i];
			}
		}
		return null;
	}

	@Override
	void put(String key, String value) { // k,v�� ����. ���� key�� ������ value�� ����
		// TODO Auto-generated method stub
		String g = get(key);
		if (g == null) {
			int n = length();
			keyArray[n] = key;
			valueArray[n] = value;
		}
		else {
			for(int i=0;i<len;i++) {
				if(keyArray[i] == key) {
					valueArray[i] = value;
				}
			}
		}
	}

	@Override
	String delete(String key) { // key���� ���� ������ ����. ������ value�� ����
		// TODO Auto-generated method stub
		String g = get(key);
		if(g != null) {
			String del;
			for(int i=0;i<length();i++) {
				if(keyArray[i] == key) {
					del = valueArray[i];
					keyArray[i] = null;
					valueArray[i] = null;
					return del;
				}
			}
		}
		return null;
	}

	@Override
	int length() { // ���� ����� �������� ���� ����
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=0;i<len;i++) {
			if(keyArray[i] == null) {
				break;
			}
			cnt++;
		}
		return cnt;
	}
	
	
}
public class Hw2_1 { // DictionaryApp
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("Ȳ����", "�ڹ�");
		dic.put("���繮", "���̽�");
		dic.put("���繮", "C++");
		System.out.println("���繮�� ���� " + dic.get("���繮"));
		System.out.println("Ȳ������ ���� " + dic.get("Ȳ����"));
		dic.delete("Ȳ����");
		System.out.println("Ȳ������ ���� " + dic.get("Ȳ����"));
	}
}
