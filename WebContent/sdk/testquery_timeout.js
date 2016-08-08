
var path ="http://jsq.fivelives.net/jsquery/jsonp.json";
function init_ajax(){
	
	var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "//hm.baidu.com/hm.js?f5a9b0c9b75034305dd9abf0bb503cf0";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })(); 
	
	$.ajax({
        url: path,
        type: 'get',
//        cache: true,
        dataType:"jsonp",
        jsonp:"callback",
        jsonpCallback:"callback",
        success: function (data) {
        } ,error: function(XMLHttpRequest, textStatus, errorThrown) {
       	 alert(XMLHttpRequest.status);
    	 alert(XMLHttpRequest.readyState);
    	 alert(textStatus);
    	   }
	});
	
}
init_ajax();
//window.setInterval(init_ajax,5000);

function callback(data){
	var pub=data.pub;
	var slot=data.slot;
	var src=data.src;
	jsoncallback(pub,slot,src,1) ;
	
}



function jsoncallback(pub,slot,src,i) {
	i=i+1;
	if(i>5){
		return;
	}
    if (!document.body) return setTimeout(arguments.callee, 50);
    var e = document.createElement("script");
    e.type = "text/javascript",
    e.text = '_guanggao_pub= "'+pub+'";',
    e.text += '_guanggao_slot= "'+slot+'";',
    document.body.appendChild(e);
    var e = document.createElement("script");
    e.src = src,
    e.type = "text/javascript",
    document.body.appendChild(e);
    setTimeout(function(){jsoncallback(pub,slot,src,i) ;}, 15000);
}

