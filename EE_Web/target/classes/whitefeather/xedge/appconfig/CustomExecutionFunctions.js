/**
 * 
 */
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Form Type Selection</title>
</head>
<body>
<button id="selectType" name="selectAppFormType" onclick="invokeAppFormTypePopUp()">Select Application Form Type</button>
<p id="customAppURL"></p>

<script>
function userProvidedDataType()
{
	var decisionPopUp="";
	var defautTxt="";
	
	decisionPopUp = prompt("Please make choice: ?\n1. Use Computer Generated Data\n2. Provide data manually");
    if (decisionPopUp == null || decisionPopUp == "") {
    	defautTxt = "User has not provided any input.";
    } 
    else if (decisionPopUp == "1" || decisionPopUp == "Use Computer Generated Data") 
    	{
    		confirm("Redirecting to >> "+defautTxt);
    	}
    else if (decisionPopUp == "2" || decisionPopUp == "Provide data manually") 
	{
		confirm("Redirecting to >> "+defautTxt);
	}
    else if (decisionPopUp != "1" || decisionPopUp != "2" || decisionPopUp != "Use Computer Generated Data" || decisionPopUp != "Provide data manually") 
    {
    	defautTxt = "Invalid input is provided.";
    }
}
</script>
</body>
</html>