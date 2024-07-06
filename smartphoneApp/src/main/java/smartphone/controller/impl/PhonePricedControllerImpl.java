/**
 * 
 */
package smartphone.controller.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartphone.controller.PhonePricedController;
import smartphone.model.SmartphoneDto;
import smartphone.service.SmartphoneService;

/**
 * The Class SimilarPricedControllerImpl.
 *
 * @author ivan
 * 
 *         https://github.com/IvanPerez9
 */
@RestController
@RequestMapping("/smartphone")
public class PhonePricedControllerImpl implements PhonePricedController {

	private SmartphoneService smartphoneService;

	/**
	 * Instantiates a new similar priced controller impl.
	 *
	 * @param smartphoneService the smartphone service
	 */
	public PhonePricedControllerImpl(SmartphoneService smartphoneService) {
		super();
		this.smartphoneService = smartphoneService;
	}

	/**
	 * Gets the smartphone by id.
	 *
	 * @param id the id
	 * @return the smartphone by id
	 */
	@GetMapping("/{id}")
	public SmartphoneDto getSmartphoneById(@PathVariable Long id) {
		return smartphoneService.getSmartphoneById(id);
	}

	/**
	 * Gets the similar price phone ids.
	 *
	 * @param id the id
	 * @return the similar price phone ids
	 */
	@GetMapping("/{id}/similarprices")
	public List<Long> getSimilarPricePhoneIds(@PathVariable Long id) {
		return smartphoneService.getSimilarPricePhoneIds(id);
	}

	/**
	 * Find similar smartphones.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@GetMapping("/{id}/similar")
    public ResponseEntity<List<SmartphoneDto>> findSimilarSmartphones(@PathVariable Long id) {
        List<SmartphoneDto> similarSmartphones = smartphoneService.getSimilarPriceSmartphones(id);
        return ResponseEntity.ok(similarSmartphones);
    }

}
