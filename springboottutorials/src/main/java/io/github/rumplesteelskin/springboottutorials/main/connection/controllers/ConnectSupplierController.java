package io.github.rumplesteelskin.springboottutorials.main.connection.controllers;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Supplier;
import io.github.rumplesteelskin.springboottutorials.main.connection.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("connect-supplier")
@RequiredArgsConstructor
public class ConnectSupplierController {

    private final SupplierRepository supplierRepository;

    @GetMapping("generate")
    public String generate() {
        int count = 100;
        for (int i = 0; i < count; i++) {
            supplierRepository.save(new Supplier(UUID.randomUUID(), "Supplier " + (i + 1), 5000 + 250 * i));
        }
        return "Generated: " + count;
    }

    @GetMapping("custom-query-list")
    public String customList() {
        StringBuilder customQueryList = new StringBuilder();
        for (Supplier supplier : supplierRepository.findSuppliers()) {
            customQueryList.append(supplier.getName()).append("\n");
        }
        return customQueryList.toString();
    }

    @GetMapping("custom-query-like-list")
    public String customLikeList() {
        StringBuilder customQueryList = new StringBuilder();
        for (Supplier supplier : supplierRepository.findSuppliersLike("Sup%5")) {
            customQueryList.append(supplier.getName()).append("\n");
        }
        return customQueryList.toString();
    }


    @GetMapping("custom-query-min-list")
    public String customMinList() {
        StringBuilder customQueryList = new StringBuilder();
        for (Supplier supplier : supplierRepository.findSuppliersMin(12500)) {
            customQueryList.append(supplier.getName()).append(" Total Debit: ").append(supplier.getTotalDebit()).append("<br/>");
        }
        return customQueryList.toString();
    }


    @GetMapping("custom-query-criteria-list")
    public String customCriteriaList() {
        StringBuilder customQueryList = new StringBuilder();
        for (Supplier supplier : supplierRepository.findSuppliersCriteria(20000, "Sup%5")) {
            customQueryList.append(supplier.getName()).append(" Total Debit: ").append(supplier.getTotalDebit()).append("<br/>");
        }
        return customQueryList.toString();
    }

    @GetMapping("custom-query-get-with-name/{name}")
    public String customGetWithName(@PathVariable("name") String name) {
        return supplierRepository.findSupplierByName(name).toString();
    }

    @GetMapping("custom-query-min-average")
    public String customMinAverageList() {
        return Double.toString(supplierRepository.findSuppliersMinAverage(20000));
    }
}
