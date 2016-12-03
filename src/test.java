import java.util.Arrays;


public class test {
	public static void main(String[] args){
		int[] a = {1,2,3,4};
		int[] b = a;
		int[] c = a.clone();
		a[1] = 0;
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
	}
}
