package game;

import java.awt.Color;
import java.awt.Graphics;

public class Map1RENAME extends Polygon implements Maps{
	//width will be defined but not length because
	//the width of all sections of tracks will remain the same
	private static int width=90;
	private final static int ID=1;
	private String difficulty;
	static Point p1=new Point(0,0);
	static Point p2=new Point(0,width);
	static Point p3=new Point(100,width);
	static Point p4=new Point(100,0);
	static Point[] TrackPoints=new Point[] {p1,p2,p3,p4};
	public class TrackPart1 extends Polygon{
		public Point location;
		public TrackPart1(Point location) {
			super(TrackPoints,location,0);
			
		}
		public void paint(Graphics brush) {
				Point[] pointArr=this.getPoints();
				int[] xPoints=new int[pointArr.length];
				int[] yPoints=new int[pointArr.length];
				for(int i=0;i<pointArr.length;i++) {
					xPoints[i]=(int) pointArr[i].getX();
				}
				for(int i=0;i<pointArr.length;i++) {
					yPoints[i]=(int) pointArr[i].getY();
				}
				brush.setColor(Color.DARK_GRAY);
				brush.fillPolygon(xPoints, yPoints, 4);
			
		}
	}
	public class CornerTrack extends Polygon{
		public Point location;
		static Point p1=new Point(0,0);
		static Point p2=new Point(0,width);
		static Point p3=new Point(75,width);
		static Point p4=new Point(75,0);
		static Point[] TrackPoints=new Point[] {p1,p2,p3,p4};
		public CornerTrack(Point location,double rotation) {
			super(TrackPoints,location,rotation);
			
		}
		public void paint(Graphics brush) {
				Point[] pointArr=this.getPoints();
				int[] xPoints=new int[pointArr.length];
				int[] yPoints=new int[pointArr.length];
				for(int i=0;i<pointArr.length;i++) {
					xPoints[i]=(int) pointArr[i].getX();
				}
				for(int i=0;i<pointArr.length;i++) {
					yPoints[i]=(int) pointArr[i].getY();
				}
				brush.setColor(Color.DARK_GRAY);
				brush.fillPolygon(xPoints, yPoints, 4);
			
		}
	}
	public class PowerUp extends Polygon{
		final static Point p1=new Point(0,0);
		final static Point p2=new Point(0,10);
		final static Point p3=new Point(10,10);
		final static Point p4=new Point(10,0);
		public PowerUp() {
			super(TrackPoints,p1,0);
			// TODO Auto-generated constructor stub
		}
		
	}
	public Map1RENAME() {
		super(TrackPoints,p4,0);
		this.difficulty="easy";
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDifficulty() {
		return this.difficulty;
	}

	@Override
	public int getID() {
		return ID;
	}
	//this paint method is essentially being used as a track builder
	@Override
	public void paint(Graphics brush) {
		Map1RENAME.TrackPart1 track1=new Map1RENAME.TrackPart1(new Point(0,50));
		track1.paint(brush);
		Map1RENAME.TrackPart1 track2=new Map1RENAME.TrackPart1(new Point(100,50));
		track2.paint(brush);
		Map1RENAME.TrackPart1 track3=new Map1RENAME.TrackPart1(new Point(200,50));
		track3.paint(brush);
		Map1RENAME.TrackPart1 track4=new Map1RENAME.TrackPart1(new Point(300,50));
		track4.paint(brush);
		Map1RENAME.CornerTrack track5=new Map1RENAME.CornerTrack(new Point(350,75),45);
		track5.paint(brush);
		Map1RENAME.CornerTrack track6=new Map1RENAME.CornerTrack(new Point(350,125),135);
		track6.paint(brush);
		Map1RENAME.CornerTrack track7=new Map1RENAME.CornerTrack(new Point(350,100),90);
		track7.paint(brush);
		Map1RENAME.CornerTrack track8=new Map1RENAME.CornerTrack(new Point(300,150),165);
		track8.paint(brush);
		/*Point[] pointArr=this.getPoints();
			int[] xPoints=new int[pointArr.length];
			int[] yPoints=new int[pointArr.length];
			for(int i=0;i<pointArr.length;i++) {
				xPoints[i]=(int) pointArr[i].getX();
			}
			for(int i=0;i<pointArr.length;i++) {
				yPoints[i]=(int) pointArr[i].getY();
			}
			brush.setColor(Color.LIGHT_GRAY);
			brush.fillPolygon(xPoints, yPoints, 4);
		*/
	}
	
}
