/**
 * 
 */
package csc2a.model;

import javafx.scene.paint.Color;

/**
 * @author ASHLEY
 *
 */
public class Enemy extends Objects {

	private int w;
	private Color c;
	private int h;
	boolean isAlive;

	

	public Enemy(Color c, int x, int y, int w, int h,boolean t) {
		super(x, y);
		this.w = w;
		this.h = h;
		this.c = c;
		this.isAlive = t;
	}

	@Override
	public void accepts(GameObjectsVisitor gameobjectvisitor) {
		gameobjectvisitor.print(this);
	}
	

	/**
	 * @return the c
	 */
	public Color getC() {
		return c;
	}

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Color c) {
		this.c = c;
	}

	/**
	 * @return the w
	 */
	public int getW() {
		return w;
	}

	/**
	 * @param w the w to set
	 */
	public void setW(int w) {
		this.w = w;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}
	public void Shoot() {
		this.y = y+10;
	}
	
}
