
public class test {

	public static void main(String[] args) {
		long result;//pdf�� �־ �������� ������� �ʴ� �����̴�. .
		long start;//ó�� �Լ��� ������ �� ���� �ð��� ������ �ϴ� �����̴�.
		
		System.out.println("1~100������ �� : "+ TotalMultiThread.sum(100, 10));//1~100���� 10���� �����带 �̿��� �Ͽ� ����� �Ѱ��� ����� �Ѵ�.
		
		System.out.println("<<1~N������ �� M���� ������� ��� �ð� (ns)>>");//��� ���� �ȳ����� ����� �Ѵ�.
		for(int i=16;i<=134217728;i=i*2){//i�� ���� 16���� 134217728���� *2�� �þ�鼭 �ݺ����� ������.
			for(int j=1;j<=16;j=j*2){//�����带 1������ 16������ *2�� ���� ��Ű�鼭 �ݺ����� ������.
				start = System.nanoTime();//ó���� �ð��� start������ ����.
				TotalMultiThread.sum(i, j);//static�޼ҵ��� TotalMultiThread.sum()ȣ�� ��ü ���� �ʿ� x
				System.out.printf("%8d\t", System.nanoTime() - start);//���� �ð��̶� ó�� �ð��� ���������� �Ͽ� �ɸ��ð��� ���
			}
			System.out.println("");//�ٹٲ�
		}
	}

}
