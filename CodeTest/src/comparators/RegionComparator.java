package comparators;

import java.util.Comparator;

import devproblem.GrapeComponent;

public class RegionComparator implements Comparator<GrapeComponent> {

	@Override
	public int compare(GrapeComponent o1, GrapeComponent o2) {
		//Compare by region
		int region = o2.getRegion().compareTo(o1.getRegion());
		if (region != 0) {
			return region;
		}
		
		//Compare by percentage		
		return (int) (o2.getPercentage() - o1.getPercentage());
	}

}
