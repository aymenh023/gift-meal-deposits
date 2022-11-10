import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author AH
 *
 */
public class GiftMealDeposit {

	private static Map<String, Gift> gifts = new LinkedHashMap<>();
	private static Map<String, Meal> meals = new LinkedHashMap<>();

	private static Integer companyBalance = 500;
	private static Integer userBalance = 0;

	public static void main(String[] args) {
		LocalDate dateNow = LocalDate.now();

		Gift giftA = new Gift("gift A", dateNow, 150);
		Gift giftB = new Gift("gift B", dateNow, 100);
		Gift giftC = new Gift("gift C", dateNow, 400);

		distibuteGift(giftA);
		distibuteGift(giftB);
		distibuteGift(giftC);

		Meal mealA = new Meal("meal A", dateNow, 20);
		Meal mealB = new Meal("meal B", dateNow, 10);
		Meal mealC = new Meal("meal C", dateNow, 250);

		distibuteMeal(mealA);
		distibuteMeal(mealB);
		distibuteMeal(mealC);

		calculateUserBalance();
	}

	/**
	 * Méthode pour distribuer des Gifts
	 * 
	 * @param gift à distribuer
	 */
	public static void distibuteGift(Gift gift) {
		gifts.put(gift.getName(), gift);
	}

	/**
	 * Méthode pour distribuer des Meals
	 * 
	 * @param meal à distribuer
	 */
	public static void distibuteMeal(Meal meal) {
		meals.put(meal.getName(), meal);
	}

	/**
	 * Méthode pour initialiser la liste de Gifts
	 */
	public static void clearGifts() {
		gifts.clear();
	}

	/**
	 * Méthode pour initialiser la liste de Meals
	 */
	public static void clearMeals() {
		meals.clear();
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
		System.out.println("Initial User balance is : " + userBalance + "£");
		System.out.println("Initial Company balance is : " + companyBalance + "£");

		Integer giftValue = null;
		Integer mealValue = null;
		Gift gift = null;
		Meal meal = null;

		for (Map.Entry<String, Gift> giftEntry : gifts.entrySet()) {
			gift = giftEntry.getValue();

			if (dateNow.isBefore(gift.getExpirationDate())) {
				giftValue = gift.getValue();
				if (incrementUserBalance(giftValue)) {
					System.out.println(gift.toString());
				}
			}
		}

		for (Map.Entry<String, Meal> mealEntry : meals.entrySet()) {
			meal = mealEntry.getValue();

			if (dateNow.isBefore(meal.getExpirationDate())) {
				mealValue = meal.getValue();
				if (incrementUserBalance(mealValue)) {
					System.out.println(meal.toString());
				}
			}
		}

		System.out.println("User balance is : " + userBalance + "£");
		System.out.println("Company balance is : " + companyBalance + "£");
		System.out.println();
	}

	/**
	 * @return the companyBalance
	 */
	public static Integer getCompanyBalance() {
		return companyBalance;
	}

	/**
	 * @param companyBalance the companyBalance to set
	 */
	public static void setCompanyBalance(Integer companyBalance) {
		GiftMealDeposit.companyBalance = companyBalance;
	}

	/**
	 * @return the userBalance
	 */
	public static Integer getUserBalance() {
		return userBalance;
	}

	/**
	 * @param userBalance the userBalance to set
	 */
	public static void setUserBalance(Integer userBalance) {
		GiftMealDeposit.userBalance = userBalance;
	}

}