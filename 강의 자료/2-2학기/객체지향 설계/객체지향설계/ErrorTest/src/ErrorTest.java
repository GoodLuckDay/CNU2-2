import java.util.*;
public class ErrorTest {
	static Scanner scanf = new Scanner(System.in);
	public static void main(String[] args) {
		int size;
		System.out.print("Input Array Size : ");
		try{
		size = scanf.nextInt();
		int[] array = arrayAssign(size);//�迭�� ũ��� �� �ʱ�ȭ
		}
		catch(NegativeArraySizeException e){
			System.out.println(e.getMessage());//�迭�� ����� �����϶� ���� ó��
		}
		catch(ArrayIndexOutOfBoundsException e){//�迭�� ������ ���� ������ ����ó��
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e){
			System.out.println("Input type must be Integer");//�Է°��� ������ �ƴ� ��� �߻��ϴ� ���� ó���� �Ѵ�.
		}
		finally{
			System.out.println("Array Size assigned");
		}
	}
	
	public static int[] arrayAssign(int size) throws NegativeArraySizeException,ArrayIndexOutOfBoundsException{
		int[] a;
		if(size < 0){
			throw new NegativeArraySizeException("Array Size can't be negative");//�Է��� ���� ���� �϶��� ���� �߻�
		}
		else{
			a = new int[size];
			for(int i=0;i<=size;i++){
				if(i >= size)
					throw new ArrayIndexOutOfBoundsException("Array Index out of Bound");//�迭�� ������ �Ѿ� ���� �� ���� �߻�
				a[i] = i;
				System.out.printf("a[%d] : %d \n",i,a[i]);
			}
		}
		return a;
	}

}
