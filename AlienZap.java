import java.awt.Color;
public class AlienZap extends Bullet {

	private static final int MOVE_AMOUNT = 4;
	private static final Color gb_black = new Color(0, 56, 68);
	private static final Color gb_brown = new Color(228, 145, 31);
	private static final Color gb_pink = new Color(255, 199, 191);
	public static final Color [][] display = {
			{null, gb_black, gb_brown, gb_brown, gb_brown, gb_brown, gb_black, null},
			{gb_black, gb_black,gb_black,gb_black,gb_black,gb_brown,gb_brown, gb_black},
			{gb_black, gb_brown, gb_black, gb_brown, gb_black,  gb_brown, gb_brown, gb_black},
			{gb_black, gb_brown,gb_brown,gb_brown,gb_brown,gb_brown,gb_brown,gb_black},
			{null,gb_black,gb_black,gb_black,gb_black,gb_black,gb_black,null},
			{null,gb_black,gb_pink,gb_pink,gb_pink,gb_pink,gb_black,null},
			{gb_black,gb_black,gb_black,gb_black,gb_black,gb_black,gb_black,gb_black},
			{gb_black,gb_black,gb_black,gb_black,null,gb_black,gb_black,gb_black,}
	};


	public AlienZap(int startX, int startY) {
		super(startX, startY, display, false, MOVE_AMOUNT);
	}

}
