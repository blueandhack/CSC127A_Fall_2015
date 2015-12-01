import java.util.Random;
import java.awt.Color;
import java.io.*;

public class Cars_Proj1
{
    public static void main(String[] args)
    {
        int seed;
        if (args.length == 1)
            seed = Integer.parseInt(args[0]);
        else
            seed = (int)(1000000*Math.random());

        System.out.println("Running with seed="+seed);
        Random rand = new Random(seed);
        
        
//        System.out.println("Running with seed="+84168);
//        Random rand = new Random(84168);
        double Len = 0;


        // initialize the array of cars
        BaseCar[] cars = new BaseCar[2];
        
        cars[0] = new Proj1Car();
        cars[1] = new TargetCar(rand);
        cars[0].setNext(cars[1]);

        cars[0].init(rand.nextInt(100),                     rand.nextInt(25)+25, 2);
        cars[1].init(cars[0].getPos()+50+rand.nextInt(100), cars[0].getSpeed(),  2);
        
        
        
        // before we start the main loop, we run tick() once on each car
        // (but with time=0) so that we'll get the cars all pre-colored
        // as greed or red (instead of black)
        for (int i=0; i<cars.length; i++)
            cars[i].tick(0);

        
        // the main loop: we draw the current state, increment by a certain
        // time delta, and then check for collisions.  If a collision has
        // occurred, we terminate the simulation.  We run all of the cars have
        // exited the road.
        int    ROAD_LEN    = 200;
        int    ROAD_WIDTH  = 2;
        int    LAPS        = 10;
        int    LAP_SPACING = ROAD_LEN/LAPS;
        double TIME_TICK   = 0.01;

        // init the StdDraw window
        StdDraw.setScale(0,ROAD_LEN);
        
        // this boolean tells us whether the simulation has started yet.
        // If not, then we won't call tick() on any of the cars, or check
        // for collisions - but we *will* refresh the screen.
        boolean simStarted = false;

        // now, do the loop.
        double elapsedTime = 0;
        double score = 0;
        while (elapsedTime < 25)
        {
            // the screen has two parallel lines, representing the sides of
            // the road, and little rectangles (length defined by the property
            // of the car) driving between the lines.
            //
            // UPDATE: we have LAPS-many copies of that road now.
            StdDraw.clear(StdDraw.WHITE);

            for (int i=0; i<LAPS; i++)
            {
                double where = (i+.5)*LAP_SPACING;

                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledRectangle(ROAD_LEN/2,where, ROAD_LEN/2, ROAD_WIDTH);

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(0,where-ROAD_WIDTH, ROAD_LEN,where-ROAD_WIDTH);
                StdDraw.line(0,where+ROAD_WIDTH, ROAD_LEN,where+ROAD_WIDTH);
            }


            // draw the cars
            for (int i=0; i<cars.length; i++)
            if (cars[i] != null)
            {
                double pos   = cars[i].getPos() % (ROAD_LEN*LAPS);
                double len   = cars[i].getLen();
                double speed = cars[i].getSpeed();
                Color  color = cars[i].getColor();

                int    lap    = (int)(pos/ROAD_LEN);
                double lapPos = pos%ROAD_LEN;

                double whereY = (lap+.5)*LAP_SPACING;

                StdDraw.setPenColor(color);
                StdDraw.filledRectangle(lapPos+len/2,whereY, len/2,ROAD_WIDTH/2*.7);

                StdDraw.text(lapPos,whereY + 3*ROAD_WIDTH, String.format("%.1f", speed));
            }
            
            
            // if the simulation hasn't started yet, then print out a message
            // prompting the user to start it...but don't advance any car
            // positions yet.
            if ( ! simStarted && StdDraw.isKeyPressed(' '))
            {
                // start the simulation!
                simStarted = true;
                //获得距离
                Len = cars[0].distToNextCar();
            }
            else if ( ! simStarted)
            {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(ROAD_LEN/2, ROAD_LEN/2, "Press SPACE to begin the simulation!");
                StdDraw.show(100);
                continue;
            }
            
            
            // update the score.
            score += TIME_TICK * Math.abs(cars[0].distToNextCar()-100);


            // print out the state of the game.
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.text(ROAD_LEN/2,ROAD_LEN/2,
                         String.format("Time: %.1f CurDist: %.1f Score: %.1f",
                                       elapsedTime, cars[0].distToNextCar(), score));


            // iterate over all of the cars, and advance their positions
            for (int i=0; i<cars.length; i++)
            if (cars[i] != null)
                cars[i].tick(TIME_TICK);
            
            elapsedTime += TIME_TICK;
            
            
            // hunt for any collisions
            int collision = findCollision(cars);
            if (collision != -1)
            {
                System.out.printf("CRASH!  Car %d has crashed into another car!\n", collision);
                return;
            }

            // if we get here, then there was *NOT* a collision, and so
            // we can loop back.  But first, we sleep a bit.
            StdDraw.show(10);
        }

        // we get here when either there has been a collision, or when all
        // of the cars have exited the road.
        System.out.printf("The pursuit has ended normally.  Your Score: %.1f\n", score);
        
        //写入记录
        try {
			FileWriter file = new FileWriter("src/legendboard",true);
			String result = "";
			int a = (int) Len;
			int b = (int) score;
			result = " | Begin of Distance："+ a +" | Last Score: "+ b +" | Seed: "+seed+" |\n============================================================\n";
			file.write(result);
			System.out.println("Somethings Printed");
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return;
    }
    
    public static int findCollision(BaseCar[] cars)
    {
        for (int i=0; i<cars.length; i++)
        for (int j=0; j<cars.length; j++)
        if (i != j && cars[i] != null && cars[j] != null)
        {
            double posI = cars[i].getPos();
            double posJ = cars[j].getPos();
            double lenI = cars[i].getLen();

            if (posI <= posJ && posI+lenI > posJ)
                return i;
        }
        
        return -1;
    }
}
