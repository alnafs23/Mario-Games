import greenfoot.*;

public class HUD extends Actor
{
    private GreenfootImage image;
    private GreenfootImage coinIcon; 

    public HUD()
    {
        image = new GreenfootImage(600, 60); 
        coinIcon = new GreenfootImage("coin.gif"); 
        coinIcon.scale(20, 20); 
        
        setImage(image); 
    }

    /**
     * Method ini dipanggil oleh World untuk memperbarui data
     * DIUBAH: Menambahkan parameter 'lives'
     */
    public void update(int score, int coins, int time, int lives) 
    {
        image.clear();
        
        image.setColor(Color.WHITE); 
        image.setFont(new Font("Verdana", true, false, 18)); 

        String scoreText = String.format("%06d", score); 
        String coinText = String.format("x%02d", coins);
        String timeText = String.format("%03d", time);
        
        String livesText = String.format("x%d", lives); 
        image.drawString("MARIO", 50, 25);
        image.drawString(scoreText, 50, 50);
        
        image.drawImage(coinIcon, 200, 30); 
        image.drawString(coinText, 225, 50);
        
        image.drawString("LIVES", 300, 25);
        image.drawString(livesText, 300, 50);
        
        image.drawString("TIME", 420, 25); 
        image.drawString(timeText, 420, 50);
    }
}