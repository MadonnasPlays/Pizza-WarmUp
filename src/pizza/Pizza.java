package pizza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
	
	//maddonas push test
	
	private int rows;
	private int columns; 
	private int L;
	private int H;
	private int numberOfTomatos;
	private int numberOfMushrooms;
	private char less;
	private Cell[][] cells;
	
	private ArrayList<Slice> slices;
	
	Pizza(){
		slices = new ArrayList<Slice>();
	}
	
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
				//System.out.println(temp);
				for(int j=0;j < columns; j++) {
					char type = temp.charAt(j);
					
					if(type == Cell.TOMATO) numberOfTomatos++;
					if(type == Cell.MUSHROOM) numberOfMushrooms++;
					
					cells[i][j] = new Cell(type, i, j);
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
	
	private boolean findNextAvailable() {
		for(int i =0 ; i < rows; i++){
			for(int j=0;j < columns; j++) {
				if(cells[i][j].getType() != calcLess() || cells[i][j].isUsed()) continue;
				
				Slice slice = new Slice(L,H);
				slice.addCell(cells[i][j], this);
				slice.zergSlice(this);
				slices.add(slice);
				return true;
			}
		}
		return false;
	}
	
	public char calcLess() {
		if(numberOfTomatos < numberOfMushrooms)  return Cell.TOMATO;
		return Cell.MUSHROOM;
	}
	
	public Cell getCell(int i,int j) {
		if(i < rows && i>= 0 && j < columns && j >=0 ) return cells[i][j];
		System.out.println("Cell out of bounds!");
		return null;
	}
	
	public void printMap() {
		System.out.println(slices.size());
		for(int i =0 ; i < slices.size();i++) {
			System.out.println((slices.get(i)).getString());
		}
	}
	
	
	public static void main(String[] args) {
		Pizza pizza = new Pizza();
		pizza.readFromFile("data/example.in");
		pizza.findNextAvailable();
		pizza.printMap();
	}
}
