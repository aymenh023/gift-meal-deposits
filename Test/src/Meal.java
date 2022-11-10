import java.time.LocalDate;

/**
 * @author AH
 *
 */
public class Meal extends Deposit {

	/**
	 * Constructeur public avec paramètres
	 * 
	 * @param name
	 * @param creationDate
	 * @param value
	 */
	public Meal(String name, LocalDate creationDate, Integer value) {
		super(name, creationDate, value);
		LocalDate mealExpirationDate = LocalDate.of(creationDate.getYear() + 1, 2, 1);
		mealExpirationDate = mealExpirationDate.withDayOfMonth(mealExpirationDate.getMonth().length(mealExpirationDate.isLeapYear()));
		super.expirationDate = mealExpirationDate;
	}

	/**
	 * Constructeur public avec paramètres
	 * 
	 * @param name
	 * @param creationDate
	 * @param value
	 * @param expirationDate
	 */
	public Meal(String name, LocalDate creationDate, Integer value, LocalDate expirationDate) {
		super(name, creationDate, value, expirationDate);
	}

	@Override
	public String toString() {
		return "Meal Added To User Balance [name="
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
