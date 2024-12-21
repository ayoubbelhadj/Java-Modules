import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int countweek = 1;
		while(countweek <= 18){
			System.out.print("➜ ");
			String wek = in.nextLine();
			if (wek.equals("42"))
				break;
			if (!wek.equals("Week "+countweek)){
				System.out.println("IllegalArgument");
				in.close();
				System.exit(-1);
			}
			int mingrad = 9;
			System.out.print("➜ ");
			for(int i = 0; i < 5; i++){
				int grad = Integer.parseInt(in.next());
				if (grad < 1 || grad > 9){
					System.out.println("IllegalArgument");
					in.close();
					System.exit(-1);
				}
				mingrad = Math.min(grad, mingrad);
			}
			System.out.println(mingrad);
			in.nextLine();
			countweek++;
		}
		// String ok = "";

		// 	for(int i = 0; i < 5; i++){
		// 		int j = in.nextInt();
		// 		ok += "." + Integer.toString(j);
		// 	}
			
		// System.out.println(ok);
		in.close();
	}
}