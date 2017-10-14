import java.util.Collection;
import java.util.Scanner;

public class VirtualPetShelterApp {

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
				System.out.println("Wonderful! You'd like to clean a cage. Please choose which Pet's cage:\n");
				handlePetActivity(myShelter, "clean");
				break;
			case "7":
				System.out.println("Terrific!  You'd like to adopt a pet.  Please choose one: \n");
				handlePetAdoption(myShelter);
				break;
			case "8":
				System.out.println("Welcome! You'd like to admit a pet. We can help with that.\n");
				handlePetAdmission(myShelter);
				break;
			case "9":
				System.out.println("No Problem! You want to check on a specific pet.  Please choose one:  9\n");
				handlePetCheck(myShelter);
				break;
			case "10":
				System.out.println("You loved our pizza!\n\n");
				break;
			case "11":
				System.out.println("Thanks for playing the Virtual Pet Shelter game!");
				break;
			}
			myShelter.tick();

		} while (!userOption.equals("11"));
		input.close();

	}

	public static void displayPetStatus(VirtualPetShelter myShelter) {

		String needsToGoOut = "(Not Yet)";
		String cageStatus = "Clean";

		System.out.println("This is the status of your pets:\n");
		System.out.println("Name           |Hunger  |Thirst  |Activity Level |Needs to Go Out|Cage");
		System.out.println("---------------|--------|--------|---------------|---------------|----------");

		Collection<VirtualPet> shelterPets = myShelter.getAllPets();
		for (VirtualPet shelterPet : shelterPets) {
			if (shelterPet.getNeedsToPee() || shelterPet.getNeedsToPoop()) {
				needsToGoOut = "Yes!";
			} else {
				needsToGoOut = "(Not Yet)";
			}
			if (shelterPet.getMadeAMess()) {
				cageStatus = "Dirty";
			} else {
				cageStatus = "Clean";
			}
			System.out.printf("%-15s", shelterPet.getName());
			System.out.print("|");
			System.out.printf("%-8d", shelterPet.getHungerLevel());
			System.out.print("|");
			System.out.printf("%-8d", shelterPet.getThirstLevel());
			System.out.print("|");
			System.out.printf("%-15d", shelterPet.getActivityLevel());
			System.out.print("|");
			System.out.printf("%-15s", needsToGoOut);
			System.out.print("|");
			System.out.printf("%-10s", cageStatus);
			System.out.println();

		} // end for loop

	} // end displayPetStatus()

	public static void displayMainMenu() {

		System.out.println("\nWhat would you like to do next?\n");
		System.out.println("\t1. Feed the pets");
		System.out.println("\t2. Water the pets");
		System.out.println("\t3. Walk a pet");
		System.out.println("\t4. Play with a pet");
		System.out.println("\t5. Let a pet go outside");
		System.out.println("\t6. Clean a cage");
		System.out.println("\t7. Adopt a pet");
		System.out.println("\t8. Admit a pet");
		System.out.println("\t9. Check on a specific pet");
		System.out.println("\t10. Eat pizza");
		System.out.println("\t11. Quit");
	}

	public static void displayPetNamesAndDescriptions(VirtualPetShelter myShelter) {

		String name = "";
		Collection<VirtualPet> shelterPets = myShelter.getAllPets();
		for (VirtualPet shelterPet : shelterPets) {
			name = "[" + shelterPet.getName() + "]";
			System.out.printf("%-15s", name);
			System.out.printf("%-25s", shelterPet.getDescription());
			System.out.println();
		}
	}

	public static void handlePetActivity(VirtualPetShelter myShelter, String activity) {

		displayPetNamesAndDescriptions(myShelter);
		Scanner input = new Scanner(System.in);
		String petName = input.nextLine();
		// the user may have typed an invalid name, if so give them a message and
		// go back to the menu
		VirtualPet testPet = myShelter.getPet(petName);
		if (testPet == null) {
			System.out.println("Sorry, the name you typed does not match one of our pets.");
		} else if (activity.equals("walk")) {
			myShelter.walkAPet(petName);
			System.out.println("Thanks for walking " + petName + "!\n\n");
		} else if (activity.equals("play")) {
			myShelter.playWithAPet(petName);
			System.out.println("Thanks for playing with " + petName + "!\n\n");
		} else if (activity.equals("go-out")) {
			myShelter.takeAPetOutside(petName);
			System.out.println("Thanks for taking " + petName + " outside!\n\n");
		} else if (activity.equals("clean")) {
			myShelter.cleanCage(petName);
			System.out.println("Thanks for cleaning the cage for " + petName + "!\n\n");
		}

	}

	public static void handlePetAdoption(VirtualPetShelter myShelter) {

		displayPetNamesAndDescriptions(myShelter);
		Scanner input = new Scanner(System.in);
		String petName = input.nextLine();
		// the user may have typed an invalid name, if so give them a message and
		// go back to the menu
		VirtualPet testPet = myShelter.getPet(petName);
		if (testPet == null) {
			System.out.println("Sorry, the name you typed does not match one of our pets.");
		} else {
			myShelter.releasePet(petName);
			System.out.println(petName + " is going to a great home!\n\n");
		}

	}

	public static void handlePetAdmission(VirtualPetShelter myShelter) {

		Scanner input = new Scanner(System.in);
		System.out.println("What is your pet's name?");
		String petName = input.nextLine();
		System.out.println("Please provide a brief description of your pet:");
		String petDescription = input.nextLine();
		if (petName.isEmpty() || petDescription.isEmpty()) {
			System.out.println("Sorry, you must enter both a pet name and a description.");
		} else {
			myShelter.addPet(new VirtualPet(petName, petDescription));
			System.out.println("Don't worry, we will find a great home for " + petName + "!\n\n");
		}

	}

	public static void handlePetCheck(VirtualPetShelter myShelter) {

		displayPetNamesAndDescriptions(myShelter);
		Scanner input = new Scanner(System.in);
		String petName = input.nextLine();
		// the user may have typed an invalid name, if so give them a message and
		// go back to the menu
		VirtualPet petToCheck = myShelter.getPet(petName);
		if (petToCheck == null) {
			System.out.println("Sorry, the name you typed does not match one of our pets.");
		} else {
			System.out.println(petToCheck.getStatus());
			System.out.println("Thanks for checking on " + petName + "!\n\n");
		}

	}

}
