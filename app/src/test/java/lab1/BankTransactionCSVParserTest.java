package lab1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankTransactionCSVParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "30-01-2017,-50,Tesco";

        BankTransaction result = statementParser.parseFrom(line);

        BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    public void shouldReturnErrorFromZero() throws Exception {
        String line = "30-01-2017,50,Tesco";
        BankTransaction result = statementParser.parseFrom(line);
        assertNotEquals(0, result.getAmount(), 0.0d);
    }

}
