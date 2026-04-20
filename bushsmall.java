   import greenfoot.*;

public class bushsmall extends Actor
{
    public bushsmall()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 9;
        int newHeight = image.getHeight() / 9;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}