package io.github.rumplesteelskin.springboottutorials.main.connection.controllers;

import io.github.rumplesteelskin.springboottutorials.main.connection.entities.Supplier;
import io.github.rumplesteelskin.springboottutorials.main.connection.repositories.DerivedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("derived")
@RequiredArgsConstructor
public class ConnectDerivedController {

    private final DerivedRepository derivedRepository;

    @GetMapping("name")
    public Iterable<Supplier> getByName() {
        return derivedRepository.findByName("Supplier 44");
    }


    @GetMapping("name-ending-with/{ending}")
    public Iterable<Supplier> getByNameEndingWith(@PathVariable String ending) {
        return derivedRepository.findByNameEndingWith(ending);
    }

    @GetMapping("name-starting-with/{starting}")
    public Iterable<Supplier> getByNameStartingWith(@PathVariable String starting) {
        return derivedRepository.findByNameStartingWith(starting);
    }

    @GetMapping("name-like/{like}")
    public Iterable<Supplier> getByName(@PathVariable String like) {
        return derivedRepository.findByNameLike(like);
    }

    @GetMapping("total-debit-equals/{equal}")
    public Iterable<Supplier> getTotalDebitEquals(@PathVariable double equal) {
        return derivedRepository.findByTotalDebitEquals(equal);
    }

    @GetMapping("total-debit-greater-than-equal/{gte}")
    public Iterable<Supplier> getTotalDebitGreaterThanEqual(@PathVariable double gte) {
        return derivedRepository.findByTotalDebitGreaterThanEqual(gte);
    }

    @GetMapping("total-debit-between/{min}-{max}")
    public Iterable<Supplier> getTotalDebitBetween(@PathVariable double min, @PathVariable double max) {
        return derivedRepository.findByTotalDebitBetween(min, max);
    }

    @GetMapping("name-like-and-greater-than-equal/{like}/{gte}")
    public Iterable<Supplier> getNameLikeAndGreaterThanEqual(@PathVariable String like, @PathVariable double gte) {
        return derivedRepository.findByNameLikeAndTotalDebitGreaterThanEqual(like, gte);
    }
}

