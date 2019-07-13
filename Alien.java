import java.awt.Color;

public class Alien extends Sprite{
	
	private static final double randomShootChance = 0.001;
	
	private static final Color g_red = new Color(78, 26, 13);
	private static final Color black = new Color(0, 0, 0);
	private static final Color g_yellow = new Color(248, 192, 128);

	public static final Color [][] g_shape = {
			{null, null, null, null, null, null, g_red,g_red,g_red,g_red, null, null, null, null, null, null },
			{null, null, null, null, null, g_red, g_red,g_red,g_red,g_red, g_red, null, null, null, null, null },
			{null, null, null, null, g_red, g_red, g_red,g_red,g_red,g_red, g_red, g_red, null, null, null, null },
			{null, null, null, g_red, g_red, g_red, g_red,g_red,g_red,g_red, g_red, g_red, g_red, null, null, null },
			{null, null, g_red, black, black, g_red, g_red,g_red,g_red,g_red, g_red, black, black, g_red, null, null },
			{null,  g_red, g_red, g_red, g_yellow, black, g_red, g_red, g_red, g_red, black, g_yellow, g_red, g_red, g_red, null},
			{null,  g_red, g_red, g_red, g_yellow, black, black,black,black,black, black, g_yellow, g_red, g_red, g_red, null},
			{g_red,  g_red, g_red, g_red, g_yellow, black, g_yellow, g_red, g_red, g_yellow, black, g_yellow, g_red, g_red, g_red, g_red},
			{g_red,  g_red, g_red, g_red, g_yellow, g_yellow, g_yellow, g_red, g_red, g_yellow, g_yellow, g_yellow, g_red, g_red, g_red, g_red},
			{g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red,g_red},
			{null, g_red, g_red, g_red, g_red, g_yellow, g_yellow,g_yellow,g_yellow,g_yellow,g_yellow, g_red,g_red,g_red,g_red,null},
			{null, null, null, null, g_yellow,g_yellow,g_yellow,g_yellow,g_yellow,g_yellow,g_yellow,g_yellow, null, null, null, null},
			{null, null, null, null,  g_yellow,g_yellow,g_yellow,g_yellow,g_yellow,g_yellow,g_yellow,g_yellow, black, black, null, null},
			{null,null,null, black, black,g_yellow,g_yellow,g_yellow,g_yellow,g_yellow,  black,black,black,black,black, null},
			{null,null,null, black,black,black,g_yellow,g_yellow,g_yellow, black,black,black,black,black, null},
			{null,null,null,null, black, black, black, g_yellow,g_yellow, black,black,black,black,black,null,null}
	};
	


	public static final Color[] choices = {Display.RED, Display.GREEN, Display.BLUE};
	
	public static Color chooseColour() {
		return choices[(int)(Math.random() * choices.length)];
	}

	public Alien(int startX, int startY) {
		super(startX, startY, g_shape);
		// take the alien shape, replace colours for fun
		//this.setColor(chooseColour());
	}
	
	public boolean shouldShoot() {
		return Math.random() < randomShootChance;
	}
}

