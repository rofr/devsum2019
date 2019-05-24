# Devsum 2019 code example

I gave a presentation on memory image pattern at the Devsum conference in Stockholm, May 2019 that ended with this code as a demo.

The example uses airomem, a persistence library for java based on the memory image pattern. It uses snapshots and journal files, keep an eye on the inventory folder while you test the service.

https://github.com/airomem/airomem

The Airomem persistence layer sits between the service and domain, transparently logging commands and then calling into the core domain logic component. 

RestController -> PersistentInventoryService -> CoreInventoryService

## Running the demo
Open in any IDE you prefer that supports Maven or Gradle. Start the Application-class and then call the rest endpoints described in the InventoryController. (See the rest folder for details)

If you restart the application the in-memory model is lost but reloaded from snaphot and journal entries in the inventory folder.
