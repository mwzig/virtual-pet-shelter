import java.util.Collection;

public class testMapStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VirtualPetShelter myShelter = new VirtualPetShelter();
		myShelter.addPet(new VirtualPet("Daisy", "the fluffy poodle"));
		myShelter.addPet(new VirtualPet("Spot", "has lots of spots!"));
		myShelter.addPet(new VirtualPet("Rufus", "loves to play ball", 5, 5, 5, false, false));
		myShelter.addPet(new VirtualPet("Rover", "watch out, he bites", 15, 15, 15));
		
		Collection<VirtualPet> myPetCollection = myShelter.getAllPets();
		System.out.println(myPetCollection);
}

}
