public class Num1 {
	
	public static void main(String[] args) {
		int random [] = new int[10];
		double avg=0;
		
		for(int i=0; i<random.length; i++) {
			int num = (int)(Math.random()*101+100); //0-100 > 100-200
			avg += num;
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.print(avg/random.length);
	}
}
