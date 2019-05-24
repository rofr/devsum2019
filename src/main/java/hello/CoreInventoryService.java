package hello;

import java.io.Serializable;
import java.util.HashMap;

public class CoreInventoryService implements InventoryService, Serializable {

	private static final long serialVersionUID = 1L;
	private HashMap<String, Integer> inventory = new HashMap<>();
	
	@Override
	public int available(String warehouse, String product) {
		String key = key(warehouse,product);
		return inventory.getOrDefault(key, 0);
	}

	@Override
	public int fill(String warehouse, String product, int amount) {
		String key = key(warehouse, product);
		return inventory.merge(key, amount, (a,b) -> a + b);
	}

	@Override
	public void reserve(String warehouse, String product, int amount) {
		fill(warehouse, product, -amount);
	}
	
	private String key(String warehouse, String product) {
		return warehouse + ":" + product;
	}
	
	
}
