import org.junit.Assert;
import org.junit.Test;
import ru.geekbrains.anronelenberger.homework6.MainClass;

public class TestOfTask2 {
    @Test
    public void test1() {
        int[] array1 = {4, 1, 2, 3, 4, 5, 6, 0};
        Assert.assertFalse(MainClass.task2(array1));
    }

    @Test
    public void test2() {
        int[] array2 = {1, 2, 3, 4, 5, 6};
        Assert.assertFalse(MainClass.task2(array2));
    }

    @Test
    public void test3() {
        int[] array3 = {1};
        Assert.assertTrue(MainClass.task2(array3));
    }

    @Test
    public void test4() {
        int[] array4 = {};
        Assert.assertFalse(MainClass.task2(array4));
    }
}
