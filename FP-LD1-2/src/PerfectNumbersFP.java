import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumbersFP {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Perfect number check by Orbacle (LD1-2) ");
		System.out.println("Enter anything other than a number to exit.");
		System.out.print("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int a = 0;
		while(true) {
			try { a = sc.nextInt(); }
			catch(Exception e) {
				sc.close();
				return;
			}
			String numType;
			Set<Integer> set = divisors(a);
			System.out.print("Divisors of number " + a + ": ");
			System.out.println(set);
			STATE state = detect(set, a);
			switch (state) {
			case PERFECT:
				numType = "perfect";
				break;
			case ABUNDANT:
				numType = "abundant";
				break;
			case DEFICIENT:
				numType = "deficient";
				break;
			case PRIME:
				numType = "prime";
				break;
			default:
				numType = "too special for this test";
				break;
			}
			System.out.println("The number " + a + " is " + numType);
			System.out.println();
		}
	}
	
	public enum STATE {
		DEFICIENT, ABUNDANT, PERFECT, PRIME, NA;
	}
	
	public static STATE detect(Set<Integer> set, int n) {
		STATE numType = STATE.NA;
		int sum = set.stream().mapToInt(Integer::intValue).sum();
		if (sum == n && n != 0) { numType = STATE.PERFECT; }
		else if (sum > n && n > 0) { numType = STATE.ABUNDANT; }
		else if (sum == 1) { numType = STATE.PRIME; }
		else if (sum < n && sum > 1) { numType = STATE.DEFICIENT; }
		return numType;
	}
	
	public static Set<Integer> divisors(int n) {
		return IntStream.rangeClosed(1, n/2)
						.filter(i -> n % i == 0)
						.boxed()
						.collect(Collectors.toCollection(HashSet::new));
		
	}
}
