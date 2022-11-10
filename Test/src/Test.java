import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

	private static Map<String, Gift> gifts = new LinkedHashMap<>();
	private static Map<String, Meal> meals = new LinkedHashMap<>();

	private static Integer companyBalance = 500;
	private static Integer userBalance = 0;

	public static void main(String[] args) {
		distibuteGift("gift A", LocalDate.now(), 150);
		distibuteGift("gift B", LocalDate.now(), 100);
		distibuteGift("gift C", LocalDate.now(), 400);
		distibuteMeal("meal A", LocalDate.now(), 20);
		distibuteMeal("meal B", LocalDate.now(), 10);
		distibuteMeal("meal C", LocalDate.now(), 250);
		calculateUserBalance();
	}

	/**
	 * Méthode pour distribuer des Gifts
	 * 
	 * @param giftName
	 * @param crationDate
	 * @param giftValue
	 */
	public static void distibuteGift(String giftName, LocalDate crationDate, Integer giftValue) {
		Gift gift = new Gift(giftName, crationDate, giftValue);
		gifts.put(gift.getName(), gift);
	}

	/**
	 * Méthode pour distribuer des Meals
	 * 
	 * @param mealName
	 * @param crationDate
	 * @param mealValue
	 */
	public static void distibuteMeal(String mealName, LocalDate crationDate, Integer mealValue) {
		Meal meal = new Meal(mealName, crationDate, mealValue);
		meals.put(meal.getName(), meal);
	}

	/**
	 * Méthode pour : </br>
	 * incrémenter le solde du bénéficiaire si seulmenet le solde de l'entreprise est positif </br>
	 * décrémenter le solde de l'entreprise si seulement il reste positif
	 * 
	 * @param value
	 * @return true, si les soldes ont été traités correctement
	 */
	public static boolean incrementUserBalance(Integer value) {
		if (companyBalance - value >= 0) {
			companyBalance -= value;
			userBalance += value;
			return true;
		}

		return false;
	}

	/**
	 * Méthode pour calculer le solde du bénéficiaire
	 */
	public static void calculateUserBalance() {
		LocalDate dateNow = LocalDate.now();

		System.out.println("Today : " + dateNow);

		LocalDate giftExpirationDate = null;
		LocalDate mealExpirationDate = null;
		Integer giftValue = null;
		Integer mealValue = null;
		Gift gift = null;
		Meal meal = null;

		for (Map.Entry<String, Gift> giftEntry : gifts.entrySet()) {
			gift = giftEntry.getValue();
			giftExpirationDate = gift.getCreationDate().plusYears(1).minusDays(1);
			gift.setExpirationDate(giftExpirationDate);

			if (dateNow.isBefore(giftExpirationDate)) {
				giftValue = gift.getValue();
				if (incrementUserBalance(giftValue)) {
					System.out.println(gift.toString());
				}
			}
		}

		for (Map.Entry<String, Meal> mealEntry : meals.entrySet()) {
			meal = mealEntry.getValue();
			mealExpirationDate = LocalDate.of(meal.getCreationDate().getYear() + 1, 2, 1);
			mealExpirationDate = mealExpirationDate.withDayOfMonth(mealExpirationDate.getMonth().length(mealExpirationDate.isLeapYear()));
			meal.setExpirationDate(mealExpirationDate);

			if (dateNow.isBefore(mealExpirationDate)) {
				mealValue = meal.getValue();
				if (incrementUserBalance(mealValue)) {
					System.out.println(meal.toString());
				}
			}
		}

		System.out.println("User balance is : " + userBalance + "£");
		System.out.println("Company balance is : " + companyBalance + "£");
	}

	private static class Deposit {
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
		 * @param expirationDate the expirationDate to set
		 */
		public void setExpirationDate(LocalDate expirationDate) {
			this.expirationDate = expirationDate;
		}

	}

	private static class Gift extends Deposit {
		/**
		 * Constructeur public avec paramètres
		 * 
		 * @param name
		 * @param creationDate
		 * @param value
		 */
		public Gift(String name, LocalDate creationDate, Integer value) {
			super(name, creationDate, value);
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

	private static class Meal extends Deposit {
		/**
		 * Constructeur public avec paramètres
		 * 
		 * @param name
		 * @param creationDate
		 * @param value
		 */
		public Meal(String name, LocalDate creationDate, Integer value) {
			super(name, creationDate, value);
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

}
