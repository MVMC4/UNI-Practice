import java.util.Scanner;

public class Sym_Enc {

    static String state_instance = "Enter";

    public String[] alpha_array = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", " "
    };

    public static void main(String[] args) {

        progress_loop();

    }

    static void progress_loop() {

        Inputs inputs = new Inputs();

        System.out.print(state_instance + " text to encrypt(alphabetic): ");
        String response = inputs.start();

        String response_code = response.substring(0, 1);
        int response_length = response.length();
        response = response.substring(3, response_length);

        if (response_code.equals("1")) {

            System.out.println("\nEncryption process completed.");
            System.out.println("Result: " + response);

        } else {

            System.err.println("\nEncryption process failed.");
            System.out.println("Error: " + response);

            System.err.println("\n===============================================================================\n");
            state_instance = "Re-enter";
            progress_loop();

        }
    }

}

class Inputs {

    static Encryption enc = new Encryption();
    static Scanner scanner = new Scanner(System.in);

    static String start() {

        String response = null;

        String input = scanner.nextLine();

        System.out.println("Text to encrypt: " + input);

        if (alhpa_verif(input)) {

            response = selection(input);

        } else {
            response = "0: Non alpahanumeric charcheter detected.";
        }

        return response;
    }

    static boolean alhpa_verif(String input) {
        String raw = input;
        int raw_length = raw.length();
        Sym_Enc sym = new Sym_Enc();
        String[] local_alpha_array = sym.alpha_array;
        boolean alpha_bool = false;

        for (int string_loop = 0; string_loop < raw_length; string_loop++) {
            String unit = raw.substring(string_loop, string_loop + 1);
            alpha_bool = false;
            for (String alpha : local_alpha_array) {

                if (unit.equals(alpha)) {
                    alpha_bool = true;
                }

            }
            if (!alpha_bool) {
                break;
            }
        }

        return alpha_bool;
    }

    static String selection(String input) {

        System.out.print("\nEnter encryption method, manual array | randomised array(enter, 0 | 1): ");
        String response = null;

        if (scanner.hasNext()) {
            String method = scanner.nextLine();

            if (method.equals("0")) {

                response = enc.manual(input);

            } else if (method.equals("1")) {

                response = "1: " + enc.random(input);

            } else {
                response = "0: Invalid method selected.";
            }
        }
        return response;
    }

}

class Encryption {

    static String[] alpha_array = new String[27];

    Encryption() {

        Sym_Enc sym = new Sym_Enc();
        this.alpha_array = sym.alpha_array;

    }

    static String random(String raw) {

        int input_length = raw.length();
        int tens = 1;

        for (int index = 1; index < input_length; index++) {
            tens *= 10;
        }

        int key = (int) ((Math.random() + 1) * tens);
        String encyp = incrementor(raw, key);

        return "Randomm Encryption: " + encyp + " with key: " + key;

    }

    static String manual(String raw) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manual array selected.");
        // Manual_Sym manual = new Manual_Sym(input);

        System.out.print("Enter key: ");
        int key = scanner.nextInt();
        int raw_length = raw.length();
        int key_length = (key + "").length();
        if (key_length != raw_length) {
            return "0: Key is not the same length as the input.";
        }
        scanner.nextLine(); // Consume newline

        return "1: Manual Encryption: " + incrementor(raw, key) + " with key: " + key;

    }

    static String incrementor(String raw, int key) {

        int input_length = raw.length();

        String str_key = key + "";
        String build = "";

        for (int index = 0; index < input_length; index++) {
            String unit = raw.substring(index, index + 1);
            int seg_key = Integer.parseInt(str_key.substring(index, index + 1));
            int alpha_index = -1;
            for (String alpha : alpha_array) {
                alpha_index++;
                if (unit.equals(alpha)) {
                    if (alpha_index + seg_key > 26) {
                        alpha_index = alpha_index - 27;
                    }
                    build += alpha_array[alpha_index + seg_key];
                    break;
                }

            }

        }

        return build;

    }
}
