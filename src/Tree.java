import gdp.stdlib.StdDraw;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Martin Hoffmann (hoffmmqj)
 * @version 1.1
 */
public class Tree {

	/**
	 * @param args
	 *            arguments passed from the command line.
	 */
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		draw(n, .2, .4, .1, 0);
	}

	/**
	 * @param n
	 *            recursion counter / stop drawing squares when n is below zero
	 * @param size
	 *            size of the square to be drawn (between 0 and 1)
	 * @param x
	 *            x coordinate of the square that will be drawn
	 * @param y
	 *            y coordinate of the square that will be drawn
	 * @param tilt
	 *            angle at which the square is tilted (negative values accepted)
	 */
	public static void draw(int n, double size, double x, double y, int tilt) {
		if (n < 0)
			return;

		double[] newPosition = drawSquare(x, y, size, tilt);

		int alpha = ThreadLocalRandom.current().nextInt(30, 61);
		int beta = 90 - alpha;

		double a = size * Math.cos(Math.toRadians(beta));
		double b = Math.sqrt(Math.pow(size, 2) - Math.pow(a, 2));

		double q = Math.pow(a, 2) / size;
		double p = size - q;
		double h = Math.sqrt(p * q);
		draw(n - 1, b, newPosition[0], newPosition[1], alpha + tilt);
		draw(n - 1, a, newPosition[0] + p, newPosition[1] + h, -(beta - tilt));
	}

	/**
	 * @param x
	 *            x coordinate of the square
	 * @param y
	 *            y coordinate of the square
	 * @param size
	 *            size of the square
	 * @param tilt
	 *            angle at which the square will be tilted
	 * @return returns the last element of the drawn square, in most cases the
	 *         top right corner, for the draw() function to determine where the
	 *         next, smaller square should be placed.
	 */
	public static double[] drawSquare(double x, double y, double size, int tilt) {
		double[] xPositions;
		double[] yPositions;

		tilt %= 360;

		if (tilt != 0) {
			double alpha = Math.toRadians(tilt);
			double a = size * Math.tan(alpha);
			double c = Math.sqrt(Math.pow(a, 2) + Math.pow(size, 2));
			double q = Math.pow(a, 2) / c;

			double x_offset = c - q;
			double y_offset = Math.sqrt(x_offset * q);

			if (tilt > 0) {
				xPositions = new double[] { x, x + x_offset,
						x + x_offset - y_offset, x - y_offset };
				yPositions = new double[] { y, y + y_offset,
						y + x_offset + y_offset, y + x_offset };
			} else // tilt is negative
			{
				xPositions = new double[] { x, x + x_offset,
						x + x_offset + y_offset, x + y_offset };
				yPositions = new double[] { y, y - y_offset,
						y - y_offset + x_offset, y + x_offset };
			}
		} else // no angle, just a regular square
		{
			xPositions = new double[] { x, x + size, x + size, x };
			yPositions = new double[] { y, y, y + size, y + size };
		}

		StdDraw.polygon(xPositions, yPositions);

		return new double[] { xPositions[3], yPositions[3] };
	}
}
