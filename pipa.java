   import greenfoot.*;

public class pipa extends Actor
{
    public pipa()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 7;
        int newHeight = image.getHeight() / 7;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}