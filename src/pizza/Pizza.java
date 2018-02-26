package pizza;

public class Pizza {
	
	private int rows;
	private int columns; 
	
	
	private class Cell{
		private boolean mushroom;
		private boolean tomato;
	}
	
	private class Slice{
		private int rows;
		private int columns;
		private int cells;
		private int L;
		private int H;
		private boolean overlap;
		
		private void Slice(int leastCells , int highestCells) {
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
		// TODO Auto-generated method stub

	}

}
