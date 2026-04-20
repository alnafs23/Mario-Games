import greenfoot.*;
import java.util.List;
import java.lang.Math;

public class Goomba extends Actor 
{
    private final int MOVE_SPEED = 1;
    private final int MAX_FALL_SPEED = 8;
    private final int TILE_SIZE = 32; 
    private final int ANIMATION_SPEED = 5; 
    private int horizontalDirection = -1; 
    private int vSpeed = 0; 
    private boolean isDead = false;
    private GreenfootImage[] walkFrames = {
        new GreenfootImage("goombawalk1.png"), 
        new GreenfootImage("goombawalk2.png") 
    };
    private GreenfootImage deadFrame = new GreenfootImage("goomba-dead.png"); 

    private int animationTimer = 0;

    public Goomba()
    {
        double scaleFactor = 0.07; 
        
        // Scaling
        for (int i = 0; i < walkFrames.length; i++) {
            int newWidth = (int)(walkFrames[i].getWidth() * scaleFactor);
            int newHeight = (int)(walkFrames[i].getHeight() * scaleFactor);
            walkFrames[i].scale(newWidth, newHeight);
        }
        if (walkFrames.length > 0) {
            int fullWidth = walkFrames[0].getWidth();
            int deadHeight = walkFrames[0].getHeight() / 2;
            deadFrame.scale(fullWidth, deadHeight);
        } else {
             deadFrame.scale((int)(deadFrame.getWidth() * scaleFactor), (int)((deadFrame.getHeight() * scaleFactor) / 2));
        }
        
        setImage(walkFrames[0]);
    }

    public void act()
    {
        if (isDead) {
            if (animationTimer > 30) { 
                if (getWorld() != null) {
                    getWorld().removeObject(this);
                }
            } else {
                animationTimer++;
            }
        } else {
            applyGravity();
            moveHorizontal();
            checkEdgeAndObstacles(); 
            animate();
        }
    }

    private void moveHorizontal()
    {
        setLocation(getX() + horizontalDirection * MOVE_SPEED, getY());
    }
    
    private void checkEdgeAndObstacles()
    {
        int checkOffset = (getImage().getWidth() / 2) + 1;
        int nextXOffset = horizontalDirection * (checkOffset + MOVE_SPEED);
        
        Actor obstacle = getOneObjectAtOffset(horizontalDirection * checkOffset, 0, Ground.class);
        if (obstacle == null) obstacle = getOneObjectAtOffset(horizontalDirection * checkOffset, 0, block.class);
        if (obstacle == null) obstacle = getOneObjectAtOffset(horizontalDirection * checkOffset, 0, brick.class);
        if (obstacle == null) obstacle = getOneObjectAtOffset(horizontalDirection * checkOffset, 0, pipa.class);

        
        int verticalCheck = getImage().getHeight() / 2 + 5;
        Actor cliff = getOneObjectAtOffset(nextXOffset, verticalCheck, Ground.class);
        if (cliff == null) cliff = getOneObjectAtOffset(nextXOffset, verticalCheck, block.class);
        if (cliff == null) cliff = getOneObjectAtOffset(nextXOffset, verticalCheck, brick.class);
        if (cliff == null) cliff = getOneObjectAtOffset(nextXOffset, verticalCheck, pipa.class);


        if (obstacle != null || getX() <= 0 || getX() >= getWorld().getWidth() - 1 || cliff == null) {
            horizontalDirection *= -1; 
        }
    }

    private void applyGravity()
    {
        setLocation(getX(), getY() + vSpeed);
        
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, block.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, brick.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa.class);
        
        if (ground != null) {
            int groundTop = ground.getY() - ground.getImage().getHeight() / 2;
            setLocation(getX(), groundTop - getImage().getHeight() / 2);
            vSpeed = 0;
        } else {
            if (vSpeed < MAX_FALL_SPEED) {
                vSpeed++;
            }
        }
    }
    
    private void animate()
    {
        animationTimer++;
        if (animationTimer >= ANIMATION_SPEED * walkFrames.length) {
            animationTimer = 0;
        }
        int frameIndex = animationTimer / ANIMATION_SPEED;
        setImage(walkFrames[frameIndex]);
    }
    
    /**
     * Metode ini sekarang dipanggil OLEH MARIO, bukan oleh Goomba sendiri.
     */
    public void die()
    {
        if (isDead) return; 
        
        isDead = true;
        setImage(deadFrame);
        vSpeed = 0;
        horizontalDirection = 0; 
        animationTimer = 0; 
        Greenfoot.playSound("stompswim.wav");
    }
}