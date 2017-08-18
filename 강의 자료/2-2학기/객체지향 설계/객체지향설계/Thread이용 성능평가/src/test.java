
public class test {

	public static void main(String[] args) {
		long result;//pdf에 있어서 적었지만 사용하지 않는 변수이다. .
		long start;//처음 함수가 시작이 될 때의 시간을 저장을 하는 변수이다.
		
		System.out.println("1~100까지의 합 : "+ TotalMultiThread.sum(100, 10));//1~100까지 10개의 쓰레드를 이용을 하여 계산을 한것을 출력을 한다.
		
		System.out.println("<<1~N까지의 합 M개의 쓰레드로 계산 시간 (ns)>>");//계산 시작 안내문을 출력을 한다.
		for(int i=16;i<=134217728;i=i*2){//i의 값을 16부터 134217728까지 *2씩 늘어나면서 반복문을 돌린다.
			for(int j=1;j<=16;j=j*2){//쓰레드를 1개부터 16개까지 *2씩 증가 시키면서 반복문을 돌린다.
				start = System.nanoTime();//처음의 시간을 start변수에 저장.
				TotalMultiThread.sum(i, j);//static메소드인 TotalMultiThread.sum()호출 객체 생성 필요 x
				System.out.printf("%8d\t", System.nanoTime() - start);//현재 시간이랑 처음 시간을 뺄셈연산을 하여 걸린시간을 계산
			}
			System.out.println("");//줄바꿈
		}
	}

}
