# Money Mobs
Money mobs is a minecraft plugin for the player to earn money when killing a mobs, it also simplifies many of the options currently existing.

**Suport server:** https://discord.gg/UhBaxpFv6f

## Licence [MIT](./LICENSE.md)

## Permissions
- `moneymobs.command.moneymobs` - For use /moneymobs
- `moneymobs.command.moneymobs.info` - For use /moneymobs info
- `moneymobs.command.moneymobs.about` - For use /moneymobs about
- `moneymobs.command.moneymobs.reload` - Reaload config of the plugin
- `moneymobs.drops` - If player don't have this permission, the system don't worked

## Commands
- `/moneymobs` - Display info of the mobs.
- `/moneymobs info` - Display info of the mobs.
- `/moneymobs about` - Display about of the plugin.
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