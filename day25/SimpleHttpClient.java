package day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class SimpleHttpClient {

    public static void main(String[] args) {
        String urlString = "http://example.com"; 

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            Map<String, List<String>> headers = connection.getHeaderFields();
            System.out.println("Response Headers:");
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseBody = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseBody.append(inputLine).append("\n");
            }
            in.close();

            System.out.println("Response Body:");
            System.out.println(responseBody.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}