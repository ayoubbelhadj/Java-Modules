import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("➜ ");
		int nbr = in.nextInt();
		boolean flag = true;
		int step = 0;
		if (nbr > 1){
			for (int i = 2; i < nbr; i++){
				step++;
				if (nbr % i == 0){
					flag = false;
					break;
				}
				else if(i >= Math.round(Math.sqrt(nbr)))
					break;
			}
		}
		else {
			System.err.println("IllegalArgument");
			in.close();
			System.exit(1);
		}
		
		System.out.println(flag + " " + step);
		in.close();
	}
}