package Tests;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.util.Map;

public class FailCheckTests{
    protected final static String value1 = "LT647044001231@65456";
    protected final static String value2 = "LT227044077788877777";
    protected final static String value3 = "US227044077788877777";
    protected final static String value4 = "LT64704400123146545";
    protected final static String value5 = "LT6470440012314654561";
    protected final static Map<String, Integer> codeLength = Iban.InputHandling.listCodes();

    @Test
    public void SpecialCharacterShouldFailSpecialCharactersCheck() {
        assertFalse(Iban.Checks.specialCharacters(value1));
    }

    @Test
    public void InvalidIbanShouldFailChecksumCheck() {
        assertFalse(Iban.Checks.checksum(value2));
    }

    @Test
    public void InvalidCountryCodeIbanShouldFailCountrySupportCheck() {
        assertFalse(Iban.Checks.countrySupport(value3, codeLength));
    }

    @Test
    public void ShortIbanShouldFailNumberLengthCheck() {
        assertFalse(Iban.Checks.numberLength(value4, codeLength));
    }

    @Test
    public void LongIbanShouldFailNumberLengthCheck() {
        assertFalse(Iban.Checks.numberLength(value5, codeLength));
    }

}