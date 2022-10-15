package gameplay;

import character.GameCharacter;
import manager.GameManager;

import java.awt.*;

public class GLOBALS {
    /** Game name */
    public static final String GAME_NAME = "Mastermind";
    /** Number of actions per turn */
    public static final int ACTIONS = 5;
    /** Number of turns per game */
    public static final int TURNS = 10;
    private static GameCharacter npc;
    private static GameCharacter player;
    private static int turnCount = 0;
    /** Default game character data */
    private final String DEFAULT_CHARS= "game-files/default-characters";
    /** User-created character data */
    private final String USER_CHARS= "game-files/user-characters";
    public static final Color BG_COLOR = new Color(30,30,45);
    public static final Color FG_COLOR = new Color(200,200,220);

    public GLOBALS(GameCharacter npc, GameCharacter player) {
       this.npc = npc;
       this.player = player;
   }
    public static GameCharacter getNPC() {  return npc; }
    public static GameCharacter getPlayer() {  return player; }
    public static int getTurnCount() { return turnCount; }
    public static void incrementTurnCount() { turnCount++; }
    public static void resetTurnCount() { turnCount = 0; }
}
