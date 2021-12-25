//Body.java
public class Body {
   public double xxPos;
   public double yyPos;
   public double xxVel;
   public double yyVel;
   public double mass;
   public String imgFileName;
   public Body(double xP, double yP, double xV,
               double yV, double m, String img){
      xxPos = xP;
      yyPos = yP;
      xxVel = xV;
      yyVel = yV;
      mass = m;
      imgFileName = img;
   }
   public Body(Body b){
      xxPos = b.xxPos;
      yyPos = b.yyPos;
      xxVel = b.xxVel;
      yyVel = b.yyVel;
      mass  = b.mass;
      imgFileName = b.imgFileName;
   }
   
   public void draw() {
      StdDraw.enableDoubleBuffering();
      StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
      StdDraw.show();
    }
    
   public double calcDistance(Body bod){
      double x = bod.xxPos;
      double y = bod.yyPos;
      double distance = Math.sqrt((xxPos-x)*(xxPos-x)+(yyPos-y)*(yyPos-y));
      return distance;
   }
   
   public double calcForceExertedBy(Body bod){
      double grav_const = 6.67*Math.pow(10,-11);
      double m1 = mass;
      double m2 = bod.mass;
      double dist = this.calcDistance(bod);
      double net_force = grav_const*(m1*m2)/(dist*dist);
      return net_force;
      
   }
   
   public double calcNetForceExertedByX(Body[] bodies){
      double sum_force_X = 0;
      for (Body bod: bodies){
         if (this.equals(bod)) {continue;}
         sum_force_X += this.calcForceExertedByX(bod);
      }
      return sum_force_X;
   }
   
   public double calcNetForceExertedByY(Body[] bodies){
      double sum_force_Y = 0;
      for (Body bod: bodies){
         if (this.equals(bod)) {continue;}
         sum_force_Y += this.calcForceExertedByY(bod);
      }
      return sum_force_Y;
   }
   
   public double calcForceExertedByX(Body bod){
      double total_force = this.calcForceExertedBy(bod);
      double dist = this.calcDistance(bod);
      double xdist = bod.xxPos - xxPos;
      double ydist = bod.yyPos - yyPos;
      double Fx  = total_force * xdist / dist;
      return Fx;
   }
   
   public double calcForceExertedByY(Body bod){
      double total_force = this.calcForceExertedBy(bod);
      double dist = this.calcDistance(bod);
      double xdist = bod.xxPos - xxPos;
      double ydist = bod.yyPos - yyPos;
      double Fy  = total_force * ydist / dist;
      return Fy;
   }
   
   public void update(double dt, double fX, double fY){
      double ax = fX / mass;
      double ay = fY / mass;
      xxVel += ax*dt;
      yyVel += ay*dt;
      xxPos += xxVel*dt;
      yyPos += yyVel*dt;
   }
}
