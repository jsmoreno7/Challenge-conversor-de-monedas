import java.util.HashMap;

public record DatosConversionMoneda(String result, int time_last_update_unix,
                                    String time_last_update_utc, int time_next_update_unix,
                                    String time_next_update_utc,
                                    String base_code,
                                    HashMap conversion_rates
                     )  {
}
