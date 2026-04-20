import greenfoot.*;

public class bowser extends Actor
{
    private int speed = 1;
    private int vSpeed = 0;
    private int gravity = 1;
    private final int MAX_FALL_SPEED = 10;
    private int direction = 1; 
    private int patrolSteps = 100; 
    private int moveCounter = 0;   

    /**
     * Konstruktor (Tetap sama, DIBAGI 5)
     */
    public bowser()
    {
        int divisionFactor = 5; 
        
        GreenfootImage image = getImage();
        int newWidth = image.getWidth() / divisionFactor; 
        int newHeight = image.getHeight() / divisionFactor;
        
        image.scale(newWidth, newHeight);
        setImage(image);
    }
    
    /**
     * Metode act
     */
    public void act()
    {
        patrol();
        applyGravity();
    }

    /**
     * BARU: Membuat Bowser bergerak bolak-balik berdasarkan JARAK
     */
    private void patrol()
    {
        setLocation(getX() + (speed * direction), getY());
        
        moveCounter++;
        
        if (moveCounter >= patrolSteps)
        {
            direction = direction * -1; 
            moveCounter = 0;            
        }
    }

    
    /**
     * Menerapkan gravitasi dan mendarat di platform
     * (Ini SAMA seperti sebelumnya, kita tetap butuh ini)
     */
    private void applyGravity()
    {
        setLocation(getX(), getY() + vSpeed);

        if (vSpeed < MAX_FALL_SPEED) {
            vSpeed = vSpeed + gravity;
        }
        
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, block.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa2.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa3.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, brick.class);
        
        if (ground != null && vSpeed >= 0) 
        {
            int groundTop = ground.getY() - ground.getImage().getHeight() / 2;
            setLocation(getX(), groundTop - getImage().getHeight() / 2);
            vSpeed = 0; 
        }
    }
}