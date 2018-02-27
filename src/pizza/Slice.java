package pizza;

public class Slice{
	private int firstRow,firstColumn,secondRow,secondColumn;
	
	private void Slice() {
		
	}
	private void Slice(int firstRow, int firstColumn , int secondRow,int secondColumn) {
		this.firstRow=firstRow;
		this.firstColumn=firstColumn;
		this.secondRow=secondRow;
		this.secondColumn=secondColumn;
	}
	
	
	public int getFirstRow() {
		return firstRow;
	}
	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}
	public int getSecondRow() {
		return secondRow;
	}
	public void setSecondRow(int secondRow) {
		this.secondRow = secondRow;
	}

	public void setFirstColumn(int firstColumn) {
		this.firstColumn = firstColumn;
	}
	public void setSecondColumn(int secondColumn) {
		this.secondColumn = secondColumn;
	}
}
