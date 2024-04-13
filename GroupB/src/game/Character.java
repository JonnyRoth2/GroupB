package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Point;
import game.Polygon;
import java.util.Timer;
import java.util.TimerTask;

public class Character extends Polygon implements KeyListener, Boost {
	public String name;
	final static Point p1 = new Point(0, 0);
	final static Point p2 = new Point(20, 0);
	final static Point p3 = new Point(30, 30);
	final static Point p4 = new Point(0, 20);
	static Point position = new Point(366, 250);
	private static int rotation = 0;
	private static double accel = 0;
	private static double stepSize = 4;
	boolean forward;
	boolean left;
	boolean right;
	boolean back;
	boolean drift;
	final static Point[] CharacterPoints = new Point[] { p1, p2, p3, p4 };
	Point[] pointArr = this.getPoints();

	public Character(String name) {
		super(CharacterPoints, position, rotation);
		this.name = name;
		this.forward = false;
		this.left = false;
		this.right = false;
		this.back = false;

	}

	void paint(Graphics brush) {
		Point[] pointArr = this.getPoints();
		int[] xPoints = new int[pointArr.length];
		int[] yPoints = new int[pointArr.length];
		for (int i = 0; i < pointArr.length; i++) {
			xPoints[i] = (int) pointArr[i].getX();
		}
		for (int i = 0; i < pointArr.length; i++) {
			yPoints[i] = (int) pointArr[i].getY();
		}
		brush.setColor(Color.orange);
		brush.fillPolygon(xPoints, yPoints, 4);
		move();
		teleportCollision();
	}

	public class bullet extends Polygon {
		final static Point bulletP1 = new Point(0, 0);
		final static Point bulletP2 = new Point(5, 0);
		final static Point bulletP3 = new Point(5, 5);
		final static Point bulletP4 = new Point(0, 5);
		final static Point[] bulletPoints = new Point[] { bulletP1, bulletP2, bulletP3, bulletP4 };

		public bullet() {
			super(bulletPoints, Character.position, 0);
		}

	}
	//LAMBDA EXPRESSION FOR BOOST!
	Boost giveDriftBoost = (x) -> x + 0.001;

	void move() {
		if (forward == true && drift == false) {
			position.y -= stepSize * Math.sin(Math.toRadians(rotation + 230));
			position.x -= stepSize * Math.cos(Math.toRadians(rotation + 230));
		}
		if (forward == true && drift == true && right == true) {
			position.y -= stepSize * Math.sin(Math.toRadians(rotation + 180));
			position.x -= stepSize * Math.cos(Math.toRadians(rotation + 180));
		}
		if (forward == true && drift == true && left == true) {
			position.y -= stepSize * Math.sin(Math.toRadians(rotation + 270));
			position.x -= stepSize * Math.cos(Math.toRadians(rotation + 270));
		}

		if (left == true) {
			rotation -= 5;
			this.rotate(355);
		}
		if (right == true) {
			rotation += 5;
			this.rotate(5);
		}
		if (back == true) {
			position.y += (stepSize - 2.5) * Math.sin(Math.toRadians(rotation + 230));
			position.x += (stepSize - 2.5) * Math.cos(Math.toRadians(rotation + 230));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int checker = e.getKeyCode();
		if (checker == 87) {
			this.forward = true;
			// while(checker==87) {accel+=0.01;}
		}
		if (checker == 65) {
			this.left = true;
		}
		if (checker == 68) {
			this.right = true;
		}
		if (checker == 83) {
			this.back = true;
		}
		if (checker == 32) {
			this.drift = true;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int checker = e.getKeyCode();
		if (checker == 87) {
			this.forward = false;
			accel = 0;
		}
		if (checker == 65) {
			this.left = false;
		}
		if (checker == 68) {
			this.right = false;
		}
		if (checker == 83) {
			this.back = false;
		}
		if (checker == 32) {
			this.drift = false;
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					stepSize = 4;

				}

			};
			stepSize = giveDriftBoost.giveBoost(stepSize);
			timer.schedule(task, 500);
			// stepSize=4;
		}

	}

	public void teleportCollision() {
		Point[] pointArr = this.getPoints();
		for (int i = 0; i < pointArr.length; i++) {
			if (pointArr[i].getX() < -100) {
				position.x = 770;
			}
			if (pointArr[i].getX() > 820) {
				position.x = -50;
			}
			if (pointArr[i].getY() < -50) {
				position.y = 600;
			}
			if (pointArr[i].getY() > 650) {
				position.y = 0;
			}
		}
	}

	static public class Health extends Polygon {

		final static Point p1 = new Point(0, 0);
		final static Point p2 = new Point(0, 20);
		final static Point p3 = new Point(10, 20);
		final static Point p4 = new Point(10, 10);
		final static Point p5 = new Point(20, 10);
		final static Point p6 = new Point(20, 0);
		static Point Position = new Point(600, 25);
		static Point Position2 = new Point(450, 25);
		static Point Position3 = new Point(400, 25);
		static int HPCount = 3;
		final static Point[] HealthPoints = new Point[] { p1, p2, p3, p4, p5, p6 };
		Point[] heart = this.getPoints();

		public Health(int locationX) {
			super(HealthPoints, new Point(locationX, 25), 225);
		}

		void paint(Graphics brush) {
			Point[] pointArr = this.getPoints();
			int[] xPoints = new int[pointArr.length];
			int[] yPoints = new int[pointArr.length];
			for (int i = 0; i < pointArr.length; i++) {
				xPoints[i] = (int) pointArr[i].getX();
			}
			for (int i = 0; i < pointArr.length; i++) {
				yPoints[i] = (int) pointArr[i].getY();
			}
			brush.setColor(Color.red);
			brush.drawPolygon(xPoints, yPoints, 6);
		}
	}

	@Override
	public double giveBoost(double x) {
		return (x = x + 1.0);
	}

}
