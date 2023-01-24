package study0403;

public class testStatic {
	 int cnt;
	
	public testStatic(){
		this.cnt++;
		System.out.println(this.cnt);
	}
	
	public static int getCnt() {
		return cnt;
	}
	public static void main(String[] args) {
		testStatic s1 = new testStatic();
		testStatic s2 = new testStatic();
		
		System.out.println("total = " + testStatic.getCnt());
	}

}
