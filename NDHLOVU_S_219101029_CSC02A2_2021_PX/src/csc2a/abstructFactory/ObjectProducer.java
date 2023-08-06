/**
 * 
 */
package csc2a.abstructFactory;

import csc2a.gui.GamePane;
import csc2a.model.Bullet;
import csc2a.model.Enemy;
import csc2a.model.Enum;
import csc2a.model.GameObjects;
import csc2a.model.Player;
import javafx.scene.paint.Color;

/**
 * @author ASHLEY
 *
 */
public class ObjectProducer implements ObjectFactory {

	@Override
	public GameObjects Produceplayer(Color c, int x, int y, int w, int h, boolean b) {
		return new Player(c, x, y, w, h, b);
	}

	@Override
	public GameObjects Produceenemy(Color c, int x, int y, int w, int h, boolean b) {
		return new Enemy(c, x, y, w, h, b);
	}

	@Override
	public GameObjects Producebullet(Color c, int x, int y, int r, Enum t, int d) {

		return new Bullet(c, x, y, r, t, d);
	}

	@Override
	public GamePane ProducegamePane() {

		return new GamePane();
	}

}
