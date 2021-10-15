/* This class creates a Player
 * [class still under development]
 */

import java.util.ArrayList;

public class PlayerManager {
    Player player;
    public PlayerManager(String name, ArrayList<Stat> stats){
        this.player = new Player(name, stats);
    }

    public PlayerManager(String name, ArrayList<Stat> stats, int capacity){
        this.player = new HumanPlayer(name, stats, capacity);
    }

    public String getPlayerName(){
        return this.player.getName();
    }

    public Player getPlayer(){
        return player;
    }

}
