  import greenfoot.*;

public class hilllarge extends Actor
{
    public hilllarge()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 7;
        int newHeight = image.getHeight() / 7;
        
        image.scale(newWidth, newHeight); 
        
        setImage(image); 
    }

    public void act()
    {
        
    }
}