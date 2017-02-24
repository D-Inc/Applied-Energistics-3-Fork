# Applied Energistics 3 - Structure

#### This file describes new modular structure of Applied Energistics 3 and repartition of AE2's items, blocks and other features between modules.

It is important to note that this file is repartition of **AE2's features only**. Applied Energistics 3 will have new systems, new mechanics and a lot of new stuff, but these are not included in here, as these will be discussed later on, because we have to move over the old stuff first.
_Also, not all old stuff made it over ;) :(_

## Modules

Applied Energistics 3 is split into modules. Each module represents a certain theme/feature/element/..., like _World Gen_ module is responsible for world generation (meteorites and ores), _ME_ module adds ME system, _Spatial IO_ module adds spatial storage cells, etc.
The significant part of the new modules system is difference between _internal_ and _external_ modules. Before we get to it, you have to understand how Applied Energistics 3 will be distributed:
- There will be one JAR that includes ALL modules (it will also be the one you download by default).
- A _Core_ jar which contains utility classes, core API and all internal modules. It is included in the _ALL_ JAR, but in other cases it will always have to be installed.
- A JAR per external module, which logically requires _Core_ JAR to be installed.
- Some JARs for addon & cross-compat developers, which we will not cover here.

Now that we covered distribution, we only have to sum things up to define _internal_ and _external_ modules:
- _Internal_ modules - Modules of Applied Energistics 3 that are always installed, whether you want it or not.
- _External_ modules - Optional Applied Energistics 3 modules.

**TLDR: If you are a simple user and you do not care about all of this mess, just download the first JAR you see and you're good.**

--

### Current Modules Structure:
**(All modules under _Core_ are internal)**

- Core
  - Crafting
  - ME
  - Spatial
  - World Gen
- Debug (not distributed)
- Decorative
- Miscellaneous
- Tools

-----

## Repartition Of AE2 Features (WIP):
- Core
  - Blocks:
    - Charger
    - Creative Energy Cell
    - Crystal Growth Accelerator
    - Dense Energy Cell
    - Energy Acceptor
    - Energy Cell
    - Inscriber
    - Light Detecting Fixture
    - Meteorite Compass
    - Matter Condenser
    - Quartz Grindstone
    - Quartz Glass
    - Tiny TNT
    - Vibrant Quartz Glass
    - Vibration Chamber
    - Wooden Crank
  - Items:
    - Engineering Processor
    - Calculation Processor
    - Logic Processor
    - Annihilation Core
    - Formation Core
    - Certus Quartz Cutting Knife
    - Certus Quartz Seed
    - Certus Quartz Wrench
    - Charged Certus Quartz Crystal
    - Pure Certus Quartz Crystal
    - Fluix Crystal
    - Fluix Pearl
    - Fluix Seed
    - Inscriber Calculation Press
    - Inscriber Engineering Press
    - Inscriber Logic Press
    - Inscriber Name Press
    - Inscriber Silicon Press
    - Matter Ball
    - Matter Cannon
    - Nether Quartz Cutting Knife
    - Nether Quartz Seed
    - Nether Quartz Wrench
    - Paint Ball
    - Printed Calculation Circuit
    - Printed Engineering Circuit
    - Printed Logic Circuit
    - Printed Silicon
    - Pure Fluix Crystal
    - Pure Nether Quartz Crystal
    - Wooden Gear
    - Color Applicator
  - Materials:
    - Certus Quartz Crystal
    - Certus Quartz Dust
    - Gold Dust
    - Fluix Dust
    - Nether Quartz Dust
    - Ender Dust
    - Flour
    - Iron Dust
    - Sky Stone Dust
    - Silicon
  - Crafting
    - Blocks:
	    - 16k Crafting storage
      - 1k Crafting Storage
      - 4k Crafting Storage
      - 64k Crafting Storage
      - Crafting Co Processing Unit
      - Crafting Monitor
      - Crafting Unit
      - Molecular Assembler
    - Items:
	  - 
  - ME
    - Blocks:
	    - Cell Workbench
      - ME Chest
      - ME Controller
      - ME Drive
      - ME Interface
      - ME IO Port
      - ME Quantum Link Chamber
      - ME Quantum Ring
      - ME Security Terminal
    - Items:
      - Annihilation Core
	    - 16k ME Storage Cell
	    - 16k ME Storage Component 
	    - 1k ME Storage Cell
	    - 1k ME Storage Component
	    - 4k ME Storage Cell
	    - 4k ME Storage Component
	    - 64k ME Storage Cell
	    - 64k ME Storage Component
      - Acceleration Card
      - Advanced Card
      - Basic Card
      - Biometric Card
      - Blank Pattern
      - Capacity Card
      - Crafting Card
      - Creative ME Storage Cell
      - Encoded Pattern
      - Fuzzy Card
      - Inverter Card
      - ME Storage Housing
      - Memory Card
      - Network Tool
      - Portable Cell
      - Quantum Entangled Singularity
      - Redstone Card
      - Singularity
      - View Cell
      - Wireless Booster
      - Wireless Receiver
      - Wireless Terminal
    - Parts:
      - Bright Illuminated Panel
      - Cable Anchor
      - Cable Facade
      - Dark Illuminated Panel
      - Illuminated Panel
      - ME Annihilation Plane
      - ME Conversion Monitor
      - ME Covered Cable
      - ME Crafting Terminal
      - ME Dense Cable
      - ME Export Bus
      - ME Formation Plane
      - ME Glass Cable
      - ME Import Bus
      - ME Interface Terminal
      - ME Inverted Toggle Bus
      - ME Level Emitter
      - ME Pattern Terminal
      - ME Smart Cable
      - ME Storage Bus
      - ME Storage Monitor
      - ME Terminal
      - ME Toggle Bus
      - ME Wireless Access Point
      - Quartz Fiber
  - Spatial
    - Blocks:
	    - Spatial IO Port
	    - Spatial Pylon
    - Items:
	    - 128Cubed Spatial Component
	    - 128Cubed Spatial Storage Cell
	    - 16Cubed Spatial Component
	    - 16Cubed Spatial Storage Cell 
      - 2Cubed Spatial Component
      - 2Cubed Spatial Storage Cell
  - World Gen
    - Blocks:
	    - Certus Quartz Ore
      - Charged Certus Quartz Ore
    - Items:
	  - 
- Decorative
  - Blocks:
    - Certus Quartz Block
    - Certus Quartz Pillar
    - Charged Quartz Fixture
    - Chiseled Certus Quartz Block
    - Sky Stone Block Chest
    - Sky Stone Block
    - Sky Stone Brick
    - Sky Stone Chest
    - Sky Stone Small Brick
    - Sky Stone
    - Fluix Block
  - Items:
    - 
- Miscellaneous
  - Blocks:
    - 
  - Items:
    - Certus Quartz Axe
    - Certus Quartz Hoe
    - Certus Quartz Pickaxe
    - Certus Quartz Shovel
    - Certus Quartz Sword
    - Charged Staff
    - Entropy Manipulator
    - Nether Quartz Axe
    - Nether Quartz Hoe
    - Nether Quartz Pickaxe
    - Nether Quartz Shovel
    - Nether Quartz Sword
- Tools 
  - Blocks:
    - 
  - Items:
    - 

- **Did Not Make It Over (yet - may come back in later versions)**:
  - P2P