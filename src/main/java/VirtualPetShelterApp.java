import java.util.Collection;
import java.util.Map.Entry;
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

	public static void displayPetStatus(VirtualPetShelter myShelter) {

		String needsToGoOut = "(Not Yet)";
		String status = "";

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
			System.out.printf("%-15s", "Hello");
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
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				System.out.println("Thanks for playing!");
				break;
			}
			
		} while (!userOption.equals("8"));
		
		
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
