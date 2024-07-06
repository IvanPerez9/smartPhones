package smartphone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class SmartphoneDtoTest {

	@Test
	void testGettersAndSetters() {
		SmartphoneDto dto = new SmartphoneDto();
		dto.setId("1");
		dto.setName("name");
		dto.setBrand("brand");
		BigDecimal price = new BigDecimal(100);
		dto.setPrice(price);
		dto.setCurrency("EUR");

		assertEquals("1", dto.getId());
		assertEquals("name", dto.getName());
		assertEquals("brand", dto.getBrand());
		assertEquals(price, dto.getPrice());
		assertEquals("EUR", dto.getCurrency());
	}
	
}
