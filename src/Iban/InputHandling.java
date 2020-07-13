package Iban;

import java.io.*;
import java.util.*;

public class InputHandling {

    //funkcija terminalo įvesčiai skaityti
    @SuppressWarnings("resource")
    public static String readInput() {
        System.out.println("Įrašykite IBAN sąskaitos numerį validavimui");
        Scanner scanner = new Scanner(System.in);
        String accountNumber = scanner.nextLine();

        accountNumber = accountNumber.toUpperCase();
        System.out.println("Rasta įvestis- " + accountNumber);
        return accountNumber;
    }

    //skaitymas iš failo
    public static List<String> readFile() {
        List<String> ibanArray = new ArrayList<>();

        System.out.println("Įveskite failo kelią ir pavadinimą");

        @SuppressWarnings("resource")
        Scanner filePath = new Scanner(System.in);
        String path = filePath.nextLine();

        System.out.println("Reading file from " + path);

        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                ibanArray.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String s : ibanArray) {
            System.out.println(s);
        }

        System.out.println();
        return ibanArray;
    }

    // patikrinamas IBAN numeris
    public static boolean Manual(String accountNumber, Map<String, Integer> codeLength) {
        accountNumber = accountNumber.replaceAll("\\s+", "");

        if(!Checks.numberLength(accountNumber,codeLength)){
            System.out.println(accountNumber + " nėra validus IBAN - Netinkamas IBAN numerio ilgis\n");
            return false;
        }
        if(!Checks.specialCharacters(accountNumber)){
            System.out.println(accountNumber + " nėra validus IBAN - Numeryje yra nevartotinų simbolių\n");
            return false;
        }
        if(!Checks.checksum(accountNumber)){
            System.out.println(accountNumber + " nėra validus IBAN - Netinkama IBAN kontrolinė suma\n");
            return false;
        }
        if(!Checks.countrySupport(accountNumber,codeLength)){
            System.out.println(accountNumber + " nėra validus IBAN - Šalis nepalaiko IBAN\n");
            return false;
        }


        /*
        tiktų:
         return Checks.specialCharacters(accountNumber);
         jei vėliau nenorima būtų pridėti daugiau tikrinimų
        */
        System.out.println(accountNumber + " yra validus IBAN \n");
        return true;
    }

    // nuskaitomi IBAN numeriai faile ir tikrinami naudojantis Manual()
    public static void File(List<String> ibanArray, Map<String, Integer> codeLength) throws IOException {
        System.out.println("Enter File Output path");

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String outputPath = scanner.nextLine();

        boolean isValid;
        List<String> ibanOutput = new ArrayList<>();

        File file = new File(outputPath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (int i = 0; i < ibanArray.size(); i++) {
            isValid = Manual(ibanArray.get(i), codeLength);
            ibanOutput.add(ibanArray.get(i).replaceAll("\\s+", "") + ";" + isValid);
            writer.write(ibanOutput.get(i));
            writer.newLine();
        }

        writer.close();
    }

    // Sudaromas šalių numerių ilgių sąrašas
    public static Map<String, Integer> listCodes(){
        Map<String, Integer> codeLength = new HashMap<>();

        codeLength.put("AL", 28);
        codeLength.put("AD", 24);
        codeLength.put("AT", 20);
        codeLength.put("AZ", 28);
        codeLength.put("BH", 22);
        codeLength.put("BY", 28);
        codeLength.put("BE", 16);
        codeLength.put("BA", 20);
        codeLength.put("BR", 29);
        codeLength.put("BG", 22);
        codeLength.put("CR", 22);
        codeLength.put("HR", 21);
        codeLength.put("CY", 28);
        codeLength.put("CZ", 24);
        codeLength.put("DK", 18);
        codeLength.put("DO", 28);
        codeLength.put("SV", 28);
        codeLength.put("EE", 20);
        codeLength.put("FO", 18);
        codeLength.put("FI", 18);
        codeLength.put("FR", 27);
        codeLength.put("GE", 22);
        codeLength.put("DE", 22);
        codeLength.put("GI", 23);
        codeLength.put("GR", 27);
        codeLength.put("GL", 18);
        codeLength.put("GT", 28);
        codeLength.put("VA", 22);
        codeLength.put("HU", 28);
        codeLength.put("IS", 26);
        codeLength.put("IQ", 23);
        codeLength.put("IE", 22);
        codeLength.put("IL", 23);
        codeLength.put("IT", 27);
        codeLength.put("JO", 30);
        codeLength.put("KZ", 20);
        codeLength.put("XK", 20);
        codeLength.put("KW", 30);
        codeLength.put("LV", 21);
        codeLength.put("LB", 28);
        codeLength.put("LI", 21);
        codeLength.put("LT", 20);
        codeLength.put("LU", 20);
        codeLength.put("MT", 31);
        codeLength.put("MR", 27);
        codeLength.put("MU", 30);
        codeLength.put("MD", 24);
        codeLength.put("MC", 27);
        codeLength.put("ME", 22);
        codeLength.put("NL", 18);
        codeLength.put("MK", 19);
        codeLength.put("NO", 15);
        codeLength.put("PK", 24);
        codeLength.put("PS", 29);
        codeLength.put("PL", 28);
        codeLength.put("PT", 25);
        codeLength.put("QA", 29);
        codeLength.put("RO", 24);
        codeLength.put("LC", 32);
        codeLength.put("SM", 27);
        codeLength.put("ST", 25);
        codeLength.put("SA", 24);
        codeLength.put("RS", 22);
        codeLength.put("SC", 31);
        codeLength.put("SK", 24);
        codeLength.put("SI", 19);
        codeLength.put("ES", 24);
        codeLength.put("SE", 24);
        codeLength.put("CH", 21);
        codeLength.put("TL", 23);
        codeLength.put("TN", 24);
        codeLength.put("TR", 26);
        codeLength.put("UA", 29);
        codeLength.put("AE", 23);
        codeLength.put("GB", 22);
        codeLength.put("VG", 24);

        return codeLength;
    }

}
