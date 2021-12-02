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
        assertNotNull(testChar.sprite);

        //testing add reward method performs as intended
        assertEquals(0, testChar.getRewardsCollected());
        testChar.addReward();
        assertEquals(1, testChar.getRewardsCollected());
    }

    @Test
    public void collisionTest() {

    }



}
