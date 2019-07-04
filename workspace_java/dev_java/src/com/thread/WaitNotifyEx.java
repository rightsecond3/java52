package com.thread;
class ATMTwo implements Runnable {
		private long depositMoney = 10000;
		@Override
		public void run() {
			/*
			 * wait()와 notify()는 싱크로나이즈 블록에서만 사용
			 * notifyAll() : 잠자는 스레드를 모두 불러옴
			 * 이 메소드를 제공하는 이유 : 데드락 상태를 방지하기 위해 사용
			 */
			synchronized (this) {
				//10번의 인출을 진행
				for(int i=0; i<10; i++) {//지연처리
					if (getDepositMoney()<=0) {
						break;
					}
					withDraw(1000);
					//잔고가 짝수금액일때는 강제로 지연을 시킴
					if(getDepositMoney()%2000==0) {
						try {
							Thread.sleep(1000);
							this.wait();
						} catch (InterruptedException ie) {
							ie.printStackTrace();
						}
					} else {
						this.notify();
					}
				}///////////end of for
			}///////////////end of synchronized
		}
		//** 잔고를 가져오는 메소드 선언 **//
		public long getDepositMoney() {
			return depositMoney;
		}
		public void withDraw(long howMuch) {
			if(getDepositMoney()>0) { //잔고가 0보다 크니?
				depositMoney-=howMuch;
				System.out.println(Thread.currentThread().getName());
				System.out.printf("잔액: %d원 \n", getDepositMoney());
			}
			else { //잔고가 0보다 작거나 요청 금액보다 작을 때
				System.out.print(Thread.currentThread().getName()+" : ");
				System.out.println("잔액이 부족합니다.");			
			}
		}
}
public class WaitNotifyEx{


	public static void main(String[] args) {
		ATMTwo atm = new ATMTwo();
		// insert here - 엄마와 아들 스레드 추가하기
		Thread mother = new Thread(atm, "엄마");
		Thread son = new Thread(atm, "아들");
		mother.start();
		son.start();
	}
}
