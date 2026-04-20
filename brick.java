        import greenfoot.*;

public class brick extends Actor
{
    public brick()
    {
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / 10;
        int newHeight = image.getHeight() / 10;
        
        image.scale(newWidth, newHeight); ;
        
        setImage(image); 
    }
    public void act()
    {
        
    }
}