import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie eine IP-Adresse ein (z.B. 192.168.0.1):");
        String ipAdresse = scanner.nextLine();

        // Umrechnung und Ausgabe der verschiedenen Darstellungen
        String[] darstellungen = convertIP(ipAdresse);
        System.out.printf("Dezimal: %s%n", darstellungen[0]);
        System.out.printf("Binär: %s%n", darstellungen[1]);
        System.out.printf("Oktal: %s%n", darstellungen[2]);
        System.out.printf("Hexadezimal: %s%n", darstellungen[3]);
    }

    // Methode zur Umrechnung der IP-Adresse in verschiedene Zahlensysteme
    public static String[] convertIP(String ip) {
        String[] oktette = ip.split("\\.");
        String[] dezimal = new String[4];
        String[] binaer = new String[4];
        String[] oktal = new String[4];
        String[] hexadezimal = new String[4];

        // Schleife durch jedes Oktett der IP-Adresse
        for (int i = 0; i < oktette.length; i++) {
            int teil = Integer.parseInt(oktette[i]);

            dezimal[i] = String.valueOf(teil);
            binaer[i] = String.format("%08d", Integer.parseInt(Integer.toBinaryString(teil)));
            oktal[i] = Integer.toOctalString(teil);
            hexadezimal[i] = String.format("%02X", teil);
        }

        return new String[]{
                String.join(".", dezimal),
                String.join(".", binaer),
                String.join(".", oktal),
                String.join(".", hexadezimal)
        };
    }
}
