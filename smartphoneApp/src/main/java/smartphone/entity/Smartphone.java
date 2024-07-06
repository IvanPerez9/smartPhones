package smartphone.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Class Smartphone.
 */
@Entity
@Table(name = "PHONES")
public class Smartphone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "NAME")
    private String name;

	@Column(name = "BRAND")
    private String brand;

	@Column(name = "PRICE")
    private BigDecimal price;
	
	@Column(name = "CURR")
	private String currency;
	
	/**
	 * Instantiates a new smartphone.
	 */
	public Smartphone() {}

    /**
     * Instantiates a new smartphone.
     *
     * @param id the id
     * @param name the name
     * @param brand the brand
     * @param price the price
     * @param currency the currency
     */
    public Smartphone(Long id, String name, String brand, BigDecimal price, String currency) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.currency = currency;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand.
     *
     * @param brand the new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the new price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency the new currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
