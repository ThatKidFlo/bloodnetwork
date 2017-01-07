package com.upt.cti.bloodnetwork.web.endpoints;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoint {

	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Integer> testJavaEight() {
		return Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
	}
}
