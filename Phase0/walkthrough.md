# Scenario Walk-Through

## Background
For this scenario walk-through, we will initialize a new HumanPlayer with their customized name and two customized attributes, 
then play the game with some basic pre-written story

We assuming that:
* The number of skill points available for user to distribute is 10 
* User will assign 1 skill point for attribute [Intelligence]
* User will put the remaining points on attribute [Psyche]
* User will input "Booboo" as their character name
* The player's [Intelligence] is too low and the check will always fail, but User will retry as many times as possible.
* Failing the check will cause [Sadness] to increase by 25.



## The Walk-Through
1. After User starts and runs the program, the program will first call upon `Console` to execute commands for 
   initializing certain UI elements. Then, `Console` will call upon `MainLoop` which will in turn initialize `GameState`.
   `GameState` reads into the pre-written scripts in `GameStage`, and passes the prompt to`MainLoop`, which will then ask the
   user to in input and assign their 10 skill points to two attributes on `Console`.
2. `GameState` initializes a new `StatManager` with 10 skill points. User follows the prompts on `Console` to input
   1 skill points for attribute [Intelligence], then 8 points for [Psyche].`Console` will return the input 
   to `MainLoop`, then `MainLoop` calls on `GameState`, and `GameState` calls on the
   `StatManager` to initialize `Stat` [Intelligence] and [Psyche] with their respective values.
3. Following the script, `GameState` also asks this `StatManager` to initialize another
   `Stat` called [Sadness]. `StatManager` uses the default limits to create this `Stat` [Sadness].
4. `GameState` then reads further into the scripts in `GameStage`.
   User then inputs "Booboo" as their character name. This name will be taken to the `Gamestate` following a path similar
   to the ones mentioned above. `GameState` then initializes new `PlayerManager` to create a new `HumanPlayer`
   with the name and this `PlayerManager` will also access the `StatManager`to ask for the attributes. Then `PlayerManager`
   will create this new `HumanPlayer` with the desired name and attributes.
5. `GameState` then reads more scripts in `GameStage` while passing the String and potential input prompts to `MainLoop`. 
   `MainLoop` then shows them on `Console` and the actual story starts
6. Soon `GameState` will read the need of `Check` in `GameStage`. `GameState` initializes a new `Check`. This `Check` will
   check if `HumanPlayer` passes. Since this check will always fail and the User will retry as many times as possible, 
   Every failed `Check` causes the `HumanPlayer` to gain [Sadness] and soon it reaches the limit.
7. `GameState` asks `PlayerManager` to perform a check. `PlayerManager` notices that [Sadness] is at its limit and passes the result to `GameState`.
    Then `GameState` executes the ending scripts in `GameStage`. The ending messages will be passed to `MainLoop` and then `Console`,
    which the `Console` will display the ending texts and inform the User that the game is over.

