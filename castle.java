     import greenfoot.*;

public class  castle extends Actor
{
    public castle()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 2;
        int newHeight = image.getHeight() / 2;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}