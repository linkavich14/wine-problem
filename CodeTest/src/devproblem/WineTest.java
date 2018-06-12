package devproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import comparators.RegionComparator;
import comparators.VarietyComparator;
import comparators.YearComparator;
import comparators.YearVarietyComparator;


public class WineTest {

	public static void main(String[] args) {

		Wine w = new Wine("11YVCHAR001", 1000);
		w.setDescription("2011 Yarra Valley Chardonnay");
		w.setTankCode("T25-01");
		w.setProductState("Ready for bottling");
		w.setOwnerName("YV Wines Pty Ltd");
		
		
		w.getComponents().add(new GrapeComponent(80D, 2011, "Chardonnay", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(10D, 2010, "Chardonnay", "Macedon"));
		w.getComponents().add(new GrapeComponent(5D, 2011, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2010, "Pinot Noir", "Macedon"));		
		
		
		w.getComponents().add(new GrapeComponent(60D, 2015, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(2D, 2015, "Pinot Noir", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(5D, 2014, "Pinot Noir", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(3D, 2015, "Merlot", "Yarra Valley"));
		w.getComponents().add(new GrapeComponent(1D, 2015, "Shiraz", "Mornington"));
		w.getComponents().add(new GrapeComponent(2D, 2015, "Zinfandel", "Macedon"));
		w.getComponents().add(new GrapeComponent(2D, 2014, "Malbec", "Port Phillip"));
		w.getComponents().add(new GrapeComponent(10D, 2014, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(10D, 2015, "Pinot Noir", "Mornington"));
		w.getComponents().add(new GrapeComponent(5D, 2013, "Cabernet", "Heathcote"));
		
		
		
		printYearBreakdown(w);
		printVarietyBreakdown(w);
		printRegionBreakdown(w);
		printYearAndVarietyBreakdown(w);
		
	}
	
	/**
	 * <p>Prints the grape components by variety and displays them by percentage from highest to lowest.</p>
	 * Only displays the component with highest amount of percentage for each unique variety
	 * @param w
	 */
	private static void printVarietyBreakdown(Wine w) {
		List<GrapeComponent> grapeComponentsList = new ArrayList<>(w.getComponents());	
		Collections.sort(grapeComponentsList, new VarietyComparator());
		
		Map<String, Double> grapeCompMap = new TreeMap<String, Double>();
		
		for (int i = 0; i < grapeComponentsList.size(); i++) {
			if (grapeCompMap.containsKey(grapeComponentsList.get(i).getVariety())) {
				grapeCompMap.put(grapeComponentsList.get(i).getVariety(), grapeCompMap.get(grapeComponentsList.get(i).getVariety()) + grapeComponentsList.get(i).getPercentage());
			} else {
				grapeCompMap.put(grapeComponentsList.get(i).getVariety(), grapeComponentsList.get(i).getPercentage());
			}
		}
		
		printSortMapByValueString(grapeCompMap);
		     		
	}
	
	/**
	 * <p>Prints the grape components by year and displays them by percentage from highest to lowest</p>
	 * Only displays the component with highest amount of percentage for each unique year
	 * @param w
	 */
	private static void printYearBreakdown(Wine w) {
		List<GrapeComponent> grapeComponentsList = new ArrayList<>(w.getComponents());		
		Collections.sort(grapeComponentsList, new YearComparator());		
		Map<Integer, Double> grapeCompMap = new TreeMap<Integer, Double>();		

		for (int i = 0; i < grapeComponentsList.size(); i++) {
			if (grapeCompMap.containsKey(grapeComponentsList.get(i).getYear())) {
				grapeCompMap.put(grapeComponentsList.get(i).getYear(), grapeCompMap.get(grapeComponentsList.get(i).getYear()) + grapeComponentsList.get(i).getPercentage());
			}else {
				grapeCompMap.put(grapeComponentsList.get(i).getYear(), grapeComponentsList.get(i).getPercentage());
			}
		}		
		
		List<Map.Entry<Integer, Double>> list = new LinkedList<Map.Entry<Integer, Double>>(grapeCompMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getValue() + "% - " + entry.getKey());
        }
	
	}
	
	/**
	 * <p>Prints the grape components by region and displays them by percentage from highest to lowest</p>
	 * Only displays the component with highest amount of percentage for each unique region
	 * @param w
	 */
	private static void printRegionBreakdown(Wine w) {
		List<GrapeComponent> grapeComponentsList = new ArrayList<>(w.getComponents());	
		Collections.sort(grapeComponentsList, new RegionComparator());
		Map<String, Double> grapeCompMap = new TreeMap<String, Double>();
		
		for (int i = 0; i < grapeComponentsList.size(); i++) {
			if (grapeCompMap.containsKey(grapeComponentsList.get(i).getRegion())) {
				grapeCompMap.put(grapeComponentsList.get(i).getRegion(), grapeCompMap.get(grapeComponentsList.get(i).getRegion()) + grapeComponentsList.get(i).getPercentage());
			} else {
				grapeCompMap.put(grapeComponentsList.get(i).getRegion(), grapeComponentsList.get(i).getPercentage());
			}
		}
		
		printSortMapByValueString(grapeCompMap);
		
	}
	
	/**
	 * <p>Prints the grape components by year, variety and displays them by percentage from highest to lowest</p>
	 * Only displays the component with highest amount of percentage for each unique variety and year
	 * @param w
	 */
	private static void printYearAndVarietyBreakdown(Wine w) {
		List<GrapeComponent> grapeComponentsList = new ArrayList<>(w.getComponents());		
		Collections.sort(grapeComponentsList, new YearVarietyComparator());
		Map<String, Double> grapeCompMap = new TreeMap<String, Double>();
		
		for (int i = 0; i < grapeComponentsList.size(); i++) {			
			String yearVariety = grapeComponentsList.get(i).getYear() + grapeComponentsList.get(i).getVariety();
			if (grapeCompMap.containsKey(yearVariety)) {
				grapeCompMap.put(yearVariety, grapeCompMap.get(yearVariety) + grapeComponentsList.get(i).getPercentage());
			}else {
				grapeCompMap.put(yearVariety, grapeComponentsList.get(i).getPercentage());
			}
		}
		
		printSortMapByValueString(grapeCompMap);
				
	}
	
	private static void printSortMapByValueString(Map<String, Double> map) {
		List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1,
                               Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
		
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getValue() + "% - " + entry.getKey());
        }
	}	

}
