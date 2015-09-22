public class Proj1_ConcCircs
{
    public static void main(String[] args)
    {
        // read the arguments from the command line.  Note that we don't
        // worry about any sort of error checking here - we just assume
        // that the arguments exist and are valid.  In later projects,
        // later in this semester, we'll be more careful.
        int val1 = Integer.parseInt(args[0]);
        int val2 = Integer.parseInt(args[1]);

        // this creates the graphics window and clears it.  The valid
        // coordinates in the window range from (-100,-100) on the lower-left
        // to (100,100) on the upper-right.
        StdDraw.setScale(-100,100);
        StdDraw.clear(StdDraw.WHITE);


        // it's now time to draw the larger of the two circles.  Which of the
        // two values is larger?
        if ( val1 > val2 )
        {
            // make sure that the if() statement above is coded such that
            // we will come here only if val1 was the bigger of the two
            // numbers.
            //
            // note that the color of the second number must be StdDraw.RED
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(0,0, val1);   // the args are x,y,radius
        }
        else
        {
            // the second number was the larger of the two.
            //
            // note that the color of the second number must be StdDraw.GREEN
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledCircle(0, 0, val2);
        }


        // it's now time to draw the smaller circle.  cut-n-paste the big
        // if/else above - but modify it so that we will draw the smaller of
        // the two circles.  Remember that val1's circle is still RED, and
        // val2's circle is still GREEN.
        if ( val1 < val2){
        	
        	StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(0,0, val1);
            
        }else{
        	
        	StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.filledCircle(0,0, val2);
            
        }


        // this prints out the two values at the upper-left portion of the
        // screen.
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.text(-90,90, ""+val1);

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.text(-90,70, ""+val2);

        // we're done.  End of the program!  (The window will stay open
        // until the user closes it.)
    }
}

