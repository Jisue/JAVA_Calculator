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

	@Override // key 값을 가진 value 리턴. 없으면 null
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
	void put(String key, String value) { // k,v쌍 저장. 기존 key가 있으면 value로 수정
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
	String delete(String key) { // key값을 가진 아이템 삭제. 삭제된 value값 리턴
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
	int length() { // 현재 저장된 아이템의 개수 리턴
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
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
	}
}
