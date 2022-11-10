import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

/**
 * @author AH
 *
 */
public class TestJUnit {

	@Test
	public void testDistributeGiftsNormalExpiration() {
		// Prepare
		GiftMealDeposit.clearGifts();
		GiftMealDeposit.clearMeals();

		LocalDate dateNow = LocalDate.now();

		GiftMealDeposit.setCompanyBalance(240);
		GiftMealDeposit.setUserBalance(0);

		Gift giftA = new Gift("gift A", dateNow, 130);
		Gift giftB = new Gift("gift B", dateNow, 100);
		Gift giftC = new Gift("gift C", dateNow, 50);

		GiftMealDeposit.distibuteGift(giftA);
		GiftMealDeposit.distibuteGift(giftB);
		GiftMealDeposit.distibuteGift(giftC);

		// Test
		GiftMealDeposit.calculateUserBalance();

		// Assert
		assertTrue(GiftMealDeposit.getCompanyBalance().equals(10));
		assertTrue(GiftMealDeposit.getUserBalance().equals(230));
	}

	@Test
	public void testDistributeGiftsPrematureExpiration() {
		// Prepare
		GiftMealDeposit.clearGifts();
		GiftMealDeposit.clearMeals();

		LocalDate dateNow = LocalDate.now();

		GiftMealDeposit.setCompanyBalance(240);
		GiftMealDeposit.setUserBalance(0);

		Gift giftA = new Gift("gift A", dateNow, 130, dateNow.minusYears(1));
		Gift giftB = new Gift("gift B", dateNow, 100);
		Gift giftC = new Gift("gift C", dateNow, 50);

		GiftMealDeposit.distibuteGift(giftA);
		GiftMealDeposit.distibuteGift(giftB);
		GiftMealDeposit.distibuteGift(giftC);

		// Test
		GiftMealDeposit.calculateUserBalance();

		// Assert
		assertTrue(GiftMealDeposit.getCompanyBalance().equals(90));
		assertTrue(GiftMealDeposit.getUserBalance().equals(150));
	}

	@Test
	public void testDistributeMealsNormalExpiration() {
		// Prepare
		GiftMealDeposit.clearGifts();
		GiftMealDeposit.clearMeals();

		LocalDate dateNow = LocalDate.now();

		GiftMealDeposit.setCompanyBalance(240);
		GiftMealDeposit.setUserBalance(0);

		Meal mealA = new Meal("meal A", dateNow, 130);
		Meal mealB = new Meal("meal B", dateNow, 100);
		Meal mealC = new Meal("meal C", dateNow, 50);

		GiftMealDeposit.distibuteMeal(mealA);
		GiftMealDeposit.distibuteMeal(mealB);
		GiftMealDeposit.distibuteMeal(mealC);

		// Test
		GiftMealDeposit.calculateUserBalance();

		// Assert
		assertTrue(GiftMealDeposit.getCompanyBalance().equals(10));
		assertTrue(GiftMealDeposit.getUserBalance().equals(230));
	}

	@Test
	public void testDistributeMealsPrematureExpiration() {
		// Prepare
		GiftMealDeposit.clearGifts();
		GiftMealDeposit.clearMeals();

		LocalDate dateNow = LocalDate.now();

		GiftMealDeposit.setCompanyBalance(240);
		GiftMealDeposit.setUserBalance(0);

		Meal mealA = new Meal("meal A", dateNow, 130, dateNow.minusYears(1));
		Meal mealB = new Meal("meal B", dateNow, 100);
		Meal mealC = new Meal("meal C", dateNow, 50);

		GiftMealDeposit.distibuteMeal(mealA);
		GiftMealDeposit.distibuteMeal(mealB);
		GiftMealDeposit.distibuteMeal(mealC);

		// Test
		GiftMealDeposit.calculateUserBalance();

		// Assert
		assertTrue(GiftMealDeposit.getCompanyBalance().equals(90));
		assertTrue(GiftMealDeposit.getUserBalance().equals(150));
	}

	@Test
	public void testDistributeGiftsMealsNormalExpiration() {
		// Prepare
		GiftMealDeposit.clearGifts();
		GiftMealDeposit.clearMeals();

		LocalDate dateNow = LocalDate.now();

		GiftMealDeposit.setCompanyBalance(500);
		GiftMealDeposit.setUserBalance(0);

		Gift giftA = new Gift("gift A", dateNow, 130);
		Gift giftB = new Gift("gift B", dateNow, 100);
		Gift giftC = new Gift("gift C", dateNow, 300);

		GiftMealDeposit.distibuteGift(giftA);
		GiftMealDeposit.distibuteGift(giftB);
		GiftMealDeposit.distibuteGift(giftC);

		Meal mealA = new Meal("meal A", dateNow, 130);
		Meal mealB = new Meal("meal B", dateNow, 100);
		Meal mealC = new Meal("meal C", dateNow, 300);

		GiftMealDeposit.distibuteMeal(mealA);
		GiftMealDeposit.distibuteMeal(mealB);
		GiftMealDeposit.distibuteMeal(mealC);

		// Test
		GiftMealDeposit.calculateUserBalance();

		// Assert
		assertTrue(GiftMealDeposit.getCompanyBalance().equals(40));
		assertTrue(GiftMealDeposit.getUserBalance().equals(460));
	}

	@Test
	public void testDistributeGiftsMealsPrematureExpiration() {
		// Prepare
		GiftMealDeposit.clearGifts();
		GiftMealDeposit.clearMeals();

		LocalDate dateNow = LocalDate.now();

		GiftMealDeposit.setCompanyBalance(500);
		GiftMealDeposit.setUserBalance(0);

		Gift giftA = new Gift("gift A", dateNow, 130, dateNow.minusYears(1));
		Gift giftB = new Gift("gift B", dateNow, 100);
		Gift giftC = new Gift("gift C", dateNow, 300);

		GiftMealDeposit.distibuteGift(giftA);
		GiftMealDeposit.distibuteGift(giftB);
		GiftMealDeposit.distibuteGift(giftC);

		Meal mealA = new Meal("meal A", dateNow, 130, dateNow.minusYears(1));
		Meal mealB = new Meal("meal B", dateNow, 100);
		Meal mealC = new Meal("meal C", dateNow, 300);

		GiftMealDeposit.distibuteMeal(mealA);
		GiftMealDeposit.distibuteMeal(mealB);
		GiftMealDeposit.distibuteMeal(mealC);

		// Test
		GiftMealDeposit.calculateUserBalance();

		// Assert
		assertTrue(GiftMealDeposit.getCompanyBalance().equals(0));
		assertTrue(GiftMealDeposit.getUserBalance().equals(500));
	}

}
