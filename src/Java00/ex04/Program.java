package Java00.ex04;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
        int[] Maps = new int[65536];
        int CountAlpha = 0;

        for (int c : input.toCharArray()) {
            Maps[c]++;
        }
        for (int map : Maps) {
            if (map != 0)
                CountAlpha++;
        }

        char[] chars = new char[CountAlpha];
        int[] freq = new int[CountAlpha];
        int index = 0;
        for (int i = 0; i < Maps.length; i++) {
            if (Maps[i] > 0){
                chars[index] = (char) i;
                freq[index] = Maps[i];
                index++;
            }
        }

        for (int i = 0; i < freq.length - 1; i++) {
            for (int j = i; j < freq.length - 1; j++) {
                if (freq[i] < freq[j + 1] || (freq[i] == freq[j + 1] && chars[i] > chars[j + 1])){
                    int tmp = freq[i];
                    freq[i] = freq[j + 1];
                    freq[j + 1] = tmp;

                    char tmp1 = chars[i];
                    chars[i] = chars[j + 1];
                    chars[j + 1] = tmp1;
                }
            }
        }

        int top = Math.min(10, freq.length);
        int[] topFreq = new int[top];
        char[] topChars = new char[top];
        for (int i = 0; i < top; i++) {
            topFreq[i] = freq[i];
            topChars[i] = chars[i];
        }

        int topNbr = topFreq[0];
        int[] chart = new int[top];
        for (int i = 0; i < top; i++) {
            chart[i] = (topFreq[i] * 10) / topNbr;
        }

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < top; j++) {
                if (i + chart[j] + 2 == 12 ){
                    System.out.format("%3d", topFreq[j]);
                }
                else if (i + chart[j] + 1 >= 12 && i - 1 != 10)
                    System.out.format("%3c", '#');
                else if (i - 1 == 10)
                    System.out.format("%3c", topChars[j]);
                else
                    System.out.format("%3c", ' ');
            }
            System.out.println();
        }
    }

}