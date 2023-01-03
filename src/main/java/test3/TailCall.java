package test3;

import java.util.stream.Stream;
//함수형 인터페이스
public interface TailCall<T> {
	TailCall<T> apply();
	
	default boolean isComplete() {
		return false;
	}
	
	default T result() {
		throw new Error("not imple");
	}
	
	default T invoke() {
		return Stream.iterate(this, TailCall::apply)
					 .filter(TailCall::isComplete)
					 .findFirst()
					 .get()
					 .result();
	}
	
	
	
}
