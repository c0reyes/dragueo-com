package com.dragueo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class WebSecurityApplicationTest {
	@Autowired
	private MockMvc mockMvc;

	private String authorization = String.format("Basic %s",Base64.getEncoder()
            .encodeToString(("test:test").getBytes(StandardCharsets.UTF_8)));

	@Test
	public void userAuthorizedRequest() throws Exception {
		this.mockMvc.perform(get("/api/v1/dragtree/add").header("Authorization", authorization))
				.andExpect(status().isOk());
	}
	
	@Test
	public void userUnAuthorizedRequest() throws Exception {
		this.mockMvc.perform(get("/api/v1/dragtree/add"))
				.andExpect(status().isUnauthorized());
	}
}
