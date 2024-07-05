package smartphone.controller;

import smartphone.controller.impl.SimilarPricedControllerImpl;
import smartphone.entity.Smartphone;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class SimilarPricedControllerTest {

    @InjectMocks
    private SimilarPricedControllerImpl similarPricedController;
    
    private static final String PHONE_ID = "1";

    @Test
     void when_callGetSimilarSmartphonesById_then_returnOKStatus() {

        Smartphone smartphone = new Smartphone();

        ResponseEntity<Smartphone> responseEntity = similarPricedController.findSimilarSmartphones(PHONE_ID);

        Assertions.assertThat(HttpStatus.OK).isEqualTo( responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }
}
