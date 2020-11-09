package cloudapps.draughts.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConsoleTest {

	@Mock
    private BufferedReader bufferedReader;

    @InjectMocks
    private Console console = new Console();

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("1");
        assertThat(this.console.readString(""), is("1"));
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringIntegerThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("1");
        assertThat(this.console.readInt(""), is(1));
    }

    @Disabled
    @Test 
    public void testGivenNewConsoleWhenReadLineCorrectStringIntegerThenIsInCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        Assertions.assertThrows(AssertionError.class, () -> {
        	assertThat(this.console.readInt(""), is(1));
		});
    }

    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringCharThenIsCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        assertThat(this.console.readChar(""), is('a'));
    }

    @Disabled
    @Test
    public void testGivenNewConsoleWhenReadLineCorrectStringCharThenIsInCorrect() throws IOException {
        when(this.bufferedReader.readLine()).thenReturn("a");
        Assertions.assertThrows(AssertionError.class, () -> {
        	assertThat(this.console.readChar(""), is(1));
		});
    }
}
