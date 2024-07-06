package smartphone.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc(print = MockMvcPrint.DEFAULT)
class PhonePricedControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
    void testGetSmartphoneById() throws Exception {
        Long id = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/smartphone/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists());
    }

    @Test
    void testGetSimilarPricePhoneIds() throws Exception {
        Long id = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/smartphone/{id}/similarprices", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }
    
    @Test
    void testFindSimilarSmartphones() throws Exception {
        Long id = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/smartphone/{id}/similar", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").exists());
    }
	
}
