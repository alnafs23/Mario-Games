  import greenfoot.*;

public class bushlarge extends Actor
{
    public bushlarge()
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