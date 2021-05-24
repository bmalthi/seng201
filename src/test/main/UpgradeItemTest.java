package test.main;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Island;
import main.Item;
import main.ItemType;
import main.PriceType;
import main.PricedItem;
import main.Ship;
import main.StorageList;
import main.Store;
import main.UpgradeItem;



/**
 * Class to test ship upgrade functionality
 */
class UpgradeItemTest {

	@Test
	void upgradeEngineTest() {
		Ship testShip = new Ship("Ben Ship", 5, 10, 100);
		testShip.getStorageBays().add(new StorageList("UpgradeBay", 2, ItemType.UPGRADE));
		UpgradeItem upgradeItem = new UpgradeItem("ENGINE");
		
		//Num upgrades should be 0
		int startSpeed = testShip.getSailSpeed();
		assertTrue(testShip.getUpgrades().size() == 0);	
		
		// After added item and upgrading ship, engine should be faster
		// and ship should have upgrade registered. Upgrades == 1
		testShip.addItem(upgradeItem);
		upgradeItem.upgradeShip(testShip);		
		int endSpeed = testShip.getSailSpeed();
		assertTrue(endSpeed > startSpeed);
		assertTrue(testShip.getUpgrades().size() == 1);
	}
	
	@Test
	void upgradeCargoTest() {
		Ship testShip = new Ship("Ben Ship", 5, 10, 100);		
		testShip.getStorageBays().add(new StorageList("UpgradeBay", 2, ItemType.UPGRADE));
		UpgradeItem upgradeItem = new UpgradeItem("CARGO10");
		Item testCargo = new Item("Tester", "", 10, ItemType.CARGO);
		
		//Num upgrades should be 0, and space for cargo should be 0
		assertTrue(testShip.getUpgrades().size() == 0);
		assertFalse(testShip.hasSpace(testCargo));
		
		// After added item and upgrading ship, cargo space should now exist
		// and ship should have upgrade registered. Upgrades == 1		
		testShip.addItem(upgradeItem);
		upgradeItem.upgradeShip(testShip);
		assertTrue(testShip.hasSpace(testCargo));
		assertTrue(testShip.getUpgrades().size() == 1);
	}	
	
	@Test
	void upgradeWeaponStorageTest() {
		Ship testShip = new Ship("Ben Ship", 5, 10, 100);
		testShip.getStorageBays().add(new StorageList("UpgradeBay", 2, ItemType.UPGRADE));
		UpgradeItem upgradeItem = new UpgradeItem("WEAPONBAY");
		Item testWeapon = new Item("Tester", "", 2, ItemType.WEAPON);
		
		//Num upgrades should be 0		
		assertFalse(testShip.hasSpace(testWeapon));
		assertTrue(testShip.getUpgrades().size() == 0);
		
		// After added item and upgrading ship, weapon space should now exist
		// and ship should have upgrade registered. Upgrades == 1		
		testShip.addItem(upgradeItem);
		upgradeItem.upgradeShip(testShip);
		assertTrue(testShip.hasSpace(testWeapon));
		assertTrue(testShip.getUpgrades().size() == 1);
	}		

}
