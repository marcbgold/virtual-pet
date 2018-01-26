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

}
