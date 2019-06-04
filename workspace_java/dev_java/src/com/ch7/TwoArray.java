package com.ch7;

public class TwoArray {
	int a[] = new int[3];
	int a2[][] = new int[2][3];
	String name[] = {"정지우","유승기","정재현"};
	int a3[][]= {
			    {70,80}
			   ,{90,75}
			   ,{85,60}
    		};
	//세친구의 총점을 담을 1차배열 선언하기
	int tots[] = new int[3];
	double avgs[] = new double[tots.length];
	int rnks[] = {1,1,1};
	//총점을 구해서 tots배열 초기화하기 구현
	public void totsInit() {
		for(int i=0; i<tots.length; i++) {
			tots[i] = a3[i][0]+a3[i][1];
		}
		avgsInit(a3[0].length);
	}
	//평균을 구하는 메소드 구현
	public void avgsInit(int inwon) {
		for(int i=0; i<tots.length; i++) {
			avgs[i] = tots[i]/inwon;
		}
	}
	//석차를 구해서 출력해보시오.
	public void ranking() {
		for (int i=0; i<rnks.length; i++) {
			for(int j=0 ;j<rnks.length;j++) {
				if(tots[i]>tots[j]) {
					rnks[j]++;
				}
			}
		}
	}
	public void Print() {
		for(int i=0;i<tots.length;i++) {
			System.out.println(name[i]+"총점은"+tots[i]);			
		}
		for(int i=0; i<tots.length; i++) {
			System.out.println(name[i]+"평균은"+avgs[i]);
		}
		for(int i=0; i<rnks.length; i++) {
			System.out.println(name[i]+"의 석차는"+rnks[i]+"등");
		}
	}
	public static void main(String[] args) {
		TwoArray ta = new TwoArray();
		System.out.println(ta.a[0]);//값
		System.out.println(ta.a2[0]);//주소번지
		for(int i=0;i<ta.a2.length;i++) { //i<2
			for(int j=0;j<ta.a2[i].length;j++) {//j<3
				System.out.println("a2["+i+"]["+j+"]="+ta.a2[i][j]);
			}
		}System.out.println("=========================");
		ta.totsInit();
		ta.avgsInit(3);
		ta.ranking();
		ta.Print();
	}

}
