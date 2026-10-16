# Tool Stats — unofficial Fabric 1.21.1 port

This is an unofficial port of [Tool Stats by Darkhax](https://www.curseforge.com/minecraft/mc-mods/tool-stats) for Fabric on Minecraft 1.21.1. It is not affiliated with or endorsed by the original author.

The port retains the configurable item-tooltip information from the 1.20.4 source: mining speed, enchantability, repair cost, durability, horse-armor protection, and harvest-level information where the game exposes a numeric level. Existing item ignore tags and config switches are retained.

## Compatibility

- Minecraft 1.21.1
- Fabric Loader 0.16.14 or newer
- Fabric API 0.116.8+1.21.1 or newer for Minecraft 1.21.1
- Java 21

Minecraft 1.21 removed the numeric level from the `Tier` API. The port maps vanilla tiers to their previous levels and reads a legacy public `getLevel()` method from third-party tiers when one remains available. A custom tier without that method has no numeric harvest-level line; its other tooltip data remains available.

## Configuration and tags

The config is created at `config/toolstats.json`. The original item tags remain under `data/toolstats/tags/items/` and can be extended by data packs or other mods.

## Build

Run `gradlew.bat build` on Windows with Java 21. The remapped mod JAR is written to `build/libs/`.

## Attribution and license

The port is based on the 1.20.4 source branch of [Darkhax-Minecraft/Tool-Stats](https://github.com/Darkhax-Minecraft/Tool-Stats). The code remains under GNU LGPL version 2.1; see [LICENSE](LICENSE). The original logo is reused unchanged and is credited to Lorc via Game-icons.net under CC BY 3.0; see [PORT-NOTICE.md](PORT-NOTICE.md).

