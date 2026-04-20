import greenfoot.*;

/**
 * Aktor ini menampilkan animasi "Game Over" saat dipanggil.
 * Dia juga mendengarkan 'spasi' untuk restart.
 */
public class GameOver extends Actor
{
    private GreenfootImage[] frames;
    private int currentFrame = 0;
    private int animationTimer = 0;
    private final int ANIMATION_SPEED = 8; 

    public GameOver()
    {
        frames = new GreenfootImage[5];
        frames[0] = new GreenfootImage("gameOver1.png");
        frames[1] = new GreenfootImage("gameOver2.png");
        frames[2] = new GreenfootImage("gameOver3.png");
        frames[3] = new GreenfootImage("gameOver4.png");
        frames[4] = new GreenfootImage("gameOver5.png");
        setImage(frames[0]); 
    }

    /**
     * Metode ini dipanggil sekali saat Aktor ditambahkan ke dunia.
     */
    protected void addedToWorld(World world)
    {
        if (world instanceof MarioWorld) {
            ((MarioWorld)world).stopMusic(); 
        }
    }

    public void act()
    {
        animate();
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new Homepage());
            Greenfoot.start(); 
        }
    }
    
    /**
     * Helper method untuk menjalankan animasi
     */
    private void animate()
    {
        animationTimer++;
        if (animationTimer % ANIMATION_SPEED == 0)
        {
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
        }
    }
}