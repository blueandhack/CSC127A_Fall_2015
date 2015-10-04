import java.util.Random;


/**
 * TargetCar
 *
 * This class implements a car that slows down and speeds up; it is designed
 * to be kind of hard to follow.
 *
 * To implement this, it randomly implements "moves" - each move is a choice
 * to either speed up, slow down, or coast, for a certain number of ticks; it
 * will do the same thing for a while.  When the ticks expire, it will choose
 * a new move.
 *
 * Each car is biased to target a certain (randomly chosen) speed between 10
 * and 50; when it is below that speed, it will be more likely that it speed
 * up, and when it is above, it is more likely that it will slow down.
 */

public class TargetCar extends BaseCar
{
    // this is the preferred speed for this car.  It is set in the
    // constructor, and never changed.
    double biasSpeed;

    // this is the current move, along with the number of ticks left in it.
    // We do not initialize either in the constructor, instead using the
    // default values of zero; during the first call to getPedal(), we will
    // set them.
    int curMove;
    int moveTicksLeft;

    // this is the RNG that we use throughout the life of this car.
    Random rand;


    // --- CONSTRUCTOR ---
    TargetCar(Random rand)
    {
        this.rand = rand;

        biasSpeed = 10 + rand.nextInt(91);
    }


    // --- OVERRIDED METHOD(s) ---

    /* This method is called over and over by main().  The job of this method
     * is to decide whether the car should speed up (return 1), slow down
     * (return -1), or coast (return 0).
     *
     * There are two basic requirements:
     *   - Don't exceed the speed limit of 35
     *   - Don't crash into another car
     *
     * To decide what to do, you have several methods you can call to query
     * the state of your car:
     *   getSpeed()       - gives the speed of your own car
     *   distToNextCar()  - gives the dist to the car in front of you
     *   speedOfNextCar() - gives the speed of the car in front of you
     */
    public int getPedal()
    {
        // if our current move has expired (including the case where this is
        // the first call for this object), we decide on a move.
        if (moveTicksLeft <= 0)
        {
            // randomly select the next move.  Values -1,0,1 are valid; we
            // use 2 to represent "set to the bias"
            curMove       = -1 + rand.nextInt(4);
            moveTicksLeft =      rand.nextInt(200);


            // fix up the move==2 case
            if (curMove == 2)
            {
                double speed = getSpeed();

                if (speed >= biasSpeed-5 && speed <= biasSpeed+5)
                    curMove = 0;
                else if (speed < biasSpeed)
                    curMove =  1;
                else
                    curMove = -1;
            }
        }
        
        // special case: if this car is stopped, then accelerate for a while,
        // no matter what else we normally would have chosen
        if (getSpeed() == 0)
        {
            curMove = 1;
            moveTicksLeft = 10;
        }


        // update the ticks, and return the move...then we're done!
        moveTicksLeft--;
        return curMove;
    }
}

