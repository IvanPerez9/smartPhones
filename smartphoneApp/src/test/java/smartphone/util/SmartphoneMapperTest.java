package smartphone.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import smartphone.entity.Smartphone;
import smartphone.model.SmartphoneDto;
import smartphone.model.mapper.SmartphoneMapper;

class SmartphoneMapperTest {

	@Test
    void testSmartphoneToDto_ValidEntity() {
        Smartphone entity = new Smartphone();
        entity.setId(1L);
        entity.setName("Test Smartphone");
        entity.setBrand("Test Brand");
        entity.setPrice(new BigDecimal("1000.00"));
        entity.setCurrency("USD");

        SmartphoneDto dto = SmartphoneMapper.smartphoneToDto(entity);

        assertNotNull(dto);
        assertEquals("1", dto.getId());
        assertEquals("Test Smartphone", dto.getName());
        assertEquals("Test Brand", dto.getBrand());
        assertEquals(new BigDecimal("1000.00"), dto.getPrice());
        assertEquals("USD", dto.getCurrency());
    }
	
	@Test
    void testSmartphoneToDto_NullEntity() {
        assertThrows(IllegalArgumentException.class, () -> {
            SmartphoneMapper.smartphoneToDto(null);
        });
    }
	
	@Test
    void testSmartphoneToEntity_ValidDto() {
        SmartphoneDto dto = SmartphoneDto.builder()
                .id("1")
                .name("Test Smartphone")
                .brand("Test Brand")
                .price(new BigDecimal("1000.00"))
                .currency("USD")
                .build();

        Smartphone entity = SmartphoneMapper.smartphoneToEntity(dto);

        assertNotNull(entity);
        assertEquals(1L, entity.getId());
        assertEquals("Test Smartphone", entity.getName());
        assertEquals("Test Brand", entity.getBrand());
        assertEquals(new BigDecimal("1000.00"), entity.getPrice());
        assertEquals("USD", entity.getCurrency());
    }
	
	@Test
    void testSmartphoneToEntity_NullDto() {
        assertThrows(IllegalArgumentException.class, () -> {
            SmartphoneMapper.smartphoneToEntity(null);
        });
    }
	
}
