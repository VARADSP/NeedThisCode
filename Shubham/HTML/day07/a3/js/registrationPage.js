function check_checkbox() {
  /* get array of all languages*/
  var language = document.getElementsByName("language");
  var flag = 0;
  /* check if selected or not*/
  for (var i = 0; i < language.length; i++) {
    if (language[i].checked == false) {
      /* if not selected flag to 0*/
      flag = 0;
    } else {
      /* if selected flag to 1 return */
      return true;
    }
  }
  /* check if flag is 0 then print message*/
  if (flag == 0) {
    alert("Please select at least one area of Interest");
    /* return false to calling function*/
    return false;
  }
}
/* drag and drop */
function drag(ev) {
  //set dragging data
  ev.dataTransfer.setData("text", ev.target.id);
}

function allowDrop(ev) {
  ev.preventDefault();
}

function drop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  //appen data to drop
  ev.target.appendChild(document.getElementById(data));
}