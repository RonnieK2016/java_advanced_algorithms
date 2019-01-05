import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Vector2DTest {

    private static final double DELTA = 1e-9;
    private Vector2D vector2D;

    @Before
    public void createNewVector() {
        vector2D = new Vector2D();
    }

    @Test
    public void newVectorShouldHaveZeroLength() {
        Assert.assertEquals(0, vector2D.length(), DELTA);
    }

    @Test
    public void newVectorShouldHaveZeroX() {
        Assert.assertEquals(0, vector2D.getX(), DELTA);
    }

    @Test
    public void newVectorShouldHaveZeroY() {
        Assert.assertEquals(0, vector2D.getY(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSetNegativeValueToX() {
        vector2D.setX(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotSetNegativeValueToY() {
        vector2D.setY(-1);
    }
}
