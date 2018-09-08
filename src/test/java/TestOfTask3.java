import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.anronelenberger.homework6.SQLTable;

import java.sql.SQLException;

public class TestOfTask3 {
    SQLTable sqlTable;

    @Before
    public void create() {
        sqlTable = new SQLTable();
    }

    @Test
    public void insertTest() {
        try {
            Assert.assertEquals("Bob9", sqlTable.insert("Bob9", 12));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readTest() {
        try {
            Assert.assertEquals("Bob1", sqlTable.read());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
