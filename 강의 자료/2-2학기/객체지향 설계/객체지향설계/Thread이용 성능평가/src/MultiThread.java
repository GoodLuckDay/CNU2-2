
public class MultiThread extends Thread{
	long num;//������ ������ �˷��ִ� ����
	long range;//������ �������ϴ� ���� range
	long sum;//������ ���� �������ϴ� sum�����̴�.
	
	public MultiThread(long aNum,long aRange){//�Ű������� ���� �޾ƿ� num�� range�� �������ϴ� 
						     				//MultiThread�� �������̴�.
		this.num = aNum;
		this.range = aRange;
		this.sum = 0;
	}
	public void run() {//Thread�� ���������� ������ �Ǵ� �κ��̴�.
		for(int i=1;i<=range;i++){//num�� ���� +1��ŭ �����ؼ� +10���� sum���� �����ش�.
			sum = sum + num + i;
		}
	}

}
