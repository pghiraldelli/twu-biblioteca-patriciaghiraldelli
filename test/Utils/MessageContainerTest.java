package Utils;

import com.twu.biblioteca.Utils.MessageContainer;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;


public class MessageContainerTest extends TestUtils {

    @Test
    public void shouldGetWelcomeMessage() {
        String msg = MessageContainer.getWelcomeMessage();

        assertEquals("~~~~ Welcome to Biblioteca! ~~~~", msg);
    }

    @Test
    public void shouldGetBookList(){
        String expected = "\n--------------------------------\n";
        expected +=       "     ***  Book Details  ***     \n";
        expected +=       "--------------------------------\n";
        expected += "| 0 | Book 1 | Author 1 | 1994 |\n";
        expected += "| 1 | Book 2 | Author 2 | 2018 |\n";
        expected += "| 2 | Book 3 | Author 3 | 2000 |\n";

        String result = MessageContainer.getBookDetails(getBooks(), "Book Details");
        assertEquals(expected, result);
    }

    @Test
    public void shouldGetMenuOptions() {
        String expected = "\n--------------------------------\n";
        expected += "         ***  Menu  ***         \n";
        expected += "--------------------------------\n";
        ;
        expected += "|    0- Quit                |\n";
        expected += "|    1- Book details        |\n";
        expected += "|    2- Checkout book       |\n";
        expected += "|    3- Return book         |\n";
        expected += "|    4- Movie details       |\n";

        assertEquals(expected, MessageContainer.getMenuOptions());
    }

    @Test
    public void shouldGetMovieList(){
        String expected = "\n--------------------------------\n";
        expected +=       "    ***  Movie details  ***    \n";
        expected +=       "--------------------------------\n";
        expected += "| 0 | Movie 1 | 2010 | Director 1 | 3 |\n";
        expected += "| 1 | Movie 2 | 2018 | Director 2 | 1 |\n";
        expected += "| 2 | Movie 3 | 1850 | Director 3 | 5 |\n";
        expected += "| 3 | Movie 4 | 1900 | Director 4 | 10 |\n";
        expected += "| 4 | Movie 5 | 2000 | Director 5 | 7 |\n";

        String result = MessageContainer.getMovieDetails(getMovies(), "Movie details");
        assertEquals(expected, result);
    }
}
