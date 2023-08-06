
import java.io.File;
import java.util.ArrayList;
import csc2a.abstructFactory.ObjectFactory;
import csc2a.abstructFactory.ObjectProducer;
import csc2a.file.GameFileHandler;
import csc2a.gui.GameCanvas;
import csc2a.gui.GamePane;
import csc2a.model.Bullet;
import csc2a.model.Enemy;
import csc2a.model.Enum;
import csc2a.model.Objects;
import csc2a.model.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 */

/**
 * @author SIFISO NDHLOVU
 * @version PracticalXx
 *
 */
public class Main extends Application {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ObjectFactory factory = new ObjectProducer(); // object factory to instantiate game objects
		ArrayList<Objects> objects = new ArrayList<>();
		GamePane gamePane = factory.ProducegamePane();
		GameCanvas canvas = new GameCanvas();
		MenuBar mBar = new MenuBar();
		//instantiating menu bar 
		Menu fileMenu = new Menu("New Game");
		Menu fileMenu2 = new Menu("Help");
		MenuItem openMenuItem = new MenuItem("Level");
		MenuItem openInstructions = new MenuItem("Instructions");
		fileMenu.getItems().addAll(openMenuItem);
		fileMenu2.getItems().addAll(openInstructions);
		
		mBar.getMenus().addAll(fileMenu,fileMenu2);
		HBox layout = new HBox();
		layout.getChildren().addAll(mBar);
		
		BorderPane root = new BorderPane();
		StackPane pane = new StackPane();
		root.setCenter(canvas);
		root.setTop(layout);
		pane.getChildren().add(root);
		Scene scene = new Scene(pane, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		//Adding action Listener For opening Instructions
		fileMenu2.setOnAction(e -> {
			Text text = new Text("Enemies Have Arrived In Utopia You Must Kill Them \nBefore They Colonize Your Planet "
					+ "Use the following \nKeys To Play:\n \n"
					+ "W: move up\n \n"
					+ "S: move down\n \n"
					+ "D: move right\n \n"
					+ "A: move left\n \n"
					+ "Space: Shoot");
			text.setStroke(Color.AQUAMARINE);
			
			text.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,20));
			root.setCenter(text);
		});
		//Action Listener to start the game
		openMenuItem.setOnAction(e -> {
			root.setCenter(canvas);
			final FileChooser chooser = new FileChooser();
			chooser.setTitle("Select a File");
			chooser.setInitialDirectory(new File("data"));
			File file = chooser.showOpenDialog(null);
			if (file != null) {
				int level = GameFileHandler.readFile(file);
				//abstract factory to create player
				Player player = (Player) factory.Produceplayer(Color.GREEN, 290, 560, 20, 20, true);
				//instantiating enemy objects
				Enemy enemy = gamePane.CreateEnemies(0);
				Enemy enemy2 = gamePane.CreateEnemies(80);
				Enemy enemy7 = gamePane.CreateEnemies(160);
				Enemy enemy3 = gamePane.CreateEnemies(240);
				Enemy enemy4 = gamePane.CreateEnemies(320);
				Enemy enemy5 = gamePane.CreateEnemies(400);
				Enemy enemy6 = gamePane.CreateEnemies(480);
				//adding each enemy to the araay of game object
				objects.add(enemy);
				objects.add(enemy2);
				objects.add(enemy3);
				objects.add(enemy4);
				objects.add(enemy5);
				objects.add(enemy6);
				objects.add(enemy7);
				objects.add(player);
				canvas.setArray(objects);
				AnimationTimer timer = new AnimationTimer() {

					int d = -1;

					@Override
					public void handle(long now) {

						gamePane.EnemyCollision(objects, enemy);
						//ActionListiner for movements
						scene.setOnKeyPressed(e -> {
							if (e.getCode() == KeyCode.D) {

								int i = player.getX();
								if (i >= 580) {

								} else {

									i = i + 15;
									player.setX(i);
									canvas.setArray(objects);
								}
							}
							if (e.getCode() == KeyCode.A) {

								int i = player.getX();
								if (i <= 0) {

								} else {

									i = i - 15;
									player.setX(i);
									canvas.setArray(objects);
								}
							}
							if (e.getCode() == KeyCode.W) {
								int i = player.getY();
								if (i <= 0) {

								} else {
									d = -1;
									i = i - 20;
									player.setY(i);
									canvas.setArray(objects);
								}
							}
							if (e.getCode() == KeyCode.S) {

								int i = player.getY();
								if (i >= 560) {

								} else {

									i = i + 20;
									player.setY(i);
									canvas.setArray(objects);
								}
							}
							if (e.getCode() == KeyCode.SPACE) {
								if (!player.isAlive()) {
									System.out.println("GAME OVER");
								} else {
									Bullet bullet = gamePane.Shoot((player.getX() + (player.getW() / 2)), player.getY(),
											Enum.player, d);
									objects.add(bullet);
								}
								canvas.setArray(objects);

							}

							System.out.println(e.getCode());
						});
						//checking if an enemy is colliding with a bullet 
						gamePane.EnemyCollision(objects, enemy);
						gamePane.EnemyCollision(objects, enemy2);
						gamePane.EnemyCollision(objects, enemy3);
						gamePane.EnemyCollision(objects, enemy4);
						gamePane.EnemyCollision(objects, enemy5);
						gamePane.EnemyCollision(objects, enemy6);
						gamePane.EnemyCollision(objects, enemy7);
						//checking if all enemies are dead
						gamePane.EnemyShot(enemy, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7, objects, level);
						if ((!enemy.isAlive()) && (!enemy2.isAlive()) && (!enemy3.isAlive()) && (!enemy4.isAlive())
								&& (!enemy5.isAlive()) && (!enemy6.isAlive()) && (!enemy7.isAlive())) {
							Text text = new Text("YOU WON");
							text.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,70));
							root.setCenter(text);
							//System.out.println("YOU WON!!");

						}
						//Checking if a player is still Alive
						if(!player.isAlive()) {
							Text text = new Text("GAME OVER");
							text.setFont(Font.font("verdana",FontWeight.BOLD,FontPosture.REGULAR,70));
							root.setCenter(text);
						}
						//checking collision of a bullet and a player
						gamePane.PlayerCollision(objects, player);
						canvas.setArray(objects);
					}
				};
				timer.start();
				System.out.println(level);
			}

		});
	}
}
