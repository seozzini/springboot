package com.example.demo.customer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> { //인터페이스 간의 상속은 extends <타입, 기본키의 타입>
	
}
