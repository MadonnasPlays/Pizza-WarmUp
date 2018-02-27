package pizza;

public class Slice{
	private int rows;
	private int columns;
	private int cells;
	private int L;
	private int H;
	private boolean overlap;
	private int firstRow,firstColumn,secondRow,secondColumn;
	
	private void Slice() {
		
	}
	private void Slice(int firstRow, int firstColumn , int secondRow,int secondColumn) {
		this.firstRow=firstRow;
		this.firstColumn=firstColumn;
		this.secondRow=secondRow;
		this.secondColumn=secondColumn;
	}
	
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
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
	public void setL(int l) {
		L = l;
	}
	public void setH(int h) {
		H = h;
	}
	public void setFirstColumn(int firstColumn) {
		this.firstColumn = firstColumn;
	}
	public void setSecondColumn(int secondColumn) {
		this.secondColumn = secondColumn;
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
