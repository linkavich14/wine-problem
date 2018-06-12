package comparators;

import java.util.Comparator;

import devproblem.GrapeComponent;

public class PercentageComparator implements Comparator<GrapeComponent> {

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		return (int) (o2.getPercentage() - o1.getPercentage());
	}

}
