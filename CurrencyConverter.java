package task;


import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    
    // Method to get exchange rates (hardcoded for this example)
    public static Map<String, Double> getExchangeRates() {
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0);        // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.50);
        exchangeRates.put("JPY", 110.0);
        // Add more currencies as needed
        return exchangeRates;
    }

    // Method to convert currency
    public static double convertCurrency(double amount, double fromRate, double toRate) {
        return amount * (toRate / fromRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> exchangeRates = getExchangeRates();

        System.out.println("Available currencies: USD, EUR, GBP, INR, JPY");

        System.out.print("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the currency you are converting from (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the currency you are converting to (e.g., EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        // Validate currencies
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            System.out.println("Invalid currency code.");
            scanner.close();
            return;
        }

        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        double convertedAmount = convertCurrency(amount, fromRate, toRate);

        System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, toCurrency);
        
        scanner.close();
    }
}
