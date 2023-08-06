/**
 * 
 */
package csc2a.gui;

import java.util.ArrayList;

import csc2a.abstructFactory.ObjectFactory;
import csc2a.abstructFactory.ObjectProducer;
import csc2a.model.Bullet;
import csc2a.model.Enemy;
import csc2a.model.Enum;
import csc2a.model.Objects;
import csc2a.model.Player;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Random;

/**
 * @author SIFISO NDHLOVU
 *
 */
public class GamePane {
	ArrayList<Objects> objects;
	ArrayList<Bullet> bullets;
	ObjectFactory factory;
	GameCanvas canvas;
	Random random = new Random();

	int Speed = 10;

	/**
	 * 
	 */
	public GamePane() {
		objects = new ArrayList<>();
		canvas = new GameCanvas();
		factory = new ObjectProducer();
		bullets = new ArrayList<>();

	}

// Method to shoot a bullet
	public Bullet Shoot(int x, int y, Enum t, int d) {
		return (Bullet) factory.Producebullet(Color.BLUE, x, y, 5, t, d);
	}

	// creating enemies using abstract factory
	public Enemy CreateEnemies(int x) {
		return (Enemy) factory.Produceenemy(Color.RED, x, 90, 30, 25, true);
	}

	// random number generator
	public int getRandom(int r) {
		return random.nextInt(r);
	}

	//method to check if a player is colliding with a bullet
	public ArrayList<Objects> EnemyCollision(ArrayList<Objects> objects, Enemy enemy) {

		for (Objects i : objects) {
			if (i instanceof Bullet) {
				if (((Bullet) i).getType() == Enum.player && i.getY() == (((Objects) enemy).getY())
						&& i.getX() >= ((Objects) enemy).getX()
						&& i.getX() <= ((((Objects) enemy).getX() - 10) + (((Enemy) enemy).getW() + 10))) {
					enemy.setAlive(false);
					objects.remove(enemy);
					objects.remove(i);
					System.out.println("AN ENEMY IS KILLED ");
					return objects;
				}
			}
		}

		return objects;

	}
	
	public ArrayList<Objects> PlayerCollision(ArrayList<Objects> objects, Player player) {
		for (Objects i : objects) {
			if (i instanceof Bullet) {
				if (((Bullet) i).getType() == Enum.enemy && i.getY() == (player.getY()) && i.getX() >= player.getX()
						&& i.getX() <= (player.getX() + player.getW())) {
					player.setAlive(false);
					objects.remove(player);
					Text text = new Text("GAME OVER");
					text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

					return objects;
				}
			}

		}
		return objects;

	}
	
	public ArrayList<Objects> EnemyShot(Enemy enemy, Enemy enemy2, Enemy enemy3, Enemy enemy4, Enemy enemy5,
			Enemy enemy6, Enemy enemy7, ArrayList<Objects> objects, int level) {
		Bullet bulllet1 = Shoot(enemy.getX(), enemy.getY(), Enum.enemy, 1);
		Bullet bulllet2 = Shoot(enemy2.getX(), enemy2.getY(), Enum.enemy, 1);
		Bullet bulllet3 = Shoot(enemy3.getX(), enemy3.getY(), Enum.enemy, 1);
		Bullet bulllet4 = Shoot(enemy4.getX(), enemy4.getY(), Enum.enemy, 1);
		Bullet bulllet5 = Shoot(enemy5.getX(), enemy5.getY(), Enum.enemy, 1);
		Bullet bulllet6 = Shoot(enemy6.getX(), enemy6.getY(), Enum.enemy, 1);
		Bullet bulllet7 = Shoot(enemy7.getX(), enemy7.getY(), Enum.enemy, 1);

		if (getRandom(level) <= 10) {
			if (!enemy.isAlive()) {

			} else {
				objects.add(bulllet1);
				return objects;
			}
			return objects;
		}
		if (getRandom(level) < 3) {
			if (!enemy2.isAlive()) {

			} else {
				objects.add(bulllet2);
				return objects;
			}
			return objects;
		}
		if (getRandom(level) < 9) {
			if (!enemy3.isAlive()) {

			} else {
				objects.add(bulllet3);
				return objects;
			}
			return objects;
		}

		if (getRandom(level) < 5) {

			if (!enemy4.isAlive()) {

			} else {
				objects.add(bulllet4);
				return objects;
			}
			return objects;
		}
		if (getRandom(level) <= 40) {
			if (!enemy5.isAlive()) {

			} else {
				objects.add(bulllet5);
				return objects;
			}
			return objects;
		}
		if (getRandom(level) <= 50) {
			if (!enemy6.isAlive()) {

			} else {
				objects.add(bulllet6);
				return objects;
			}
			return objects;
		}
		if (getRandom(level) <= 90) {
			if (!enemy7.isAlive()) {

			} else {
				objects.add(bulllet7);
				return objects;
			}
			return objects;
		}

		return objects;

	}

}
