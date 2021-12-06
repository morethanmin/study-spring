package com.jade.studyspring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//GreetingController 클래스를 RestController로 정의해주는 annotation
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

  //greeting 함수를 /greeting route에 mapping해주는 annotation
	@GetMapping("/greeting")
  //Gretting을 반환하는 greeting 함수 정의, String name의 값엔 annotation에 명시된 값이 들어감.
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}