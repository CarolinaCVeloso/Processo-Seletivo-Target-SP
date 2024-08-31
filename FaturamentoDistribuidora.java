import org.json.JSONArray;
import org.json.JSONObject;

public class FaturamentoDistribuidora  {
    public static void main(String[] args) {
        String json = "{" +
                "\"faturamento\": [" +
                "{\"dia\": 1, \"valor\": 22174.1664}," +
                "{\"dia\": 2, \"valor\": 24537.6698}," +
                "{\"dia\": 3, \"valor\": 26139.6134}," +
                "{\"dia\": 4, \"valor\": 0.0}," + // exemplo de dia sem faturamento
                "{\"dia\": 5, \"valor\": 0.0}," +
                "{\"dia\": 6, \"valor\": 26742.6612}" +
                // Adicione outros dias conforme necessário
                "]" +
                "}";

        JSONObject obj = new JSONObject(json);
        JSONArray faturamento = obj.getJSONArray("faturamento");

        double menor = Double.MAX_VALUE, maior = Double.MIN_VALUE, soma = 0;
        int diasComFaturamento = 0, diasAcimaDaMedia = 0;

        for (int i = 0; i < faturamento.length(); i++) {
            double valor = faturamento.getJSONObject(i).getDouble("valor");

            if (valor > 0) {
                if (valor < menor) menor = valor;
                if (valor > maior) maior = valor;
                soma += valor;
                diasComFaturamento++;
            }
        }

        double media = soma / diasComFaturamento;

        for (int i = 0; i < faturamento.length(); i++) {
            double valor = faturamento.getJSONObject(i).getDouble("valor");
            if (valor > media) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: " + menor);
        System.out.println("Maior valor de faturamento: " + maior);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}