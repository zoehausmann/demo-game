package gameplay;

/**
 * Possible Action choices for each Move.
 * @author Zoë Hausmann
 */
public enum Action {
    PUNCH, // swing at your opponent
    KICK, // sweep your opponent
    SPECIAL, // unique attack
    DUCK, // counter a punch
    JUMP, // counter a kick
    BLOCK // blocks special attack
}