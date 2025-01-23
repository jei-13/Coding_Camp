import java.util.Scanner;

public class UpDown {
	Scanner scanner = new Scanner(System.in);
	public void q(){
		int ran = (int)(Math.random()*100);
		System.out.println("수를 결정하였습니다. 맞춰보세요.");
		System.out.println("0-99");
		
		int n=1; //횟수
		int minn =0; //최솟값
		int maxn = 99; //최댓값
		while(true) {
			System.out.print(n+">>");
			int num = scanner.nextInt();
			
			if(num!=ran) {
				if(num < ran) {
					System.out.println("더 높게");
					minn = Math.max(minn, num); //minn과 num중에 큰 값 리턴
					n++;
				}
				else if(num > ran) {
					System.out.println("더 낮게");
					maxn = Math.min(maxn, num); //maxn과 num중에 작은 값 리턴
					n++;
				}	
				System.out.println(minn+"-"+maxn); //현재 범위
			}
			
			else if(num == ran) {
				System.out.println("맞았습니다.");
				System.out.print("다시 하시겠습니다(y/n)>>");
				String an = scanner.next();
				if(an.equals("y")) {
						q();
				}
				else if(an.equals("n")){
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		UpDown up = new UpDown();
		up.q();
	}

}
