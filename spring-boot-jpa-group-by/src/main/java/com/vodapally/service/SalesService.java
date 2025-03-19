package com.vodapally.service;

import com.vodapally.dto.SalesSummary;
import com.vodapally.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public List<SalesSummary> getSalesSummaryByCategory(){
        return salesRepository.getSalesSummaryByCategory();
    }
}
