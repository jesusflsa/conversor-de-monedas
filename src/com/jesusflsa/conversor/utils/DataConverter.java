package com.jesusflsa.conversor.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataConverter {
    public static List<List<String>> mapaDeConversionesALista(Map<String, Double> map, double cantidad) {

        List<String> keys = new ArrayList<>(map.keySet());
        List<Double> values = new ArrayList<>(map.values());
        List<List<String>> lista = new ArrayList<>(map.keySet().size());

        for (int i = 0; i < map.keySet().size(); i++) {
            List<String> value = new ArrayList<>(2);
            value.add(keys.get(0));
            value.add(values.get(1) * cantidad + "");
            lista.add(value);
        }

        return lista;
    }
}
