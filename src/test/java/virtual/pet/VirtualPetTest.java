package virtual.pet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldConstructNewPetUsingConstructorParameters() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);

		String name = underTest.getName();
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int boredomLevel = underTest.getBoredomLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		// boolean isAsleep = underTest.getSleepStatus();
		int foodBowlLevel = underTest.getFoodBowlLevel();
		int waterBowlLevel = underTest.getWaterBowlLevel();
		int litterBoxLevel = underTest.getLitterBoxLevel();

		Assert.assertEquals("Test", name);
		Assert.assertEquals(60, hungerLevel);
		Assert.assertEquals(60, thirstLevel);
		Assert.assertEquals(60, boredomLevel);
		Assert.assertEquals(60, tirednessLevel);
		// Assert.assertEquals(false, isAsleep);
		Assert.assertEquals(0, foodBowlLevel);
		Assert.assertEquals(0, waterBowlLevel);
		Assert.assertEquals(0, litterBoxLevel);
	}

	@Test
	public void checkForValuesOver100ShouldKeepValuesFromGoingOver100() {
		VirtualPet underTest = new VirtualPet("Test", 110, 110, 110, 110, 110);
		underTest.checkForValuesOver100();

		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int boredomLevel = underTest.getBoredomLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		int wasteLevel = underTest.getWasteLevel();

		Assert.assertEquals(100, hungerLevel);
		Assert.assertEquals(100, thirstLevel);
		Assert.assertEquals(100, boredomLevel);
		Assert.assertEquals(100, tirednessLevel);
		Assert.assertEquals(100, wasteLevel);
	}

	@Test
	public void eatShouldRaiseOrLowerLevels() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.putOutFood();
		underTest.eat();

		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int boredomLevel = underTest.getBoredomLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		int wasteLevel = underTest.getWasteLevel();
		int foodBowlLevel = underTest.getFoodBowlLevel();

		Assert.assertEquals(20, hungerLevel);
		Assert.assertEquals(70, thirstLevel);
		Assert.assertEquals(55, boredomLevel);
		Assert.assertEquals(70, tirednessLevel);
		Assert.assertEquals(80, wasteLevel);
		Assert.assertEquals(80, wasteLevel);
		Assert.assertEquals(1, foodBowlLevel);
	}

	@Test
	public void drinkShouldRaiseOrLowerLevels() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.putOutWater();
		underTest.drink();

		int thirstLevel = underTest.getThirstLevel();
		int wasteLevel = underTest.getWasteLevel();
		int waterBowlLevel = underTest.getWaterBowlLevel();

		Assert.assertEquals(20, thirstLevel);
		Assert.assertEquals(80, wasteLevel);
		Assert.assertEquals(1, waterBowlLevel);
	}

	@Test
	public void playShouldRaiseOrLowerLevels() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();

		int boredomLevel = underTest.getBoredomLevel();
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int tirednessLevel = underTest.getTirednessLevel();

		Assert.assertEquals(20, boredomLevel);
		Assert.assertEquals(70, hungerLevel);
		Assert.assertEquals(70, thirstLevel);
		Assert.assertEquals(90, tirednessLevel);
	}

	@Test
	public void sleepShouldRaiseOrLowerLevels() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.sleep();

		int tirednessLevel = underTest.getTirednessLevel();
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		// boolean isAsleep = underTest.getSleepStatus();

		Assert.assertEquals(0, tirednessLevel);
		Assert.assertEquals(80, hungerLevel);
		Assert.assertEquals(80, thirstLevel);
		// Assert.assertEquals(true, isAsleep);
	}

	@Test
	public void useLitterBoxShouldRaiseOrLowerLevels() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.useLitterBox();

		int wasteLevel = underTest.getWasteLevel();
		int litterBoxLevel = underTest.getLitterBoxLevel();

		Assert.assertEquals(0, wasteLevel);
		Assert.assertEquals(1, litterBoxLevel);
	}

	@Test
	public void useFloorShouldLowerWasteLevelAndTriggerFlag() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.useFloor();

		int wasteLevel = underTest.getWasteLevel();
		boolean hasUsedFloorBefore = underTest.getHasUsedFloorBefore();

		Assert.assertEquals(0, wasteLevel);
		Assert.assertEquals(true, hasUsedFloorBefore);
	}

	@Test
	public void putOutFoodShouldRaiseFoodBowlLevelTo2() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.putOutFood();

		int foodBowlLevel = underTest.getFoodBowlLevel();

		Assert.assertEquals(2, foodBowlLevel);
	}

	@Test
	public void putOutWaterShouldRaiseWaterBowlLevelTo2() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.putOutWater();

		int waterBowlLevel = underTest.getWaterBowlLevel();

		Assert.assertEquals(2, waterBowlLevel);
	}

	@Test
	public void scoopLitterBoxShouldLowerLitterBoxLevelToZero() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.scoopLitterBox();

		int litterBoxLevel = underTest.getLitterBoxLevel();

		Assert.assertEquals(0, litterBoxLevel);
	}

	@Test
	public void tickShouldRaiseValuesBy10() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.tick();

		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int boredomLevel = underTest.getBoredomLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		int wasteLevel = underTest.getWasteLevel();

		Assert.assertEquals(70, hungerLevel);
		Assert.assertEquals(70, thirstLevel);
		Assert.assertEquals(70, boredomLevel);
		Assert.assertEquals(70, tirednessLevel);
		Assert.assertEquals(70, wasteLevel);
	}

}
