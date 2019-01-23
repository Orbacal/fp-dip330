import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = 0;
		System.out.println("Enter a number to check: ");
		if (sc.hasNextLong()) a = sc.nextLong();
		long t1 = System.nanoTime();
		System.out.println("SuperDigit of "+ a + " is " + superDigitEx(a));
		long t2 = System.nanoTime();
		System.out.println("Exec. time = " + (t2-t1));
		sc.close();
	}

	static long superDigitEx(long x) {
		if (x == 0) return 0;
		return x % 10 + superDigitEx(x / 10);
	}

	/* imp
	static long superDigitRec(long x) {
		long[] arr = new long[10];
		int mod, i = 0;
		long sum = 0;
		while (x > 0) {
			arr[i] = (x % 10);
			x = (int) (x / 10);
			i++;
			System.out.println(x + " ");
		}
		for (long j : arr) {
			sum += j;
		}
		return sum;
	}
	*/
}
