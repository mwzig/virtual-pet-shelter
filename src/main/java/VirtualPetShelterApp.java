import java.util.Collection;
import java.util.Map.Entry;

public class VirtualPetShelterApp {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VirtualPetShelter myShelter = new VirtualPetShelter();
		myShelter.addPet(new VirtualPet("Daisy", "the fluffy poodle"));
		myShelter.addPet(new VirtualPet("Spot", "has lots of spots!"));
		
		displayPetStatus(myShelter);
	}

	public static void displayPetStatus(VirtualPetShelter myShelter) {
		
		String needsToGoOut = "(Not Yet)";
		String status = "";
		
		System.out.println("This is the status of your pets:\n");
		System.out.println("Name           |Hunger  |Thirst  |Activity Level |Needs to Go Out");
		System.out.println("---------------|--------|--------|---------------|---------------|");
			
		Collection<VirtualPet> shelterPets = myShelter.getPets(); 
		for (VirtualPet shelterPet : shelterPets) {
			if (shelterPet.getNeedsToPee() || shelterPet.getNeedsToPoop()) {
				needsToGoOut = "Yes!";
			} else {
				needsToGoOut = "(Not Yet)";
			}
			//At least five-wide, left-justified	printf("'%-5d'", 10);
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
				
			/*
			System.out.printf(format string syntax, 
					 shelterPet.getName(),  
					 shelterPet.getHungerLevel(),  
					 shelterPet.getThirstLevel(), 
					 shelterPet.getActivityLevel(), 
					 needsToGoOut;
					 */ 
			
		}
	}
}
