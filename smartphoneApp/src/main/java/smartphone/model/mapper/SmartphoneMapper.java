/**
 * 
 */
package smartphone.model.mapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;

import smartphone.entity.Smartphone;
import smartphone.model.SmartphoneDto;

/**
 * The Class SmartphoneMapper.
 *
 * @author ivan
 * 
 *         https://github.com/IvanPerez9
 */
public class SmartphoneMapper {

	@Value("${app.regional-settings.regionalCurrency:EUR}")
	static String defaultCurrency;

	private SmartphoneMapper() {
	}

	/**
	 * Smartphone to dto.
	 *
	 * @param entity the entity
	 * @return the smartphone dto
	 */
	public static SmartphoneDto smartphoneToDto(Smartphone entity) {
		if (entity == null) {
			throw new IllegalArgumentException("Smartphone entity cannot be null");
		}

		return SmartphoneDto.builder()
				.id(Optional.ofNullable(entity.getId()).map(Object::toString)
						.orElseThrow(() -> new IllegalArgumentException("Id cannot be null")))
				.name(Optional.ofNullable(entity.getName())
						.orElseThrow(() -> new IllegalArgumentException("Name cannot be null")))
				.brand(entity.getBrand())
				.price(Optional.ofNullable(entity.getPrice())
						.orElseThrow(() -> new IllegalArgumentException("Price cannot be null")))
				.currency(Optional.ofNullable(entity.getCurrency()).orElse(defaultCurrency)).build();
	}

	/**
	 * Smartphone to entity.
	 *
	 * @param dto the dto
	 * @return the smartphone
	 */
	public static Smartphone smartphoneToEntity(SmartphoneDto dto) {
		if (dto == null) {
			throw new IllegalArgumentException("Smartphone DTO cannot be null");
		}

		Smartphone smartphone = new Smartphone();
		smartphone.setId(Optional.ofNullable(dto.getId()).map(Long::valueOf)
				.orElseThrow(() -> new IllegalArgumentException("Id cannot be null")));
		smartphone.setName(Optional.ofNullable(dto.getName())
				.orElseThrow(() -> new IllegalArgumentException("Name cannot be null")));
		smartphone.setBrand(dto.getBrand());
		smartphone.setPrice(Optional.ofNullable(dto.getPrice())
				.orElseThrow(() -> new IllegalArgumentException("Price cannot be null")));
		smartphone.setCurrency(dto.getCurrency());

		return smartphone;
	}
}
