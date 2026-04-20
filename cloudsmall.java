   import greenfoot.*;

public class  cloudsmall extends Actor
{
    public cloudsmall()
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