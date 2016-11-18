public class Banner {
	public static void main(String[] args){
		String input = args[0];
		if(input.length()>10)
			input = input.substring(0, 10);
		
		int[] numArray = new int[input.length()];
		
		try{
			Integer.parseInt(input);
		} catch( NumberFormatException e ){
			System.err.println("Fehlerhafte Eingabe - nur Ziffern erlaubt!");
			System.exit(1);
		}
		
		for(int i = 0; i<input.length(); i++){
			char c = input.charAt(i);
			numArray[i] = c-'0'; //this is possible because we made sure that every character is a number above.
		}
		
		printNumbers(numArray);
	}
	
	private static void printNumbers(int[] numArray){
		String[][] numbers = {
			{
				"  ###   ",
				" #   #  ",
				"#     # ",
				"#     # ",
				"#     # ",
				" #   #  ",
				"  ###   ",
				"        ",
			},
			{
				"   #    ",
				"  ##    ",
				" # #    ",
				"   #    ",
				"   #    ",
				"   #    ",
				" #####  ",
				"        ",
			},
			{
				" #####  ",
				"#     # ",
				"      # ",
				" #####  ",
				"#       ",
				"#       ",
				"####### ",
				"        ",
			},
			{
				" #####  ",
				"#     # ",
				"      # ",
				" #####  ",
				"      # ",
				"#     # ",
				" #####  ",
				"        ",
			},
			{
				"#       ",
				"#    #  ",
				"#    #  ",
				"#    #  ",
				"####### ",
				"     #  ",
				"     #  ",
				"        ",
			},
			{
				"####### ",
				"#       ",
				"#       ",
				"######  ",
				"      # ",
				"#     # ",
				" #####  ",
				"        ",
			},
			{
				" #####  ",
				"#     # ",
				"#       ",
				"######  ",
				"#     # ",
				"#     # ",
				" #####  ",
				"        ",
			},
			{
				"####### ",
				"#    #  ",
				"    #   ",
				"   #    ",
				"  #     ",
				"  #     ",
				"  #     ",
				"        ",
			},
			{
				" #####  ",
				"#     # ",
				"#     # ",
				" #####  ",
				"#     # ",
				"#     # ",
				" #####  ",
				"        ",
			},
			{
				" #####  ",
				"#     # ",
				"#     # ",
				" ###### ",
				"      # ",
				"#     # ",
				" #####  ",
				"        ",
			}
		};

		/* we can't print each number individually because they are
		 * supposed to be next to each other in a line, so we need to 
		 * draw line after line.
		 */
		for(int line=0; line<8; line++){
			for(int i=0; i<numArray.length; i++){
				System.out.print(numbers[numArray[i]][line]);
			}
			System.out.println();
		}
	}
}
