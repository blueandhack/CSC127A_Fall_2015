import java.util.Random;
import java.awt.Color;

public class Car_Section2
{
    public static void main(String[] args)
    {
        Random rand = new Random();

        // initialize the array of cars
        BaseCar[] cars = new BaseCar[50];
        for (int i=0; i<cars.length; i++)
        {
            // each car is given a random position on the road and
            // a random initial speed.  Will they crash or not?
            //
            // (for now, all of them have the same length)
            //
            // UPDATE: Since we want to be able to find out which car
            // is in front of which, we'll just add positions together,
            // rather than making the positions independently random.

            // THIS IS THE DEFAULT SETUP - ALL OF THE CARS ARE UNDER YOUR
            // CONTROL.
            cars[i] = new MyCar();

            // IF YOU WANT TO ALLOW FOR SOME OF THE CARS TO ACT RANDOMLY,
            // UNCOMMENT THE NEXT TWO LINES.
//            if (rand.nextBoolean())
//                cars[i] = new RandomCar();

            // IF YOU WANT SOME OF THE CARS TO SIMPLY COME TO A HALT,
            // UNCOMMENT THE NEXT TWO LINES.
//            if (rand.nextBoolean())
//                cars[i] = new StoppedCar();


            // this find the location of the car previous car - the one
            // behind the one we're currently about to set up.  We define
            // the position of this current one as a random distance
            // in front of the one behind it.
            double prev;
            if (i == 0)
                prev = 0;
            else
            {
                cars[i-1].setNext(cars[i]);
                prev = cars[i-1].getPos() + 2*cars[i-1].getLen();
            }

            // this actually initializes the current car.
            cars[i].init(prev+rand.nextInt(100), rand.nextInt(5), 2);
        }
        
        
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
        int carsOnRoad = cars.length;
        while (carsOnRoad > 0)
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
                double pos   = cars[i].getPos();
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
            }
            else if ( ! simStarted)
            {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(ROAD_LEN/2, ROAD_LEN/2, "Press SPACE to begin the simulation!");
                StdDraw.show(100);
                continue;
            }


            // iterate over all of the cars, and advance their positions.
            // remove any from the array which have left the end of the road.
            for (int i=0; i<cars.length; i++)
            if (cars[i] != null)
            {
                cars[i].tick(TIME_TICK);
                if (cars[i].getPos() >= ROAD_LEN*LAPS)
                {
                    // set the position of the car to way, way out beyond
                    // the end of the track - so that the car behind won't
                    // stop near the end of the track, trying to avoid it.
                    cars[i].pos *= 2;

                    cars[i] = null;
                    carsOnRoad--;
                }
            }
            
            
            // check for speed limit violators
            for (int i=0; i<cars.length; i++)
            if (cars[i] != null)
            {
                if (cars[i].getSpeed() > 35)
                {
                    System.out.printf("OH, NO!  You've been pulled over for a speed limit violation!  You were doing %.1f in a 35 zone!\n", cars[i].getSpeed());
                    return;
                }
            }


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
        System.out.println("CONGRATULATIONS!  All cars have completed the track safely.");
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
