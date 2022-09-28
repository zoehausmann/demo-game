package gameplay;

import character.GameCharacter;
import manager.GameManager;

public class GLOBALS {
    /** Game name */
    public static final String GAME_NAME = "Demo Game";
    /** Number of actions per turn */
    public static final int ACTIONS = 5;
    /** Number of turns per game */
    public static final int TURNS = 10;
    private static GameCharacter npc;
    private static GameCharacter player;
    private static int turnCount = 0;

   public GLOBALS(GameCharacter npc, GameCharacter player) {
       this.npc = npc;
       this.player = player;
   }
    public static GameCharacter getNPC() {  return npc; }
    public static GameCharacter getPlayer() {  return player; }
    public static int getTurnCount() { return turnCount; }
    public static void incrementTurnCount() { turnCount++; }
}
