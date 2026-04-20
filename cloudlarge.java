   import greenfoot.*;

public class  cloudlarge extends Actor
{
    public cloudlarge()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 8;
        int newHeight = image.getHeight() / 8;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}