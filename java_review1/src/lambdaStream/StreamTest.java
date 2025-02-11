package lambdaStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		String[] strArr = { "키위", "포도", "바나나", "사과", "감", "사과" };

		//count
		long cnt = Stream.of(strArr) // 스트림 생성
				.filter(s -> s.length() > 1)
				.distinct()
				.sorted()
				.count();
		System.out.println(cnt);
		
		
		//collect
		List<String> list = Stream.of(strArr)	//스트림 생성
							.filter(s->s.length()>1)
							.distinct()
							.collect(Collectors.toList());
		
		System.out.println(list);
		
		//forEach
		Stream.of(strArr)	//스트림 생성
		.filter(s->s.length()>1)	//중간연산함수 n개 가능
		.distinct()
		.sorted()
		//.sorted((a,b) -> b.compareTo(a))	//거꾸로 정렬
		.forEach(System.out::println);	//최종함수는 마지막에 하나만 가능

	}
}
