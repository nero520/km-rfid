package com.test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import UHF.Reader18Utils;


public class TestEPCList {
	
	public static Map<String, String> map ;
	
	public static void main(String[] args) {
		map = new HashMap<String, String>();
//    	E2001026770E006212409C68
//    	E20040783207008613708BC0
//    	060708090A0B0C0D0E0F1011
		map.put("E2001026770E006212409C68", "客户A");
		map.put("E20040783207008613708BC0", "客户B");
		map.put("060708090A0B0C0D0E0F1011", "客户C");
		map.put("E200307239070222189052E6", "客户D");
		map.put("E2003072390702281130A75D", "客户E");
		map.put("E200307239070226147083CB", "客户F");
		map.put("E20030723907022814208610", "客户G");
		
	    Timer timer = new Timer();     
        timer.schedule(new MyTask(), 0, 1000);//在1秒后执行此任务,每次间隔2秒执行一次,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.     
        while(true){//这个是用来停止此任务的,否则就一直循环执行此任务     
            try{     
                int in = System.in.read();    
                if(in == 's'){     
                    timer.cancel();//使用这个方法退出任务     
                    break;  
                }     
            } catch (IOException e){     
                // TODO Auto-generated catch block     
                e.printStackTrace();     
            }     
        }     
    }    
	      
	    static class MyTask extends java.util.TimerTask{
			@Override
			public void run() {
				List<String> list = null;
				try {
					list = Reader18Utils.getEPCList();
				} catch (Exception e) {
					System.out.println("异常不处理");
				}
				if(list == null){
					return;
				}
				for(String str : list){
					String name = map.get(str);
					if(name != null){
						System.out.println(name+",欢迎您.");
					}
				}
			}      
	}
}
