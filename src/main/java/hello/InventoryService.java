package hello;

public interface InventoryService {

	/**
	 * How many in stock? - Query
	 */
	int available(String warehouse, String product);
	
	/**
	 * Fill up stock, return resulting stock - Both a command and a query
	 */
	int fill(String warehouse, String product, int amount);

	/**
	 * Command
	 */
	void reserve(String warehouse, String product, int amount);
}
