     import greenfoot.*;

public class pipa3 extends Actor
{
    public pipa3()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 3;
        int newHeight = image.getHeight() / 3;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}