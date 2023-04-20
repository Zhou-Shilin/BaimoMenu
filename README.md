# BaimoMenu
BaimoMenu is a Nukkit plugin that allows server owners to define custom menus for different worlds. The plugin adds items to a player's inventory when they join or teleport to a world with a defined menu. The items can be customized to execute commands when clicked.
# Installation
To install the BaimoMenu plugin, follow these steps:
1. Download the latest version of the plugin from the releases page.
2. Copy the downloaded JAR file to the plugins folder of your Nukkit server.
3. Restart your Nukkit server.
# Usage
To use the BaimoMenu plugin, you need to define menus for your worlds in the plugin's configuration file. The configuration file is located in the plugins/BaimoMenu folder and is named config.yml.  
Here is an example configuration file:
```
worlds:
  world1:
    enabled: true
    items:
      - item: diamond_sword
        name: "&6Sword"
        lore:
          - "&7This is a powerful sword."
        command: "give @p diamond_sword"
      - item: diamond_pickaxe
        name: "&6Pickaxe"
        lore:
          - "&7This is a powerful pickaxe."
        command: "give @p diamond_pickaxe"
  world2:
    enabled: false
    items:
      - item: diamond_axe
        name: "&6Axe"
        lore:
          - "&7This is a powerful axe."
        command: "give @p diamond_axe"
```
In this example, there are two worlds defined: world1 and world2. The world1 menu is enabled, while the world2 menu is disabled.  
The items list defines the items that will be added to a player's inventory when they join or teleport to the world. Each item has the following properties:
 - `item`: The ID of the item to add to the player's inventory.
 - `name`: The display name of the item.
 - `lore`: The lore of the item.
 - `command`: The command to execute when the item is clicked.
To enable or disable a menu for a world, set the enabled property to true or false, respectively.
# Support
If you encounter any issues with the BaimoMenu plugin, please create a new issue.
