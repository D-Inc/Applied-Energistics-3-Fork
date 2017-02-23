# Applied Energistics 3 - Structure

##### This file describes new modular structure of Applied Energistics 3 and repartition of AE2's items, blocks and other features between modules.

It is important to note that this file is repartition of **AE2's features only**. Applied Energistics 3 will have new systems, new mechanics and a lot of new stuff, but these are not included in here, as these will be discussed later on, because we have to move over the old stuff first. _Also, not all old stuff made it over ;) :( _

## Modules

Applied Energistics 3 is split into modules. Each module represents a certain theme/feature/option/..., like _World Gen_ module is responsible for world generation (meteorites and ores), _ME_ module adds ME system, _Spatial IO_ module adds spatial storage cells, etc.
The significant part of the new modules system is difference between _internal_ and _external_ modules. Before we get to it, you have to understand how Applied Energistics 3 will be distributed:
- There will be one JAR that includes ALL modules (it will also be the one you download by default).
- A _Core_ jar which contains utility classes, core API and all internal modules. It is included in the _ALL_ JAR, but in other cases it will always have to be installed.
- A JAR per external module, which logically requires _Core_ JAR to be installed.
- Some JARs for addon & cross-compat developers, which we will not cover here.

Now that we covered distribution, we only have to sum things up to define _internal_ and _external_ modules:
- _Internal_ modules - Modules of Applied Energistics 3 that are always installed, whether you want it or not.
- _External_ modules - Optional Applied Energistics 3 modules.

**TLDR: If you are a simple user and you do not care about all of this mess, just download the first JAR you see and you're good.**

#### Current Modules Structure:
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

## Repartition Of AE2 Features:
- Core
  - Blocks:
    - 
  - Items:
    - 
  - Crafting
    - Blocks:
	  - 
	- Items:
	  - 
  - ME
    - Blocks:
	  - 
	- Items:
	  - 
  - Spatial
    - Blocks:
	  - 
	- Items:
	  - 
  - World Gen
    - Blocks:
	  - 
	- Items:
	  - 
- Decorative
  - Blocks:
    - 
  - Items:
    - 
- Miscellaneous
  - Blocks:
    - 
  - Items:
    - 
- Tools
  - Blocks:
    - 
  - Items:
    - 