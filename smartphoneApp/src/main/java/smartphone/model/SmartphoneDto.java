/**
 * 
 */
package smartphone.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ivan
 *
 *         https://github.com/IvanPerez9
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class SmartphoneDto {

	@NotNull
	private String id;

	@NotNull
	private String name;

	private String brand;

	@NotNull
	private BigDecimal price;
	
	private String currency;

}
