package smartphone.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class SmartphoneTest {

	@Test
	void testGettersAndSetters() {
		Smartphone entity = new Smartphone();
		entity.setId(1L);
		entity.setName("name");
		entity.setBrand("brand");
		entity.setPrice(new BigDecimal("6.50"));
		entity.setCurrency("EUR");

		assertEquals(1L, entity.getId());
		assertEquals("name", entity.getName());
		assertEquals("brand", entity.getBrand());
		assertEquals(new BigDecimal("6.50"), entity.getPrice());
		assertEquals("EUR", entity.getCurrency());
	}
	
}
