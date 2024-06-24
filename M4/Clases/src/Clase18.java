import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Clase18 {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("---- Consumir Api ------------------------------------");
        consumirApi();
        System.out.println("---- Consumir Api Uri --------------------------------");
        consumirApiUri();
        System.out.println("---- Consumir Txt ------------------------------------");
        consumirArchivo();
        System.out.println("---- Consumir Txt Uri --------------------------------");
        consumirArchivoUri();
        System.out.println("------------------------------------------------------");
    }

    public static void consumirApi() throws IOException {
        URL url = new URL("https://artema.bsite.net/api/Publico/Enlace");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;

        System.out.println("Respuesta de la API:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        connection.disconnect();
    }

    public static void consumirApiUri() throws IOException, InterruptedException {
        URI uri = URI.create("https://artema.bsite.net/api/Publico/Enlace");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Respuesta de la API:");
        System.out.println(response.body());
    }

    public static void consumirArchivo() throws IOException {
        URL url = new URL("https://thenefelin.github.io/Viajes_Chile/assets/docs/Aloy.txt");
        URLConnection connection = url.openConnection();

        InputStream inputStream = connection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        System.out.println("Respuesta del Txt:");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        inputStream.close();
    }

    public static void consumirArchivoUri() throws IOException, InterruptedException {
        URI uri = URI.create("https://thenefelin.github.io/Viajes_Chile/assets/docs/Aloy.txt");
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Contenido del archivo remoto:");
        System.out.println(response.body());
    }
}
