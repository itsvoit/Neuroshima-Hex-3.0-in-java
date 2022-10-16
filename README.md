# Neuroshima-Hex-3.0-in-java

## Neuroshima Hex 3.0

An attempt on making neuroshima hex in java for pc

# Main tasks:
  - create board for 1v1 and FFA
  - develop board placement (spaces numbers and logic)
  - develop backend logic (battle calculation)
  - create responsive gui
  - put everything together

# Project Overview


## Main features:
- Board (GUI)
	- Army tokens
	- Board itself
	- Hand space
		- Save tokens for later
		- Discard tokens
- Logic
	- Hex indexing
	- Token placement logic
	- Battle logic
		- Choices for different tokens during battle
		- Resolving battle automatically
		
		

## Class hierarchy:

## Game
  - Has:
    - Player (x2)
    - Board

### Player
  - Has:
    - Army
    - Hand
		
### Army
  - Has:
    - Tile (x34)

### Tile
  - Super to:
    - UnitTile		
    - GroundTile		
    - InstantTile
  - Has:
	  - Attributes



## Descriptions:

  Game - Main class; it's responsible for turns and managing the board. Let's players draw and play cards
	
  Player - player class; has player deck with an Army, as well as a current Hand. It's main purpose is for easier turn and player deck management
	
  Hand - all the cards the player has on hand; helps with turns
	
  Army - A preset deck of Tiles. Contains all the player's tiles. Draws random cards to fill the hand.
	
  Tile - Base class for all usable tiles in the game. Has attributes which define what the tile can do. Can be Placable or Instant
	
  Attributes - Define tile's properties. Can be passive (eg. medic heal or Toughness) or active (eg. warrior's attack or HQ's Mobility). Help with managing new Armies additions (just create new attributes and add them to new tiles). Can work on self or others attached to the unit that has it.
	
	
	
## Battle:
  When invoked the game should automatically calculate all the damage accounting for different bonuses (from Modules, HQs, passive Attributes, etc.) and also ask the player to make a choice in certain situations (eg. Medic taking damage for a unit between 2 different sources)
