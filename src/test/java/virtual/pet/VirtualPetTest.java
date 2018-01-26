package virtual.pet;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetTest {

	@Test
	public void shouldHaveStartingHungerLevel() {
		VirtualPet underTest = new VirtualPet();
		int hungerLevel = underTest.getHungerLevel();
		Assert.assertEquals(20, hungerLevel);
	}

	@Test
	public void shouldHaveStartingThirstLevel() {
		VirtualPet underTest = new VirtualPet();
		int thirstLevel = underTest.getThirstLevel();
		Assert.assertEquals(20, thirstLevel);
	}

	@Test
	public void shouldHaveStartingBoredomLevel() {
		VirtualPet underTest = new VirtualPet();
		int boredomLevel = underTest.getBoredomLevel();
		Assert.assertEquals(50, boredomLevel);
	}

	@Test
	public void shouldHaveStartingTirednessLevel() {
		VirtualPet underTest = new VirtualPet();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(10, tirednessLevel);
	}

	@Test
	public void shouldHaveStartingWasteLevel() {
		VirtualPet underTest = new VirtualPet();
		int wasteLevel = underTest.getWasteLevel();
		Assert.assertEquals(0, wasteLevel);
	}

	@Test
	public void shouldConstructNewPetUsingConstructorParameters() {
		VirtualPet underTest = new VirtualPet(60, 60, 60, 60, 60);
		int hungerLevel = underTest.getHungerLevel();
		int thirstLevel = underTest.getThirstLevel();
		int boredomLevel = underTest.getBoredomLevel();
		int tirednessLevel = underTest.getTirednessLevel();
		Assert.assertEquals(60, hungerLevel);
		Assert.assertEquals(60, thirstLevel);
		Assert.assertEquals(60, boredomLevel);
		Assert.assertEquals(60, tirednessLevel);
	}

}
