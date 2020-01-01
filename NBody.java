public class NBody {
	public static double readRadius(String planetsPath){
        In in = new In(planetsPath);
        double secondItemInFile = in.readDouble();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet [] readPlanets(String planetsPath) {
		In in = new In(planetsPath);
		int num = in.readInt(); 
		double radius = in.readDouble();
		Planet [] allPlanets = new Planet[num];
		for(int i = 0; i < num; i++) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
	        allPlanets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return allPlanets;
	}


	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet [] allPlanets = NBody.readPlanets(filename);
		double radius = NBody.readRadius(filename);

		
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(Planet p : allPlanets){
			p.draw();
		}

		StdDraw.enableDoubleBuffering();

		for(double t = 0; t <= T; t+=dt) {
			double [] xForces = new double [allPlanets.length];
			double [] yForces = new double [allPlanets.length];
		
			for(int i = 0; i < allPlanets.length; i++) {
        		xForces [i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
        		yForces [i] = allPlanets[i].calcNetForceExertedByY(allPlanets);  
        	}
        	for(int i = 0; i < allPlanets.length; i++) {
        	  	allPlanets[i].update(dt, xForces [i], yForces [i]);
        	}
        	StdDraw.picture(0, 0, "./images/" + filename);
		}
		for(Planet p : allPlanets) {
			p.draw();
		}
		StdDraw.show();
        StdDraw.pause(10);
	
		StdOut.printf("%d\n", Planets.length);
    	StdOut.printf("%.2e\n", uniRadius);
    	for (int i = 0; i < Planets.length; i++) {
        	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                         Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                         Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName); 
        }
    } 

}

