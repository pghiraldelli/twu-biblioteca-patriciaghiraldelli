package Utils;

import com.twu.biblioteca.Utils.MessageContainer;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class MessageContainerTest extends TestUtils {

    @Test
    public void testGetWelcomeMessage() {
        MessageContainer container = new MessageContainer();
        String msg = container.getWelcomeMessage();

        assertEquals("~~~~ Welcome to Biblioteca! ~~~~", msg);
    }

    @Test
    public void testGetBookList(){
        MessageContainer container = new MessageContainer();

        String expected = "\n--------------------------------\n";
        expected +=       "     ***  Book Details  ***     \n";
        expected +=       "--------------------------------\n";
        expected += "| 0 | Book 1 | Author 1 | 1994 |\n";
        expected += "| 1 | Book 2 | Author 2 | 2018 |\n";
        expected += "| 2 | Book 3 | Author 3 | 2000 |\n";

        String result = container.getBookDetails(getBooks(), "Book Details");
        assertEquals(expected, result);
    }

    @Test
    public void testGetMenuOptions() {
        String expected = "\n--------------------------------\n";
        expected += "         ***  Menu  ***         \n";
        expected += "--------------------------------\n";
        ;
        expected += "|    0- Quit                |\n";
        expected += "|    1- Book details        |\n";
        expected += "|    2- Checkout book       |\n";
        expected += "|    3- Return book         |\n";

        assertEquals(expected, MessageContainer.getMenuOptions());
    }
}
