package test2;

public class ChainingCalculator {
	
	int result = 0;
	
	public ChainingCalculator add(int count) {
		this.result += count;
		return this;
	}
	
	public ChainingCalculator subtract(int count) {
		this.result -= count;
		return this;
	}
	
	public int out() {
		return this.result;
	}
	
	public static void main(String[] args) {
		ChainingCalculator calculator = new ChainingCalculator();
		int result = calculator.add(4).add(5).subtract(3).out();
		
		System.out.print(result);
	}
	
}
