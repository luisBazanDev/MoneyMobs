# Money Mobs
Money mobs is a minecraft plugin for the player to earn money when killing a mobs, it also simplifies many of the options currently existing.

## Licence [MIT](./LICENSE.md)

## Permissions
- `moneymobs.command.moneymobs` - For use /moneymobs command
- `moneymobs.drops` - If player don't have this permission, the system don't worked

## Commands
- `/moneymobs` - Display low info.
- `/moneymobs info` - Display all info.
- `/moneymobs reload` - Reload config of the plugin.

## Default Config
```yml
prefix: "&6&lMM &f» "
msg: "&7+%money%$" # %money% is variable
format: "00.0#" # Default "00.0#"

sound:
  enable: true
  sound: ENTITY_PLAYER_LEVELUP # From this site https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Sound.html
  pitch: 2 # values from the 0 to 2
  volume: 1 # values from the 0 to 1

##############################################################################
# Entity type of the Spigot-API in this link                                 #
# https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/entity/EntityType.html #
##############################################################################
money-mobs:
  BAT:
    min: 1
    max: 5
  PIGLIN_BRUTE:
    min: 1
    max: 5
  PILLAGER:
    min: 1
    max: 5
  SKELETON:
    min: 1
    max: 5
  ZOMBIE:
    min: 1
    max: 5
```