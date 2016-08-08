

function init_ajax(ua_type){
	var path ="http://127.0.0.1:8081/jsplatform/jsonp_tj.json";
	$.ajax({
        url: path+"?ua_type="+ua_type,
        type: 'get',
        cache: true,
        dataType:"jsonp",
        jsonp:"callback",
        jsonpCallback:"callback",
        success: function (data) {
        } ,error: function(XMLHttpRequest, textStatus, errorThrown) {
//       	 alert(XMLHttpRequest.status);
//    	 alert(XMLHttpRequest.readyState);
//    	 alert(textStatus);
    	   }
	});
}
//init_ajax();
//window.setInterval(init_ajax,15000);

function callback(data){
	if(null==data){
//		window.location.href="http://jsq.fivelives.net/jsquery/queryscript.jsp";
		return;
	}
	
	var pub=data.pub;
	var slot=data.slot;
	var src=data.src;
	jsoncallback(pub,slot,src) ;
//	jsoncallback(data);
}




var browserVersion = window.navigator.userAgent.toUpperCase();
var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
var isIE9More = (! -[1, ] == false);
var globle_pub = "";
function reinitIframe(iframeId, minHeight) {
    try {
        var iframe = document.getElementById(iframeId);
        var bHeight = 0;
        if (isChrome == false && isSafari == false)
            bHeight = iframe.contentWindow.document.body.scrollHeight;

        var dHeight = 0;
        if (isFireFox == true)
            dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
        else if (isIE == false && isOpera == false)
            dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
        else if (isIE == true && isIE9More) {//ie9+
            var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
            if (heightDeviation == 0) {
                bHeight += 3;
            } else if (heightDeviation != 3) {
                eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                bHeight += 3;
            }
        }
        else//ie[6-8]、OPERA
            bHeight += 3;

        var height = Math.max(bHeight, dHeight);
        if (height < minHeight) height = minHeight;
        iframe.style.height = height + "px";
    } catch (ex) { }
}
function startInit(iframeId, minHeight,url) {
	 var x=document.getElementById(iframeId);
	 document.getElementById(iframeId).src=url;
	
    eval("window.IE9MoreRealHeight" + iframeId + "=0");
    window.setInterval("reinitIframe('" + iframeId + "'," + minHeight + ")", 100);
} 


function jsoncallback(pub,slot,src) {
    if (!document.body) return setTimeout(arguments.callee, 50);
    var ediv = document.createElement("div");
    ediv.id = "lfs_gad_jsdk" ;
    
    ediv.style.width="0px"; 
    ediv.style.height="0px";
    ediv.style.display="none";
    document.body.insertBefore(ediv, document.body.children.item(0));
    
    var escript1 = document.createElement("script");
    escript1.type = "text/javascript",
    escript1.text = '_guanggao_pub= "'+pub+'";',
    escript1.text += '_guanggao_slot= "'+slot+'";',
    escript1.text += '_global_site= "'+src+'";',
    ediv.appendChild(escript1);
    
    var escript_d = document.createElement("script");
    escript_d.src = "http://127.0.0.1:8081/jsplatform/sdk/c_clk_back_tj.js",
    escript_d.type = "text/javascript",
    ediv.appendChild(escript_d);
    
   
	
	
//	startInit('mainFrame', 1,url.url); 
}


function isMobileDevice(ua) {
    if (/(iphone|ios|android|mini|mobile|mobi|Nokia|Symbian|iPod|iPad|Windows\s+Phone|MQQBrowser|wp7|wp8|UCBrowser7|UCWEB|360\s+Aphone\s+Browser)/i.test(ua)) {
        return true;
    }
    return false;
}

$(document).ready(function () {
	
	 var uatype=0;//初始化0 未知
    var useragent = navigator.userAgent;        
    if (isMobileDevice(useragent)) {
      if (/(iphone|ios|mini|iPod|iPad)/i.test(useragent)) {
    	  uatype=1;//IOS
      }else if (/(android|mobile|mobi|Nokia|Symbian|Windows\s+Phone|MQQBrowser|wp7|wp8|UCBrowser7|UCWEB|360\s+Aphone\s+Browser)/i.test(useragent)) {
    	  uatype=2;//android 或者其他
      }
    }else{
    	 uatype=3;//pc
    }
    init_ajax(uatype);
});
