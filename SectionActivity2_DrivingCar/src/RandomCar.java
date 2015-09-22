import java.util.Random;
import java.awt.Color;

public class RandomCar extends BaseCar
{
    Random rand;
    RandomCar()
    {
        rand = new Random();
    }

    public Color getColor()
    {
        return StdDraw.BLUE;
    }
    
    public int getPedal()
    {
        // try (a little bit) to not crash into the car in front
        if (distToNextCar() < 10)
            return -1;

        // otherwise, be random
        return rand.nextInt(3)-1;
    }
}