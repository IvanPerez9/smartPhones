package smartphone.controller;

import org.springframework.http.ResponseEntity;

import smartphone.entity.Smartphone;

public interface SimilarPricedController {

    public ResponseEntity<Smartphone> findSimilarSmartphones(String id);

}
