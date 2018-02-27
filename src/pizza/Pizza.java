package pizza;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Pizza {
	
	
	
	private int rows;
	private int columns; 
	private int L;
	private int H;
	
	private Cell[] cells;
	
	
	Pizza(){}
	
	private void readFromFile(String fileName) {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
		
			this.rows = in.read();
			this.columns = in.read();
		
		} catch (FileNotFoundException e) {
			System.out.println("File Not found!");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("Wrong File format");
			e.printStackTrace();
		}
		
	}
	
	private class Cell{
		private final static int MUSHROOM = 1;
		private final static int TOMATO = 2;
		
		
		private int type;
		
		Cell(){
			type = 0;
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
}
