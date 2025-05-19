package com.dizi.dz.controller;

import com.dizi.dz.entity.Dizi;
import com.dizi.dz.entity.DiziOrder;
import com.dizi.dz.repository.IngredientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignDiziController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients, type));
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