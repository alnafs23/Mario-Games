    import greenfoot.*;

public class pipa2 extends Actor
{
    public pipa2()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 3;
        int newHeight = image.getHeight() / 4;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}