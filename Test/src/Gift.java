import java.time.LocalDate;

/**
 * @author AH
 *
 */
public class Gift extends Deposit {

	/**
	 * Constructeur public avec paramètres
	 * 
	 * @param name
	 * @param creationDate
	 * @param value
	 */
	public Gift(String name, LocalDate creationDate, Integer value) {
		super(name, creationDate, value);
		super.expirationDate = creationDate.plusYears(1).minusDays(1);
	}

	/**
	 * Constructeur public avec paramètres
	 * 
	 * @param name
	 * @param creationDate
	 * @param value
	 * @param expirationDate
	 */
	public Gift(String name, LocalDate creationDate, Integer value, LocalDate expirationDate) {
		super(name, creationDate, value, expirationDate);
	}

	@Override
	public String toString() {
		return "Gift Added To User Balance [name="
			+ name
			+ ", creationDate="
			+ creationDate
			+ ", value="
			+ value
			+ ", expirationDate="
			+ expirationDate
			+ "]";
	}

}
