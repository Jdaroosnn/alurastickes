import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    
    private static final Pattern REGEX_URL = Pattern.compile("h(.+)@\\.(.+)\\.(.+)");

    private static String modifUrl (String url) {
        Matcher matcher = REGEX_URL.matcher(url);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }

        return matcher.group(0).replace("." + matcher.group(2), "");
    }

    public static void main(String[] args) throws Exception {
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> filmes = jsonParser.parse(json);
        
        GeradorDeFigurinhas gDeFigurinhas = new GeradorDeFigurinhas();
        // String urlImagem = filmes.get(0).get("image");
        // String novaUrl = modifUrl(urlImagem);
        // System.out.println(urlImagem);
        // System.out.println(novaUrl);
        
        // filmes.forEach(f -> {
        //     String urlImagem = f.get("image");
        //     String novaUrl = modifUrl(urlImagem);
        //     String titulo = f.get("title");

        //     InputStream inputStream;
        //     try {
        //         inputStream = new URL(urlImagem).openStream();
        //         String nomeArquivo = "./saida/" + titulo + ".jpg";
        //         gDeFigurinhas.cria(inputStream, nomeArquivo);
        //     } catch (IOException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
            
            
        //     System.out.println("Titulo: " + f.get("title"));
        //     System.out.println(urlImagem);
        //     System.out.println(novaUrl);
        // });

        for (int i = 0; i < 10; i++) {
            String urlImagem = modifUrl(filmes.get(i).get("image"));
            String titulo = filmes.get(i).get("title");

            InputStream inputStream;
            try {
                inputStream = new URL(urlImagem).openStream();
                String nomeArquivo = "./saida/" + titulo + ".jpg";
                gDeFigurinhas.cria(inputStream, nomeArquivo);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
            System.out.println("Titulo: " + titulo);
        }
    }
}
