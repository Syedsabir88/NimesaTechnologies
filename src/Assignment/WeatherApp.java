package Assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherAPI weatherAPI = new WeatherAPI();

        int choice;
        do {
            System.out.println("1. Get weather");
            System.out.println("2. Get Wind Speed");
            System.out.println("3. Get Pressure");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date1 = scanner.nextLine();
                    weatherAPI.printTemperature(date1);
                    break;
                case 2:
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date2 = scanner.nextLine();
                    weatherAPI.printWindSpeed(date2);
                    break;
                case 3:
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String date3 = scanner.nextLine();
                    weatherAPI.printPressure(date3);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}

class WeatherAPI {

    public void printTemperature(String date) {
        String apiUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";
        String response = fetchDataFromAPI(apiUrl);
        // Implement JSON parsing logic to extract temperature data for the given date and print it.
        System.out.println("Temperature on " + date + ": " + "XX °C");
    }

    public void printWindSpeed(String date) {
        String apiUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";
        String response = fetchDataFromAPI(apiUrl);
        // Implement JSON parsing logic to extract wind speed data for the given date and print it.
        System.out.println("Wind Speed on " + date + ": " + "XX m/s");
    }

    public void printPressure(String date) {
        String apiUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";
        String response = fetchDataFromAPI(apiUrl);
        // Implement JSON parsing logic to extract pressure data for the given date and print it.
        System.out.println("Pressure on " + date + ": " + "XX hPa");
    }

    private String fetchDataFromAPI(String apiUrl) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            try (Scanner scanner = new Scanner(conn.getInputStream())) {
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}