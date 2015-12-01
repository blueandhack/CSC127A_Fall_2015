public class MyCar extends BaseCar
{
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
        // if this car's speed is below the speed limit, then hit
        // the accelerator!
        if (getSpeed() < 34.5)
            return 1;

        // if this car's speed is getting to close to the speed limit,
        // then hit the brake!
        if (getSpeed() > 34.9)
            return -1;

        // otherwise, coast.
        return 0;
    }
}

