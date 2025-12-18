# DisableEnd
> [!WARNING]
> This game version is in EOL. Only bugfixes will be commited to this branch
A simple quick-toggleable fabric mod to disable the end. 

To toggle the end run `/gamerule doDisableEnd true`

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](https://choosealicense.com/licenses/mit/)
[![ModLoader](https://img.shields.io/badge/Modloader%20-Fabric-%23dbd0b4?style=for-the-badge)](https://opensource.org/licenses/)
[![API](https://img.shields.io/badge/Requires%20-Fabric%20API-%23dbd0b4?style=for-the-badge)](https://modrinth.com/mod/fabric-api/)
[![Lib](https://img.shields.io/badge/Requires%20-OWO%20lib-%23dbd0b4?style=for-the-badge)](https://modrinth.com/mod/owo-lib)

### Default incompatibility with modded respawn points

Due to there being no reliable way to get the players respawn point, a block check is preformed but due to this block check, blocks need to be manually added to a list of valid respawn points in the config.

## Requirements

* Starting in version 0.2 owo lib is required for configs to work.
* Mod is serverside ONLY and will not run clientside

# Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.

## Feedback

If you have any feedback, please open a new issue

## Building from source

To build for development run `gradlew runClient` or to build a jar run `gradlew jar`. Builds are located in .\build\libs