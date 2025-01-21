package com.example.demo.customer.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //테스트 컨테이너로 변경
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	//@Test
	@DisplayName("고객등록")
	//@Transactional
	//@Rollback //기본은 commit
	public void insert() {
		//give(테스트 할 데이터 만들고)
		Customer customer =  new Customer("홍길동","010-1111-2222");
		//when (데이터 넣고)
		customerRepository.save(customer);
		//then
		//단건조회결과와 비교
		Optional<Customer> result = customerRepository.findById(1L);
		assertThat(result.get().getName()).isEqualTo("홍길동");
	}
	
	
	//@Test
	@DisplayName("고객정보수정")
	//@Transactional
	//@Rollback //기본은 commit
	public void update() {
		//give(테스트 할 데이터 만들고)
		Customer customer =  new Customer("홍길동","010-1111-2222");
		customerRepository.save(customer);
		
		//when (데이터 넣고)
		Optional<Customer> result = customerRepository.findById(1L);
		//필드 고치고
		result.get().setPhone("2222-3333");
		//수정 (save 시에 기본키없으면 등록/있으면 수정)
		customerRepository.save(result.get());
		
		//then
		//단건조회결과와 비교
		//assertThat(result.get().getName()).isEqualTo("홍길동");
	}
	
	//@Test
	@DisplayName("이름검색")
	public void findByName() {
		String name = "%ch%"; //찾을 단어 넣기
		List<Customer> list = customerRepository.findByNameLikeIgnoreCase(name);
		System.out.println(list);
	}
	
	//@Test
	@DisplayName("이름,폰 검색")
	public void findByNameLikeOrPhoneLike() {
		String name = "%ch%"; //찾을 단어 넣기
		String phone = "%010-111%";
		List<Customer> list = customerRepository.findByNameLikeIgnoreCaseOrPhoneLikeIgnoreCaseOrderByNameDesc(name,phone);
		System.out.println(list);
	}
	
	//@Test
	public void findById() {
		Long id = 1l;
		Optional<Customer> customer = customerRepository.findById(id);
		System.out.println(customer.get());
	}
	
	//@Test
	public void findByIdAndPhone() {
		Long id = 1l;
		String phone = "111";
		Optional<Customer> customer = customerRepository.findById(id,phone);
		System.out.println(customer.get());
	}
	
	@Test
	@DisplayName("고객등록2")
	//@Transactional
	//@Rollback //기본은 commit
	public void insertCust() {
		//give(테스트 할 데이터 만들고)
		Customer customer =  new Customer("홍길동","010-1111-2222");
		//when (데이터 넣고)
		customerRepository.save(customer);
		addressRepository.save(Address
				.builder()
				.address("대구")
				//.customer(customer)
				.build() );
		System.out.println("id :" + customer.getId());
		//then
		//단건조회결과와 비교
		Optional<Customer> result = customerRepository.findById(1L);
		Optional<Address> address = addressRepository.findById(1L);
		System.out.println("address: "+address);
		assertThat(result.get().getName()).isEqualTo("Jack");
	}
	
}
