package pizza;


public class Cell{
	public final static char MUSHROOM = 'M';
	public final static char TOMATO = 'T';
	
	//cell type, must be either mushroom or tomato
	private char type;
	
	private boolean used;
	
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
		used = false;
	}
	

	public int getType() {
		return type;
	}

	public void setType(char type) {
		if(type == Cell.MUSHROOM || type == Cell.TOMATO)
			this.type = type;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	
	
	
}