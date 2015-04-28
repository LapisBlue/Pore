Contributing
============

Requirements
------------
At stage in development Pore's contribution guidelines are fairly loose, though this is subject to change as development
progresses. Currently, the only criteria are that contributions compile, and that they adhere to Pore's goals as a
project:
- Pore should serve only as an abstraction layer between Bukkit and Sponge.
    As such, it should use the most direct implementation possible while still keeping overhead in mind.
- Pore follows a minimal-diff policy for the sake of maintained compatibility.
    As such, contributions should avoid adding patches to the `Porekit` submodule unless absolutely necessary.

Submitting a Pull Request
-------------------------
Once you've ensured that your contribution meets the above requirements, you may submit them as a pull request to the
main repository. The pull request must include information regarding what has been changed and what is accomplished in
as much detail as possible without redundancy.
