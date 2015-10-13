package UHF;

import java.util.ArrayList;
import java.util.List;

public class Reader18Utils {

	/**
	 * 
	 * @return EPC号列表
	 */
	public static List<String> getEPCList() {
		List<String> epcList = new ArrayList<String>();
    	//建立连接返回结果
    	int[] comResult = Reader18Manager.getInstance().getComResult();
    	
    	if(comResult==null || comResult.length <=0 || comResult[0] != 0){
    		System.out.println("连接读卡器失败");
    		return null;
    	}
    	
    	Reader18 reader =  Reader18Manager.getInstance().getReader();
    	//远距离读写器的地址,与读写器连接端口对应的句柄
    	
    	
    	int[] arr = {comResult[comResult.length-2],comResult[comResult.length-1]};
    	//G2询查命令
    	int[] inventory = reader.Inventory_G2(arr);
    	
    	if(inventory == null || inventory.length == 0){
    		System.out.println("读卡器询查标签失败");
    		return null;
    	}

    	if(inventory[2] == 0){
//    		System.out.println("没有发现标签");
    		return null;
    	}
    	//inventory 询查返回数组
//    	第1个字节的值
//    	0x01	询查时间结束前返回
//    	0x02	询查时间结束使得询查退出
//    	0x03	如果读到的标签数量无法在一条消息内传送完，将分多次发送。如果Status为0x0D，则表示这条数据结束后，还有数据。
//    	0x04	还有电子标签未读取，电子标签数量太多，MCU存储不了
//    	返回其他值，请查看其他返回值定义，返回的错误代码请查看错误代码定义。
//    	第2个字节表示电子标签的张数，第3个字节表示返回的EPC字节数，
//    	其余字节表示读到的电子标签的EPC数据，是一张标签的EPC长度+一张标签的EPC号，依此累加。每个电子标签EPC号高字在前，每一个字的最高位在前。
    	
    	
    	StringBuffer sb = new StringBuffer();
    	//定义循环epc长度
    	int epcLen = 0;
    	//从第四开始是是一张标签的EPC长度+一张标签的EPC号，依此累加
    	for(int i=3;i<inventory.length;){
    		
    		epcLen = inventory[i];
    		for(int j=1;j<epcLen+1;j++){
    			sb.append(toHexString(inventory[i+j]));
    		}
    		sb.append("@");//间隔多个EPC号
    		i = i + epcLen + 1;
    	}

    	String[] epcs = sb.toString().split("@");
   
    	for(String str : epcs){
    		epcList.add(str);
    	}

		return epcList;
	}
	

	//不足两位前面补0
    public static String toHexString(int i) {
    	String str = Integer.toHexString(i).toUpperCase();
    	if(str.length() == 1){
    		str = "0"+str;
    	}
    	return str;
    }
    
}
