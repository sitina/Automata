package net.sitina.automata;

public abstract class Cell implements Cloneable {

	private int state = 0;
	
	private int x = 0;
	
	private int y = 0;
	
	protected Cell left = null;
	
	protected Cell right = null;
	
	protected Cell top = null;
	
	protected Cell bottom = null;
	
	private boolean changed = true;
	
	protected void setState(int state) {
		this.state = state;
	}
	
	public int getState() {
		return this.state;
	}
	
	public abstract void performStep();

	public void setLeft(Cell left) {
		this.left = left;
	}

	public void setRight(Cell right) {
		this.right = right;
	}

	public void setTop(Cell top) {
		this.top = top;
	}

	public void setBottom(Cell bottom) {
		this.bottom = bottom;
	}
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	protected int getX() {
		return this.x;
	}
	
	protected int getY() {
		return this.y;
	}
	
	protected void setChanged(boolean changed) {
		this.changed = changed;
	}
	
	public boolean isChanged() {
		return changed;
	}
	
}
