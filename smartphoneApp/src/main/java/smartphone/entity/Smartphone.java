package smartphone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHONES")
public class Smartphone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

	@Column(name = "NAME")
    private String name;

	@Column(name = "BRAND")
    private String brand;

	@Column(name = "PRICE")
    private String price;
	
	@Column(name = "CURR")
	private String currency;
}
