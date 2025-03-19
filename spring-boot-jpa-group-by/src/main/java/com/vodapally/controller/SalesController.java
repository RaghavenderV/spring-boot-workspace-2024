package com.vodapally.controller;

import com.vodapally.dto.SalesSummary;
import com.vodapally.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/summary")
    public List<SalesSummary> getSalesSummaryByCategory(){
        return salesService.getSalesSummaryByCategory();
    }
}
