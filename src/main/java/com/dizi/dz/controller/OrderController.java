package com.dizi.dz.controller;

import com.dizi.dz.entity.DiziOrder;
import com.dizi.dz.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("diziOrder")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "order";
    }

@PostMapping
public String processOrder(@Valid DiziOrder order, Errors errors,
                           SessionStatus sessionStatus) {
    if (errors.hasErrors()) {
        return "order";
    }
    orderRepo.save(order);
    sessionStatus.setComplete();

    return "redirect:/";
}
}
