function setcookie(){
	document.cookie="user=yes";
}
function getcookie(){
  var c_name="user";
	if(document.cookie.length>0){
		 var c_start = document.cookie.indexOf(c_name+"=");
        if (c_start != -1)
           {
            var c_start = c_start + c_name.length + 1;
            var c_end = document.cookie.indexOf("^", c_start);
             if (c_end == -1)
                {
                  c_end = document.cookie.length;
                 }
               if( document.cookie.substring(c_start, c_end)!="yes"){
					        window.location.href = "noa.html";
               }
           }
       }
	else{
		window.location.href = "noa.html";
	}
}