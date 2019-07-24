function validate(){
	var len = document.querySelectorAll('input[type="checkbox"]:checked').length;
	if(len <= 0){
		alert("Check Your interest first");
		return true;
	}
}

function success(){
	var len = document.querySelectorAll('input[type="checkbox"]:checked').length;
	if(len <= 0){
		alert("Check Your interest first");
		return true;
	}
	alert("Data saved successfully")
}
