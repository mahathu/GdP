/**
 * @author Martin Hoffmann (hoffmmqj)
 * @version 1.1
 */
public class Gray {	
	/**
	 * @param  n int to be converted to gray code
	 * @return   gray code of the integer
	 */
	public static int toGray(int n){
		return n ^ (n>>1);
	}
	
	/**
	 * @param g gray code to be converted to base 10 integer as int
	 * @return base 10 integer converted from the provided gray code
	 */
	public static int fromGray(int g){
		int mask;
	    for (mask = g >> 1; mask != 0; mask = mask >> 1)
	    {
	        g = g ^ mask;
	    }
	    return g;
	}
}
