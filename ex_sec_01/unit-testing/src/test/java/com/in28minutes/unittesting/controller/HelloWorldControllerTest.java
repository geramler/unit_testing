package com.in28minutes.unittesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void HelloWorld_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }

}
