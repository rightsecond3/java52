package quiz0510;

public class Return {
	public int hap() {
		int tot = 10;
		System.out.println("tot는" +tot);
		return tot;
	}
	public double avg(int tot) {
		double avg = 0.0;
		avg = tot/2;
		System.out.println("avg는 "+avg);
		return avg;
	}
	public static void main(String[] args) {
		Return rt = new Return();
		rt.avg(rt.hap());
		int tot = rt.hap();
		rt.avg(tot);
	}
}