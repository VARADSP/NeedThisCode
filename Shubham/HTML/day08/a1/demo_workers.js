var i = 0;

function timedCount() {
  i = i + 1;
  //Increments the counter variable by 1
  postMessage(i);
  //return the current i value
  setTimeout("timedCount()",500);
  //set maximun timeout limit
}

timedCount();