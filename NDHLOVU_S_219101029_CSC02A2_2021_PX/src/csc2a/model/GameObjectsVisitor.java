/**
 * 
 */
package csc2a.model;

/**
 * @author ASHLEY
 *
 */
public interface GameObjectsVisitor {

	/**
	 * @param bullet
	 */
	public void print(Bullet bullet);
	public void print(Player player);
	public void print(Enemy enemy);
}
