package Java00.ex05;
import java.util.Arrays;
import java.util.Scanner;

public class Program{
	public static int getHour(String input){
		char[] hour = input.toCharArray();
		if (input.length() < 3)
			return -1;
		if (hour[0] >= '1' && hour[0] <= '6')
			return hour[0] - '0' - 1;
		return -1;
	}
	public static int getDay(String input){
		String[] week = {"TU", "WE", "TH", "FR", "SA", "SU", "MO"};
		if (input.length() < 3)
			return -1;
		char[] Day = input.toCharArray();
		for (int i = 0; i < 7; i++) {
			char[] strW = week[i].toCharArray();
			if (strW[0] == Day[2] && strW[1] == Day[3])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int StudentsCount = 0;
		String[] Students = new String[10];
		while (true){
			if(StudentsCount >= 10){
				System.out.println("-> .");
				break;
			}
			System.out.print("-> ");
			String input = in.nextLine();
			if (input.equals("."))
				break;
			if (input.isEmpty())
				continue;
			if (input.length() > 10){
				System.out.println("Max name length is 10.");
				continue;
			}

			Students[StudentsCount] = input;
			StudentsCount++;
		}

		int[] ScheduleHour = new int[10];
		int[] ScheduleDay = new int[10];
		boolean[][][] ScheduleMonth = new boolean[6][30][7];
		int   ScheduleCount = 0;
		while (true){
			if (StudentsCount >= 10){
				System.out.println("-> .");
				break;
			}
			System.out.print("-> ");
			String input = in.nextLine();
			if (input.equals("."))
				break;
			if (input.isEmpty())
				continue;
			int hour = getHour(input);
			int day  = getDay(input);
			if (hour == -1 || day == -1){
				System.out.println("IllegalArgument");
				continue;
			}
			ScheduleCount++;
            getSchedule(ScheduleMonth, hour, day);
        }
		// get all day of the month
//		for (int i = 0; i < 30; i++) {
//			System.out.format("%3d", i+1);
//		}
//		System.out.println();
//		for (int i = 0; i < 6; i++) {
//			for (int j = 0; j < 30; j++) {
//				for (int k = 0; k < 7; k++) {
//					if (ScheduleMonth[i][j][k]){
//						System.out.print("  1");
//						break;
//					}
//					else if (k + 1 == 7)
//						System.out.print("  0");
//				}
//			}
//				System.out.println();
//		}
		int[][][] StudentSchedules =new int[10][30][6];
		while (true){
			System.out.print("-> ");
			String input = in.next();
			if (input.equals("."))
				break;
			if (input.isEmpty())
				continue;
			int studentIndex = getStudentIndex(Students, input);
			if (studentIndex == -1){
				System.out.println("Name not found.");
				continue;
			}
			int time = in.nextInt();
			int day = in.nextInt();
			String Presence = in.next();
			if(Presence.equals("HERE"))
				StudentSchedules[studentIndex][day][time] = 1;
			else if (Presence.equals("NOT_HERE"))
				StudentSchedules[studentIndex][day][time] = -1;
			else {
				System.out.println("IllegalArgument");
				continue;
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 30; j++) {
				for (int k = 0; k < 6; k++) {
					if (StudentSchedules[i][j][k] == 1){
						System.out.print("01");
					}
					else if (StudentSchedules[i][j][k] == -1){
						System.out.print("-1");
					}
					else
						System.out.print(".|");
				}
				System.out.print("*");
			}
				System.out.println();
		}
		in.close();
	}
	public static void getSchedule(boolean[][][] ScheduleMonth, int hour, int day){
		int dayIndex = day;
		for (int i = 0; i < 5 && dayIndex < 30; i++){
			ScheduleMonth[hour][dayIndex][day] = true;
			dayIndex += 7;
		}
//		return ScheduleMonth;
	}
	public static int getStudentIndex(String[] Students, String input){
		for (int i = 0; i < Students.length; i++){
			if (Students[i] != null && input.equals(Students[i]))
				return i;
		}
		return -1;
	}

//0000001000000100000010000001000000

}