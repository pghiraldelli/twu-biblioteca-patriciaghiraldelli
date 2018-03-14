package Utils;

import com.twu.biblioteca.Utils.StringUtils;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class StringUtilsTest {

    private StringUtils su;

    @Test
    public void shouldGetFormattedString(){
        String expected = "111-1111";
        String mask = "###-####";
        String input = "1111111";
        String formatted = "";

        try{
            formatted = StringUtils.formatString(input, mask);
        }catch(Exception e){
            assertFalse(true);
        }

        assertEquals(expected, formatted);
    }

    @Test
    public void shouldReturnTrueToNumbers(){
        String onlyNumbers = "123";
        assertTrue(StringUtils.containsOnlyNumbers(onlyNumbers));
    }

    @Test
    public void shouldReturnFalseToChars(){
        String withChars = "1A3";
        assertFalse(StringUtils.containsOnlyNumbers(withChars));
    }

    @Test
    public void shouldReturnCentralizedText(){
        String textToCentralize = "hey";
        int sizeOfString = 5;

        String expected = " hey ";

        assertEquals(expected, StringUtils.centralizeString(textToCentralize, sizeOfString));
    }

    @Test
    public void shouldReturnSameText(){
        String textToCentralize = "hey";
        int sizeOfString = 4;

        String expected = "hey";

        assertEquals(expected, StringUtils.centralizeString(textToCentralize, sizeOfString));
    }
}
