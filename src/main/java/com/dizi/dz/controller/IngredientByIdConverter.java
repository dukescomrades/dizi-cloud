package com.dizi.dz.controller;

import com.dizi.dz.entity.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("DIZS",
                new Ingredient("DIZS", "Dizi Sangi", Ingredient.Type.ZARF));
        ingredientMap.put("DIZM",
                new Ingredient("DIZM", "Dizi Messi", Ingredient.Type.ZARF));
        ingredientMap.put("DIZC",
                new Ingredient("DIZC", "Dizi Chodani", Ingredient.Type.ZARF));
        ingredientMap.put("DIZZ",
                new Ingredient("DIZZ", "Dizi Zoodpazi", Ingredient.Type.ZARF));
        ingredientMap.put("GOJF",
                new Ingredient("GOJF", "Goje Farangi", Ingredient.Type.SABZIJAT));
        ingredientMap.put("SIBZ",
                new Ingredient("SIBZ", "Sibzamini", Ingredient.Type.SABZIJAT));
        ingredientMap.put("PIAZ",
                new Ingredient("PIAZ", "Piaz", Ingredient.Type.SABZIJAT));
        ingredientMap.put("SIR",
                new Ingredient("SIR", "Sir", Ingredient.Type.SABZIJAT));
        ingredientMap.put("GGMA",
                new Ingredient("GGMA", "Goosht Gosfandi - Mahiche", Ingredient.Type.GOOSHT));
        ingredientMap.put("GGGH",
                new Ingredient("GGGH", "Goosht Gosfandi - Ghalam", Ingredient.Type.GOOSHT));
        ingredientMap.put("GGGD",
                new Ingredient("GGGD", "Goosht Gosfandi - Gardan", Ingredient.Type.GOOSHT));
        ingredientMap.put("GGGV",
                new Ingredient("GGGV", "Goosht Gosfandi - Gholvegah", Ingredient.Type.GOOSHT));
        ingredientMap.put("GMOR",
                new Ingredient("GMOR", "Goosht Morgh", Ingredient.Type.GOOSHT));
        ingredientMap.put("DGOS",
                new Ingredient("DGOS", "Donbeh Gosfandi", Ingredient.Type.CHARBI));
        ingredientMap.put("LBSF",
                new Ingredient("LBSF", "Loobia Sefid", Ingredient.Type.HOBOBAT));
        ingredientMap.put("LBGR",
                new Ingredient("LBGR", "Loobia Ghermez", Ingredient.Type.HOBOBAT));
        ingredientMap.put("NOKH",
                new Ingredient("NOKH", "Nokhod", Ingredient.Type.HOBOBAT));
        ingredientMap.put("NAMK",
                new Ingredient("NAMK", "Namak", Ingredient.Type.ADVIYEHJAT));
        ingredientMap.put("ZARD",
                new Ingredient("ZARD", "Zardchoobeh", Ingredient.Type.ADVIYEHJAT));
        ingredientMap.put("DARC",
                new Ingredient("DARC", "Darchin", Ingredient.Type.ADVIYEHJAT));
        ingredientMap.put("FFGR",
                new Ingredient("FFGR", "Felfel Ghermez", Ingredient.Type.ADVIYEHJAT));
        ingredientMap.put("FFSI",
                new Ingredient("FFSI", "Felfel Siah", Ingredient.Type.ADVIYEHJAT));
        ingredientMap.put("ZIRE",
                new Ingredient("ZIRE", "Zire", Ingredient.Type.ADVIYEHJAT));
        ingredientMap.put("LIMO",
                new Ingredient("LIMO", "Limoo Amani", Ingredient.Type.ADVIYEHJAT));
        ingredientMap.put("RBSN",
                new Ingredient("RBSN", "Rob San'ati", Ingredient.Type.SOS));
        ingredientMap.put("RBMH",
                new Ingredient("RBMH", "Rob Mahali", Ingredient.Type.SOS));
        ingredientMap.put("LAVH",
                new Ingredient("LAVH", "Lavash", Ingredient.Type.NOON));
        ingredientMap.put("BARB",
                new Ingredient("BARB", "Barbari", Ingredient.Type.NOON));
        ingredientMap.put("SANG",
                new Ingredient("SANG", "Sangak", Ingredient.Type.NOON));
        ingredientMap.put("BAGT",
                new Ingredient("BAGT", "Baget", Ingredient.Type.NOON));
        ingredientMap.put("TAFT",
                new Ingredient("TAFT", "Taftoon", Ingredient.Type.NOON));
        ingredientMap.put("KHKH",
                new Ingredient("KHKH", "Khoshk Khorasooni", Ingredient.Type.NOON));
        ingredientMap.put("KHGZ",
                new Ingredient("KHGZ", "Khoshk Ghazvini", Ingredient.Type.NOON));
        ingredientMap.put("KHYZ",
                new Ingredient("KHYZ", "Khoshk Yazdi", Ingredient.Type.NOON));
        ingredientMap.put("KHST",
                new Ingredient("KHST", "Khoshk Sonati", Ingredient.Type.NOON));
        ingredientMap.put("MSTS",
                new Ingredient("MSTS", "Mast Sade", Ingredient.Type.DORCHIN));
        ingredientMap.put("MTSM",
                new Ingredient("MTSM", "Mast Moosir", Ingredient.Type.DORCHIN));
        ingredientMap.put("ZEIT",
                new Ingredient("ZEIT", "Zeitoon", Ingredient.Type.DORCHIN));
        ingredientMap.put("ZPVD",
                new Ingredient("ZPVD", "Zeitoon Parvarde", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSLT",
                new Ingredient("TSLT", "Torshi Lite", Ingredient.Type.DORCHIN));
        ingredientMap.put("STSR",
                new Ingredient("STSR", "Sir Torshi", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSFL",
                new Ingredient("TSFL", "Torshi Felfel", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSBD",
                new Ingredient("TSBD", "Torshi Bandari", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSKG",
                new Ingredient("TSKG", "Torshi Kalam Ghermez", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSHB",
                new Ingredient("TSHB", "Torshi Haft Bijar", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSBDM",
                new Ingredient("TSBDM", "Torshi Bademjoon", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSAN",
                new Ingredient("TSAN", "Torshi Anbe", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSPZ",
                new Ingredient("TSPZ", "Torshi Piaz", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSNZ",
                new Ingredient("TSNZ", "Torshi Nazkhaton", Ingredient.Type.DORCHIN));
        ingredientMap.put("TSKH",
                new Ingredient("TSKH", "Torshi Khorfe", Ingredient.Type.DORCHIN));
        ingredientMap.put("SBKH",
                new Ingredient("SBKH", "Sabzi Khordan", Ingredient.Type.DORCHIN));
        ingredientMap.put("PHLG",
                new Ingredient("PHLG", "Piaz Halghe'ei", Ingredient.Type.DORCHIN));
        ingredientMap.put("SLSH",
                new Ingredient("SLSH", "Salad Shirazi", Ingredient.Type.DORCHIN));
        ingredientMap.put("SLKH",
                new Ingredient("SLKH", "Salad Kahoo", Ingredient.Type.DORCHIN));
        ingredientMap.put("SLKM",
                new Ingredient("SLKM", "Salad Kalam", Ingredient.Type.DORCHIN));
        ingredientMap.put("KHSH",
                new Ingredient("KHSH", "Khiarshoor", Ingredient.Type.DORCHIN));
        ingredientMap.put("DOUG",
                new Ingredient("DOUG", "Dough", Ingredient.Type.NOSHIDANI));
        ingredientMap.put("DELS",
                new Ingredient("DELS", "Delster", Ingredient.Type.NOSHIDANI));
        ingredientMap.put("NOSH",
                new Ingredient("NOSH", "Noshabeh", Ingredient.Type.NOSHIDANI));
        ingredientMap.put("AB",
                new Ingredient("AB", "Ab", Ingredient.Type.NOSHIDANI));
        ingredientMap.put("ABGZ",
                new Ingredient("ABGZ", "Ab Gazdar", Ingredient.Type.NOSHIDANI));

    }

    @Override
    public Ingredient convert(String str) {
        return ingredientMap.get(str);
    }
}
