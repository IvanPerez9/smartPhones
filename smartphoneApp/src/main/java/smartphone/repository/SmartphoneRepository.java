package smartphone.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartphone.entity.Smartphone;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {

    List<Smartphone> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}