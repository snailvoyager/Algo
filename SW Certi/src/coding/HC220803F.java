package coding;

import java.util.LinkedHashMap;
import java.util.Map;

public class HC220803F {
    public static void main(String[] args) {

    }

    public static String firstUniqueProduct(String[] products) {
        Map<String, Boolean> map = new LinkedHashMap<>();
        for (String product : products) {
            if (map.containsKey(product)) {
                map.put(product, false);
            } else {
                map.put(product, true);
            }
        }

        for(String product : map.keySet()) {
            if (map.get(product))
                return product;
        }

        return null;
    }
}
