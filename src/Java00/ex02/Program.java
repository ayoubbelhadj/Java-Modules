package Java00.ex02;
import java.util.Scanner;
public class Program {
	public static int sum(int nbr) {
		int sum = 0;
		while(nbr > 0){
			sum += nbr % 10;
			nbr /= 10;
		}
		return sum;
	}
	public static boolean isPrime(int nbr){
		boolean flag = true;
		for (int i = 2; i < nbr; i++){
			if (nbr % i == 0){
				flag = false;
				break;
			}
			else if(i >= Math.round(Math.sqrt(nbr)))
				break;
		}
		return flag;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("➜ ");
		int nbr = in.nextInt();
		int coffee = 0;
		while (nbr != 42) {
			if (nbr > 1){
				if(isPrime(sum(nbr)))
					coffee++;
			}
			else
				System.err.println("IllegalArgument");
			System.out.print("➜ ");
			nbr = in.nextInt();
		}
		System.out.println("Count of coffee-request : " + coffee);
		in.close();
	}
}