/**
 * 
 */
package csc2a.model;

import javafx.scene.canvas.GraphicsContext;

/**
 * @author ASHLEY
 *
 */
public class GameObjectPrintVisitor implements GameObjectsVisitor{
	
	GraphicsContext gc;
	
	public void setGraphicContext(GraphicsContext gc)
	{
		this.gc = gc;
	}

	@Override
	public void print(Bullet bullet) {
		gc.setFill(bullet.getC());
		gc.fillOval(bullet.x,bullet.y, bullet.getR()*2,bullet.getR()*2);
	}

	@Override
	public void print(Player player) {
		gc.setFill(player.getC());
		gc.fillRect(player.getX(), player.getY(),player.getW(),player.getH());
	}

	@Override
	public void print(Enemy enemy) {
		
		gc.setFill(enemy.getC());
		gc.fillRect(enemy.getX(), enemy.getY(),enemy.getW(),enemy.getH());
		
	}

}
