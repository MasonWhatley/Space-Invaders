import java.awt.Color;

public class Ship extends Sprite {

	public static final int moveAmount = 4;
	

	
	public Ship(int startX, int startY) {
		super(startX, startY, Display.SHIP_SHAPE);
	}
	
	public void moveLeft() {
		this.move(this.getX() - moveAmount, this.getY());
	}
	
	public void moveRight() {
		this.move(this.getX() + moveAmount, this.getY());
	}
	
}
