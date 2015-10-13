import UHF.Reader18;
import UHF.Reader18Manager;


public class Test {

    public static void main(String[] args) {
        // TODO code application logic here

    	//获取连接读写器返回结果
    	//如果该函数调用成功，返回一个数组，第一个字节表示函数执行结果，
//    	为0表示成功，返回非零值请查看其他返回值定义，返回的错误代码请查看错误代码定义，
//    	第2个字节表示返回的端口号(COM1-COM9)，第3个字节表示读写器实际地址，
//    	第4个字节表示返回与读写器连接端口对应的句柄，应用程序通过该句柄可以操作连接在相应端口的读写器。如果打开不成功，返回的句柄值为-1。
    	int[] comResult = Reader18Manager.getInstance().getComResult();
    	
    	Reader18 reader = new Reader18();
    	System.out.println("连接读写器返回结果:");
    	for(int i :comResult){
    		System.out.println(i);
    	}
    	System.out.println("end-------");
    	
    	//第3个字节表示读写器实际地址，第4个字节表示返回与读写器连接端口对应的句柄
    	int[] arr = {comResult[comResult.length-2],comResult[comResult.length-1]};
    	
    	//=============================
//    	 Inventory_G2 ()：G2询查命令
    	int[] inventory = reader.Inventory_G2(arr);
    	System.out.println("Inventory_G2返回结果-------");
    	for(int i=0;i<inventory.length;i++){
    		System.out.println(inventory[i] + ":"+toHexString(inventory[i]));
    	}
    	System.out.println("end-------");
    	StringBuffer sb = new StringBuffer();
    	

    	
    	//打印第一张epc号
    	System.out.println("打印第一张epc号-------");
    	for(int i=4;i<inventory[3]+4;i++){
    		sb.append(toHexString(inventory[i]));
//    		System.out.println(inventory[i] + ":"+toHexString(inventory[i]));
    	}
    	System.out.println(sb.toString());
    	System.out.println("end-------");
    
    	
    	//=============================
//    	ReadCard_G2 ()：G2读取数据命令
    	
    	//读取的位数
    	int readNum = 6;
    	int epcLen= inventory[3];
    	int[] arr2 = new int[epcLen+13];
    	arr2[0] = comResult[comResult.length-2];//注意，到时修改NET网口的是数组comResult[1]；
    	arr2[1] = inventory[3];
    	int j = 2;
    	for(int i=4;i<epcLen+4;i++){
    		arr2[j] = inventory[i];
    		j++;
    	}
    	//选择要读取的存储区。
//    	0x00: 保留区；
//    	0x01：EPC存储器；
//    	0x02：TID存储器；
//    	0x03：用户存储器
    	arr2[epcLen+2] = 1;
 //指定要读取的字起始地址。0x00 表示从第一个字(第一个16位存储体)开始读，0x01表示从第2个字开始读，依次类推
    	arr2[epcLen+3] = 0x02;
    	//要读取的字的个数Num。不能设置为0x00，将返回参数错误信息。Num不能超过120，即最多读取120个字。若Num设置为0或者超过了120，将返回参数出错的消息。
    	arr2[epcLen+4] = readNum;
    	//这四个字节是访问密码,没有也设置四个0
    	arr2[epcLen+5] = 0;
    	arr2[epcLen+6] = 0;
    	arr2[epcLen+7] = 0;
    	arr2[epcLen+8] = 0;
    	
    	//EPC掩模起始字节地址
    	arr2[epcLen+9] = 0;
    	//掩模使能标记
    	arr2[epcLen+10] = 0;
//    	第EPClength+12个字节：掩模使能标记。
//    	maskFlag =1：掩模使能；
//    	maskFlag =0：掩模禁止；
    	arr2[epcLen+11] = 0;
    	//与读写器连接端口对应的句柄
    	arr2[epcLen+12] = comResult[comResult.length-1];
   	
    	int[] readcard = reader.ReadCard_G2(arr2);
    	System.out.println("ReadCard======");
    	StringBuffer sb2 = new StringBuffer();
    	int index = 0;
    	for(int i : readcard){
    		System.out.println(i);
    		if(index >=2){
    			sb2.append(toHexString(i));
    		}
    		index++;
    	}
    	System.out.println(sb2.toString() );
    	System.out.println("end-------");
    	//=============================
    	// WriteCard_G2 ()：G2写命令
    	int writedatalen = 8;
    	int[] arr3 = new int[epcLen+writedatalen+13];
    	arr3[0] = comResult[comResult.length-2];
    	arr3[1] = inventory[3];
    	int j2 = 2;
    	for(int i=4;i<epcLen+4;i++){
    		arr3[j2] = inventory[i];
    		j2++;
    	}
//    	第EPClength+3个字节：选择要读取的存储区。
//    	0x00: 保留区；
//    	0x01：EPC存储器；
//    	0x02：TID存储器；
//    	0x03：用户存储器
    	arr3[epcLen+2] = 3;
    	//指定要读取的字起始地址。0x00 表示从第一个字(第一个16位存储体)开始读，0x01表示从第2个字开始读，依次类推
    	arr3[epcLen+3] = 0;
//    	第EPClength+5个字节：待写入的字节数Writedatalen（长度必须为偶数字节数）。Writedatalen必须大于0，这里字节数必须和实际待写入的数据个数相等。否则将会返回参数错误的消息。
    	arr3[epcLen+4] = writedatalen;
    	
    	//第EPClength+6至EPClength+Writedatalen+5个字节：待写入的字。
//    	这是要写入到存储区的数据。比如，WordPtr等于0x02，则输出变量Data中第一个字(从左边起)写在Mem指定的存储区的地址0x02中，第二个字写在0x03中，依次类推。
    	arr3[epcLen+5] = 1;
    	arr3[epcLen+6] = 2;
    	arr3[epcLen+7] = 3;
    	arr3[epcLen+8] = 4;
    	arr3[epcLen+9] = 5;
    	arr3[epcLen+10] = 6;
    	arr3[epcLen+11] = 7;
    	arr3[epcLen+12] = 8;
    	
    	//这四个字节是访问密码。
    	arr3[epcLen+writedatalen+5] = 0;
    	arr3[epcLen+writedatalen+6] = 0;
    	arr3[epcLen+writedatalen+7] = 0;
    	arr3[epcLen+writedatalen+8] = 0;
    	
    	
    	
    	arr3[epcLen+writedatalen+8] = 0;
    	
    	//EPC掩模起始字节地址
    	arr3[epcLen+writedatalen+9] = 0;
    	//掩模使能标记
    	arr3[epcLen+writedatalen+10] = 0;
//    	第EPClength+Writedatalen+12个字节：掩模使能标记。
//    	maskFlag =1：掩模使能；
//    	maskFlag =0：掩模禁止；
    	arr3[epcLen+writedatalen+11] = 0;
    	//与读写器连接端口对应的句柄
    	arr3[epcLen+writedatalen+12] = comResult[comResult.length-1];
   	
    	int[] writecard = reader.WriteCard_G2(arr3);
    	System.out.println("writecard================");
    	for(int i : writecard){
    		System.out.println(i);
    	}
    	System.out.println("end-------");
    	
    	//=============================
    	//WriteEPC_G2 ()：G2写EPC号命令
    	int writeEPClen = 12;
    	int[] arr4 = new int[writeEPClen+7];
    	arr4[0] = comResult[comResult.length-2];
    	
    	arr4[1] = 0;
    	arr4[2] = 0;
    	arr4[3] = 0;
    	arr4[4] = 0;
    	
    	//第6个字节：要写标签的EPC长度WriteEPClen。
    	arr4[5] = writeEPClen;
    	for(int i=6;i<writeEPClen+6;i++){
    		arr4[i] = i;
    	}
    	
    	arr4[writeEPClen+6] = comResult[comResult.length-1];
    	
    	int[] writeEPC = reader.WriteEPC_G2(arr4);
    	System.out.println("writeEPC================");
    	for(int i : writeEPC){
    		System.out.println(i);
    	}
    	//
    	System.out.println("end-------");
    	
	}
    
    
    //	//不足两位前面补0
    private static String toHexString(int i) {
    	String str = Integer.toHexString(i).toUpperCase();
    	if(str.length() == 1){
    		str = "0"+str;
    	}
    	return str;
    }
}
