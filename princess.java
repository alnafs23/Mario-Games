 import greenfoot.*; 

public class princess extends Actor
{
    private boolean isFollowing = false;
    private static final int FOLLOW_SPEED = 2; 
    private mario targetMario = null; 
    
    public princess()
    {
        GreenfootImage img = new GreenfootImage("princess.png");
        double scaleFactor = 0.10; 
        int newWidth = (int)(img.getWidth() * scaleFactor);
        int newHeight = (int)(img.getHeight() * scaleFactor);
        
        img.scale(newWidth, newHeight); 
        setImage(img);
    }

    public void act()
    {
        if (isFollowing)
        {
            followMario();
        }
    }
    
    public void startFollowing(mario mario) 
    {
        if (targetMario == null)
        {
            isFollowing = true;
            targetMario = mario;
        }
    }
    
    private void followMario()
    {
        if (targetMario == null || getWorld() == null)
        {
            isFollowing = false;
            return;
        }

        int targetX = targetMario.getX();
        int targetY = targetMario.getY();
        int currentX = getX();
        int minDistanceX = 50; 
        
        if (currentX < targetX - minDistanceX) 
        {
            setLocation(currentX + FOLLOW_SPEED, targetY);
        }
        else if (currentX > targetX + minDistanceX) 
        {
            setLocation(currentX - FOLLOW_SPEED, targetY);
        }
        
        setLocation(getX(), targetY); 
    }
}