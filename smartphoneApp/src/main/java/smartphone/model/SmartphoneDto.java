/**
 * 
 */
package smartphone.model;

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
public class SmartphoneDto {

	private String id;

	private String name;

	private String brand;

	private String price;

}
