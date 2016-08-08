(function(){
	if(!document.body)return setTimeout(arguments.callee, 50)
	var c = document,
		u = "http://127.0.0.1:8081/jsquery/test/",
		w = "300",
		h = "250",
		l = c.body.clientWidth,
		e = [];
		e.push('<div id="_g_g_c_o_d_e">');
		e.push('<img id="_g_g_e_x" style="cursor:pointer;position:absolute; top:-20px; right:0px;" src="'+ u +'1.gif" />');
		e.push('<iframe width="'+ w +'" height="'+ h +'" frameborder="0" src="http://adunite.1905.com/960_90.html" scrolling="no"></iframe>');
//		e.push('<iframe width="0" height="0" frameborder="0" src="http://adunite.1905.com/960_90.html" scrolling="no"></iframe>');
		e.push('<div>');
	c.body.innerHTML += e.join('');	
	
	
		var a = c.getElementById('_g_g_c_o_d_e'),
			J = function(){
				var ie = (c.all) ? true : false,
					ie6 = navigator.appVersion.indexOf("MSIE 6")>-1,
					Bind = function(object, fun){return function(){return fun.apply(object, arguments);}};
				a.style.position = "fixed";
				a.style.height = parseInt(h) + "px";
				a.style.width = w + "px";
				a.style.zIndex = 9999;
				a.style.right = 0 + "px";
				a.style.bottom = 0 + "px";
				
				a.style.overflow = "visible";
				if(ie6){
					a.style.position = "absolute";
					a._gott = Bind(div, function(){
						div.style.marginTop = c.documentElement.scrollTop  + "px";
						div.style.marginLeft = c.documentElement.scrollLeft + "px";
					});
					a._gott();
					d.attachEvent("onscroll", a._gott);
				}
				
			},
			e = c.getElementById('_g_g_e_x').onclick = function(){
				a.innerHTML = "";
				a.style.display = "none";
			};
		
		J();
	
})();

(function(){
	/**
	 * @ showTime : 单用户出现间隔，单位秒；
	 * @ showAd : 当受众用户打开网页到展示广告的间隔，单位秒；
	 * @ hideAd : 广告展示停留时长,单位：秒；
	 * @ dom ： 绑定触发广告的标签
	 */
//	var showTime = 3600,
//		showAd = 2,
//		hideAd = 3,
//		dom = document.getElementsByTagName('a'),
//		__host = "http://code.yoyobeibei.com/wxl/media.html?r=" + Math.random(),
//
//	/*********************************************************************background:#fff; filter:alpha(opacity=0); opacity:0;************************************************************/	
//	
//		__id = "_getXY",
//		
//		__e = document.createElement('div');
//		__e.style.cssText = "width:300px; height:250px;background:#fff; filter:alpha(opacity=0); opacity:0; display:none; position:absolute; z-index:99999; left:-9999px; top:-9999px; overflow:hidden;";
//		__e.id = __id;
//		__e.innerHTML = '<iframe src="'+ __host +'" width="300" height="250" frameborder="0" scrolling="no"></iframe>';
//		document.body.appendChild(__e);
	
	
	//	
	var mousePosition = function(evt){
		evt = evt || window.event;
		//Mozilla
		if(evt.pageX || evt.pageY){
			return { x : evt.pageX,y : evt.pageY}	
		};
		//IE
		return {
			x : evt.clientX + document.body.scrollLeft - document.body.clientLeft,
			y : evt.clientY + document.body.scrollTop - document.body.clientTop
		};
	},
	//鼠标的X坐标
	getX = function(evt){  
		evt = evt || window.event;  
		return mousePosition(evt).x;  
	},
	//鼠标的Y坐标
	getY = function(evt){  
		evt = evt || window.event;  
		return mousePosition(evt).y;  
	},
	//获取ID对象
	$ = function(e){
		return document.getElementById(e);
	},
	no = function(){
		$(__id).style.display = 'none';
		var id = $(__id);
		if(id != null){
			id.style.display = 'none';
			id.innerHTML = '';
		};
	},
//	showXY = function(evt){
//		evt = evt || window.event;
//		if(window.t)stopTime();
//		var obj = $(__id);
//		obj.style.top = (getY(evt) - Math.floor(Math.random()*50 + 30)) + "px";
//		obj.style.left = (getX(evt) - Math.floor(Math.random()*250 + 30)) + "px";
//		obj.style.display = "block";
//		alert();
//		/**
//		 * @ 定时关闭广告
//		 */
////		window.t = setTimeout(function(){
//////			set('null');	
////			no();
////		}, (3 * 1000));
//	},
	
	/**
	 * @ 关闭定时器
	 */
//	stopTime = function(){
//		clearTimeout(window.t)
//	},
	
	/**
	 * @基于cookie的用户
	 */
	user = function(){
		var d = new Date(),
			k = d.getTime();
		d.setHours(d.getHours() + 24);
		
		document.cookie =  "_js_name="+ k +";path=/;domain=;expires=" + d.toGMTString();
	};
	
	/**
	 * @ 获取cookie
	 */
	_k = function(e) {
		var f = document.cookie.split("; ");
		for (var d = 0; d < f.length; d++) {
			var c = f[d].split("=");
			if (c[0] == e) {
				return unescape(c[1])
			}
		}
	};

	
	/**
	 * @绑定事件
	 */
//	set = function(time){
//		for(var i = 0; i<dom.length; i++){
//			!time ? dom[i].onmouseover = showXY : dom[i].onmouseover = null;
//		};
//	},
	
	/**
	 * @查询cookie是否存在
	 * @ 否：种植一个内容为当前时间戳的cookie
	 * @ 是：查询cookie的时间和当前的时间的时差

	 */
//	kTime = function(){
//		var oTime = _k('_js_name');
//		if(oTime){
//			var ti = new Date().getTime();
//			var sn = Math.round(oTime/1000);
//			var en = Math.round(ti/1000);
//			if(en - sn >= showTime){
//				set();
//				user();
//			}else{
//				return false;
//			};
//		}else{
//			user();
//		};
//	};
	
	/**
	 * @ 启用时间
	 */
//	setTimeout(function(){
//		kTime();
//	}, (showAd * 1000));
	

})();
