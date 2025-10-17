package io.github.rumplesteelskin.springboottutorials.main.connection.controllers;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Supplier;
import io.github.rumplesteelskin.springboottutorials.main.connection.repositories.ParticularRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("particular")
@RequiredArgsConstructor
public class ConnectParticularController {

    private final ParticularRepository particularRepository;

    @GetMapping("page")
    public Page<Supplier> getPage() {
        int pageNumber = 3;
        int pageSize = 5;
        return particularRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @GetMapping("sort")
    public Iterable<Supplier> getSort() {
        return particularRepository.findAll(Sort.by(Sort.Direction.ASC, "totalDebit"));
    }

    @GetMapping("sort-descending")
    public Iterable<Supplier> getSortDescending() {
        return particularRepository.findAll(Sort.by(Sort.Direction.ASC, "totalDebit").descending());
    }

    @GetMapping("sort-and-page1")
    public Iterable<Supplier> getSortAndPage1() {
        int pageNumber = 0;
        int pageSize = 5;
        String sortField = "totalDebit";
        Sort sort = Sort.by(Sort.Direction.ASC, sortField);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return particularRepository.findAll(pageable);
    }


    @GetMapping("sort-and-page2")
    public Iterable<Supplier> getSortAndPage2() {
        return particularRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "totalDebit")));
    }


    @Operation(summary = "All Suppliers Get")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Parameters invalid"),
            @ApiResponse(responseCode = "500", description = "Server error")
    })
    @GetMapping("/suppliers")
    public ResponseEntity<Page<Supplier>> getSuppliers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "totalDebit") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        if (page < 0 || size <= 0)
            return ResponseEntity.badRequest().build();

        Sort sort = Sort.by(direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Supplier> result = particularRepository.findAll(pageable);
        return ResponseEntity.ok(result);
    }


    @GetMapping("sort-and-page-and-min-debit")
    public Page<Supplier> getSortAndPageMinDebit() {
        return particularRepository.findSuppliersMinAndPageable(20000, PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "totalDebit")));
    }

}
