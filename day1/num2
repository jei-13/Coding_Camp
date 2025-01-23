import java.util.Scanner;
import java.util.Arrays;

public class Num2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("배열의 크기 입력:");
		
		int index = scanner.nextInt();
		
		int []arr = new int[index];
		int i;
		System.out.println("배열의 입력값을 띄어쓰기를 활용하여 입력하시오.");
		for(i=0; i<index; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println("결과:"+singleNumber(arr));
	}
	
	public static int singleNumber(int[] nums) {
		//중복되지 않는 하나의 숫자 출력
		
		//최대 숫자 찾아서 최대숫자 크기를 가진 새로운 배열 생성
		int max=0;
		for(int i=0; i<nums.length; i++) {
			if(max<nums[i]) {
				max = nums[i];
			}
		}
		int an [] = new int[max+1];
		
		//nums배열을 돌면서 an배열에 숫자 발생 카운트 
		for(int j =0; j<nums.length; j++) {
			an[nums[j]]++;
		}
		
                //1번 나온 숫자 리턴
		for(int fin=0; fin<an.length; fin++) {
			if(an[fin] == 1)
				return fin;
		}
		
		return -1;
	}
}
