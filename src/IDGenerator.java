
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IDGenerator {
    public static void main(String[] args) {
        Map<String, Integer> languageCountMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            System.out.println("Select a programming language (Java, Python, PHP): ");
            String selectedLanguage = scanner.nextLine().toLowerCase();

            if (isValidLanguage(selectedLanguage)) {
                int count = languageCountMap.getOrDefault(selectedLanguage, 0) + 1;
                languageCountMap.put(selectedLanguage, count);

                String generatedID = generateID(selectedLanguage, count);
                System.out.println("Hello " + name + ", your generated ID: " + generatedID);
            } else {
                System.out.println("Invalid language selection. Please choose Java, Python, or PHP.");
            }

            System.out.println("Do you want to generate another ID? (yes/no): ");
            String continueOption = scanner.nextLine().toLowerCase();
            if (!continueOption.equals("yes")) {
                break;
            }
        }

        scanner.close();
    }

    private static boolean isValidLanguage(String language) {
        return language.equals("java") || language.equals("python") || language.equals("php");
    }

    private static String generateID(String language, int count) {
        return language.substring(0, 1).toUpperCase() + language.substring(1) + count;
    }
}
