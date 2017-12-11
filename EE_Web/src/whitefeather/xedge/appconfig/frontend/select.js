//$('.ui.search.dropdown').dropdown();

var URL={};
var dmName;
var accountUrl;
$(document).ready(function () {
	
    // EXTRACT JSON DATA.
    $.getJSON("domains.json", function (data) 
    		{debugger;
        $.each(data, function (index, value) {
            // APPEND OR INSERT DATA TO SELECT ELEMENT.
            $('.ui.search.dropdown').append('<option value="' + value.domainName + '">' + value.domainName + '</option>');
            dmName = value.domainName;
            URL[dmName]=value.url;
        });
    });

    // SELECT change EVENT TO READ SELECTED VALUE FROM DROPDOWN LIST.
    $('.ui.search.dropdown').change(function () {
//        $('#domainName').text(this.options[this.selectedIndex].text);
        $('#domainURL').text(URL[this.options[this.selectedIndex].text]);
    });
});

function fetchDetails()
{
	document.getElementById("logo").style.display = 'none'; 
	document.getElementById("dropDown").style.display = 'none'; 
	document.getElementById("submitDetails").style.display = 'none'; 
	document.getElementById("redirectionMessage").style.display = 'block'; 
	document.getElementById("accountURL").style.display = 'block';
	document.getElementById("accountURL").innerHTML = document.getElementById("domainURL").innerHTML;
	
}
