/**
 * 
 */
package smartphone.model.mapper;

import org.mapstruct.Mapper;

import smartphone.entity.Smartphone;
import smartphone.model.SmartphoneDto;

/**
 * @author ivan
 *
 *  https://github.com/IvanPerez9
 */
@Mapper
public interface SmartphoneMapper {

	SmartphoneDto smartphoneToDto (Smartphone entity);
	
	Smartphone smartphoneToEntity (SmartphoneDto dto);
}
