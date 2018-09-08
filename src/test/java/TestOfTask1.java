import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.anronelenberger.homework6.*;

public class TestOfTask1 {

    @Test
    public void test1() {
        int[] array1 = {5, 6, 7};
        Assert.assertArrayEquals(MainClass.task1(1, 2, 3, 4, 5, 6, 7), array1);
    }

    @Test
    public void test2() {
        int[] array2 = {7};
        Assert.assertArrayEquals(MainClass.task1(1, 4, 3, 4, 5, 4, 7), array2);
    }

    @Test
    public void test3() {
        int[] array3 = {};
        Assert.assertArrayEquals(MainClass.task1(1, 2, 3, 4, 5, 6, 4), array3);
    }

    @Test(expected = RuntimeException.class)
    public void test4() {
        MainClass.task1(1, 2, 3, 5, 6, 7, 8, 0);
    }
}
