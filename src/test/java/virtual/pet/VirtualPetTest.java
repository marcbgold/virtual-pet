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
		int foodBowlLevel = underTest.getFoodBowlLevel();
		int waterBowlLevel = underTest.getWaterBowlLevel();
		int litterBoxLevel = underTest.getLitterBoxLevel();

		Assert.assertEquals("Test", name);
		Assert.assertEquals(60, hungerLevel);
		Assert.assertEquals(60, thirstLevel);
		Assert.assertEquals(60, boredomLevel);
		Assert.assertEquals(60, tirednessLevel);
		Assert.assertEquals(0, foodBowlLevel);
		Assert.assertEquals(0, waterBowlLevel);
		Assert.assertEquals(0, litterBoxLevel);
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

		Assert.assertEquals(20, thirstLevel);
		Assert.assertEquals(80, wasteLevel);
	}

	@Test
	public void playShouldRaiseOrLowerLevels() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();

		int boredomLevel = underTest.getBoredomLevel();
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(20, boredomLevel);
		Assert.assertEquals(70, hungerLevel);
		Assert.assertEquals(70, thirstLevel);
	}

	@Test
	public void sleepShouldRaiseOrLowerLevels() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.sleep();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(0, tirednessLevel);
	}

	@Test
	public void useBathroomShouldLowerWasteLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.useBathroom();
		int wasteLevel = underTest.getWasteLevel();
		Assert.assertEquals(0, wasteLevel);
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
	public void playShouldAlsoIncreaseHungerLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();

	}

	@Test
	public void playShouldAlsoIncreaseThirstLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();

	}

	@Test
	public void playShouldAlsoIncreaseTirednessLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(90, tirednessLevel);
	}

	@Test
	public void sleepShouldAlsoIncreaseHungerLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.sleep();
		int hungerLevel = underTest.getHungerLevel();
		Assert.assertEquals(80, hungerLevel);
	}

	@Test
	public void sleepShouldAlsoIncreaseThirstLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.sleep();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(80, thirstLevel);
	}

	@Test
	public void eatShouldNotRaiseThristTirednessOrWasteAbove100() {
		VirtualPet underTest = new VirtualPet("Test", 99, 99, 99, 99, 99);
		underTest.eat();
		int thirstLevel = underTest.getThirstLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		int wasteLevel = underTest.getWasteLevel();
		Assert.assertEquals(100, thirstLevel);
		Assert.assertEquals(100, tirednessLevel);
		Assert.assertEquals(100, wasteLevel);
	}

	@Test
	public void drinkShouldNotRaiseWasteAbove100() {
		VirtualPet underTest = new VirtualPet("Test", 99, 99, 99, 99, 99);
		underTest.drink();
		int wasteLevel = underTest.getWasteLevel();
		Assert.assertEquals(100, wasteLevel);
	}

	@Test
	public void playShouldNotRaiseHungerThirstOrTirednessAbove100() {
		VirtualPet underTest = new VirtualPet("Test", 99, 99, 99, 99, 99);
		underTest.play();
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(100, hungerLevel);
		Assert.assertEquals(100, thirstLevel);
		Assert.assertEquals(100, tirednessLevel);
	}

	@Test
	public void sleepShouldNotRaiseHungerOrThirstAbove100() {
		VirtualPet underTest = new VirtualPet("Test", 99, 99, 99, 99, 99);
		underTest.sleep();
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(100, hungerLevel);
		Assert.assertEquals(100, thirstLevel);
	}

	@Test
	public void tickShouldRaiseAllValuesBy10() {
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

	@Test
	public void tickShouldNotRaiseValuesAbove100() {
		VirtualPet underTest = new VirtualPet("Test", 99, 99, 99, 99, 99);
		underTest.tick();
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

}
