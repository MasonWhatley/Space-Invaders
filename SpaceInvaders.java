import java.util.ArrayList;

public class SpaceInvaders {
	
	private final static int NUM_IN_ROW = 4; 
	private final static int SPACING = 40;
	private final static int MAX_BULLETS = 2;
	private final static int BULLET_SPEED = 4;
	private final static int ALIEN_SPEED = 1;
	private final static int ALIEN_DROP = 10;
	private final static int ROW_SPACING = 25;
	private final static int NUM_ROWS = 5;
	private final static int HIT_DISTANCE = 20;
	private final static int LOSE_HEIGHT = -50;
	
	private ArrayList<Sprite> items;
	private ArrayList<Alien> aliens;
	private Ship ship;
	private boolean shipHit = false;
	private ArrayList<Bullet> bullets;
	private int height, width;
	private int currAlienSpeed = ALIEN_SPEED;
	
	public SpaceInvaders(int height, int width) {
		items = new ArrayList<Sprite>();
		bullets = new ArrayList<Bullet>();
		aliens = new ArrayList<Alien>();
		this.height = height;
		this.width = width;
		
		ship = new Ship( width/4, height - 60);
		items.add(ship);
		
		for (int row = 0; row < NUM_ROWS; row++) {
			for (int i = 0; i < NUM_IN_ROW; i++) {
				Alien a = new Alien(i*SPACING, 30 + row * ROW_SPACING);
				items.add(a);
				aliens.add(a);
			}
		}
	}
	
	private static int distance(int x1, int y1, int x2, int y2) {
		return (int)Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(y1-y2,2) ); 
	}
	
	private void checkCollision() {
		for (int i = bullets.size() - 1; i >= 0; i--) {
			Bullet bullet = bullets.get(i);
			boolean hit = false;
			// check who's bullet this is
			if (bullet.isPlayerBullet()) {
				for (int j = aliens.size() -1 ; j >= 0 && !hit; j--) {
					Alien alien = aliens.get(j);
					if (distance(bullet.getX(), bullet.getY(), alien.getX(), alien.getY()) < HIT_DISTANCE) {
						// remove both
						items.remove(alien);
						aliens.remove(j);
						hit = true;
					}
				}
				if(hit) {
					items.remove(bullet);
					bullets.remove(bullet);
				}
			}
			else {
				// this is an alien bullet. Check against ship location.
				if (distance( ship.getX(), ship.getY(), bullet.getX(), bullet.getY() ) < HIT_DISTANCE ) {
					// we lose!
					shipHit = true;
				}
			}
		}
	}
	
	public void update() {
		// move all the things!
		
		// is there an alien that would move out of the bounds?
		boolean switchDirection = false;
		for(Alien alien : aliens) {
			if (alien.getX() + currAlienSpeed > width || alien.getX() + currAlienSpeed < 0)
				switchDirection = true;
		}
		if (switchDirection)
			currAlienSpeed *= -1;
	
		for(Alien alien : aliens) {
			if (switchDirection)
				alien.move(alien.getX() + currAlienSpeed, alien.getY() + ALIEN_DROP);
			else
				alien.move(alien.getX() + currAlienSpeed, alien.getY());
			
			// should any aliens shoot?
			if (alien.shouldShoot()) {
				Bullet newBullet = new AlienZap(alien.getX(), alien.getY()); 
				bullets.add(newBullet);
				items.add(newBullet);
			}
		}
		
		// move any bullets, remove any that are off the screen
		for(int i = bullets.size() -1 ; i >= 0; i--) {
			Bullet bullet = bullets.get(i);
			if (bullet.getY() + bullet.getMoveAmount() > 0 && bullet.getY() + bullet.getMoveAmount() < height)
				bullet.move(bullet.getX(), bullet.getY() + bullet.getMoveAmount());
			else {
				items.remove(bullet);
				bullets.remove(i);
			}
			
		}
		

		
		checkCollision();
		
	}

	public ArrayList<Sprite> getItems() {
		return items;
	}
	public void shoot() {
		// add a bullet, if there is not MAX amount
		// count how many bullets are mine
		int count = 0;
		for (Bullet bill : bullets)
			if (bill.isPlayerBullet())
				count++;
		if (count < MAX_BULLETS) {
			Bullet newBullet = new ShipBullet(ship.getX(), ship.getY());
			bullets.add(newBullet);
			items.add(newBullet);
		}
		
	}
	
	public int status() {
		// if an alien gets to the bottom, we lose
		int result = Display.CONTINUE;
		int maxY = 0;
		
		// check if an alien is about to go out-of-bounds
		for (Alien a : aliens)
			if (a.getY() > maxY)
				maxY = a.getY();
		if (maxY >= this.height - LOSE_HEIGHT)
			result = Display.LOSE;
		if (aliens.size() == 0)
			result = Display.WIN;
		if (shipHit)
			result = Display.LOSE;
		return result;
	}
	
	public void move(int direction) {
		if (direction == Display.MOVE_LEFT)
			ship.moveLeft();
		if (direction == Display.MOVE_RIGHT)
			ship.moveRight();
	}

}
