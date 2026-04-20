import greenfoot.*;

public class coin extends Actor
{
    private int vSpeed = 0; 
    private final int GRAVITY = 1; 
    private final int MAX_FALL_SPEED = 10;

    /**
     * Ini adalah Konstruktor. 
     * Kode ini berjalan SAAT koin pertama kali dibuat.
     */
    public coin()
    {
        GreenfootImage image = getImage();
        
        if (image != null) 
        {
            image.scale(16, 16); 
            setImage(image);
        }
        
        vSpeed = -10; 
    }
    
    /**
     * Method act() akan mengurus fisika koin
     */
    public void act()
    {
        applyGravityAndVerticalMovement();
    }
    
    /**
     * Method BARU: Versi sederhana dari fisika Mario
     * Ini membuat koin jatuh dan mendarat.
     */
    private void applyGravityAndVerticalMovement()
    {
        setLocation(getX(), getY() + vSpeed);

        if (vSpeed < MAX_FALL_SPEED) {
            vSpeed += GRAVITY; 
        }
        
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, block.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, tanya.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa2.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa3.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, brick.class);
        
        if (ground != null && vSpeed > 0)
        {
            int groundTop = ground.getY() - ground.getImage().getHeight() / 2;
            setLocation(getX(), groundTop - getImage().getHeight() / 2);
            
            vSpeed = 0; 
        } 
    }
}