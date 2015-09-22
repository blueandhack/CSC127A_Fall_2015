import java.awt.Color;

public class StoppedCar extends BaseCar
{
    public Color getColor()
    {
        return StdDraw.BLUE;
    }
    
    public int getPedal()
    {
        return -1;
    }
}