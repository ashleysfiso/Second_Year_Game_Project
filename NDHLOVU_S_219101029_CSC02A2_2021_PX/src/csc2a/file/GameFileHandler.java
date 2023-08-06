/**
 * 
 */
package csc2a.file;

import java.io.File;

import java.io.IOException;

import java.util.Scanner;

/**
 * @author ASHLEY
 *
 */
public class GameFileHandler {
	private static int item;

	public static int readFile(File gameFile) {
		if (!gameFile.exists()) {
			System.out.println("Error opening file");
		}

		try (Scanner sc = new Scanner(gameFile)) {
			while (sc.hasNext()) {

				item = Integer.parseInt(sc.nextLine());

			}
			sc.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return item;

	}

	/**
	 * @return the item
	 */
	public static int getItem() {
		return item;
	}
}
