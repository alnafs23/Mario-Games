 import greenfoot.*;

public class Ground extends Actor
{
    public Ground()
    {
        GreenfootImage image = this.getImage();
        int groundWidth = 40;   
        int groundHeight = 40;  
        
        image.scale(groundWidth, groundHeight);
        
        this.setImage(image);
    }
}