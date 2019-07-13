import java.awt.Color;

public class ShipBullet extends Bullet {

	private static final int MOVE_AMOUNT = -4;

	public static final Color display [][]= {
			{Display.BLACK},
			{Display.BLACK},
			{Display.BLACK},
			{Display.BLACK},
	};
	public ShipBullet(int startX, int startY) {
		super(startX, startY, display, true, MOVE_AMOUNT);
	}

}
