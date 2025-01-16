package com.example.demo;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController //RestController : 이거붙이면 리턴값 제이슨으로 바꿔줌
public class SampleController {

	@GetMapping(value = "/getText", produces = "text/plain;charset:UTF-8")
	public String getText() { //리턴타입앞에 적던가
		return "안녕하세요"; //@rest 빼면 안녕하세요.html 페이지 찾으러감
	}
	
	@GetMapping(value = "/getTextEntity")
	public ResponseEntity<String> getTextEntity() { //리턴타입앞에 적던가
		return new ResponseEntity<>("안녕하세요",HttpStatus.BAD_GATEWAY); //502 에러 bad gateway 에러로 보내보자.
	}
	
	//@ResponseBody //메소드 앞에 적던가 똑같음
	@GetMapping("/getSample")
	public SampleVO getSample() {
		return new SampleVO(100,"길동","김", new Date());
	}
	
	@GetMapping("/getSampleEntity") //p.148
	public ResponseEntity<SampleVO> getSampleEntity() {
		SampleVO sample =  new SampleVO(100,"길동","김", new Date());
		return new ResponseEntity<>(sample, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getMap")
	public Map<String,Object> getMap(){
		Map<String,Object> map = new HashMap<>();
		map.put("sample", new SampleVO(100,"길동","김", new Date()));
		map.put("total", 20);
		map.put("success", true);
		return map;
	}
	
	@GetMapping("/product/{cat}/{pid}") //p.366 중괄호는 값이 들어온다는 뜻 그 안에는 변수명
	public String[] getPath(@PathVariable String cat,
			                @PathVariable(name="pid") Integer prdid) {
		return new String[] {cat, ""+prdid}; // String.value // integet.parstint하는 것과 동일
		
	}
	
	@PostMapping("/ticket")
	public List<Ticket> convert(@RequestBody List<Ticket> ticket) { //JSON string 을 보내려면 @RequestBody 필수
		log.info("ticket: "+ticket);
		return ticket; // convert: 일반 질의문자열(쿼리스트링)을 JSON string 으로 변환함
	}
	
	@PostMapping("/comp")
	public CompVO comp(@RequestBody CompVO comp) {
		comp.getList().get(0).getOwner();
		log.info("owner: "+comp.getList().get(0).getOwner());
		log.info("comp: "+comp);
		return comp;
	}

	@PostMapping("/compMap")
	public JsonNode compMap(@RequestBody JsonNode node) {
		//첫번째 티켓의 owner 출력
		log.info("owner : "+ node.get("list").get(0).get("owner").asText() ); 
		return node;
		
	}


	@GetMapping("/movie")
	public String movie(@RequestParam(defaultValue = "20250115",required = false ) String date) {
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt="+date;
		JsonNode node = restTemplate.getForObject(uri, JsonNode.class);
		String name = node.get("boxOfficeResult").get("dailyBoxOfficeList").get(0).get("movieNm").asText(); //객체면 필드, 배열이면 인덱스로 읽어내기
		return name;
		
	}

}
