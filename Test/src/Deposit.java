import java.time.LocalDate;

/**
 * @author AH
 *
 */
public class Deposit {

	protected String name;
	protected LocalDate creationDate;
	protected Integer value;
	protected LocalDate expirationDate;

	/**
	 * Constructeur public avec paramètres
	 * 
	 * @param name
	 * @param creationDate
	 * @param value
	 */
	public Deposit(String name, LocalDate creationDate, Integer value) {
		this.name = name;
		this.creationDate = creationDate;
		this.value = value;
	}

	/**
	 * Constructeur public avec paramètres
	 * 
	 * @param name
	 * @param creationDate
	 * @param value
	 * @param expirationDate
	 */
	public Deposit(String name, LocalDate creationDate, Integer value, LocalDate expirationDate) {
		this.name = name;
		this.creationDate = creationDate;
		this.value = value;
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the creationDate
	 */
	public LocalDate getCreationDate() {
		return creationDate;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @return the expirationDate
	 */
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

}
