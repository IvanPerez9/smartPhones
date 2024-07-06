package smartphone.service;

import java.util.List;

import smartphone.model.SmartphoneDto;

/**
 * The Interface SmartphoneService.
 */
public interface SmartphoneService {

	/**
	 * Gets the smartphone by id.
	 *
	 * @param id the id
	 * @return the smartphone by id
	 */
	public SmartphoneDto getSmartphoneById(Long id);
	
	/**
	 * Gets the similar price phone ids.
	 *
	 * @param id the id
	 * @return the similar price phone ids
	 */
	public List<Long> getSimilarPricePhoneIds(Long id);
	
	/**
	 * Gets the similar price smartphones.
	 *
	 * @param id the id
	 * @return the similar price smartphones
	 */
	public List<SmartphoneDto> getSimilarPriceSmartphones(Long id);
	
}
