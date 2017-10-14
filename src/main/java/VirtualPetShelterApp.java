import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

	add to lower case where necessary
	think about cage status on constructor
	
	
	public static void main(String[] args) {

		VirtualPetShelter myShelter = new VirtualPetShelter();
		myShelter.addPet(new VirtualPet("Daisy", "the fluffy poodle"));
		myShelter.addPet(new VirtualPet("Spot", "has lots of spots!"));

		displayWelcomeMessage();
		handleVolunteerActions(myShelter);
	}

	public static void displayWelcomeMessage() {
		System.out.println("Welcome to Hound Dogz Virtual Pet Shelter!");
		System.out.println("Thank you for volunteering! We provide free pizza for helping!\n");
	}

	public static void displayPetStatus(VirtualPetShelter myShelter) {

		String needsToGoOut = "(Not Yet)";

		System.out.println("This is the status of your pets:\n");
		System.out.println("Name           |Hunger  |Thirst  |Activity Level |Needs to Go Out");
		System.out.println("---------------|--------|--------|---------------|---------------");

		Collection<VirtualPet> shelterPets = myShelter.getPets();
		for (VirtualPet shelterPet : shelterPets) {
			if (shelterPet.getNeedsToPee() || shelterPet.getNeedsToPoop()) {
				needsToGoOut = "Yes!";
			} else {
				needsToGoOut = "(Not Yet)";
			}
			// At least five-wide, left-justified printf("'%-5d'", 10);
			System.out.printf("%-15s", shelterPet.getName());
			System.out.print("|");
			System.out.printf("%-8d", shelterPet.getHungerLevel());
			System.out.print("|");
			System.out.printf("%-8d", shelterPet.getThirstLevel());
			System.out.print("|");
			System.out.printf("%-15d", shelterPet.getActivityLevel());
			System.out.print("|");
			System.out.printf("%-15s", needsToGoOut);
			System.out.println();

		} // end for loop

	} // end displayPetStatus()

	public static void handleVolunteerActions(VirtualPetShelter myShelter) {

		Scanner input = new Scanner(System.in);
		String userOption = "";

		do {
			if (myShelter.getNumberOfPets() == 0) {
				System.out.println("Good news! All pets have been adopted! Please come back soon.");
				break;
			}
			displayPetStatus(myShelter);
			displayMainMenu();
			userOption = input.nextLine();
			switch (userOption) {
			case "1":
				myShelter.feedPets();
				System.out.println("You fed the pets! Thank you!");
				break;
			case "2":
				myShelter.waterPets();
				System.out.println("You watered the pets! Thank you!");
				break;
			case "3":
				System.out.println("Great! You'd like to take a pet for a walk. Please choose one:\n");
				handlePetActivity(myShelter, "walk");
				break;
			case "4":
				System.out.println("Fantastic! You'd like to play with a pet. Please choose one:\n");
				handlePetActivity(myShelter, "play");
				break;
			case "5":
				System.out.println("Super! You'd like to take a pet outside. Please choose one:\n");
				handlePetActivity(myShelter, "go-out");
				break;
			case "6":
				System.out.println("Terrific!  You'd like to adopt a pet.  Please choose one: \n");
				handlePetAdoption(myShelter);
				break;
			case "7":
				break;
			case "8":
				System.out.println("Thanks for playing!");
				break;
			}
			myShelter.tick();

		} while (!userOption.equals("8"));

	}

	public static void handlePetActivity(VirtualPetShelter myShelter, String activity) {

		displayPetNamesAndDescriptions(myShelter);
		Scanner input = new Scanner(System.in);
		String petName = input.nextLine();
		if (activity.equals("walk")) {
			myShelter.walkAPet(petName);
			System.out.println("Thanks for walking " + petName + "!\n\n");
		} else if (activity.equals("play")) {
			myShelter.playWithAPet(petName);
			System.out.println("Thanks for playing with " + petName + "!\n\n");
		} else if (activity.equals("go-out")) {
			myShelter.takeAPetOutside(petName);
			System.out.println("Thanks for taking " + petName + "outside!\n\n");

		}
		// input.close();
	}

	public static void displayPetNamesAndDescriptions(VirtualPetShelter myShelter) {
		String name = "";
		Collection<VirtualPet> shelterPets = myShelter.getPets();
		for (VirtualPet shelterPet : shelterPets) {
			name = "[" + shelterPet.getName() + "]";
			System.out.printf("%-15s", name);
			System.out.printf("%-25s", shelterPet.getDescription());
			System.out.println();
		}

	}

	public static void handlePetAdoption(VirtualPetShelter myShelter) {

		displayPetNamesAndDescriptions(myShelter);
		Scanner input = new Scanner(System.in);
		String petName = input.nextLine();
		myShelter.releasePet(petName);
		System.out.println(petName + " is going to a great home!\n\n");
	}

	public static void displayMainMenu() {

		System.out.println("\nWhat would you like to do next?\n");
		System.out.println("\t1. Feed the pets");
		System.out.println("\t2. Water the pets");
		System.out.println("\t3. Walk a pet");
		System.out.println("\t4. Play with a pet");
		System.out.println("\t5. Let a pet go outside");
		System.out.println("\t6. Adopt a pet");
		System.out.println("\t7. Admit a pet");
		System.out.println("\t8. Quit");

	}

}
