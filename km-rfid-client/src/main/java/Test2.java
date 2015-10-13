import UHF.Reader18;
import UHF.Reader18Manager;


public class Test2 {
    // TODO code application logic here

  public static void main(String[] args) {
	
	  System.out.println(System.getProperty("java.library.path"));
	//获取连接读写器返回结果
	//如果该函数调用成功，返回一个数组，第一个字节表示函数执行结果，
//	为0表示成功，返回非零值请查看其他返回值定义，返回的错误代码请查看错误代码定义，
//	第2个字节表示返回的端口号(COM1-COM9)，第3个字节表示读写器实际地址，
//	第4个字节表示返回与读写器连接端口对应的句柄，应用程序通过该句柄可以操作连接在相应端口的读写器。如果打开不成功，返回的句柄值为-1。
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
//	 Inventory_G2 ()：G2询查命令
	int[] inventory = reader.Inventory_G2(arr);
	System.out.println("Inventory_G2返回结果-------");
	for(int i=0;i<inventory.length;i++){
		System.out.println(inventory[i] + ":"+toHexString(inventory[i]));
	}
	System.out.println("end-------");
	StringBuffer sb = new StringBuffer();
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
