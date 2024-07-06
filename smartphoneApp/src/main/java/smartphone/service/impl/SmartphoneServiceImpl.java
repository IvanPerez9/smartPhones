package smartphone.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import smartphone.entity.Smartphone;
import smartphone.model.SmartphoneDto;
import smartphone.model.mapper.SmartphoneMapper;
import smartphone.repository.SmartphoneRepository;
import smartphone.service.SmartphoneService;

/**
 * The Class SmartphoneServiceImpl.
 */
@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    private SmartphoneRepository smartphoneRepository;
    
    @Value("${app.regional-settings.rangeDifference:80}")
    private BigDecimal rangeDifference;
    
    /**
     * Instantiates a new smartphone service impl.
     *
     * @param smartphoneRepository the smartphone repository
     */
    public SmartphoneServiceImpl(SmartphoneRepository smartphoneRepository) {
		super();
		this.smartphoneRepository = smartphoneRepository;
	}
    
    /**
     * Gets the smartphone by id.
     *
     * @param id the id
     * @return the smartphone by id
     */
    public SmartphoneDto getSmartphoneById(Long id) {
        Smartphone smartphone = smartphoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Smartphone with id " + id + " not found"));
        return SmartphoneMapper.smartphoneToDto(smartphone);
    }

    /**
     * Gets the similar price phone ids.
     *
     * @param id the id
     * @return the similar price phone ids
     */
    public List<Long> getSimilarPricePhoneIds(Long id) {
        Smartphone baseSmartphone = smartphoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Smartphone with id " + id + " not found"));

        BigDecimal price = baseSmartphone.getPrice();
        BigDecimal minPrice = price.subtract(rangeDifference);
        BigDecimal maxPrice = price.add(rangeDifference);

        List<Smartphone> smartphones = smartphoneRepository.findByPriceBetween(minPrice, maxPrice);
        return smartphones.stream()
                          .map(Smartphone::getId)
                          .filter((Long smartphoneId) -> !smartphoneId.equals(id))
                          .collect(Collectors.toList());
    }
    
    /**
     * Gets the similar price smartphones.
     *
     * @param id the id
     * @return the similar price smartphones
     */
    public List<SmartphoneDto> getSimilarPriceSmartphones(Long id) {
        return Optional.ofNullable(getSimilarPricePhoneIds(id))
                .orElseGet(List::of)
                .stream()
                .map(this::getSmartphoneById)
                .collect(Collectors.toList());
    }
	
}
