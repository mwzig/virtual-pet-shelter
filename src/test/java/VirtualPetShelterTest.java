
import static org.junit.Assert.*;
import org.junit.Test;

public class VirtualPetShelterTest {

	@Test
	public void shouldBeAbleToCreateVirtualPetWithNameAndDescOnly() {
		VirtualPet underTest = new VirtualPet("Fido", "the great");
		String check = underTest.getName();
		assertEquals("Fido", check);
		check = underTest.getDescription();
		assertEquals("the great", check);
		int check2 = underTest.getActivityLevel();
		assertEquals(10, check2);
		check2 = underTest.getHungerLevel();
		assertEquals(10, check2);
		check2 = underTest.getThirstLevel();
		assertEquals(10, check2);
		boolean check3 = underTest.getNeedsToPee();
		assertEquals(false, check3);
		check3 = underTest.getNeedsToPoop();
		assertEquals(false, check3);
		check3 = underTest.getMadeAMess();
		assertEquals(false, check3);
	}

	@Test
	public void shouldBeAbleToCreateAVirtualPetShelterMap() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 5, 5, 5));
		int check = underTest.getNumberOfPets();
		assertEquals(2, check);
	}

	@Test
	public void testReleaseNonExistingPetFails() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocius", 5, 5, 5));
		VirtualPet check = underTest.releasePet("feefee");
		assertNull(check);
	}

	@Test
	public void testReleaseExistingPetSucceeds() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		VirtualPet testPet = new VirtualPet("fido", "the ferocius", 5, 5, 5);
		underTest.addPet(testPet);
		underTest.addPet(new VirtualPet("feefee", "the furious", 5, 5, 5));
		VirtualPet check = underTest.releasePet("fido");
		// we are comparing the object we create to the object returned on the release
		// they should be the same because removing something from a HashMap returns
		// the object if it exists.
		assertEquals(testPet, check);
		// another check to do is to check the count. Since we added 2 and removed 1,
		// the count should be 1
		int check2 = underTest.getNumberOfPets();
		assertEquals(1, check2);
	}

	@Test
	public void testGetNumberPetsReturnsCorrectNbr() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 5, 5, 5));
		underTest.addPet(new VirtualPet("spot", "the spotty", 5, 5, 5));
		int check = underTest.getNumberOfPets();
		assertEquals(3, check);
		underTest.releasePet("fido");
		check = underTest.getNumberOfPets();
		assertEquals(2, check);
	}

	@Test
	public void testThatFeedPetsChangesHungerLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 5, 5));
		underTest.feedPets();
		VirtualPet pet1 = underTest.getPet("fido");
		int check = pet1.getHungerLevel();
		assertEquals(0, check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getHungerLevel();
		assertEquals(0, check);
	}

	// Verify that after constructing, the pet does not need
	// to poop. After feeding, the pet should need to poop.
	@Test
	public void testThatFeedPetsCausesNeedToPoop() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 5, 5));
		VirtualPet pet1 = underTest.getPet("fido");
		boolean check = pet1.getNeedsToPoop();
		assertFalse(check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPoop();
		assertFalse(check);
		underTest.feedPets();
		pet1 = underTest.getPet("fido");
		check = pet1.getNeedsToPoop();
		assertTrue(check);
		pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPoop();
		assertTrue(check);
	}

	@Test
	public void testThatWaterPetsChangesThirstLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 10, 5));
		underTest.waterPets();
		VirtualPet pet1 = underTest.getPet("fido");
		int check = pet1.getThirstLevel();
		assertEquals(0, check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getThirstLevel();
		assertEquals(0, check);
	}

	@Test
	public void testThatWaterPetsCausesNeedToPee() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 5, 5));
		VirtualPet pet1 = underTest.getPet("fido");
		boolean check = pet1.getNeedsToPee();
		assertFalse(check);
		VirtualPet pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPee();
		assertFalse(check);
		underTest.waterPets();
		pet1 = underTest.getPet("fido");
		check = pet1.getNeedsToPee();
		assertTrue(check);
		pet2 = underTest.getPet("feefee");
		check = pet2.getNeedsToPee();
		assertTrue(check);
	}

	@Test
	public void testThatPlayingWIthChangesActivityLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.playWithAPet("fido");
		int check = underTest.getPet("fido").getActivityLevel();
		assertEquals(75, check);
	}

	@Test
	public void testThatWalkingPetChangesActivityLevel() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		underTest.walkAPet("fido");
		int check = underTest.getPet("fido").getActivityLevel();
		assertEquals(75, check);
	}

	@Test
	public void testThatWalkingPetChangesNeedsToPoop() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		boolean check = underTest.getPet("fido").getNeedsToPoop();
		assertEquals(false, check);
		underTest.getPet("fido").eat();
		check = underTest.getPet("fido").getNeedsToPoop();
		assertEquals(true, check);
		underTest.walkAPet("fido");
		check = underTest.getPet("fido").getNeedsToPoop();
		assertEquals(false, check);
	}

	@Test
	public void testThatWalkingPetChangesNeedsToPee() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 5));
		boolean check = underTest.getPet("fido").getNeedsToPee();
		assertEquals(false, check);
		underTest.getPet("fido").drink();
		check = underTest.getPet("fido").getNeedsToPee();
		assertEquals(true, check);
		underTest.walkAPet("fido");
		check = underTest.getPet("fido").getNeedsToPee();
		assertEquals(false, check);
	}

	@Test
	public void testThatTickMethodChangesAttributeLevels() {
		VirtualPetShelter underTest = new VirtualPetShelter();
		underTest.addPet(new VirtualPet("fido", "the ferocious", 5, 5, 50));
		underTest.addPet(new VirtualPet("feefee", "the furious", 10, 10, 60));
		underTest.addPet(new VirtualPet("spot", "the spotty", 15, 15, 70));
		underTest.tick();
		underTest.tick();
		int check1 = underTest.getPet("fido").getHungerLevel();
		int check2 = underTest.getPet("fido").getThirstLevel();
		int check3 = underTest.getPet("fido").getActivityLevel();
		assertEquals(15, check1);
		assertEquals(15, check2);
		assertEquals(40, check3);

		int check11 = underTest.getPet("feefee").getHungerLevel();
		int check12 = underTest.getPet("feefee").getThirstLevel();
		int check13 = underTest.getPet("feefee").getActivityLevel();
		assertEquals(20, check11);
		assertEquals(20, check12);
		assertEquals(50, check13);

		int check21 = underTest.getPet("spot").getHungerLevel();
		int check22 = underTest.getPet("spot").getThirstLevel();
		int check23 = underTest.getPet("spot").getActivityLevel();
		assertEquals(25, check21);
		assertEquals(25, check22);
		assertEquals(60, check23);
	}

}