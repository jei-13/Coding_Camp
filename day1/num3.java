import java.util.Scanner;

public class Num3 {
	public boolean equallnt(int a[], int b[]) {
		int len = a.length;
		
		for(int i=0; i<len; i++) {
			if(a[i] == b[i]) {
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int a[] = {0,1,2,3,4};
		int b[] = {0,1,2,3,4};
		
		Num1 q = new Num1();
		
		if(q.equallnt(a,b) == true) {
			System.out.print("같음");
		}
		else {
			System.out.print("다름");
		}
	}
}
