/**
 * 
 */
package csc2a.model;

import javafx.scene.paint.Color;

/**
 * @author ASHLEY
 *
 */
public class Player extends Objects {

	private Color c;
	private int w;
	private int h;
	private int r;
	private boolean isAlive;
	public Player(Color c, int x, int y, int w, int h,boolean b) {
		super(x, y);
		this.w = w;
		this.h = h;
		this.c = c;
		this.isAlive= b;
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
	 * @param c the c to set
	 */
	public void setC(Color c) {
		this.c = c;
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

}
