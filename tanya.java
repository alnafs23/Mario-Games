       import greenfoot.*;

public class tanya extends Actor
{
    private int sisaKoin = 5; 
    private int scaledWidth;
    private int scaledHeight;
    public tanya()
    {
        GreenfootImage image = getImage();
        if (image != null && image.getWidth() > 0)
        {
            int originalWidth = image.getWidth(); 
            int originalHeight = image.getHeight(); 
            int newWidth = originalWidth / 12;
            int newHeight = originalHeight / 12;
            
            if (newWidth > 0 && newHeight > 0) {
                image.scale(newWidth, newHeight);
                setImage(image);
                scaledWidth = newWidth; 
                scaledHeight = newHeight;
            } else {
                image.scale(32, 32); 
                setImage(image);
                scaledWidth = 32;
                scaledHeight = 32;
            }
        } else {
            GreenfootImage defaultImage = new GreenfootImage(32, 32); 
            setImage(defaultImage);
            scaledWidth = 32;
            scaledHeight = 32;
        }
    }

    public void act()
    {
        
    }
    public void hantam() 
    {
        if (sisaKoin > 0) 
        {
            sisaKoin--;
            
            coin koinBaru = new coin(); 
            getWorld().addObject(koinBaru, getX(), getY() - 30); 
            
            setLocation(getX(), getY() - 5);
            Greenfoot.delay(2);
            setLocation(getX(), getY() + 5);
            
            if (sisaKoin == 0) 
            {
                gantiGambarJadiKosong();
            }
        }
    }
    private void gantiGambarJadiKosong()
    {
        GreenfootImage imgKosong = new GreenfootImage("empty.png");
        imgKosong.scale(scaledWidth, scaledHeight); 
        
        setImage(imgKosong);
    }
}