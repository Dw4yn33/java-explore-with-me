package ru.practicum.ewm.compilation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.compilation.dto.CompilationDto;
import ru.practicum.ewm.compilation.dto.NewCompilationDto;
import ru.practicum.ewm.compilation.dto.UpdateCompilationDto;
import ru.practicum.ewm.compilation.service.CompilationAdminService;

import javax.validation.Valid;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/compilations")
public class CompilationAdminController {

    private final CompilationAdminService compilationAdminService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CompilationDto add(@Valid @RequestBody NewCompilationDto newCompilationDto) {
        return compilationAdminService.add(newCompilationDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{compilationId}")
    public void delete(@PathVariable Long compilationId) {
        compilationAdminService.delete(compilationId);
    }

    @PatchMapping("/{compilationId}")
    public CompilationDto update(@PathVariable Long compilationId, @Valid @RequestBody UpdateCompilationDto updateCompilationDto) {
        return compilationAdminService.update(compilationId, updateCompilationDto);
    }

}
