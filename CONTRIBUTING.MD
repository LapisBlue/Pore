Pore Contrubuting Guidelines
============================

Requirements
------------
At this time, Pore's contribution guidelines are very loose, though this is subject to change as development progresses. Currently, the only criteria are that contributions compile, and that they adhere to Pore's goals as a project. Pore's goals are as follows:
- Pore should serve only as an abstraction layer between Bukkit and Sponge. As such, it must include as little non-reference code as possible.
- Pore follows a minimal-diff policy for the sake of maintained compatibility. As such, contributions should avoid modifying the copy of the Bukkit API included in this repository at all costs. If the API absolutely must be modified, a comment should be added denoting the change (e.g. // Pore: protected -> public).

Submitting a Pull Request
-------------------------
Once you've ensured that your contribution meets the above requirements, you may submit them as a pull request to the main repository. The pull request must include information regarding what has been changed and what is accomplished. Ultimately, the repository owner will have final discretion as to what is and is not merged.
