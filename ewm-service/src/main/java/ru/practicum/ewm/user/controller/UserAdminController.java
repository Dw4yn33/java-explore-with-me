package ru.practicum.ewm.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.user.dto.UserDto;
import ru.practicum.ewm.user.service.UserAdminService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/users")
public class UserAdminController {

    private final UserAdminService userAdminService;

    @GetMapping
    public List<UserDto> findAll(@RequestParam(defaultValue = "") List<Long> ids,
                                 @PositiveOrZero @RequestParam(defaultValue = "0") int from,
                                 @Positive @RequestParam(defaultValue = "10") int size) {
        log.info("GET findAll '/admin/users'. Params: ids: {}; from: {}; size: {};", ids, from, size);

        Pageable pageable = PageRequest.of(from / size, size, Sort.by("id"));

        return userAdminService.findAll(ids, pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto add(@Valid @RequestBody UserDto userDto) {
        log.info("POST add '/admin/users'. Params: userDto: {};", userDto);

        return userAdminService.add(userDto);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) {
        log.info("DELETE delete '/admin/users/{userId}'. Params: userId: {};", userId);

        userAdminService.delete(userId);
    }

}
