import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObtenerMonedaApi {

    public DatosConversionMoneda ConversorMoneda(String monedaP) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7f08bb9f6dffe2898a591b56/latest/"+monedaP);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), DatosConversionMoneda.class);

        } catch (Exception e) {
            throw new RuntimeException("No encontre esa Moneda");
        }
    }
}



