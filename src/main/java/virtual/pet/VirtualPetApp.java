package virtual.pet;

import java.util.Scanner;

public class VirtualPetApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Congratulations!  You just acquired a new virtual cat.");
		System.out.println("Go ahead and give your new cat a name.");
		System.out.println("If you can't think of a name, just hit enter and I'll give them one for you.");
		String nameInput = input.nextLine().trim();

		VirtualPet myPet;
		if (nameInput.equals(""))
			myPet = new VirtualPet();
		else
			myPet = new VirtualPet(nameInput);

		String choice = "";
		String name = myPet.getName();

		// System.out.println("disliked = " + myPet.getDislikedFoodType());
		// System.out.println("hated = " + myPet.getHatedFoodType());

		do {
			System.out.println();
			System.out.println("Owner's Menu for " + name + " the Cat");
			System.out.println();
			System.out.println("Hunger: " + myPet.getHungerLevel());
			System.out.println("Thirst: " + myPet.getThirstLevel());
			System.out.println("Boredom: " + myPet.getBoredomLevel());
			System.out.println("Tiredness: " + myPet.getTirednessLevel());
			System.out.println("\"Waste\": " + myPet.getWasteLevel());
			System.out.println();
			System.out.println("Food Bowl Level: " + myPet.getFoodBowlLevel());
			if (myPet.getFoodBowlLevel() > 0) {
				System.out.print("Food Type: ");
				if (myPet.getFoodType() == 1)
					System.out.println("Trader Moe's dry food");
				else if (myPet.getFoodType() == 2)
					System.out.println("Fancier Feast premium wet food");
				else if (myPet.getFoodType() == 3)
					System.out.println("Raw meat");
				else
					System.out.println("Table scraps");
			}
			System.out.println("Water Bowl Level: " + myPet.getWaterBowlLevel());
			System.out.println("Litter Box Level: " + myPet.getLitterBoxLevel());

			System.out.println();
			System.out.println("What do you want to do?");
			System.out.println();
			System.out.println("1. Play with " + name);
			System.out.println("2. Put out food");
			System.out.println("3. Put out water");
			System.out.println("4. Scoop out litter box");
			System.out.println("5. Put " + name + " to bed");
			System.out.println("6. Do nothing");
			System.out.println("7. Quit");
			choice = input.next().trim();
			System.out.println();

			switch (choice) {
			case "1":
				if (myPet.getBoredomLevel() >= 40) {
					myPet.play();
					System.out.println("You played with " + name + ".  They look like they had fun.  Now let's see what they want to do next.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					break;
				} else {
					System.out.println(name + " isn't bored enough to want to play right now.  Try again later.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					continue;
				}
			case "2":
				do {
					System.out.println("What kind of food do you want to put out?");
					System.out.println("Depending upon the kind of food, " + name + " may or may not eat it.");
					System.out.println();
					System.out.println("1. Trader Moe's dry food");
					System.out.println("2. Fancier Feast premium wet food");
					System.out.println("3. Raw meat");
					System.out.println("4. Table scraps");
					System.out.println("5. Never mind, go back to the main menu");
					choice = input.next().trim();
					System.out.println();

					switch (choice) {
					case "1":
					case "2":
					case "3":
					case "4":
					case "5":
						break;
					default:
						continue;
					}
					break;
				} while (true);

				if (choice.equals("5"))
					continue;

				myPet.putOutFood(Integer.parseInt(choice));
				System.out.println("You refilled the food bowl.  Now " + name + " will have plenty to eat.");
				System.out.println("Press any key and then hit enter to continue.");
				choice = input.next();
				break;
			case "3":
				if (myPet.getWaterBowlLevel() < 2) {
					myPet.putOutWater();
					System.out.println("You refilled the water bowl.  Now " + name + " will have plenty to drink.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					break;
				} else {
					System.out.println("The water bowl's already full.  No need to put out more water right now.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					continue;
				}
			case "4":
				if (myPet.getLitterBoxLevel() > 0) {
					myPet.scoopLitterBox();
					System.out.println("You scooped out the litter box.  Gotta exercise proper hygiene.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					break;
				} else {
					System.out.println("The litter box is already clean.  No need to scoop it out right now.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					continue;
				}
			case "5":
				if (myPet.getTirednessLevel() >= 70) {
					myPet.sleep();
					System.out.println("You put " + name + " in their bed.  They were pretty tired, so they went straight to sleep.");
					System.out.println("Let's come back later when they're awake again.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					break;
				} else {
					System.out.println(name + " isn't tired enough to want to sleep right now.  Let's try doing something else.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
					continue;
				}
			case "6":
				System.out.println("OK, I guess you can just stare at " + name + " if you feel like it.");
				System.out.println("I'm sure something'll happen if you wait long enough.");
				System.out.println("Press any key and then hit enter to continue.");
				choice = input.next();
				break;
			case "7":
				break;
			default:
				continue;
			}

			if (!choice.equals("7")) {
				System.out.println();
				myPet.tick();
				myPet.takeCareOfSelf();

				if (myPet.getHungerLevel() == 100 || myPet.getThirstLevel() == 100) {
					System.out.print("Well, you blew it. " + name + " got so ");
					if (myPet.getHungerLevel() == 100)
						System.out.print("hungry from you not feeding them");
					else
						System.out.print("thirsty from you not giving them water");
					System.out.println(" that they ran away.");
					System.out.println("Go study how to raise a cat properly and come back later for a new one.");
					System.exit(0);
				}

				if (myPet.getWasteLevel() == 100) {
					if (myPet.getHasUsedFloorBefore()) {
						System.out.println("OK, seriously.  Why do you never scoop out the litter box on time?");
						System.out.println(name + " got so annoyed at you that rather than use the floor again, they just ran away.");
						System.out.println("Go study how to raise a cat properly and come back later for a new one.");
						System.exit(0);
					}
					myPet.useBathroom();
					System.out.println("You didn't empty the litter box often enough, so " + name + " decided to use the floor, instead.");
					System.out.println("That's gross, and I really can't blame them.  I wouldn't use the toilet, either, if you never flushed it.");
					System.out.println("Go clean up the mess, and then try not to do this again. " + name + " may not put up with it a second time.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
				}

				if (myPet.getTirednessLevel() == 100) {
					if (myPet.getHasSleptOnFloorCount() == 2) {
						System.out.println("Aaaaand there they go.  I told you not to keep letting " + name + " sleep in the middle of the floor.");
						System.out.println("You're lucky they just ran away.  I'd claw your face off if you stepped on my tail like that.");
						System.out.println("Go study how to raise a cat properly and come back later for a new one.");
						System.exit(0);
					}
					myPet.sleep();
					System.out.println(name + " got so tired from you not putting them to bed that they just fell asleep in the middle of the floor.");
					System.out.println("If you don't want to accidentally step on them, you should probably put them to bed sooner next time.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
				}

				if (myPet.getBoredomLevel() == 100) {
					if (myPet.getHasDestroyedYourStuffCount() == 2) {
						System.out.println("Man, you really don't care about " + name + " all that much, do you?");
						System.out.println("They got so sick of you never playing with them that they ran away. Even shredding your socks got old.");
						System.out.println("Go study how to raise a cat properly and come back later for a new one.");
						System.exit(0);
					}
					myPet.play();
					System.out.println(name + " got so bored from you ignoring them that they decided to go entertain themselves, instead.");
					System.out.println("Naturally, that means destroying your stuff.  You probably shouldn't let that happen again.");
					System.out.println("Press any key and then hit enter to continue.");
					choice = input.next();
				}

			}

		} while (!choice.equals("7"));

		System.out.println("Bye! Come back later to play with a new cat.");
		input.close();

	}

}
