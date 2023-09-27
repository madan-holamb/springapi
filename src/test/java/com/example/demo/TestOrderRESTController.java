package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.PotOrder;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(TestOrderRESTController.class)
public class TestOrderRESTController {

	
	  @Autowired
	  private MockMvc mvc;
	  
	    @MockBean
	    private OrderService orderService;
	    
	    private static ObjectMapper mapper = new ObjectMapper();
	  
	    @Test
	    public void testGetExample() throws Exception {
	    	mvc.perform(get("/orders")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)));
	    }
}
