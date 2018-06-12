package comparators;

import java.util.Comparator;

import devproblem.GrapeComponent;

public class YearComparator implements Comparator<GrapeComponent> {

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		//Compare by year first to get all the objects sorted by year
		int year = o2.getYear() - o1.getYear();
		if (year != 0) {
			return year;
		}
		
		//Compare by percentage		
		return (int) (o2.getPercentage() - o1.getPercentage());
	}

}
