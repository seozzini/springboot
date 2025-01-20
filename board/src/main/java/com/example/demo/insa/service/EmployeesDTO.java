package com.example.demo.insa.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDTO {
	private Long employeeId;      // 사원번호
	
	@NotNull(message = "필수 입력 항목입니다.")
	private String firstName;     // 이름
	
	@NotNull(message = "필수 입력 항목입니다.")
	private String lastName;      // 이름
	
	@NotNull
	@Email
	private String email;         // 이메일
	private String phoneNumber;   // 휴대폰
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;        // 입사일
	private String jobId;         // 잡ID
	private Long salary;    // 연봉
	private Double commissionPct; // 커미션퍼센트
	private Long managerId;       // 매니저 ID
	private Long departmentId;    // 부서번호
}
