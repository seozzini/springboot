package com.example.demo.insa.service;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeesDTO {
	private Long employeeId;      // 사원번호
	private String firstName;     // 이름
	private String lastName;      // 이름
	private String email;         // 이메일
	private String phoneNumber;   // 휴대폰
	private Date hireDate;        // 입사일
	private String jobId;         // 잡ID
	private Long salary;    // 연봉
	private Double commissionPct; // 커미션퍼센트
	private Long managerId;       // 매니저 ID
	private Long departmentId;    // 부서번호
}
