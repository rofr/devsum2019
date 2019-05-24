package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    
    
    @GetMapping("/available/{warehouse}/{product}")
    public Integer getInventory(@PathVariable String warehouse, @PathVariable String product) {
    	return inventoryService.available(warehouse, product);
    }
    
    @PostMapping("/fill/{warehouse}/{product}")
    public Integer fill(@PathVariable String warehouse, @PathVariable String product, @RequestParam Integer amount) {
    	return inventoryService.fill(warehouse, product, amount);
    }
    
    @PostMapping("/reserve/{warehouse}/{product}")
    public void reserve(@PathVariable String warehouse, @PathVariable String product, @RequestParam Integer amount) {
    	inventoryService.reserve(warehouse, product, amount);
    }
}
