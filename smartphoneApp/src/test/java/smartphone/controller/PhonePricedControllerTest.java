package smartphone.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import smartphone.controller.impl.PhonePricedControllerImpl;
import smartphone.model.SmartphoneDto;
import smartphone.service.SmartphoneService;

class PhonePricedControllerTest {

	@InjectMocks
	private PhonePricedControllerImpl similarPricedController;
	@Mock
	private SmartphoneService smartphoneService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
    void testGetSmartphoneById() {
        Long id = 1L;
        SmartphoneDto expectedDto = SmartphoneDto.builder()
        	    .id(id.toString())
        	    .name("Smartphone")
        	    .brand("Brand")
        	    .price(new BigDecimal("1000.00"))
        	    .currency("EUR")
        	    .build();
        when(smartphoneService.getSmartphoneById(id)).thenReturn(expectedDto);

        SmartphoneDto actualDto = similarPricedController.getSmartphoneById(id);

        assertEquals(expectedDto, actualDto);
        verify(smartphoneService, times(1)).getSmartphoneById(id);
    }
	
	@Test
    void testGetSimilarPricePhoneIds() {
        Long id = 1L;
        List<Long> expectedIds = Arrays.asList(2L, 3L, 4L);
        when(smartphoneService.getSimilarPricePhoneIds(id)).thenReturn(expectedIds);

        List<Long> actualIds = similarPricedController.getSimilarPricePhoneIds(id);

        assertEquals(expectedIds, actualIds);
        verify(smartphoneService, times(1)).getSimilarPricePhoneIds(id);
    }

    @Test
    void testFindSimilarSmartphones() {
        Long id = 1L;
        
        SmartphoneDto smartphoneDto1 = SmartphoneDto.builder()
        	    .id("2")
        	    .name("Smartphone 2")
        	    .brand("Brand 2")
        	    .price(new BigDecimal("1200.00"))
        	    .currency("EUR")
        	    .build();
        SmartphoneDto smartphoneDto2 = SmartphoneDto.builder()
        	    .id("3")
        	    .name("Smartphone 3")
        	    .brand("Brand 3")
        	    .price(new BigDecimal("1100.00"))
        	    .currency("EUR")
        	    .build();
        List<SmartphoneDto> expectedSmartphones = Arrays.asList(smartphoneDto1, smartphoneDto2);
        when(smartphoneService.getSimilarPriceSmartphones(id)).thenReturn(expectedSmartphones);

        ResponseEntity<List<SmartphoneDto>> response = similarPricedController.findSimilarSmartphones(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedSmartphones, response.getBody());
        verify(smartphoneService, times(1)).getSimilarPriceSmartphones(id);
    }
}
