import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String json = response.body();

        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> filmes = jsonParser.parse(json);
        
        filmes.forEach(f -> System.out.println("Titulo: " + f.get("title") + 
            ", Poster: " + f.get("image") +
            ", Rank:" + f.get("rank") +
            ", Avaliação IMDB" + f.get("imDbRating")));
    }
}
