import java.awt.Color;


public class Sprite {

	private int x;
	private int y;
	
	private Color [][] display;
	
	public Sprite(int startX, int startY, Color [][] display) {
		x = startX;
		y = startY;
		// make a deep copy (had to do this so they could all have different colours
		
		this.display = new Color[display.length][] ;
		for (int i = 0; i<display.length; i++) {
			this.display[i] = new Color[display[i].length];
			for(int j = 0; j < display[i].length; j++)
				if (display[i][j] != null)
					this.display[i][j] = display[i][j];
		}
	}
	
	public void move (int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public Color[][] getColorGrid(){
		return display;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	// for fun
	public void setColor(Color newColour) {
		for (int i = 0; i<display.length; i++)
			for(int j = 0; j < display[i].length; j++)
				if (display[i][j] != null)
					display[i][j] = newColour;
	}
	
}
