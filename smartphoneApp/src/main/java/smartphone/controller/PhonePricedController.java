package smartphone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import smartphone.model.SmartphoneDto;

public interface PhonePricedController {

	public SmartphoneDto getSmartphoneById(Long id);

	public List<Long> getSimilarPricePhoneIds(Long id);

	public ResponseEntity<List<SmartphoneDto>> findSimilarSmartphones(@PathVariable Long id);

}
