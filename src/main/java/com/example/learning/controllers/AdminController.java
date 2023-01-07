package com.example.learning.controllers;

import com.example.learning.services.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@Slf4j
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/deleteOrders")
    public String deleteAllOrders() {
        log.info("Obtained request to delete all orders");
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
}
