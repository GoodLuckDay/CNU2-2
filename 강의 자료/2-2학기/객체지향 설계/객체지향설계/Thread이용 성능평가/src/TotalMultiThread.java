
public class TotalMultiThread  {
	
	
	static public long sum(long num,int numOfThread){
		MultiThread[] t1 = new MultiThread[numOfThread];//여려개의 쓰레드를 구현을 하기위해 MultiThread객체의 배열 생성
		long result = 0;//연산의 값을 저장을하기 위한 result변수
		for(int i=0;i<numOfThread;i++){
			t1[i] = new MultiThread(i*num/numOfThread,num/numOfThread);//MultiThread의 객체를 생성을 해주면서 시작을 해야하는 숫자의 값과 범위를 매개변수로 넘겨준다.
			t1[i].start();//i번째 쓰레드의 시작
		}
		try {
			t1[numOfThread-1].join();//마지막 쓰레드의 연산이 끝날때 까지 진행을 멈춘다.
		} catch (InterruptedException e) {//쓰레드가 갑자기 멈추는 오류가 발생을 하면 catch문으로 이동을 하여 처리를 한다.
			e.printStackTrace();
		}
		for(int j=0;j<numOfThread;j++){//연산을 한 결과 값들을 저장을 하기 위해서 쓰레드의 수만큼 반복문을 수행을 한다.
			result = result + t1[j].sum;//연산의 결과들을 result에 저장을 한다.
		}
		return result;//모든 연산들의 합이 저장이 된 result 변수를 반환을 해준다.
	}

}
