package pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Pizza {
	
	
	
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
					cells[i][j] = new Cell(temp.charAt(j));
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
	
	private class Cell{
		private final static char MUSHROOM = 'M';
		private final static char TOMATO = 'T';
		
		
		private int type;
		
		Cell(){
			
		}
		
		Cell(char type) {
			if(type == MUSHROOM || type == TOMATO) {
				this.type = type; 
			}
		}
		

		public int getType() {
			return type;
		}

		public void setType(int type) {
			if(type == Cell.MUSHROOM || type == Cell.TOMATO)
				this.type = type;
		}
		
		
	}
	
	private class Slice{
		private int rows;
		private int columns;
		private int cells;
		private int L;
		private int H;
		private boolean overlap;
		
		private void Slice(int leastCells, int highestCells) {
			this.L=leastCells;
			this.H=highestCells;
		}
		private void setRows(int rows) {
			this.rows=rows;
		}
		private void setColumns(int columns) {
			this.columns = columns;
		}
		//this may change kappa
		private boolean checkSliceOverlap() {
			if(rows>2 || columns>2 || cells<L || cells>H ) {
				overlap=true;
			}
			return overlap;
		}
		//overlap may need to get smarter!!!
	}
	
	
	public static void main(String[] args) {
		Pizza pizza = new Pizza();
		pizza.readFromFile("data/example.in");
	}
}
