//NBody.java

public class NBody{
   public static double readRadius(String str){
      In in = new In("./data/planets.txt");
      int num = in.readInt();
      double rad = in.readDouble();
      return rad;
   }
   
   public static Body [] readBodies(String FileName){
      In in = new In (FileName);
      int num = in.readInt();
      double rad = in.readDouble();
      Body [] bodies = new Body[num];
      for(int i=0; i < num; i++){
	 // if (in.readString() == "[!]") break;
	 
	 double xPos = in.readDouble();
	 double yPos = in.readDouble();
	 double xVel = in.readDouble();
	 double yVel = in.readDouble();
	 double mass = in.readDouble();
	 
	 String name = in.readString();
	 bodies[i] = new Body(xPos, yPos, xVel, yVel, mass, name);
      }
      return bodies;
   }
   
    private static void drawBackground(double radius, String imgfile) {
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-1 * radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imgfile);
        StdDraw.show();
    }

    private static void drawBodie(Body[] bodies) {
        for (Body body : bodies) {
            body.draw();
        }
    }
    
    private static void drawAnimation(double T, double dt, Body[] bodies, String imgbgd){
	 StdDraw.enableDoubleBuffering();
	 double time = 0.0;
	 int len = bodies.length;
	 while (time < T){
	    double [] xForces = new double[len];
	    double [] yForces = new double[len];
	    int idx = 0;
	    for (Body bod: bodies){
	       xForces[idx] = bod.calcNetForceExertedByX(bodies);
	       yForces[idx] = bod.calcNetForceExertedByY(bodies);
	       bod.update(dt, xForces[idx], yForces[idx]);
	       idx++;
	    }
	    StdDraw.picture(0, 0, imgbgd);
	    
	    for (Body bod: bodies){
	       bod.draw();
	    }
	    StdDraw.show();
	    StdDraw.pause(10);
	    time += dt;
	 }
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] bodies = readBodies(filename);
        double radius = readRadius(filename);
        StdDraw.setCanvasSize(1920,1440);
        drawBackground(radius, "images/starfield.jpg");
        drawBodie(bodies);
        drawAnimation(T, dt, bodies, "images/starfield.jpg");
        StdOut.printf("%d\n", bodies.length);
	StdOut.printf("%.2e\n", radius);
	for (int i = 0; i < bodies.length; i++) {
	    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		          bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
		          bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
	}
    }
}
