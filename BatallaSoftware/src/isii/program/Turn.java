package isii.program;

public class Turn {
	private int turn;

	public Turn() {
		this.turn = 0;
	}
	
	public int getTurn() {
		return this.turn;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	
	public void changeTurn() {
		if (getTurn() == 0) setTurn(1);
		else setTurn(0);
	}
}
