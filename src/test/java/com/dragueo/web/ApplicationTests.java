package com.dragueo.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dragueo.web.controller.DragueoController;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private DragueoController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
