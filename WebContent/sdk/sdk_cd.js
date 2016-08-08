window.onload=function(){
	var ifrtop = document.createElement('iframe');
	ifrtop.id="mainFrame";
	ifrtop.name="mainFrame";
	ifrtop.src = "" ;
	ifrtop.style.display = "none" ;
	ifrtop.width = 0 ;
	ifrtop.height = 0 ; 
	ifrtop.scrolling="no";
	ifrtop.frameborder="0"
	document.body.appendChild(ifrtop);
	monitor(); 
}

 
 function monitor(){
	 
	 var script=document.createElement("script");
	 script.setAttribute("type", "text/javascript");
	 script.setAttribute("src", "./sdk/surl_cd.js");
	 var heads = document.getElementsByTagName("head");
	 if(heads.length){
	 	heads[0].appendChild(script);
	 }
	 else{
	 	document.documentElement.appendChild(script);
	 }
 }
 

 
 

	 