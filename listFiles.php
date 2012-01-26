<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Labs</title>
</head>
<body>

<p> Projects with a link to the ReadMe and the date of last update. </p>
<?php
// open this directory
$myDirectory = opendir(".");

// get each entry
while($entryName = readdir($myDirectory)) {
	$dirArray[] = $entryName;
}

// close directory
closedir($myDirectory);

//	count elements in array
$indexCount	= count($dirArray);
//Print ("$indexCount files<br>\n");

// sort 'em
sort($dirArray);

// print 'em
print("<TABLE border=1 cellpadding=5 cellspacing=0 class=whitelinks>\n");
print("<TR style=\"background-color: gray;\"><TH>Project</TH><th>Info File</th><th>Last Updated</th></TR>\n");
// loop through the array of files and print them all
for($index=0; $index < $indexCount; $index++) {
	if (filetype($dirArray[$index])=="dir")
	if (substr("$dirArray[$index]", 0, 1) != "." ){ // don't list hidden files
		if ( $dirArray[$index] != "cgi-bin"){
		print("<TR><TD><a href=\"$dirArray[$index]\">$dirArray[$index]</a></td>");
		//print("<td>");
		print("<TD><a href=\"$dirArray[$index]/ReadMe.html\">Read Me</a></td>");
		//print("</td>");
		print("<td>");
		print(date ("m/d/Y", filemtime($dirArray[$index])));
		print("</td>");
		print("</TR>\n");
		}
	}
}
print("</TABLE>\n");

//include("./ExploreBudget/Readme.html");
?>
</body>
</html>
