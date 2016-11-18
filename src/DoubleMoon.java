import java.util.ArrayList;
import java.util.List;

public class DoubleMoon {

	public static void main(String[] args) {
		final int MOONCYCLE_LENGTH = 29;
		final String[] MONTH_NAMES = { "Januar", "Februar", "Maerz", "April",
				"Mai", "Juni", "Juli", "August", "September", "Oktober",
				"November", "Dezember" };
		int[] day_lengths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int current_year = 2013;
		List<String> months_found = new ArrayList<String>();
		
		int moon_cycle_counter = 0;
		int last_moon_month = -1;
		int n = Integer.parseInt(args[0]);

		while (months_found.size() < n) {
			if (current_year % 4 == 0
					&& (current_year % 100 != 0 || current_year % 400 == 0)) { // leap
																				// year
				day_lengths[1] = 29;
			} else { // no leap year
				day_lengths[1] = 28;
			}

			for (int current_month = 0; current_month < MONTH_NAMES.length; current_month++) { // iterate
																								// through
																								// months

				for (int current_day = 0; current_day < day_lengths[current_month]; current_day++) { // iterate
																										// through
																										// days

					if (moon_cycle_counter == 0) { // Vollmond
						moon_cycle_counter = MOONCYCLE_LENGTH;
						// reset the "counter"
						if (last_moon_month == current_month) {
							// if this full moon happened in the same month like
							// the one before, add it to the list of results
							// that will be displayed at the end
							months_found.add(current_year + ", "
									+ MONTH_NAMES[current_month]);
						}
						last_moon_month = current_month;
					}

					moon_cycle_counter--;
				}

			}

			current_year++;
		}

		for (String result : months_found) {
			System.out.println(result);
		}

	}

}