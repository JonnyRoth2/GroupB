package game;

import java.awt.Graphics;

public interface Maps {
	public String getDifficulty();
	
	public int getID();
	
	public void paint(Graphics brush);
}
