package virtual.pet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldHaveDefaultName() {
		VirtualPet underTest = new VirtualPet();
		String name = underTest.getName();
		Assert.assertEquals("Widget", name);
	}

	@Test
	public void shouldHaveDefaultHungerLevel() {
		VirtualPet underTest = new VirtualPet();
		int hungerLevel = underTest.getHungerLevel();
		Assert.assertEquals(20, hungerLevel);
	}

	@Test
	public void shouldHaveDefaultThirstLevel() {
		VirtualPet underTest = new VirtualPet();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(20, thirstLevel);
	}

	@Test
	public void shouldHaveDefaultBoredomLevel() {
		VirtualPet underTest = new VirtualPet();
		int boredomLevel = underTest.getBoredomLevel();
		Assert.assertEquals(50, boredomLevel);
	}

	@Test
	public void shouldHaveDefaultTirednessLevel() {
		VirtualPet underTest = new VirtualPet();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(10, tirednessLevel);
	}

	@Test
	public void shouldHaveDefaultWasteLevel() {
		VirtualPet underTest = new VirtualPet();
		int wasteLevel = underTest.getWasteLevel();
		Assert.assertEquals(0, wasteLevel);
	}

	@Test
	public void shouldConstructNewPetUsingConstructorParameters() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		String name = underTest.getName();
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int boredomLevel = underTest.getBoredomLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals("Test", name);
		Assert.assertEquals(60, hungerLevel);
		Assert.assertEquals(60, thirstLevel);
		Assert.assertEquals(60, boredomLevel);
		Assert.assertEquals(60, tirednessLevel);
	}

	@Test
	public void shouldEatAndReduceHungerLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.eat();
		int hungerLevel = underTest.getHungerLevel();
		Assert.assertEquals(40, hungerLevel);
	}

	@Test
	public void shouldDrinkAndReduceThirstLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.drink();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(20, thirstLevel);
	}

	@Test
	public void shouldPlayAndReduceBoredomLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();
		int boredomLevel = underTest.getBoredomLevel();
		Assert.assertEquals(20, boredomLevel);
	}

	@Test
	public void shouldSleepAndReduceTirednessLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.sleep();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(10, tirednessLevel);
	}

	@Test
	public void shouldUseBathroomAndReduceWasteLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.useBathroom();
		int wasteLevel = underTest.getWasteLevel();
		Assert.assertEquals(20, wasteLevel);
	}

	@Test
	public void shouldEatAndAlsoIncreaseThirstLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.eat();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(70, thirstLevel);
	}

	@Test
	public void shouldEatAndAlsoReduceBoredomLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.eat();
		int boredomLevel = underTest.getBoredomLevel();
		Assert.assertEquals(55, boredomLevel);
	}

	@Test
	public void shouldEatAndAlsoIncreaseTirednessLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.eat();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(70, tirednessLevel);
	}

	@Test
	public void shouldEatAndAlsoIncreaseWasteLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.eat();
		int wasteLevel = underTest.getWasteLevel();
		Assert.assertEquals(80, wasteLevel);
	}

	@Test
	public void shouldPlayAndAlsoIncreaseHungerLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();
		int hungerLevel = underTest.getHungerLevel();
		Assert.assertEquals(70, hungerLevel);
	}

	@Test
	public void shouldPlayAndAlsoIncreaseThirstLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(70, thirstLevel);
	}

	@Test
	public void shouldPlayAndAlsoIncreaseTirednessLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.play();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(90, tirednessLevel);
	}

	@Test
	public void shouldSleepAndAlsoIncreaseHungerLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.sleep();
		int hungerLevel = underTest.getHungerLevel();
		Assert.assertEquals(80, hungerLevel);
	}

	@Test
	public void shouldSleepAndAlsoIncreaseThirstLevel() {
		VirtualPet underTest = new VirtualPet("Test", 60, 60, 60, 60, 60);
		underTest.sleep();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(80, thirstLevel);
	}

}
