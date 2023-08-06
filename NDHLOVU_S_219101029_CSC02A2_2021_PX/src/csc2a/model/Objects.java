/**
 * 
 */
package csc2a.model;



/**
 * @author ASHLEY
 *
 */
public abstract class Objects implements GameObjects {
	

	protected int x;
	protected int y;
	Objects(int x , int y){
		this.x = x;
		this.y = y;
		
	}
	/**
	 * @return the c
	 */

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
		  
}
