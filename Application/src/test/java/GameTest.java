import com.ZombieW.*;
import com.ZombieW.Character;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void demoTest() { // making sure JUnit works
        assertTrue(true);
    }

    @Test
    public void characterTest() {
        //instantiating test object
        MainCharacter testChar = new MainCharacter(null, null);

        //testing score begins at 0
        assertEquals(0, testChar.score);

        //testing character image is successfully obtained
        assertNotNull(testChar.getSprite());

        //testing add reward method performs as intended
        assertEquals(0, testChar.getRewardsCollected());
        testChar.addReward();
        assertEquals(1, testChar.getRewardsCollected());

        //testing character movement
    }
    @Test
    public void movementTest() {
        //instantiating test object
        GamePanel testPanel = new GamePanel();
        //testing character movement
        testPanel.startGameThread();

        assertEquals(testPanel.mc.getX(), 100);
        assertEquals(testPanel.mc.getY(), 100);

        testPanel.mc.moveUp();

        assertEquals(testPanel.mc.getX(), 100);
        assertEquals(testPanel.mc.getY(), 52);

        testPanel.mc.moveDown();

        assertEquals(testPanel.mc.getX(), 100);
        assertEquals(testPanel.mc.getY(), 100);

        testPanel.mc.moveRight();

        assertEquals(testPanel.mc.getX(), 148);
        assertEquals(testPanel.mc.getY(), 100);

        testPanel.mc.moveLeft();

        assertEquals(testPanel.mc.getX(), 100);
        assertEquals(testPanel.mc.getY(), 100);

    }

    @Test
    public void winnable() {
        //instantiating test Game
        GamePanel testGame = new GamePanel();
        //testing if player can exit when rewards collected
        if(testGame.mc.getRewardsCollected() == 5){
            assert(testGame.exit.isExitable());
        }
    }
    @Test void chaserGeneration(){
        GamePanel testGame = new GamePanel();
        // testing to see if moving Zombie generates on player
        assert(testGame.movingZomb.getX() != testGame.mc.getX());
    }
    @Test void leglessGeneration(){
        GamePanel testGame = new GamePanel();
        // testing to see if non moving Zombie generates on player
        for(int i = 0; i < testGame.zomb.length; i++){
            assert(testGame.zomb[i].getX() != testGame.mc.getX());
        }
    }
    @Test void bonusGeneration(){
        // testing if reward generates on player
        GamePanel testGame = new GamePanel();
        for(int i = 0; i < testGame.r.length; i++){
            assert(testGame.r[i].getX() !=  testGame.mc.getX());
        }
    }
    @Test
    public void chaserTest() {
        //instantiating test object
        Chaser testZombie = new Chaser(null, null);

        //testing zombie image is successfully obtained
        assertNotNull(testZombie.getSprite());
    }

    @Test
    public void leglessTest() {
        //instantiating test object
        Legless testZombie = new Legless(null, null);

        //testing zombie image is successfully obtained
        assertNotNull(testZombie.getSprite());

        //testing zombie damage to player score
        assertEquals(3, testZombie.getDamage());
    }



}
