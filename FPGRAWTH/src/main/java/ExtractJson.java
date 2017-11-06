
import org.json.JSONArray;
import org.json.JSONObject;
import z11.F_ile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MinhPC
 */
public class ExtractJson {

    public static void main(String[] args) {

        String data = F_ile.getContentOfFile("data/data.json");
        JSONArray listItems = new JSONArray(data);

        int length = listItems.length();
        int current = 0;
        while (current < length - 1) {
            JSONObject item = new JSONObject();
            JSONArray listItem = new JSONArray();

            JSONObject head = listItems.getJSONObject(current);
            System.out.println(head.getString("Invoice"));
            item.put("Invoice", head.getString("Invoice"));
            listItem.put(new JSONObject().put("item", head.getString("StockCode")));
            int cur = current;
            while (head.getString("Invoice").equals(listItems.getJSONObject(cur + 1).getString("Invoice"))) {
                System.out.println("\t" + listItems.getJSONObject(cur + 1).getString("Invoice"));
                listItem.put(new JSONObject().put("item", listItems.getJSONObject(cur + 1).getString("Invoice")));
                cur++;
            }
            item.put("listItem", listItem);
            F_ile.writeStringToFile("data/jsonData.json", item.toString(), true);
            F_ile.writeStringToFile("data/jsonData.json", ",", true);
            System.out.println("===========");
            current = cur + 1;

        }

//        F_ile.writeStringToFile("data/dataMin.json", total.toString(), false);
    }
}
