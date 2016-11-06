import java.util.Scanner;

class I {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] aoeu) {
		int width = s.nextInt();
		long up   = (long) Math.pow(4, width);
		long both = (long) Math.pow(2, width);
		System.out.println(up*both);
	}
}
