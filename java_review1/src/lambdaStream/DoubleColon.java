package lambdaStream;

import java.util.Arrays;
import java.util.List;

public class DoubleColon {

	public static void main(String[] args) {
		List<String> fruit = Arrays.asList("사과","바나나","포도");
		
		for(int i= 0; i<fruit.size(); i++) {
			//출력
			//System.out.println(fruit.get(i));
		}
		
		//fruit.forEach(s->System.out.println(s));
		fruit.forEach(System.out::println);

	}

}
