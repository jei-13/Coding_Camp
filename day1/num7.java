import java.util.HashMap;
import java.util.Scanner;

public class Num7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//도시와 인구를 10개 입력받아 해시맵에 저장하고 도시를 입력받아 인구를 출력
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		//입력받아 해시맵에 put
		System.out.print("도시, 인구 2개 입력:");
		for(int i=0; i<2; i++) {
			String city = scanner.next();
			int people = scanner.nextInt();
			map.put(city,people);
		}
		
		//도시 입력받아서 인구 출력
		while(true) {
			System.out.print("도시 이름?");
			String cname = scanner.next();
			if(cname.equals("exit")) {
				break; //종료
			}
			
			Integer pp = map.get(cname);
			if(pp == null ){ //도시가 해시맵에 없는 경우 
				System.out.println("없는 도시");
			}
			else {
				System.out.println(pp);
			}
		}
	}
}
