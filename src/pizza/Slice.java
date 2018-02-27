package pizza;

import java.util.ArrayList;

public class Slice{
	private int upperRow,leftColumn,lowerRow,rightColumn;
	
	
	private ArrayList<Cell> cells;
	
	private int remainingTomatos;
	private int remainingMushrooms;
	private int totalCells;
	
	public int getUpperRow() {
		return upperRow;
	}



	public void setUpperRow(int upperRow) {
		this.upperRow = upperRow;
	}



	public int getLeftColumn() {
		return leftColumn;
	}



	public void setLeftColumn(int leftColumn) {
		this.leftColumn = leftColumn;
	}



	public int getLowerRow() {
		return lowerRow;
	}



	public void setLowerRow(int lowerRow) {
		this.lowerRow = lowerRow;
	}



	public int getRightColumn() {
		return rightColumn;
	}



	public void setRightColumn(int rightColumn) {
		this.rightColumn = rightColumn;
	}



	public void addFirstSlice(int upperRow, int leftColumn, int lowerRow, int rightColumn) {
		this.upperRow = upperRow;
		this.leftColumn = leftColumn;
		this.lowerRow = lowerRow;
		this.rightColumn = rightColumn;
	}

	public Slice(int l , int h) {
		cells = new ArrayList<>();
		remainingTomatos = l;
		remainingMushrooms= l;
		totalCells =h;
	}
	
	


	public boolean addCell(Cell cell,Pizza pizza) {
		
		if(cells.size() ==0 ) {
			upperRow = lowerRow = cell.getR();
			leftColumn = rightColumn = cell.getC();
			cell.setUsed(true);
			if(cell.getType() == Cell.TOMATO) remainingTomatos--;
			else remainingMushrooms--;
			cells.add(cell);
			//System.out.println("First cell added: ("+cell.getR()+" "+cell.getC()+")");
			return true;
		}
		
		if( upperRow == cell.getR()-1 || lowerRow == cell.getR()+1 || leftColumn == cell.getC() -1 ||rightColumn == cell.getC() +1 ) {
			
			if(upperRow == cell.getR()-1) {
				for(int i = leftColumn ; i< rightColumn; i++) {
					if(pizza.getCell(cell.getR(),i).isUsed()) return false;
				}
				upperRow--; 
			}
			else if(lowerRow == cell.getR()+1 ) {
				for(int i = leftColumn ; i< rightColumn; i++) {
					if(pizza.getCell(cell.getR(),i).isUsed()) return false;
				}
				lowerRow++;
			}
			else if(leftColumn == cell.getC() -1) {
				for(int i = lowerRow; i< upperRow; i++) {
					if(pizza.getCell(i,cell.getR()).isUsed()) return false;
				}
				leftColumn--;
			}
			else if(rightColumn == cell.getC() +1) {
				for(int i = lowerRow; i< upperRow; i++) {
					if(pizza.getCell(i,cell.getR()).isUsed()) return false;
				}
				rightColumn++;
			}
			cell.setUsed(true);
			if(cell.getType() == Cell.TOMATO) remainingTomatos--;
			else remainingMushrooms--;
			cells.add(cell);
			//System.out.println("Cell added: ("+cell.getR()+" "+cell.getC()+")");
			return true;
		}
		return false;
	}
	
	
	
	public void zergSlice(Pizza pizza) {
		while(remainingTomatos > 0) {
			if(upperRow-1 >= 0 && pizza.getCell(upperRow-1,leftColumn).getType() == Cell.TOMATO) {
				this.addCell(pizza.getCell(upperRow-1,leftColumn),pizza);
				remainingTomatos--;
			}
		}
	}
	
	public String getString() {
		StringBuilder temp = new StringBuilder();
		temp.append(upperRow).append(" ");
		temp.append(leftColumn).append(" ");
		temp.append(lowerRow).append(" ");
		temp.append(rightColumn);
		return temp.toString();
	}
}
