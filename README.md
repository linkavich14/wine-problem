# wine-problem

A wine is made up from grapes of different sources after being blended at the winery.  These grapes have different properties such as year, variety (e.g. Chardonnay, Pinot Noir) and region (e.g. Yarra Valley, Mornington Peninsula, Macedon Ranges, etc).  When bottling a wine, the winery needs to know the percentage breakdown of these properties so they know what they can legally claim on the wine's label.

Some basic classes have been included in a zip file.  Your mission is to complete the four methods in WineTest.java to print a breakdown of the year, variety, region and year + variety information for the wine.  It needs to be printed from highest percentage to lowest and we only want to see one line printed for each unique year in printYearBreakdown(...), one line for each unique variety in printVarietyBreakdown(...), one line for each unique region in printRegionBreakdown(...) and one line for each unique combination of year + variety in printYearAndVarietyBreakdown(...).

For example, in printYearBreakdown(...) we want to see something like:

85% - 2011
15% - 2010

... and so on for the other methods.  Each method showing percentage of the unique property along with the unique properties sorted from highest percentage to lowest.

And a similar breakdown by variety in printVarietyBreakdown(...), region in printRegionBreakdown(...) and combinations in printYearAndVarietyBreakdown(...)
