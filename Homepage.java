import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Homepage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Homepage extends World
{
    private GreenfootSound bgMusic;
    /**
     * Constructor for objects of class Homepage.
     * 
     */
    public Homepage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 500, 1); 
        bgMusic = new GreenfootSound("titleSong.mp3");
        bgMusic.playLoop();
        
        prepare();
    }
    public void stopped()
    {
        bgMusic.stop();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Play play = new Play();
        addObject(play,404,329);
        mario mario = new mario();
        addObject(mario,444,444);
        mario.setLocation(406,432);
        mario.setLocation(706,406);
        mario.setLocation(711,399);
        removeObject(mario);
    }
}