import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	private Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>(0);
	
	public void addPet(VirtualPet newPet) {
		pets.put(newPet.getName(), newPet);
	}
	
	public VirtualPet releasePet(String name) {
		return pets.remove(name);
	}
	
	public int getNumberOfPets() {
		return pets.size();
	}
	
}
