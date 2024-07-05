/**
 * 
 */
package smartphone.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import smartphone.entity.Smartphone;

/**
 * @author ivan
 *
 *  https://github.com/IvanPerez9
 */
public class SimilarPricedControllerImpl {

	@GetMapping("/smartphone/{id}/similar")
    public ResponseEntity<Smartphone> findSimilarSmartphones(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
	
}
