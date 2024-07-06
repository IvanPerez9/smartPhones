package smartphone.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.server.ResponseStatusException;

import smartphone.entity.Smartphone;
import smartphone.model.SmartphoneDto;
import smartphone.repository.SmartphoneRepository;
import smartphone.service.impl.SmartphoneServiceImpl;

class SmartphoneServiceTest {

	@Mock
	private SmartphoneRepository smartphoneRepository;

	@InjectMocks
	private SmartphoneServiceImpl smartphoneService;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
		this.smartphoneService = new SmartphoneServiceImpl(smartphoneRepository);
	}

	void initData() {
		ReflectionTestUtils.setField(smartphoneService, "rangeDifference", new BigDecimal(50));
	}

	@Test
	void testSmartphoneById() {
		// datos
		Long id = 1L;
		Smartphone expected = new Smartphone();
		expected.setId(id);
		expected.setName("Test Smartphone");
		expected.setBrand("Test Brand");
		expected.setPrice(new BigDecimal("1000.00"));
		expected.setCurrency("EUR");

		// when
		when(smartphoneRepository.findById(id)).thenReturn(Optional.of(expected));

		// then
		SmartphoneDto actual = smartphoneService.getSmartphoneById(id);

		// assert
		assertEquals(expected.getId().toString(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getBrand(), actual.getBrand());
		assertEquals(expected.getPrice(), actual.getPrice());
		assertEquals(expected.getCurrency(), actual.getCurrency());
	}

	@Test
	void testSmartphoneById_ThrowsException() {
		Long id = 1L;

		when(smartphoneRepository.findById(anyLong())).thenReturn(java.util.Optional.empty());

		ResponseStatusException exception = assertThrows(ResponseStatusException.class,
				() -> smartphoneService.getSmartphoneById(id));

		String expectedMessage = "Smartphone with id " + id + " not found";
		assertEquals(expectedMessage, exception.getReason());
	}

	@Test
	void testSimilarPricePhoneIds() {
		initData();
		Long id = 1L;

		Smartphone baseSmartphone = new Smartphone();
		baseSmartphone.setId(id);
		baseSmartphone.setPrice(new BigDecimal("1000.00"));

		Smartphone similarSmartphone1 = new Smartphone();
		similarSmartphone1.setId(2L);
		similarSmartphone1.setPrice(new BigDecimal("1050.00"));

		Smartphone similarSmartphone2 = new Smartphone();
		similarSmartphone2.setId(3L);
		similarSmartphone2.setPrice(new BigDecimal("950.00"));

		List<Smartphone> mockSmartphones = new ArrayList<>();
		mockSmartphones.add(similarSmartphone1);
		mockSmartphones.add(similarSmartphone2);

		when(smartphoneRepository.findById(id)).thenReturn(java.util.Optional.of(baseSmartphone));
		when(smartphoneRepository.findByPriceBetween(any(BigDecimal.class), any(BigDecimal.class)))
				.thenReturn(mockSmartphones);

		List<Long> actualIds = smartphoneService.getSimilarPricePhoneIds(id);

		assertEquals(2, actualIds.size());
		assertEquals(2L, actualIds.get(0));
		assertEquals(3L, actualIds.get(1));
	}

	@Test
	void testSimilarPricePhoneIds_ThrowsException() {
		initData();
		Long id = 1L;

		when(smartphoneRepository.findById(any(Long.class))).thenReturn(java.util.Optional.empty());

		ResponseStatusException exception = assertThrows(ResponseStatusException.class,
				() -> smartphoneService.getSimilarPricePhoneIds(id));

		String expectedMessage = "Smartphone with id " + id + " not found";
		assertEquals(expectedMessage, exception.getReason());
	}

	@Test
	void testGetSmartphoneById_invalidId_shouldThrowException() {
		// Arrange
		Long invalidId = 999L;
		when(smartphoneRepository.findById(invalidId)).thenReturn(java.util.Optional.empty());

		// Act & Assert
		ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
			smartphoneService.getSmartphoneById(invalidId);
		});
		assertEquals("Smartphone with id " + invalidId + " not found", exception.getReason());
	}

	@Test
	void testSimilarPriceSmartphones_EmptyList() {
		initData();
		Long id = 1L;

		Smartphone expected = new Smartphone();
		expected.setId(id);
		expected.setName("Test Smartphone");
		expected.setBrand("Test Brand");
		expected.setPrice(new BigDecimal("1000.00"));
		expected.setCurrency("EUR");

		when(smartphoneRepository.findById(id)).thenReturn(Optional.of(expected));
		when(smartphoneService.getSimilarPricePhoneIds(id)).thenReturn(List.of());

		List<SmartphoneDto> actualDtos = smartphoneService.getSimilarPriceSmartphones(id);

		assertEquals(0, actualDtos.size());
	}

	@Test
	void testGetSimilarPriceSmartphones_noSimilarPhones() {
		initData();
		Long id = 1L;

		Smartphone baseSmartphone = new Smartphone();
		baseSmartphone.setId(id);
		baseSmartphone.setName("Test Smartphone");
		baseSmartphone.setBrand("Test Brand");
		baseSmartphone.setPrice(new BigDecimal("1000.00"));
		baseSmartphone.setCurrency("EUR");

		when(smartphoneRepository.findById(id)).thenReturn(Optional.of(baseSmartphone));
		when(smartphoneService.getSimilarPricePhoneIds(id)).thenReturn(List.of());

		List<SmartphoneDto> actualDtos = smartphoneService.getSimilarPriceSmartphones(id);

		assertNotNull(actualDtos);
		assertEquals(0, actualDtos.size());
	}
}
