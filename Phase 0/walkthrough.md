# Scenario Walk-Through
## Background
For this scenario walk-through, we will initialize a new HumanPlayer with their customized name and two customized attributes, 
then play the game with some basic pre-written story

We assuming that:
* The skill points available for user to distribute is 10 
* User will assign 1 skill point for attribute [Intelligence]
* User will put the remaining points on attribute [Psyche]
* User will input "Booboo" as their character name
* The [Intellegence] is too low and the check will always fail, but User will retry as many times as possible.
* Failing the check will result a 25 increase on [Sadness]



## The Walk-Through
1. After user starts and runs the program, it will first call upon `Console` and then execute commands to 
   initialize certain UI elements. Then `Console` will call upon `MainLoop` which will in turn initialize `GameState`.
   `GmaeState` reads into the pre-written scripts in `GameStage`, and passing the prompt to`MainLoop` which will ask the
   user to in input and assign their 10 skill points for two attributes on `Console`
2. `GameState` initializes a new`StatManager` with 10 skill points. User follows the prompts on `Console` to input
   1 skill points for attribute [Intelligence], then 8 points for [Psyche].`Console` will return the input 
   to `MainLoop`, then `MainLoop` calls on `GameState`, which `GameState` will call the
   `StatManager` to initialize `Stat` [Intelligence] and [Psyche] with their value respectively. 
3. Following the script, `GameState` also asks this `StatManager` to initialize another
   `Stat` called [Sadness]. `StatManager` uses the default limits to create this `Stat` [Sadness]
4. `GameState` then reads further into the scripts in `GameStage`.
   User then inputs "Booboo" as their character name. This name will be taken to the `Gamestate` flowing the similar
   paths mentioned above. `GameState` then initializes new `PlayerManager` to create a new `HumanPlayer`
   with the name and this `PlayerManager` will also access the `StatManager`to ask for the attributes. Then `PlayerManager`
   will formly create this new `HumanPlayer` with the desired name the attributes.
5. `GameState` then reads more scripts in `GameStage` while passing the String and potential input propts to `MainLoop`. `MainLoop` then shows thwm on `Console` and the actual story starts
6. Soon `GameState` will read the need of `Check` in `GameStage`. `GameState` initializes a new `Check`. This `Check` will
   check `HumanPlayer` to examine if it passes. Since this check will always fail and the User will retry as many times as possible, 
   Every time failing of this `Check` results the `HumanPlayer` to increase [Sadness] and soon it reaches the limit.
7. `GameState` asking `PlayerManager` to examine. `PlayerManager` spots [Sadness] at its limit and pass the result to `GameState`.
    Then `GameState` executes the ending scripts in `GameStage`. The ending messages will be passed to `MainLoop` and then `Console`,
    which the `Console` will display the ending texts and inform the User that the game is over.

