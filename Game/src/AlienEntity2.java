/**
 * An entity which represents one of our aliens.
 *
 * @author Divyanshu
 */
public class AlienEntity2 extends Entity2 {
	/** The speed at which the alien moves horizontally */
	private double moveSpeed = 75;
	/** The game in which the entity exists */
	private Game2 game;

	/**
	 * Create a new alien entity
	 *
	 * @param game The game in which this entity is being created
	 * @param ref The sprite which should be displayed for this alien
	 * @param x The initial x location of this alien
	 * @param y The initial y location of this alien
	 */
	public AlienEntity2(Game2 game,String ref,int x,int y) {
		super(ref,x,y);

		this.game = game;
		dx = -moveSpeed;
	}

	/**
	 * Request that this alien moved based on time elapsed
	 *
	 * @param delta The time that has elapsed since last move
	 */
	public void move(long delta) {
		// if we have reached the left hand side of the screen and
		// are moving left then request a logic update
		if ((dx < 0) && (x < 10)) {
			game.updateLogic();
		}
		// and vice vesa, if we have reached the right hand side of
		// the screen and are moving right, request a logic update
		if ((dx > 0) && (x > 750)) {
			game.updateLogic();
		}

		// proceed with normal move
		super.move(delta);
	}

	/**
	 * Update the game logic related to aliens
	 */
	public void doLogic() {
		// swap over horizontal movement and move down the
		// screen a bit
		dx = -dx;
		y += 10;

		// if we've reached the bottom of the screen then the player
		// dies
		if (y > 570) {
			game.notifyDeath();
		}
	}

	/**
	 * Notification that this alien has collided with another entity
	 *
	 * @param other The other entity
	 */
	public void collidedWith(Entity2 other) {
		// collisions with aliens are handled elsewhere
	}
}