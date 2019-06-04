package quiz0510;

public class SingleTon {
	private static SingleTon st=null;
	private SingleTon() {}
	public static SingleTon getInstance() {
		if(st==null) {
			st = new SingleTon();
		}
		return st;
	}

}
