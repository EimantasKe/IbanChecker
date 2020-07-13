import java.util.Map;
import java.util.Scanner;

public class IbanCheck {
    public static void main(String[] args) throws Exception {

        Map<String, Integer> codeLength = Iban.InputHandling.listCodes();
        boolean running = true;

        while (running) {
            System.out.println("Pasirinkite įvesties metodą:");
            System.out.println("1. Rankinė įvestis");
            System.out.println("2. Pasirinkti failą");
            System.out.println("3. Išeiti");

            @SuppressWarnings("resource")
            Scanner in = new Scanner(System.in);
            int input = in.nextInt();

            System.out.println("Aptikta įvestis - " + input);

            if (input == 1) {
                Iban.InputHandling.Manual(Iban.InputHandling.readInput(),codeLength);
            } else if (input == 2) {
                Iban.InputHandling.File(Iban.InputHandling.readFile(),codeLength);
            }else{
                running = false;
            }
        }
    }
}