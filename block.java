      import greenfoot.*;

public class block extends Actor
{
    public block()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 15;
        int newHeight = image.getHeight() / 15;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}