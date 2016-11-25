package sample;

import com.sun.jndi.toolkit.url.Uri;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 53638138e on 14/11/16.
 */

public class ApiCartas {

    public ApiCartas() {
    }
    private static String url = "https://api.magicthegathering.io/v1/cards?";

    public ArrayList<Carta> getCardsTypes() {
        ArrayList<Carta> cards = new ArrayList<>();
        try {
            String JsonResponse = HttpUtils.get(url);
            JSONObject data = new JSONObject(JsonResponse);
            JSONArray jsonCartas = data.getJSONArray("cards");
            JSONObject object;
            JSONArray jsonArray;


            for (int i = 0; i <jsonCartas.length() ; i++) {
                Carta card = new Carta();
                object = jsonCartas.getJSONObject(i);
                card.setNombre(object.getString("name"));
                String colors = "";
                if (object.has("text")) {
                    card.setTexto(object.getString("text"));
                };
                if (object.has("rarity")) {
                    card.setTipo(object.getString("rarity"));
                }
                try {
                    jsonArray = object.getJSONArray("colors");
                    colors = jsonArray.get(0).toString();
                } catch (JSONException e) {
                    colors = "no hay color";
                }
                if (object.has("imageUrl")) {
                    card.setImagen(object.getString("imageUrl"));
                }
                JSONArray jsontypes = object.getJSONArray("types");
                String types = jsontypes.get(0).toString();
                card.setColor(colors);
                card.setTipo(types);
                cards.add(card);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cards;
    }
}
