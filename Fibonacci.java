public class Fibonacci{


	public static void main(String[] args){
		System.out.println("Hello world");

		Fibonacci fibonacci = new Fibonacci();
		int n = 7;
		System.out.println("Recursive version: Fibonacii for n: " + n + " = " + fibonacci.f(n));
		System.out.println("OOP plain version: Fibonacii for n: " + n + " = " + fibonacci.f2(n));
	}

	public int f(int n){
		if(n==1 || n==2){
			return 1;
		}
		return f(n-1) + f(n-2);	
	}

	public int f2(int n){
		if(n==1 || n==2){
			return 1;
		}

		int nMinusTwo = 1; int nMinusOne = 1; int fibonacci = 0;

		for(int i = 3; i <= n; i ++){
			fibonacci = nMinusOne + nMinusTwo;
			nMinusTwo = nMinusOne;
			nMinusOne = fibonacci;
		}
		return fibonacci;		
	}

}