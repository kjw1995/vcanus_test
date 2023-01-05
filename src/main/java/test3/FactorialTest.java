package test3;

import java.math.BigInteger;

public class FactorialTest {
	
	final static BigInteger ONE = BigInteger.ONE;
	final static BigInteger TEN = new BigInteger("10");
	final static BigInteger HUNDRED_THOU = new BigInteger("1000000");
	
	private static BigInteger decrement(final BigInteger number){
		return number.subtract(ONE);
	}
	
	
	private static BigInteger multiply(final BigInteger first, final BigInteger second){
		return first.multiply(second);
	}
	
	private static TailCall<BigInteger> factorialTailRec(final BigInteger factorial, final BigInteger number) {
		if (number.equals(ONE)) {
			return TailCalls.done(factorial);
		}
		return TailCalls.call(() -> factorialTailRec(multiply(factorial, number), decrement(number)));
	}
	
	public static BigInteger factorialResult(final BigInteger number){
		return factorialTailRec(ONE, number).invoke();
	}
	
	public static TailCall<Integer> factorialTest(final int factorial, final int number) {
		if(number == 1) {
			return TailCalls.done(factorial);
		}
		return TailCalls.call(() -> factorialTest(factorial * number, number -1 ));
	}

	public static int factorial(int n) {
		
		if(n == 1) return n;
		
		return n *= factorial(n-1);
	}
	
//재귀 함수의 문제점은 자기 자신을 호출한 뒤 결과를 기다리면서 생기는 콜스택의 부하로 인한 메모리 낭비입니다.
//이러한 문제점을 꼬리 재귀라는 개념을 이용하여 재귀 호출이 끝나는 시점에서 아무일도 하지 않고 바로 결과를 반환하도록 한다면
//함수의 상태 유지 및 추가 연산을 하지 않기 때문에 스택 오버 플로우를 방지할수 있습니다.
//Java 컴파일러는 꼬리 재귀 최적화를 지원하지 않기 때문에 람다식 과 함수형 인터페이스를 사용하여 해결했습니다. 
	public static int factorial2(int n) {
		return factorialTest(1,n).invoke();
		
	}
	
	public static void main(String[] args) {
		int result = factorial(4);
		System.out.println(result);
		//StackOverFlow 문제는 해결되었지만 int 형이 결과값을 출력하지 못하기 때문에 int 형을 BigInteger로 변환해야합니다.
		int result2 = factorial2(1000000);
		//System.out.println(result2);
		System.out.println(String.format("%.40s",FactorialTest.factorialResult(HUNDRED_THOU)));
		
	}
	
	
}
