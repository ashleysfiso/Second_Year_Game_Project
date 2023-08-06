/**
 * 
 */
package csc2a.gui;

import java.util.ArrayList;

import csc2a.model.Bullet;
import csc2a.model.Enum;
import csc2a.model.GameObjectPrintVisitor;
import csc2a.model.Objects;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


/**
 * @author ASHLEY
 *
 */
public class GameCanvas extends StackPane {

	//Initializing variables
	private ArrayList<Objects> objects;
	private GameObjectPrintVisitor visitor;
	private Canvas canvas;
	GraphicsContext gc;
	
	public GameCanvas() {
		
		this.getBackground();
		canvas = new Canvas(600, 600);
		gc = canvas.getGraphicsContext2D();

		canvas.widthProperty().bind(this.widthProperty());
		canvas.heightProperty().bind(this.heightProperty());
		this.getChildren().add(canvas);
		objects = new ArrayList<>();
		visitor = new GameObjectPrintVisitor();

	}
	//setting array list of objects
	public void setArray(ArrayList<Objects> objects) {
		this.objects = objects;
		redrawCanvas();
	}
	//drawing game objects to the canvas

	public void redrawCanvas() {
		gc.clearRect(0, 0, this.getWidth(), this.getHeight());
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
		visitor.setGraphicContext(gc);
		for (Objects i : objects) {
			if (i instanceof Bullet) {
				if (((Bullet) i).getType() == Enum.player) {
					int d = ((Bullet) i).getDirection();
					
					((Bullet) i).Shoot(10*d);
				}else {
					((Bullet) i).Shoot(10);
				}
			}
			i.accepts(visitor);
		}
	}
}
