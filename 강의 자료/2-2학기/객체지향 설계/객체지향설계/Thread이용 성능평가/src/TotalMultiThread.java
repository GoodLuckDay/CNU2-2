
public class TotalMultiThread  {
	
	
	static public long sum(long num,int numOfThread){
		MultiThread[] t1 = new MultiThread[numOfThread];//�������� �����带 ������ �ϱ����� MultiThread��ü�� �迭 ����
		long result = 0;//������ ���� �������ϱ� ���� result����
		for(int i=0;i<numOfThread;i++){
			t1[i] = new MultiThread(i*num/numOfThread,num/numOfThread);//MultiThread�� ��ü�� ������ ���ָ鼭 ������ �ؾ��ϴ� ������ ���� ������ �Ű������� �Ѱ��ش�.
			t1[i].start();//i��° �������� ����
		}
		try {
			t1[numOfThread-1].join();//������ �������� ������ ������ ���� ������ �����.
		} catch (InterruptedException e) {//�����尡 ���ڱ� ���ߴ� ������ �߻��� �ϸ� catch������ �̵��� �Ͽ� ó���� �Ѵ�.
			e.printStackTrace();
		}
		for(int j=0;j<numOfThread;j++){//������ �� ��� ������ ������ �ϱ� ���ؼ� �������� ����ŭ �ݺ����� ������ �Ѵ�.
			result = result + t1[j].sum;//������ ������� result�� ������ �Ѵ�.
		}
		return result;//��� ������� ���� ������ �� result ������ ��ȯ�� ���ش�.
	}

}
