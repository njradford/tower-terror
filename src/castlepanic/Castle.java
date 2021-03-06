package castlepanic;

import java.io.Serializable;

/**
 * The current game's castle contained in one class. Walls are put into an
 * integer array of length 7 and loaded into elements 1-6. The integer
 * represents their health: 1 is the default health, 2 is a reinforced wall, and
 * 0 is a destroyed wall. Towers are handled by booleans. They are loaded into
 * elements 1-6. True is a standing tower, false is a destroyed tower. This
 * class also has a method for checking if the game is over or not.
 *
 * @author Adam Whitley
 * @author Gregory Loftis
 * @author Dipesh Dave
 * @author John Fenwick
 */
public class Castle implements Serializable {
    public static int TOWER_STANDING = 1, TOWER_RUBBLE = -1, TOWER_DESTROYED = 0; 
   
    
    private int[] towers = new int[7]; // True means the tower exists, false means the tower is missing.
    private int[] walls = new int[7]; // Walls start out with 1 hitpoint, and when reinforced it has 2 hitpoints.

    /**
     * Constructs a castle for a new game. Creates 6 walls and 6 towers and
     * loads them into array indexes 1-6.
     *
     */
    public Castle() {

        for (int i = 1; i <= 6; i++) {
            walls[i] = 1;
            towers[i] = 1;
        }
    }

    /**
     * A method to make the targeted wall section take a hit. This reduces the
     * wall's HP by 1.
     *
     * @param wallNumber The number representing which wall takes the hit.
     * Should be between 1 and 6.
     */
    public void hitWall(int wallNumber) {
        if (wallNumber < 1 || wallNumber > 6) {
            System.err.println("Wall Number " + wallNumber + " does not exist. Only walls 1-6 exist.");
        } else if (walls[wallNumber] == 2) {
            walls[wallNumber]--;
        } else if (walls[wallNumber] == 1) {
            walls[wallNumber] =5;
        } else {
            System.err.println("Wall Number " + wallNumber + " has " + walls[wallNumber] + " hitpoints.");
        }
    }
    /**
     * 
     */
    public void clearRubble(){
        for (int i =0; i<walls.length;i++) {
            if (walls[i] == 5) {
                walls[i] = 0;
            }
        }
    }
    
    public void clearTowerRubble(){
        for (int i =0; i<towers.length;i++) {
            if (towers[i] == -1) {
                towers[i] = 0;
            }
        }
    }
    /**
     * Gets the current health of the given wall section.
     *
     * @param wallNumber The number representing which wall to get the health
     * of. Should be a number between 1 and 6.
     * @return The number of HP this wall has left, or 5 if in rubble state.
     */
    public int getWallHealth(int wallNumber) {
        if (wallNumber < 1 || wallNumber > 6) {
            System.err.println("Wall Number " + wallNumber + " does not exist. Only walls 1-6 exist.");
            return -1;
        } else if (walls[wallNumber] == 0 || walls[wallNumber] == 1 || walls[wallNumber] == 2 || walls[wallNumber]==5) {
            return walls[wallNumber];
        } else {
            System.err.println("Wall Number " + wallNumber + " has " + walls[wallNumber] + " hitpoints.");
            return -2;
        }
    }

    /**
     * Adds one to a given wall's health. Done by playing a reinforce card.
     *
     * @param wallNumber The wall section to be reinforced. Should be a number
     * between 1 and 6.
     */
    public void reinforceWall(int wallNumber) {
        if (wallNumber < 1 || wallNumber > 6) {
            System.err.println("Wall Number " + wallNumber + " does not exist. Only walls 1-6 exist.");
        } else if (walls[wallNumber] == 1) {
            walls[wallNumber]++;
        } else {
            System.err.println("Wall Number " + wallNumber + " has " + walls[wallNumber] + " hitpoints.");
        }
    }

    /**
     * Rebuilds a destroyed wall section. Checks to see if a wall is destroyed,
     * and rebuilds it if so.
     *
     * @param wallNumber The wall section to be rebuilt. Should be a number
     * between 1 and 6.
     */
    public void rebuildWall(int wallNumber) {
        if (wallNumber < 1 || wallNumber > 6) {
            System.err.println("Wall Number " + wallNumber + " does not exist. Only walls 1-6 exist.");
        } else if (walls[wallNumber] == 0) {
            walls[wallNumber]++;
        } else {
            System.err.println("Wall Number " + wallNumber + " has " + walls[wallNumber] + " hitpoints.");
        }
    }

    /**
     * A method to make a tower take a hit. Towers have one HP and are destroyed
     * upon taking any damage. Their boolean representation is set to false when
     * they are destroyed.
     *
     * @param towerNumber The specific tower to take a hit. Should be a number
     * between 1 and 6.
     */
    public void hitTower(int towerNumber) {
        if (towerNumber < 1 || towerNumber > 6) {
            System.err.println("Tower Number " + towerNumber + " does not exist. Only tower 1-6 exist.");
        } else if (towers[towerNumber] == TOWER_STANDING) {
            towers[towerNumber] = TOWER_RUBBLE;
        } else if (towers[towerNumber] == TOWER_RUBBLE) {
            //empty case
            return;
        } else {
            System.err.println("Tower Number " + towerNumber + "already destroyed. He's dead, Jim....DEAD.");
        }
    }

    /**
     * Checks to see if the given tower is standing.
     *
     * @param towerNumber The specific tower to check the status of. Should be a
     * number between 1 and 6.
     * @return 0 if the tower is destroyed, 1 if the tower is standing, -1 if it's rubble
     */
    public int getTowerState(int towerNumber) {
        if (towerNumber < 1 || towerNumber > 6) {
            System.err.println("Tower Number " + towerNumber + " does not exist. Only tower 1-6 exist.");
            return 0;
        } else {
            return towers[towerNumber];
        }
    }

    /**
     * Checks if all towers are destroyed. If all towers are destroyed, the game
     * is over.
     *
     * @return True if the game is over (all towers down), false if there is at
     * least one tower standing.
     */
    public boolean areWeDeadYet() {
        if (towers[1] != 1 && towers[2] != 1 && towers[3] != 1 && towers[4] != 1 && towers[5] != 1 && towers[6] != 1) {
            return true; 
        } else {
            return false;
        }
    }
}
