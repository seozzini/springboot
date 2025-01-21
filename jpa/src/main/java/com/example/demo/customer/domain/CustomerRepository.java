package com.example.demo.customer.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> { //인터페이스 간의 상속은 extends <타입, 기본키의 타입>

	//id 로 검색->단건조회 / ?1 첫번째값 ?2 두번째값
	@Query("select u from Customer u where u.id = ?1 order by name desc")
	public Optional<Customer> findById(Long id);
	
	@Query("select c.name from Customer c where id = :id and phone = :phone order by name")
	public Optional<Customer> findById(@Param("id") Long id,
			                           @Param("phone") String phone);
	
	public List<Customer> findByNameLikeIgnoreCase(String keyword);
	
	//이름도 like or phone like order by ___ desc
	public List<Customer> findByNameLikeIgnoreCaseOrPhoneLikeIgnoreCaseOrderByNameDesc(String name, String phone);
}
