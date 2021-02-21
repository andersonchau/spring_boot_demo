package com.and.demo.webappall;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
@SpringBootTest
@AutoConfigureMockMvc
class WebappallApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void myUnitTest () throws Exception {
		// run with gradlew test --stacktrace
		// https://dzone.com/articles/rest-endpoint-testing-with-mockmvc
		///api/unittest/list/{type}
		System.out.println("calling myUnitTest");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "application/json");
		JSONObject request = new JSONObject();
		request.put("type", "work");

		RequestBuilder requestBuilder =
				MockMvcRequestBuilders
						.get("/api/unittest/list/work")
						.headers(httpHeaders)
						.content(request.toString());

		/*
		{"status":"OK","errDescription":"no problem","response":[{"id":2,"description":null,"deadline":null,"importance":0,"status":0,"deadlineStr":null}]}
		 */
		// "$[0].idCliente"
		//
		MvcResult result = mockMvc.perform(requestBuilder)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").hasJsonPath())
				.andExpect(jsonPath("$.status").value("OK"))
				.andExpect(jsonPath("$.response.[0].id").value(2))
				//.andExpect(jsonPath("$.name").value(request.getString("name")))
				//.andExpect(jsonPath("$.price").value(request.getInt("price")))
				//.andExpect(header().exists("xxxxxx"))
				.andExpect(header().string("Content-Type", "application/json;charset=utf-8")).andReturn();
		String content = result.getResponse().getContentAsString();
		//System.out.println(content);
	}			// must fully match the string !

	@Test
	void contextLoads() {

	}

}
