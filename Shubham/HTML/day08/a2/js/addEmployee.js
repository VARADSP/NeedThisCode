function save() {
  		/* Assigning value to variable */
  		var name = document.getElementById("name").value;
  		var mobile = document.getElementById("mobile").value;
  		var role = document.getElementById("role").value;
  		/* validate user is entered value or not*/
  		if(name == "" || mobile == "" || role == "")
      {
        alert("fill all details");
      }
      else
      {
      	/* add data into local storage*/
      	localStorage.setItem("name",name);
  		localStorage.setItem("mobile",mobile);
  		localStorage.setItem("role",role);
  		/* print alert */
        text = "Name:"+ name + ", Mobile:" + mobile + ",Role:" + role;
       download("info.txt", text);
  		alert("Employee  Added Success");
  		/* claer form */
  		document.getElementById("myForm").reset();
  		}
  	}
  	function getDetails()
  	{
  		/* check if data present or not if present show data 
  		otherwise popup error	*/
  		if(localStorage.getItem("name") == null)
  		{
  			 alert("data not Found");
  		}
  		else{
  			/* Accessing local storage value to text fildes*/
  			document.getElementById("showName").value = localStorage.getItem("name");
  			document.getElementById("showMobile").value = localStorage.getItem("mobile");
  			document.getElementById("showRole").value = localStorage.getItem("role");

  		}
  	}
  	function clearLocalStorage(){
  		/*clear local storage*/
  		localStorage.clear();
  		alert("data clear success");
  		/*clear text filelds */
  		document.getElementById("showName").value = "";
  		document.getElementById("showMobile").value = "";
  		document.getElementById("showRole").value = "";

		}

    function download(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);

    element.style.display = 'none';
    document.body.appendChild(element);

    element.click();

    document.body.removeChild(element);
}