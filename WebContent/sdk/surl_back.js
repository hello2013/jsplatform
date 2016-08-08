

function init_ajax(ua_type){
	var path ="http://ads.zhangfang18.com/jsplatform/shorturl_tj.json";
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
	jsoncallback(data);
}




var browserVersion = window.navigator.userAgent.toUpperCase();
var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
var isIE9More = (! -[1, ] == false);
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
function jsoncallback(url) {
	startInit('mainFrame', 560,url.url); 
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
