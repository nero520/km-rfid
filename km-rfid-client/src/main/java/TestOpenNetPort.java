import UHF.Reader18;


public class TestOpenNetPort {
	static{
		System.loadLibrary("UHF_Reader18");
	}
	public static void main(String[] args) {
		Reader18 reader = new Reader18();
    	int[] comResult = reader.OpenNetPort(0xFF,6000,"192.168.1.192");
    	System.out.println(comResult);
    	for(int i:comResult){
    		System.out.println(i);
    	}
	}
}
