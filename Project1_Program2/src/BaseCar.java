import java.awt.Color;

abstract public class BaseCar
{
    double speed;
    public double getSpeed() { return speed; }
    
    double pos;
    public double getPos() { return pos; }

    double len;
    public double getLen() { return len; }
    
    int state;   // currently, this is just the most recent pedal
                 // state...but that might change in the future.
    public int getState() { return state; }
 

    // we use an init() method, instead of a constructor, so that we can
    // minimize the amount of code in the MyCar class, which the student
    // will see.  It's bad design in general, but good for education
    // (temporarily)
    void init(double pos, double speed, double len)
    {
        this.pos   = pos;
        this.speed = speed;
        this.len   = len;
    }



    // the child class *MUST* override this
    abstract public int getPedal();

    // the child is allowed to override this, but what we have here is a
    // good default for the student cars.  The "other" cars on the road
    // will use different logic.
    public Color getColor()
    {
        if (state == -1)
            return StdDraw.RED;
        if (state == 0)
            return StdDraw.BLACK;
        if (state == 1)
            return StdDraw.GREEN;
        
        // should never happen, default value for buggy programs
        return StdDraw.MAGENTA;
    }


    public void tick(double timeElapsed)
    {
        final double ACCEL_POWER = 1;
        final double BRAKE_FORCE = 3;

        state = getPedal();

        if (state == 1)
        {
            // there's no upper limit on speed
            speed += ACCEL_POWER*timeElapsed;
        }
        else if (state == -1)
        {
            speed -= BRAKE_FORCE*timeElapsed;

            // speed can never be negative.  (We don't allow cars to go backwards!)
            if (speed < 0)
                speed = 0;
        }
        else if (state == 0)
        {
            // coasting, we do nothing at all...
        }
        else
        {
            System.out.printf("ERROR: getPedal() returned %d, but the only valid values are -1,0,1!\n", state);
            System.exit(-1);
        }
        
        pos += speed * timeElapsed;
        return;
    }
    
    
    // I'd like to replace this with a more elegant mechanism later...probably
    // querying a Lane object, so that we can handle multiple lanes and
    // multiple roads.  But we don't have that yet, so a simple linked-list-ish
    // mechanism will have to suffice.
    BaseCar next;
    public void setNext(BaseCar next)
    {
        this.next = next;
    }
    public BaseCar getNextCar()
    {
        return next;
    }

    
    // helper functions, useful for the student's code
    public double distToNextCar()
    {
        BaseCar next = getNextCar();
        if (next == null)
            return 1000*1000;

        return next.getPos() - next.getLen() - this.getPos();
    }

    public double speedOfNextCar()
    {
        BaseCar next = getNextCar();
        if (next == null)
            return 1000*1000;

        return next.getSpeed();
    }
}
