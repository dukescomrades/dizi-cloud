package com.dizi.dz.entity;
import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        ZARF, SABZIJAT, GOOSHT, CHARBI, HOBOBAT, ADVIYEHJAT, SOS ,NOON, DORCHIN, NOSHIDANI;
    }

}
