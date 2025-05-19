package com.dizi.dz.entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        ZARF, SABZIJAT, GOOSHT, CHARBI, HOBOBAT, ADVIYEHJAT, SOS ,NOON, DORCHIN, NOSHIDANI;
    }

}
