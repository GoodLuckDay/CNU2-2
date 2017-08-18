
public class MultiThread extends Thread{
	long num;//변수의 시작을 알려주는 변수
	long range;//범위를 저장을하는 변수 range
	long sum;//값들의 합을 저장을하는 sum변수이다.
	
	public MultiThread(long aNum,long aRange){//매개변수로 값을 받아와 num과 range에 저장을하는 
						     				//MultiThread의 생성자이다.
		this.num = aNum;
		this.range = aRange;
		this.sum = 0;
	}
	public void run() {//Thread가 직접적으로 시작이 되는 부분이다.
		for(int i=1;i<=range;i++){//num의 값의 +1만큼 시작해서 +10까지 sum에서 더해준다.
			sum = sum + num + i;
		}
	}

}
