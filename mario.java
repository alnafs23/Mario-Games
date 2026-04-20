import greenfoot.*; 
import java.util.List;
import java.lang.Math; 

public class mario extends Actor
{
    private GreenfootImage leftMario = new GreenfootImage("mariostandleft.png");
    private GreenfootImage rightMario = new GreenfootImage("mariostand.png");
    private GreenfootImage jumpMario = new GreenfootImage("mariojump.png");
    private GreenfootImage jumpMarioLeft = new GreenfootImage("mariojumpleft.png");
    private GreenfootImage deadMario = new GreenfootImage("mario-dead.png"); 
    private GreenfootImage[] runAnimation;
    private GreenfootImage[] leftRunAnimation;
    private int animationTracker = 0;
    private int fallSpeed = 0; 
    private final int JUMP_POWER = 19; 
    private final int MAX_FALL_SPEED = 10;
    private int speed = 3; 
    private boolean onGround = true;
    private boolean facingLeft = false;
    private boolean facingRight = true;
    private boolean isMoving = false; 
    private boolean isDead = false;
    private boolean jumped = false;
    private int deathTimer = 0; 
    private int invincibilityTimer = 0; 
    private int Score = 0;
    private int coinTaken = 0;
    private int vSpeed = 0; 
    private int jumpVelocity = 15;
    private int lives = 3; 
    
    // --- Konstruktor ---
    public mario()
    {
        int scaleFactor = 3; 
        
        GreenfootImage[] tempRun = { new GreenfootImage("runmario1.png"), new GreenfootImage("runmario2.png"), new GreenfootImage("runmario3.png") };
        GreenfootImage[] tempLeftRun = { new GreenfootImage("leftrunmario1.png"), new GreenfootImage("leftrunmario2.png"), new GreenfootImage("leftrunmario3.png") };
        
        rightMario.scale(rightMario.getWidth() * scaleFactor, rightMario.getHeight() * scaleFactor);
        leftMario.scale(leftMario.getWidth() * scaleFactor, leftMario.getHeight() * scaleFactor);
        jumpMario.scale(jumpMario.getWidth() * scaleFactor, jumpMario.getHeight() * scaleFactor);
        jumpMarioLeft.scale(jumpMarioLeft.getWidth() * scaleFactor, jumpMarioLeft.getHeight() * scaleFactor);
        
        deadMario.scale(rightMario.getWidth(), rightMario.getHeight()); 
        
        for (int i = 0; i < tempRun.length; i++) {
            tempRun[i].scale(tempRun[i].getWidth() * scaleFactor, tempRun[i].getHeight() * scaleFactor);
            tempLeftRun[i].scale(tempLeftRun[i].getWidth() * scaleFactor, tempLeftRun[i].getHeight() * scaleFactor);
        }
        
        this.runAnimation = tempRun;
        this.leftRunAnimation = tempLeftRun;
        
        setImage(rightMario);
    }
    
    public void act()
    {
        if (isDead) {
            deathTimer++;
            setLocation(getX(), getY() + fallSpeed);
            if (fallSpeed < MAX_FALL_SPEED) fallSpeed++; 

            if (deathTimer > 90) { 
                if (getWorld() != null && getWorld() instanceof MarioWorld) {
                    ((MarioWorld)getWorld()).showGameOver();
                    getWorld().removeObject(this); 
                }
            }
            return;
        }
        
        if (invincibilityTimer > 0) {
            invincibilityTimer--;
        }
        
        checkKeys();
        handleHorizontalMovement();
        applyGravityAndVerticalMovement();
        checkFallen(); 
        takeCoin();
        checkPrincessCollision();
        
        if (invincibilityTimer == 0) {
            checkMonsterCollision(); 
        }
        
        updateAnimation();
        handleBlinking(); 
        checkWin();
    }
    
    private void checkWin()
    {
        if(isTouching(princess.class))
        {
            getWorld().showText("THANK YOU MARIO!", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    private void checkFallen()
    {
        final int DEATH_LINE = 550; 
        if (getY() > DEATH_LINE && !isDead) {
            die(); 
        }
    }

    private void checkKeys()
    {
        if (Greenfoot.isKeyDown("right")) {
            facingRight = true;
            facingLeft = false;
            isMoving = true;
        } else if (Greenfoot.isKeyDown("left")) {
            facingRight = false;
            facingLeft = true;
            isMoving = true;
        } else {
            isMoving = false;
        }

        if ((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("space")) && onGround) {
            fallSpeed = -JUMP_POWER;
            Greenfoot.playSound("jump.wav");
            jumped = true; 
        }
    }
    
    private void handleHorizontalMovement()
    {
        int move = 0;
        if (isMoving) {
            move = facingRight ? speed : -speed;
        }
        
        if (move != 0) {
            setLocation(getX() + move, getY());
            
            int checkOffset = move > 0 ? getImage().getWidth() / 2 : -getImage().getWidth() / 2;
            Actor obstacle = getOneObjectAtOffset(checkOffset, 0, Ground.class);
            if (obstacle == null) obstacle = getOneObjectAtOffset(checkOffset, 0, block.class);
            if (obstacle == null) obstacle = getOneObjectAtOffset(checkOffset, 0, tanya.class);
            if (obstacle == null) obstacle = getOneObjectAtOffset(checkOffset, 0, pipa.class);
            if (obstacle == null) obstacle = getOneObjectAtOffset(checkOffset, 0, pipa2.class);
            if (obstacle == null) obstacle = getOneObjectAtOffset(checkOffset, 0, pipa3.class);
            if (obstacle == null) obstacle = getOneObjectAtOffset(checkOffset, 0, Play.class);
            if (obstacle == null) obstacle = getOneObjectAtOffset(checkOffset, 0, brick.class);
            
            if (obstacle != null) {
                setLocation(getX() - move, getY()); 
            }
        }
    }

    private void applyGravityAndVerticalMovement()
    {
        setLocation(getX(), getY() + fallSpeed);

        if (fallSpeed < MAX_FALL_SPEED) {
            fallSpeed++;
        }
        
        if (fallSpeed < 0) {
            Actor obstacleTop = getOneObjectAtOffset(0, -getImage().getHeight() / 2, block.class);
            if (obstacleTop == null) obstacleTop = getOneObjectAtOffset(0, -getImage().getHeight() / 2, tanya.class);
            if (obstacleTop == null) obstacleTop = getOneObjectAtOffset(0, -getImage().getHeight() / 2, brick.class);
             
            if (obstacleTop != null) {
                if (obstacleTop instanceof tanya) {
                    ((tanya)obstacleTop).hantam();
                }
                fallSpeed = 1; 
            }
        }
        
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Ground.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, block.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, tanya.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa2.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, pipa3.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Play.class);
        if (ground == null) ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, brick.class);
        
        if (ground != null && fallSpeed >= 0) {
            int groundTop = ground.getY() - ground.getImage().getHeight() / 2;
            setLocation(getX(), groundTop - getImage().getHeight() / 2);
            fallSpeed = 0; 
            onGround = true;
            jumped = false; 
        } else if (ground == null) {
            onGround = false;
        }
    }

    private void updateAnimation()
    {
        if (!onGround) {
            setImage(facingRight ? jumpMario : jumpMarioLeft);
        }
        else if (isMoving) {
            setImage(facingRight ? runAnimation[animationTracker / 3] : leftRunAnimation[animationTracker / 3]);
            animationTracker = (animationTracker + 1) % 9;
        }
        else {
            setImage(facingRight ? rightMario : leftMario);
            animationTracker = 0;
        }
    }
    
    private void checkPrincessCollision()
    {
        princess princess = (princess) getOneIntersectingObject(princess.class);
        if (princess != null) {
            princess.startFollowing(this); 
        }
    }
    
    public void takeCoin()
    {
        Actor coin = getOneIntersectingObject(coin.class);
        if (coin != null) {
            Score += 1;
            coinTaken++;
            Greenfoot.playSound("smb_coin.wav");
            getWorld().removeObject(coin);
        }
    }
    
    private void checkMonsterCollision()
    {
        Actor monster = getOneIntersectingObject(Goomba.class);
        
        if (monster == null) {
            monster = getOneObjectAtOffset(0, 0, bowser.class);
        }

        if (monster != null) {
            boolean isFalling = fallSpeed > 0;
            int marioBottom = getY() + getImage().getHeight() / 2;
            int monsterTop = monster.getY() - monster.getImage().getHeight() / 2;
            boolean isAbove = (marioBottom > monsterTop && marioBottom < monster.getY() + 10);

            if (isFalling && isAbove) {
                if (monster instanceof Goomba) {
                    ((Goomba)monster).die(); 
                } else {
                    getWorld().removeObject(monster); 
                }
                bounce(10); 
            } 
            else {
                getHit(monster); 
            }
        }
    }

    public boolean isDead() { return isDead; }
    public int getFallSpeed() { return fallSpeed; }
    public int getJumpVelocity() { return Math.abs(JUMP_POWER); }
    public int getScore() { return Score; }
    public int getCoinCount() { return coinTaken; }
    public int getLives() { return this.lives; }

    public void bounce(int amount)
    {
        fallSpeed = -amount; 
        onGround = false;
        jumped = true; 
        updateAnimation(); 
    }

    public void getHit(Actor monster)
    {
        if (this.lives <= 0) {
            die(); 
        }
        else {
            this.lives--; 
            this.invincibilityTimer = 60; 
            Greenfoot.playSound("bump.wav"); 
            bounce(4); 
            
            if (getX() < monster.getX()) {
                setLocation(getX() - 15, getY()); 
            } else {
                setLocation(getX() + 15, getY());
            }
        }
    }

    public void die()
    {
        if (!isDead) {
            isDead = true;
            setImage(deadMario); 
            
            Greenfoot.playSound("gameover.wav"); 
            
            setLocation(getX(), getY() - 10); 
            fallSpeed = -10; 
            
            deathTimer = 0;
        }
    }
    
    private void handleBlinking()
    {
        if (invincibilityTimer > 0) {
            if (invincibilityTimer % 8 < 4) {
                getImage().setTransparency(100); 
            } else {
                getImage().setTransparency(255); 
            }
        } else if (!isDead) {
            getImage().setTransparency(255);
        }
    }
}