package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.Polygon;
import java.awt.event.*;

class GroupB extends Game {
	static int counter = 0;
	final static Character player=new Character("jeff");
	final static Character.Health hp1=new Character.Health(600);
	final static Character.Health hp2=new Character.Health(650);
	final static Character.Health hp3=new Character.Health(700);
	final static Map1RENAME Map1=new Map1RENAME();
	//final static Enemy1 villian=new Enemy1();
  public GroupB() {
    super("GroupB",800,600);
    this.setFocusable(true);
	this.requestFocus();
  }
 
	public void paint(Graphics brush) {
		Color DarkGreen=new Color(1,45,27);
    	brush.setColor(DarkGreen);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	counter++;
    	//Color DarkGreen=new Color(1,50,32);
    	brush.setColor(Color.BLACK);
    	brush.drawString("Counter is " + counter,10,10);
    	this.addKeyListener(player);
    	Map1.paint(brush);
    	player.paint(brush);
    	if(Character.Health.HPCount==3||Character.Health.HPCount==2||Character.Health.HPCount==1) {
    		hp1.paint(brush);
    	}
    	//hp1.paint(brush);
    	if(Character.Health.HPCount<=3||Character.Health.HPCount==2) {
    		hp2.paint(brush);
    	}
    	//hp2.paint(brush);
    	if(Character.Health.HPCount==3) {
    		hp3.paint(brush);
    	}
    	//if(player.collides(villian));{
    		//Health.HPCount--;
    //	}
 
    	
  }
  
	public static void main (String[] args) {
   		GroupB a = new GroupB();
		a.repaint();
  }
}