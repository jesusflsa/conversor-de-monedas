package com.jesusflsa.conversor.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataConverter {
    public static List<List<String>> mapaDeConversionesALista(Map<String, Double> map, double cantidad) {

        List<String> keys = new ArrayList<>(map.keySet());
        List<Double> values = new ArrayList<>(map.values());
        List<List<String>> lista = new ArrayList<>(map.keySet().size());
        DecimalFormat formatter = new DecimalFormat("0.00");

        for (int i = 0; i < map.keySet().size(); i++) {
            List<String> value = new ArrayList<>(2);
            String code = keys.get(i);
            String amount = formatter.format(values.get(i) * cantidad);

            value.add(code);
            value.add(amount);

            lista.add(value);
        }

        return lista;
    }
}
