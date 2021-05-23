package test.main;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Item;
import main.ItemType;
import main.Ship;
import main.UpgradeItem;



/**
 * Class to test ship upgrade functionality
 */
class UpgradeItemTest {

	@Test
	void upgradeEngineTest() {
		Ship testShip = new Ship("Ben Ship", 5, 10, 100);
		UpgradeItem upgradeItem = new UpgradeItem("ENGINE");
		int startSpeed = testShip.getSailSpeed();
		upgradeItem.upgradeShip(testShip);
		int endSpeed = testShip.getSailSpeed();
		assertTrue(endSpeed > startSpeed);
	}
	
	@Test
	void upgradeCargoTest() {
		Ship testShip = new Ship("Ben Ship", 5, 10, 100);
		UpgradeItem upgradeItem = new UpgradeItem("CARGO10");
		Item testCargo = new Item("Tester", "", 10, ItemType.CARGO);
		assertFalse(testShip.hasSpace(testCargo));
		upgradeItem.upgradeShip(testShip);
		assertTrue(testShip.hasSpace(testCargo));
	}	
	
	@Test
	void upgradeWeaponStorageTest() {
		Ship testShip = new Ship("Ben Ship", 5, 10, 100);
		UpgradeItem upgradeItem = new UpgradeItem("WEAPONBAY");
		Item testWeapon = new Item("Tester", "", 2, ItemType.WEAPON);
		assertFalse(testShip.hasSpace(testWeapon));
		upgradeItem.upgradeShip(testShip);
		assertTrue(testShip.hasSpace(testWeapon));
	}		

}
