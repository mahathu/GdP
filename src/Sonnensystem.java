import gdp.stdlib.StdDraw;
import gdp.stdlib.StdIn;

public class Sonnensystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int NUMBER_OF_PLANETS = StdIn.readInt();
		final float SYSTEM_RADIUS = StdIn.readFloat();
		final String BACKGROUND_FILE = "starfield.jpg";
		final int TIME_INTERVAL = 25000;
		final double G = 6.67e-11;

		float[][] planets = new float[NUMBER_OF_PLANETS][5];
		String[] planet_files = new String[NUMBER_OF_PLANETS];

		float[][] force = new float[NUMBER_OF_PLANETS][2];
		float[][] acceleration = new float[NUMBER_OF_PLANETS][2];

		for (int i = 0; i < NUMBER_OF_PLANETS; i++) {
			for (int j = 0; j < 5; j++) {
				planets[i][j] = StdIn.readFloat();
			}
			planet_files[i] = StdIn.readString();
		}
		/*
		 * planets[i][0] x-Koordinate des Planeten 
		 * planets[i][1] y-Koordinate des Planeten 
		 * planets[i][2] x-Geschwindigkeit des Planeten
		 * planets[i][3] y-Geschwindigkeit des Planeten 
		 * planets[i][4] Masse des Planeten
		 */

		while (true) {
			// aktuellen Zustand des Systems zeichnen
			StdDraw.setXscale(-SYSTEM_RADIUS, SYSTEM_RADIUS);
			StdDraw.setYscale(-SYSTEM_RADIUS, SYSTEM_RADIUS);

			StdDraw.picture(0, 0, BACKGROUND_FILE);
			for (int i = 0; i < NUMBER_OF_PLANETS; i++) {
				StdDraw.picture(planets[i][0], planets[i][1], planet_files[i]);
			}
			StdDraw.show(10);

			// calculate gravitational force for each planet
			double new_forceX, new_forceY, distanceX, distanceY, r, new_force;
			for (int i = 0; i < NUMBER_OF_PLANETS; i++) {
				force[i][0] = 0;
				force[i][1] = 0;

				for (int j = 0; j < NUMBER_OF_PLANETS; j++) {
					if (j == i)
						continue;

					distanceX = planets[i][0] - planets[j][0];
					distanceY = planets[i][1] - planets[j][1];

					r = Math.sqrt(Math.pow(distanceX, 2)
							+ Math.pow(distanceY, 2));

					new_force = G * planets[i][4] * planets[j][4]
							/ Math.pow(r, 2); // F=(G*m1*m2)/r^2

					new_forceX = -new_force * (distanceX / r);
					new_forceY = -new_force * (distanceY / r);

					// Die Beschleunigung in x/y-Richtung des Planeten addiert
					// sich aus den wirkenden Kräften
					force[i][0] += new_forceX;
					force[i][1] += new_forceY;
				}
			}

			// neue Planetenbeschleunigung berechnen:
			for (int i = 0; i < NUMBER_OF_PLANETS; i++) {
				acceleration[i][0] = force[i][0] / planets[i][4]; // a = F/m
				acceleration[i][1] = force[i][1] / planets[i][4]; // a = F/m
			}

			// neue Planetengeschwindigkeit:
			for (int i = 0; i < NUMBER_OF_PLANETS; i++) {
				planets[i][2] += TIME_INTERVAL * acceleration[i][0];
				planets[i][3] += TIME_INTERVAL * acceleration[i][1];
			}

			// neue Planetenposition berechnen basierend auf deren
			// Geschwindigkeit
			for (int i = 0; i < NUMBER_OF_PLANETS; i++) {
				planets[i][0] += TIME_INTERVAL * planets[i][2];
				planets[i][1] += TIME_INTERVAL * planets[i][3];
			}
		}
	}
}