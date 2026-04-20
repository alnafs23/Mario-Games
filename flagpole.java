 import greenfoot.*;

public class flagpole extends Actor
{
    private boolean hasBeenTriggered = false;

    public flagpole()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 2;
        int newHeight = image.getHeight() / 2;
        image.scale(newWidth, newHeight); ;
        setImage(image); 
    }
    
    public void act()
    {
        if (!hasBeenTriggered)
        {
            checkMarioCollision();
        }
    }

    /**
     * Periksa apakah Mario menyentuh TIANG ini
     */
    private void checkMarioCollision()
    {
        Actor mario = getOneIntersectingObject(mario.class);
        
        if (mario != null)
        {
            hasBeenTriggered = true;
            flag theFlag = (flag) getWorld().getObjects(flag.class).get(0);
            Greenfoot.playSound("flagpole.wav");

            if (theFlag != null)
            {
                theFlag.startMovingDown();
            }
        }
    }
}