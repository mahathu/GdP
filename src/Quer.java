public class Quer {
	public static void main(String[] args) {
		int numAmount = Integer.parseInt(args[0]);
		int i = 0;
		int stepCount;
		int maxStepAmount = 1;
		
		while(numAmount>1){
			stepCount = countSteps(i);
			if(stepCount>maxStepAmount){
				System.out.println(stepCount + " Schritte: "+i);
				maxStepAmount = stepCount;
				numAmount--;
			}
			i++;
		}
	}

	private static int mdr(int n) { // multiplicative digital root (Querprodukt)
		int result = 1;

		while (n > 0) { /*
						 * alternatively, you can split the digits of the int by
						 * converting it to a string and extracting the chars,
						 * but in my opinion this is cleaner.
						 */
			result = result * (n % 10);
			n = n / 10;
		}

		return result;
	}

	private static int countSteps(int n) {
		int result = n;
		int steps = 0;

		while (result >= 10) {
			result = mdr(result);

			steps++;
		}

		return steps;
	}
}

/*
rabe hoffmmqj 27 ( Documents ) $ time java Quer 9
2 Schritte: 25
3 Schritte: 39
4 Schritte: 77
5 Schritte: 679
6 Schritte: 6788
7 Schritte: 68889
8 Schritte: 2677889
9 Schritte: 26888999

real    0m4.391s
user    0m4.354s
sys     0m0.094s
*/