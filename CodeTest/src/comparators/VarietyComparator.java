package comparators;

import java.util.Comparator;

import devproblem.GrapeComponent;

public class VarietyComparator implements Comparator<GrapeComponent> {

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		//Compare by Variety
		int variety = o2.getVariety().compareTo(o1.getVariety());
		if (variety != 0) {
			return variety;
		}
		
		//Compare by percentage		
		return (int) (o2.getPercentage() - o1.getPercentage());
	}

}
