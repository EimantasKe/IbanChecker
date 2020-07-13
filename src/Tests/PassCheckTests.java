package Tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.Map;

public class PassCheckTests{
    protected final static String value1 = "LT647044001231465456";
    protected final static Map<String, Integer> codeLength = Iban.InputHandling.listCodes();

    @Test
    public void ValidIbanShouldPassChecksumCheck() {
        assertTrue(Iban.Checks.checksum(value1));
    }

    @Test
    public void ValidIbanShouldPassCountrySupportCheck() {
        assertTrue(Iban.Checks.countrySupport(value1, codeLength));
    }

    @Test
    public void ValidIbanShouldPassNumberLengthCheck() {
        assertTrue(Iban.Checks.numberLength(value1, codeLength));
    }

    @Test
    public void ValidIbanShouldPassSpecialCharactersCheck() {
        assertTrue(Iban.Checks.specialCharacters(value1));
    }
}
