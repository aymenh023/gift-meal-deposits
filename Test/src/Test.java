import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Test {

	private static HashMap<String, LocalDate> giftsCreationDates = new HashMap<>();
	private static HashMap<String, Integer> giftsValues = new HashMap<>();

	private static HashMap<String, LocalDate> mealsCreationDates = new HashMap<>();
	private static HashMap<String, Integer> mealsValues = new HashMap<>();

	private static Integer balance = 0;

	public static void main(String[] args) {
		distibuteGift("gift A", 150);
		distibuteGift("gift B", 100);
		distibuteMeal("meal A", 20);
		distibuteMeal("meal B", 10);
		System.out.println("User balance is : " + calculateBalance());
	}

	public static void distibuteGift(String giftName, Integer giftValue) {
		LocalDate dateNow = LocalDate.now();
		giftsCreationDates.put(giftName, dateNow);
		giftsValues.put(giftName, giftValue);
	}

	public static void distibuteMeal(String mealName, Integer mealValue) {
		LocalDate dateNow = LocalDate.now();
		mealsCreationDates.put(mealName, dateNow);
		mealsValues.put(mealName, mealValue);
	}

	public static Integer calculateBalance() {
		LocalDate dateNow = LocalDate.now();

		System.out.println("Today : " + dateNow);

		for (Map.Entry<String, LocalDate> giftCreationDate : giftsCreationDates.entrySet()) {
			LocalDate giftExpirationDate = giftCreationDate.getValue().plusYears(1).minusDays(1);

			if (dateNow.isBefore(giftExpirationDate)) {
				Integer giftValue = giftsValues.get(giftCreationDate.getKey());
				System.out.println("Gift Value : " + giftValue + "£ / Gift Expiration Date : " + giftExpirationDate);
				balance += giftValue;
			}
		}

		for (Map.Entry<String, LocalDate> mealCreationDate : mealsCreationDates.entrySet()) {
			LocalDate mealExpirationDate = LocalDate.of(mealCreationDate.getValue().getYear() + 1, 2, 1);
			mealExpirationDate = mealExpirationDate.withDayOfMonth(mealExpirationDate.getMonth().length(mealExpirationDate.isLeapYear()));

			if (dateNow.isBefore(mealExpirationDate)) {
				Integer mealValue = mealsValues.get(mealCreationDate.getKey());
				System.out.println("Meal Value : " + mealValue + "£ / Meal Expiration Date : " + mealExpirationDate);
				balance += mealValue;
			}
		}

		return balance;
	}

}
