/**
 * 
 */
package csc2a.model;

import javafx.scene.paint.Color;

/**
 * @author ASHLEY
 *
 */
public class Bullet extends Objects {
	private Color c;
	private int r;
	private int direction;
	Enum type; 
	public Bullet(Color c, int x, int y, int r,Enum t,int d) {
		super(x, y);
		this.c = c;
		this.r = r;
		this.type = t;
		this.direction = d;
	}

	

	@Override
	public void accepts(GameObjectsVisitor gameobjectvisitor) {
		// TODO Auto-generated method stub
		gameobjectvisitor.print(this);
	}


	/**
	 * @return the direction
	 */
	public int getDirection() {
		return direction;
	}



	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}



	public void Shoot(int s) {
		this.y = y+s;
	}
	/**
	 * @return the c
	 */
	public Color getC() {
		return c;
	}



	/**
	 * @param c the c to set
	 */
	public void setC(Color c) {
		this.c = c;
	}



	/**
	 * @return the r
	 */
	public int getR() {
		return r;
	}



	/**
	 * @param r the r to set
	 */
	public void setR(int r) {
		this.r = r;
	}



	/**
	 * @return the type
	 */
	public Enum getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(Enum type) {
		this.type = type;
	}



	/**
	 * @return
	 */
	public int getRadius() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
