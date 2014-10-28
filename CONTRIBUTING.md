Pore Contrubuting Guidelines
============================

Requirements
------------
At this time, Pore's contribution guidelines are very loose, though this is subject to change as development progresses. Currently, the only criteria are that contributions compile, and that they adhere to Pore's goals as a project. The current requirements are as follows:
- Pore should serve only as an abstraction layer between Bukkit and Sponge. As such, it must include as little non-reference code as possible.
- The Bukkit API contains a good deal of functional code. If a feature is already implemented by Bukkit (e.g. plugin loading), it should not be bridged unless the matter has been already discussed with the core developers.
- If a method cannot be fully implemented due to limitations of the Sponge API, it should throw a NotImplementedException.

Concurrent Development
----------------------
To avoid the issue of conflicting pull requests, we have set up [a page on Trello](https://trello.com/b/J6AT6tDl/pore) used to track who's working on what. We ask that you reference this before starting work, and create or move a card once you have.

Submitting a Pull Request
-------------------------
Once you've ensured that your contribution meets the above requirements, you may submit them as a pull request to the main repository. The pull request must include information regarding what has been changed and what is accomplished. Ultimately, the repository owner will have final discretion as to what is and is not merged.
