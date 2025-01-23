import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class HV {
	public static Vector<String> hashToVector(HashMap<String, String> h){
		Vector<String> v = new Vector<String>();
		Set<String> s = h.keySet();
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String key = it.next(); //다음 '키' 
			v.add(h.get(key)); //'값'알아내어 백터에 저장 (해시맵에서의 값을 구해옴)
		}
		return v;
	}
	
	public static void main(String[] args) {
		HashMap<String, String> h = new HashMap<String, String>();
		h.put("범죄", "112");
		h.put("화재", "119");
		h.put("전화번호", "114");
		
		Vector<String> v = hashToVector(h);
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i)+" ");
		}
	}
}
