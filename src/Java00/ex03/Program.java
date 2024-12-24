package Java00.ex03;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int CountWeek = 1;
		long j = 0;
		while(CountWeek <= 18){
			System.out.print("➜ ");
			String wek = in.nextLine();
			if (wek.equals("42"))
				break;
			if (!wek.equals("Week "+ CountWeek)){
				System.out.println("IllegalArgument");
				in.close();
				System.exit(-1);
			}
			int MinGrade = 9;
			System.out.print("➜ ");
			for(int i = 0; i < 5; i++) {
				int grad = Integer.parseInt(in.next());
				if (grad < 1 || grad > 9) {
					System.out.println("IllegalArgument");
					in.close();
					System.exit(-1);
				}
				MinGrade = Math.min(grad, MinGrade);
			}
			if (CountWeek == 1)
				j = MinGrade;
			else
				j = (MinGrade * (long)Math.pow(10, CountWeek - 1) ) + j;
			in.nextLine();
			CountWeek++;
		}
		int i = 1;
		while (j > 0){
			System.out.print("Week " + i + " ");
			long r = j % 10;
			for(int x = 0; x < r; x++)
				System.out.print("=");
			System.out.println(">");
			i++;
			j /= 10;
		}
		in.close();
	}
}