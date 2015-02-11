Pore [![travis badge](https://travis-ci.org/LapisBlue/Pore.svg)](https://travis-ci.org/LapisBlue/Pore)
=====

Pore is a plugin for the up-and-coming Sponge plugin which serves to enable compatibility for Bukkit plugins on servers
implementing SpongeAPI.

Please note that Pore is still under heavy development and **is not yet considered functional**. Currently, no Bukkit
plugins are verified to be supported.

Compilation
-----------

Gradle is used to handle dependencies.

- Clone the repo: `git clone https://github.com/LapisBlue/Pore.git`
- Initialize the project: `./poredev update` (no native Windows script yet, although `sh ./poredev update` may work)
- Compile the project using the Gradle wrapper: `./gradlew` (`gradlew` on Windows)

Questions?
----------

Have an issue or a question about Pore? No problem! Feel free to ask in #lapis on EsperNet.

Licensing
---------

Pore's source code is made available under the [MIT license](http://opensource.org/licenses/MIT). You may do as you wish
with the source within its bounds.

`.patch` files for Bukkit are made available under the [GPLv3](http://opensource.org/licenses/gpl-3.0.html).

Pore's distribution is made available under the [GPLv3](http://opensource.org/licenses/gpl-3.0.html).
