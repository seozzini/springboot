package com.example.demo.customer.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Getter;

@Getter //게터만
@Entity //테이블 생성해줌
//@Table(name="cust")
public class Customer {
	@Id //이거붙으면 PK
	@GeneratedValue(strategy = GenerationType.AUTO) //시퀀스
	private Long id;
	
	//@Column(name = "username", length = 50, nullable = false ) //이름, 길이, 낫널
	private String name;
	
	//@Column(columnDefinition = "clob")
	private String phone;
	
	//@OneToOne
	//@JoinColumn(name = "address_id")
	//Address address;
	
	//@OneToMany(mappedBy="address")
	//List<Address> address;
	
	@Transient//컬럼 반영 안됨
	private String addr;
	
	@Transient
	private String grade;

	//생성자
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	//기본생성자
	public Customer() {}
	
	//phone 만 세터추가 
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//toString
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
	
	
	
	
}
