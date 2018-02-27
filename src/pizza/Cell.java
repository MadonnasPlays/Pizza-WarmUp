package pizza;


public class Cell{
	private final static char MUSHROOM = 'M';
	private final static char TOMATO = 'T';
	
	//cell type, must be either mushroom or tomato
	private int type;
	
	//cell coordinates on map
	private int r;
	private int c;
	
	Cell(){}
	
	Cell(char type, int r,int c) {
		if(type == MUSHROOM || type == TOMATO) {
			this.type = type; 
			this.r = r;
			this.c = c;
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