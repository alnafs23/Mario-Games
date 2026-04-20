    import greenfoot.*;

public class  cloudmedium extends Actor
{
    public cloudmedium()
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