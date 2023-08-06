/**
 * 
 */
package csc2a.abstructFactory;

import csc2a.gui.GamePane;
import csc2a.model.Enum;
import csc2a.model.GameObjects;
import javafx.scene.paint.Color;

/**
 * @author ASHLEY
 *
 */
public abstract interface ObjectFactory {
	public abstract GameObjects Produceplayer(Color c, int x, int y, int w, int h,boolean b);
	public abstract GameObjects Produceenemy(Color c, int x, int y, int w, int h,boolean b);
	public abstract GamePane ProducegamePane();
	GameObjects Producebullet(Color c, int x, int y, int r, Enum t, int dir);

}
