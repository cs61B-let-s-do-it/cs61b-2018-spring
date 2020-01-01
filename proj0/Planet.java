public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
              double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = Math.pow((p.xxPos - this.xxPos), 2);
		double dy = Math.pow((p.yyPos - this.yyPos), 2);
		double r = Math.sqrt(dx+dy);
		return r;
	}

	public double calcForceExertedBy(Planet p) {
		double Force = 6.67e-11 * this.mass * p.mass / Math.pow(this.calcDistance(p),2); 
		return Force;
	}

	public double calcForceExertedByX(Planet p) {
		double Forcex = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
		return Forcex;
	}

	public double calcForceExertedByY(Planet p){
    	double Forcey = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    	return Forcey;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
    	double Forcexx = 0.0;
    	for(int i = 0; i < allPlanets.length; i++) {
    		if (this.equals(allPlanets[i]) != true){
    			Forcexx += this.calcForceExertedByX(allPlanets[i]);
    		}
    	}
    	return Forcexx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
    	double Forceyy = 0.0;
    	for(int i = 0; i < allPlanets.length; i++) {
    		if (this.equals(allPlanets[i]) != true){
    			Forceyy += this.calcForceExertedByY(allPlanets[i]);
    		}
    	}
    	return Forceyy;
    }

    public void update(double dt, double fX, double fY) {
    	double xxAcc = fX / this.mass;
      	double yyAcc = fY / this.mass;
      	this.xxVel += dt * xxAcc;
      	this.yyVel += dt * yyAcc;
      	this.xxPos += dt * xxVel;
      	this.yyPos += dt * yyVel;
    }

    //使用javac -encoding utf-8 .java
    public void draw() {
    	StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
    

}
