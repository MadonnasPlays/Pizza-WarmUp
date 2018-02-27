package pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Pizza {
	
	//maddonas push test
	
	private int rows;
	private int columns; 
	private int L;
	private int H;
	
	private Cell[][] cells;
	
	
	Pizza(){}
	
	private void readFromFile(String fileName) {
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			this.rows = scanner.nextInt();
			this.columns = scanner.nextInt();
			this.L = scanner.nextInt();
			this.H = scanner.nextInt();
			scanner.skip("\n");
			
			cells = new Cell[rows][columns];
			
			for(int i =0 ; i < rows; i++){
				
				String temp = scanner.nextLine();
				System.out.println(temp);
				for(int j=0;j < columns; j++) {
					cells[i][j] = new Cell(temp.charAt(j),i,j);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not found!");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Wrong File format");
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		Pizza pizza = new Pizza();
		pizza.readFromFile("data/example.in");
	}
}
