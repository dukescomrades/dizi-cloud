package com.dizi.dz.controller;

import com.dizi.dz.entity.Dizi;
import com.dizi.dz.entity.DiziOrder;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.dizi.dz.entity.Ingredient;
import com.dizi.dz.entity.Ingredient.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("diziOrder")
public class DesignDiziController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("DIZS", "Dizi Sangi", Ingredient.Type.ZARF),
                new Ingredient("DIZM", "Dizi Messi", Ingredient.Type.ZARF),
                new Ingredient("DIZC", "Dizi Chodani", Ingredient.Type.ZARF),
                new Ingredient("DIZZ", "Dizi Zoodpazi", Ingredient.Type.ZARF),
                new Ingredient("GOJF", "Goje Farangi", Ingredient.Type.SABZIJAT),
                new Ingredient("SIBZ", "Sibzamini", Ingredient.Type.SABZIJAT),
                new Ingredient("PIAZ", "Piaz", Ingredient.Type.SABZIJAT),
                new Ingredient("SIR", "Sir", Ingredient.Type.SABZIJAT),
                new Ingredient("GGMA", "Goosht Gosfandi - Mahiche", Ingredient.Type.GOOSHT),
                new Ingredient("GGGH", "Goosht Gosfandi - Ghalam", Ingredient.Type.GOOSHT),
                new Ingredient("GGGD", "Goosht Gosfandi - Gardan", Ingredient.Type.GOOSHT),
                new Ingredient("GGGV", "Goosht Gosfandi - Gholvegah", Ingredient.Type.GOOSHT),
                new Ingredient("GMOR", "Goosht Morgh", Ingredient.Type.GOOSHT),
                new Ingredient("DGOS", "Donbeh Gosfandi", Ingredient.Type.CHARBI),
                new Ingredient("LBSF", "Loobia Sefid", Ingredient.Type.HOBOBAT),
                new Ingredient("LBGR", "Loobia Ghermez", Ingredient.Type.HOBOBAT),
                new Ingredient("NOKH", "Nokhod", Ingredient.Type.HOBOBAT),
                new Ingredient("NAMK", "Namak", Ingredient.Type.ADVIYEHJAT),
                new Ingredient("ZARD", "Zardchoobeh", Ingredient.Type.ADVIYEHJAT),
                new Ingredient("DARC", "Darchin", Ingredient.Type.ADVIYEHJAT),
                new Ingredient("FFGR", "Felfel Ghermez", Ingredient.Type.ADVIYEHJAT),
                new Ingredient("FFSI", "Felfel Siah", Ingredient.Type.ADVIYEHJAT),
                new Ingredient("ZIRE", "Zire", Ingredient.Type.ADVIYEHJAT),
                new Ingredient("LIMO", "Limoo Amani", Ingredient.Type.ADVIYEHJAT),
                new Ingredient("RBSN", "Rob San'ati", Ingredient.Type.SOS),
                new Ingredient("RBMH", "Rob Mahali", Ingredient.Type.SOS),
                new Ingredient("LAVH", "Lavash", Ingredient.Type.NOON),
                new Ingredient("BARB", "Barbari", Ingredient.Type.NOON),
                new Ingredient("SANG", "Sangak", Ingredient.Type.NOON),
                new Ingredient("BAGT", "Baget", Ingredient.Type.NOON),
                new Ingredient("TAFT", "Taftoon", Ingredient.Type.NOON),
                new Ingredient("KHKH", "Khoshk Khorasooni", Ingredient.Type.NOON),
                new Ingredient("KHGZ", "Khoshk Ghazvini", Ingredient.Type.NOON),
                new Ingredient("KHYZ", "Khoshk Yazdi", Ingredient.Type.NOON),
                new Ingredient("KHST", "Khoshk Sonati", Ingredient.Type.NOON),
                new Ingredient("MSTS", "Mast Sade", Ingredient.Type.DORCHIN),
                new Ingredient("MTSM", "Mast Moosir", Ingredient.Type.DORCHIN),
                new Ingredient("ZEIT", "Zeitoon", Ingredient.Type.DORCHIN),
                new Ingredient("ZPVD", "Zeitoon Parvarde", Ingredient.Type.DORCHIN),
                new Ingredient("TSLT", "Torshi Lite", Ingredient.Type.DORCHIN),
                new Ingredient("STSR", "Sir Torshi", Ingredient.Type.DORCHIN),
                new Ingredient("TSFL", "Torshi Felfel", Ingredient.Type.DORCHIN),
                new Ingredient("TSBD", "Torshi Bandari", Ingredient.Type.DORCHIN),
                new Ingredient("TSKG", "Torshi Kalam Ghermez", Ingredient.Type.DORCHIN),
                new Ingredient("TSHB", "Torshi Haft Bijar", Ingredient.Type.DORCHIN),
                new Ingredient("TSBDM", "Torshi Bademjoon", Ingredient.Type.DORCHIN),
                new Ingredient("TSAN", "Torshi Anbe", Ingredient.Type.DORCHIN),
                new Ingredient("TSPZ", "Torshi Piaz", Ingredient.Type.DORCHIN),
                new Ingredient("TSNZ", "Torshi Nazkhaton", Ingredient.Type.DORCHIN),
                new Ingredient("TSKH", "Torshi Khorfe", Ingredient.Type.DORCHIN),
                new Ingredient("SBKH", "Sabzi Khordan", Ingredient.Type.DORCHIN),
                new Ingredient("PHLG", "Piaz Halghe'ei", Ingredient.Type.DORCHIN),
                new Ingredient("SLSH", "Salad Shirazi", Ingredient.Type.DORCHIN),
                new Ingredient("SLKH", "Salad Kahoo", Ingredient.Type.DORCHIN),
                new Ingredient("SLKM", "Salad Kalam", Ingredient.Type.DORCHIN),
                new Ingredient("KHSH", "Khiarshoor", Ingredient.Type.DORCHIN),
                new Ingredient("DOUG", "Dough", Ingredient.Type.NOSHIDANI),
                new Ingredient("DELS", "Delster", Ingredient.Type.NOSHIDANI),
                new Ingredient("NOSH", "Noshabeh", Ingredient.Type.NOSHIDANI),
                new Ingredient("AB", "Ab", Ingredient.Type.NOSHIDANI),
                new Ingredient("ABGZ", "Ab Gazdar", Ingredient.Type.NOSHIDANI)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "diziOrder")
    public DiziOrder order() {
        return new DiziOrder();
    }

    @ModelAttribute(name = "dizi")
    public Dizi dz() {
        return new Dizi();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

/*
  @PostMapping
  public String processDizi(Dizi dz,
  			@ModelAttribute DiziOrder diziOrder) {
    diziOrder.addDizi(dz);
    log.info("Processing dizi: {}", dz);

    return "redirect:/orders/current";
  }
 */

    @PostMapping
    public String processDizi(
            @Valid Dizi dz, Errors errors,
            @ModelAttribute DiziOrder diziOrder) {

        if (errors.hasErrors()) {
            return "design";
        }

        diziOrder.addDizi(dz);
        log.info("Processing dizi: {}", dz);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}