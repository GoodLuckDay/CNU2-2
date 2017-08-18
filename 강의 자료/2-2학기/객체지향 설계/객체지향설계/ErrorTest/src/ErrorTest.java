import java.util.*;
public class ErrorTest {
	static Scanner scanf = new Scanner(System.in);
	public static void main(String[] args) {
		int size;
		System.out.print("Input Array Size : ");
		try{
		size = scanf.nextInt();
		int[] array = arrayAssign(size);//배열의 크기와 값 초기화
		}
		catch(NegativeArraySizeException e){
			System.out.println(e.getMessage());//배열의 사이즈가 음수일때 예외 처리
		}
		catch(ArrayIndexOutOfBoundsException e){//배열의 범위를 벗어 났을때 예외처리
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e){
			System.out.println("Input type must be Integer");//입력값이 정수가 아닐 경우 발생하는 예외 처리를 한다.
		}
		finally{
			System.out.println("Array Size assigned");
		}
	}
	
	public static int[] arrayAssign(int size) throws NegativeArraySizeException,ArrayIndexOutOfBoundsException{
		int[] a;
		if(size < 0){
			throw new NegativeArraySizeException("Array Size can't be negative");//입력한 값이 음수 일때의 예외 발생
		}
		else{
			a = new int[size];
			for(int i=0;i<=size;i++){
				if(i >= size)
					throw new ArrayIndexOutOfBoundsException("Array Index out of Bound");//배열에 범위를 넘어 갔을 떄 예외 발생
				a[i] = i;
				System.out.printf("a[%d] : %d \n",i,a[i]);
			}
		}
		return a;
	}

}
