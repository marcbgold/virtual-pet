package virtual.pet;

import java.util.Random;

public class VirtualPet {

	private String name;
	private int hungerLevel;
	private int thirstLevel;
	private int boredomLevel;
	private int tirednessLevel;
	private int wasteLevel;

	private int foodBowlLevel;
	private int foodType;
	int dislikedFoodType;
	int hatedFoodType;
	int minFoodType = 1;
	int maxFoodType = 4;
	Random randomGen = new Random();

	private int waterBowlLevel;
	private int litterBoxLevel;

	boolean hasUsedFloorBefore;
	int hasDestroyedYourStuffCount;
	int hasSleptOnFloorCount;

	public VirtualPet() {
		this("Widget", 20, 20, 50, 10, 0);
	}

	public VirtualPet(String name) {
		this(name, 20, 20, 50, 10, 0);
	}

	public VirtualPet(int waste, int litterBoxLevel) { // this is only for testing wasteLevel 100 + litterBoxLevel 3 flag trigger
		wasteLevel = waste;
		this.litterBoxLevel = litterBoxLevel;
	}

	public VirtualPet(int hunger, int dislikedFoodType, int hatedFoodType) { // this is only for testing food preference behavior
		hungerLevel = hunger;
		this.dislikedFoodType = dislikedFoodType;
		this.hatedFoodType = hatedFoodType;
	}

	public VirtualPet(String name, int hunger, int thirst, int boredom, int tiredness, int waste) {
		this.name = name;
		hungerLevel = hunger;
		thirstLevel = thirst;
		boredomLevel = boredom;
		tirednessLevel = tiredness;
		wasteLevel = waste;

		dislikedFoodType = randomGen.nextInt((maxFoodType - minFoodType) + 1) + minFoodType;
		do {
			hatedFoodType = randomGen.nextInt((maxFoodType - minFoodType) + 1) + minFoodType;
		} while (dislikedFoodType == hatedFoodType);

		hasUsedFloorBefore = false;
	}

	public String getName() {
		return name;
	}

	public int getHungerLevel() {
		return hungerLevel;
	}

	public int getThirstLevel() {
		return thirstLevel;
	}

	public int getBoredomLevel() {
		return boredomLevel;
	}

	public int getTirednessLevel() {
		return tirednessLevel;
	}

	public int getWasteLevel() {
		return wasteLevel;
	}

	public int getFoodBowlLevel() {
		return foodBowlLevel;
	}

	public int getFoodType() {
		return foodType;
	}

	public int getWaterBowlLevel() {
		return waterBowlLevel;
	}

	public int getLitterBoxLevel() {
		return litterBoxLevel;
	}

	public boolean getHasUsedFloorBefore() {
		return hasUsedFloorBefore;
	}

	public int getHasSleptOnFloorCount() {
		return hasSleptOnFloorCount;
	}

	public int getHasDestroyedYourStuffCount() {
		return hasDestroyedYourStuffCount;
	}

	public int getDislikedFoodType() {
		return dislikedFoodType;
	}

	public int getHatedFoodType() {
		return hatedFoodType;
	}

	public void eat() {
		hungerLevel -= 40;
		thirstLevel += 10;
		tirednessLevel += 10;
		wasteLevel += 20;
		foodBowlLevel--;

		checkForValuesOver100();
	}

	public void drink() {
		thirstLevel -= 40;
		wasteLevel += 20;
		waterBowlLevel--;

		checkForValuesOver100();
	}

	public void play() {
		if (boredomLevel == 100)
			hasDestroyedYourStuffCount++;

		boredomLevel -= 40;
		hungerLevel += 10;
		thirstLevel += 10;
		tirednessLevel += 30;

		checkForValuesOver100();
	}

	public void sleep() {
		hungerLevel += 20;
		thirstLevel += 20;
		if (tirednessLevel == 100)
			hasSleptOnFloorCount++;
		tirednessLevel -= tirednessLevel;

		checkForValuesOver100();
	}

	public void useBathroom() {
		wasteLevel -= wasteLevel;

		if (litterBoxLevel == 3)
			hasUsedFloorBefore = true;
		else
			litterBoxLevel++;
	}

	public void putOutFood(int foodType) {
		foodBowlLevel = 2;
		this.foodType = foodType;
	}

	public void putOutWater() {
		waterBowlLevel = 2;
	}

	public void scoopLitterBox() {
		litterBoxLevel = 0;
	}

	public void tick() {
		hungerLevel += 10;
		thirstLevel += 10;
		boredomLevel += 10;
		tirednessLevel += 10;
		wasteLevel += 10;

		checkForValuesOver100();
	}

	public void takeCareOfSelf() {
		if (foodBowlLevel > 0 && foodType != hatedFoodType && hungerLevel >= 50) {
			if (foodType != dislikedFoodType)
				eat();
			else if (hungerLevel >= 70)
				eat();
		}

		if (thirstLevel >= 50 && waterBowlLevel > 0) {
			drink();
		}

		if (wasteLevel >= 70 && litterBoxLevel < 3) {
			useBathroom();
		}
	}

	public void checkForValuesOver100() {
		if (hungerLevel > 100)
			hungerLevel = 100;

		if (thirstLevel > 100)
			thirstLevel = 100;

		if (boredomLevel > 100)
			boredomLevel = 100;

		if (tirednessLevel > 100)
			tirednessLevel = 100;

		if (wasteLevel > 100)
			wasteLevel = 100;
	}

}
