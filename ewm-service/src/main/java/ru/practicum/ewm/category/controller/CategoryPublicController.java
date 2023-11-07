package ru.practicum.ewm.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.category.service.CategoryPublicService;
import ru.practicum.ewm.category.model.Category;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryPublicController {

    private final CategoryPublicService categoryPublicService;

    @GetMapping
    public List<Category> findAll(@PositiveOrZero @RequestParam(defaultValue = "0") int from,
                                  @Positive @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(from / size, size, Sort.by("id"));

        return categoryPublicService.findAll(pageable);
    }

    @GetMapping("/{categoryId}")
    public Category find(@PathVariable Long categoryId) {
        return categoryPublicService.find(categoryId);
    }

}
