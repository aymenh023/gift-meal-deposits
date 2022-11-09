import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Test {

	private static HashMap<String, Gift> gifts = new HashMap<>();
	private static HashMap<String, Meal> meals = new HashMap<>();

	private static Integer balance = 0;

	public static void main(String[] args) {
		distibuteGift("gift A", 150);
		distibuteGift("gift B", 100);
		distibuteMeal("meal A", 20);
		distibuteMeal("meal B", 10);
		calculateBalance();
	}

	public static void distibuteGift(String giftName, Integer giftValue) {
		LocalDate dateNow = LocalDate.now();
		gifts.put(giftName, new Gift(dateNow, giftValue));
	}

	public static void distibuteMeal(String mealName, Integer mealValue) {
		LocalDate dateNow = LocalDate.now();
		meals.put(mealName, new Meal(dateNow, mealValue));
	}

	public static Integer calculateBalance() {
		LocalDate dateNow = LocalDate.now();

		System.out.println("Today : " + dateNow);

		for (Map.Entry<String, Gift> gift : gifts.entrySet()) {
			LocalDate giftExpirationDate = gift.getValue().getCreationDate().plusYears(1).minusDays(1);

			if (dateNow.isBefore(giftExpirationDate)) {
				Integer giftValue = gift.getValue().getValue();
				System.out.println("Gift Value : " + giftValue + "£ / Gift Expiration Date : " + giftExpirationDate);
				balance += giftValue;
			}
		}

		for (Map.Entry<String, Meal> meal : meals.entrySet()) {
			LocalDate mealExpirationDate = LocalDate.of(meal.getValue().getCreationDate().getYear() + 1, 2, 1);
			mealExpirationDate = mealExpirationDate.withDayOfMonth(mealExpirationDate.getMonth().length(mealExpirationDate.isLeapYear()));

			if (dateNow.isBefore(mealExpirationDate)) {
				Integer mealValue = meal.getValue().getValue();
				System.out.println("Meal Value : " + mealValue + "£ / Meal Expiration Date : " + mealExpirationDate);
				balance += mealValue;
			}
		}

		System.out.println("User balance is : " + balance);

		return balance;
	}

	private static class Deposit {
		protected LocalDate creationDate;
		protected Integer value;

		/**
		 * Constructeur public avec paramètres
		 * 
		 * @param creationDate
		 * @param value
		 */
		public Deposit(LocalDate creationDate, Integer value) {
			this.creationDate = creationDate;
			this.value = value;
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
	}

	private static class Gift extends Deposit {
		/**
		 * Constructeur public avec paramètres
		 * 
		 * @param creationDate
		 * @param value
		 */
		public Gift(LocalDate creationDate, Integer value) {
			super(creationDate, value);
		}
	}

	private static class Meal extends Deposit {
		/**
		 * Constructeur public avec paramètres
		 * 
		 * @param creationDate
		 * @param value
		 */
		public Meal(LocalDate creationDate, Integer value) {
			super(creationDate, value);
		}
	}

}
