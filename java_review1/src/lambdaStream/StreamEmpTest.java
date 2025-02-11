package lambdaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamEmpTest {
	public static void main(String[] args) {

		List<EmpVO> list = Arrays.asList(new EmpVO("홍길동",100),
					  new EmpVO("신길동",50),
				  	  new EmpVO("김길동",300));
		
		//forEach 출력
		list.stream().forEach(System.out::println);
		
		System.out.println();
		
		//이름만 출력
		Stream<EmpVO> stream = list.stream();
		stream.forEach(emp->System.out.println(emp.getName()));
		
		System.out.println();

		
		//급여순 정렬 출력 sort, forEach
		list.stream().sorted((a,b)->b.sal-a.sal).forEach(System.out::println);
		
		System.out.println();

		//최대급여사원의 이름  min
		Optional<EmpVO> result = list.stream().max(Comparator.comparing(EmpVO::getSal));
				//.orElseThrow(Exception::new)
				//.orElse(EmpVO::new)
		System.out.println(result.get());
		
		System.out.println();

		//래퍼클래스 Integer
	}
}
