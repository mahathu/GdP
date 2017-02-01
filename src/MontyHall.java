import java.util.concurrent.ThreadLocalRandom;

public class MontyHall {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		float[] results = doSimulation(n);

		System.out.println("Wechseln: " + results[0]);
		System.out.println("Nichtwechseln: " + results[1]);
	}

	private static float[] doSimulation(int n) {
		float[] chances = { 0, 0 };

		int switchDoor;
		/*
		 * boolean[] possibleSwitchDoors = { false, true, true }; this array
		 * keeps track of all the doors the player can switch to. He can't
		 * switch to the first door because we assume this is the one he picks.
		 * He also can't switch to the second door with no prize behind it,
		 * because that's the one the host opens before giving him the option to
		 * switch.
		 * 
		 * I used to use a boolean here but decided against it because the
		 * option used below is easier. A potential third option would be to use
		 * a mathematical formular (using a modulo operation maybe) to determine
		 * which door the player should be given the option to switch to.
		 */

		for (int i = 0; i < n; i++) {
			int winningDoor = ThreadLocalRandom.current().nextInt(0, 3);
			// picks a random door for the prize. It is assumed that the player
			// always chooses door #1 (0) as their first pick.

			// player doesn't switch
			if (winningDoor == 0) {
				chances[1]++;
			}

			// player switches
			if (winningDoor == 0) {
				/*
				 * If the user chooses the winning door correctly, the host can
				 * choose any of the two remaining doors to show, it doesn't
				 * make a difference.
				 */
				switchDoor = 1;
			} else {
				/*
				 * If the player initially picks a "wrong" door, the show master
				 * needs to open the second "wrong door", so the only door left
				 * that the player will be given the option to switch to is the
				 * door with the prize behind it.
				 */
				switchDoor = winningDoor;
			}

			/*
			 * this could also be put in the if/else statements above, but to
			 * demonstrate the simulation i put it here at the end seperately.
			 */
			if (winningDoor == switchDoor) {
				chances[0]++;
			}

		}
		chances[0] = chances[0] / n;
		chances[1] = chances[1] / n;
		return chances;
	}
}