import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;


public class GeneradorDeArchivo {

    public void guardarJson(DatosConversionMoneda datos) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter escritura = new FileWriter(datos.result()+".json");
        escritura.write(gson.toJson(datos));
        escritura.close();

    }
}
