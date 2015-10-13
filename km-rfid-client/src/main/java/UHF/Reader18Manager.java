package UHF;

import java.util.ResourceBundle;


/**
	KL读写器系列 读写器连接管理
 * @author hebiao
 *
 */
public class Reader18Manager {
	
	static{
		System.loadLibrary("UHF_Reader18");
	}
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("baseconfig");

	private static Reader18 reader = new Reader18();
	private static int[] comResult = null;
	//自动连接串口参数数组，默认0xFF广播地址，5表示57600 bps
	private  final int[] arr = {0xFF,5};
	
//	private String connectType;
//	
//	private String port;
//	
//	private String ip;
	
	public static Reader18Manager getInstance() {
		return SingletonHolder.instance;
	}
	
	private static class SingletonHolder{
		private final static Reader18Manager instance = new Reader18Manager();	
	}
	
    private Reader18Manager(){
    	init();
    }
    
    protected void init() {
    	System.out.println(getConnectType());
    	//判断连接方式
    	if("Com".equals(getConnectType())){
        	//自动连接串口，串口
        	comResult = reader.AutoOpenComPort(arr);
    	}else if("Net".equals(getConnectType())){
        	//以广播地址（0xFF）调用此函数
        	comResult = reader.OpenNetPort(0xFF,Integer.valueOf(getPort()),getIp());
    	}
    }

	public  Reader18 getReader() {
		return reader;
	}

	public  int[] getComResult() {
		return comResult;
	}

    protected void destroy(){
    	reader.CloseComPort();
    }
    
	public String getConnectType() {
		return bundle.getString("reader18.connectType");
	}

	public String getPort() {
		return bundle.getString("reader18.port");
	}

	public String getIp() {
		return bundle.getString("reader18.ip");
	}


	public static void main(String[] args) {
		//Reader18Manager.getInstance();

	}


    
}
