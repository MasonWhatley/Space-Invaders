import java.awt.Color;

/*
 * Superclass to capture all the bullets.
 */
public class Bullet extends Sprite {

	private int moveAmount;
	private boolean playerBullet = true;
	
	public Bullet(int startX, int startY, Color[][] display, boolean player, int move) {
		super(startX, startY, display);
		playerBullet = player;
		moveAmount = move;
	}
	
	public int getMoveAmount() {
		return moveAmount;
	}
	
	public boolean isPlayerBullet() {
		return playerBullet;
	}

}
