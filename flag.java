 import greenfoot.*;

public class flag extends Actor
{
    private boolean hasBeenTriggered = false;
    private int moveSpeed = 3;
    private int bottomY = 410; 

    public flag()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 8;
        int newHeight = image.getHeight() / 8;
        image.scale(newWidth, newHeight); ;
        setImage(image); 
    }
    
    public void act()
    {
        if (hasBeenTriggered)
        {
            moveFlagDown();
        }
    }
    
    /**
     * Metode ini akan dipanggil oleh Aktor 'flagpole'
     * saat Mario menyentuh tiang.
     */
    public void startMovingDown()
    {
        hasBeenTriggered = true;
    }
    
    /**
     * Gerakkan bendera ke bawah
     */
    private void moveFlagDown()
    {
        if (getY() < bottomY)
        {
            setLocation(getX(), getY() + moveSpeed);
        }
    }
}