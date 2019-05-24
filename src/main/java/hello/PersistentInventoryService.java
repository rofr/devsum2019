package hello;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import pl.setblack.airomem.core.Persistent;

@Service
public class PersistentInventoryService implements InventoryService {

	final Persistent<CoreInventoryService> engine;

	final Path storeFolder = Paths.get("inventory");
	
	public PersistentInventoryService() {
		engine = Persistent.loadOptional(storeFolder, () -> new CoreInventoryService());
	}

	@Override
	public int available(String warehouse, String product) {
		return engine.query(core -> core.available(warehouse, product));
	}

	@Override
	public int fill(String warehouse, String product, int amount) {
		return engine.executeAndQuery(core -> core.fill(warehouse, product, amount));
	}

	@Override
	public void reserve(String warehouse, String product, int amount) {
		engine.execute(core -> core.reserve(warehouse, product, amount));
		
	}

}
