<u>**Info**</u>

 Explore the 2010 US budget. To move the pie chart use the mouse to drag
the chart and/or use the mouse wheel to scroll through the chart. Click
for zoom levels using the buttons.

<u>**Motivation**</u>

 I wanted to make a pie chart to explore the US 2010 budget. Realizing
that the budget has many large and small parts which would be hard to
show properly, it was required to look at one part of the pie at a time,
so I made this rotating pie chart.

**<u>Tools</u>**

 Protovis, jQuery, FancyBox

**<u>Results</u>**

 I’ll be first to admit that this didn’t turn out how I wanted it to.
The text is too small, but it’s hard to look at this properly at the
smallest levels. Maybe it would be easier to remove the largest parts
(National Security and Social Security) since those don’t have
interesting subsections.

 I would like to add proper colors which match for the first level and
second level nodes.

<u>**Files**</u>

-   The data used for this pie chart was from [What We Pay For][] for
    2010 budget. I noticed some negative values and I need to
    investigate the reason for those. [Data][] for all data in JS
    variable for Protovis.
-   SVG Image for [By Function][] and on [webpage][], and [By
    Subfunction][].
-   Another [image version][] with just nodes that provide more
    information shown made.

  [What We Pay For]: http://whatwepayfor.com/
  [Data]: budgetdata.js
  [By Function]: img/byFunc.svg
  [webpage]: PieChart.html
  [By Subfunction]: img/bySubfunc.svg
  [image version]: PieChartV2.html
