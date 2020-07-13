package Iban;

import java.math.BigInteger;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checks {
    // Magiškas skaičius IBAN validavimo algoritme - 97
    private final static BigInteger magicNumber = new BigInteger("97");

    public static boolean checksum(String accountNumber){
        // Pertvarkomas String
        String arrangedIBAN = accountNumber.substring(4) + accountNumber.substring(0, 4);

        // keičiami simboliai į skaičius
        StringBuilder numericIBAN = new StringBuilder();

        for (int i = 0; i < arrangedIBAN.length(); i++) {
            numericIBAN.append(Character.getNumericValue(arrangedIBAN.charAt(i)));
        }

        // gautas String paverčiamas į skaičių
        BigInteger intIBAN = new BigInteger(String.valueOf(numericIBAN));

        //skaičiuojama liekana
        int remainder = intIBAN.mod(magicNumber).intValue();

        //jei liekana == 1: return true, else false
        return remainder == 1;
    }

    // tikrinami šalių kodai
    public static boolean countrySupport(String accountNumber, Map<String, Integer> codeLength){
        String countryCode = accountNumber.substring(0, 2);
        return codeLength.containsKey(countryCode);
    }

    // tikrinamas numerio ilgis
    public static boolean numberLength(String accountNumber, Map<String, Integer> codeLength){
        String countryCode = accountNumber.substring(0, 2);
        int country;
        try{
            country = codeLength.get(countryCode);
        } catch (NullPointerException e) {
            return false;
        }
        return accountNumber.length() == country;
    }

    // Su regex tikrinami ar visi simboliai priklauso lotyniškai abecėlei ir skaičiams
    public static boolean specialCharacters(String accountNumber){
        Pattern p = Pattern.compile("[^A-Z0-9]");
        Matcher m = p.matcher(accountNumber);
        boolean b = m.find();
        return !b;
    }
}
