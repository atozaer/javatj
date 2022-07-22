package kr.co.tj;

class VarClass{
	final int x;
	static final int y=100;
		
	public VarClass(int x) {
		this.x = x;
	}
	
}

public class FinalVar {

	public static void main(String[] args) {
		VarClass vc1 = new VarClass(10);
		//vc1.x=20;
		
	}

}
