package ru.practicum.ewm.request.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.request.dto.ParticipationRequestDto;
import ru.practicum.ewm.request.service.RequestPrivateService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class RequestPrivateController {

    private final RequestPrivateService requestPrivateService;

    @GetMapping("/{userId}/requests")
    public List<ParticipationRequestDto> getRequests(@PathVariable Long userId) {
        log.info("GET getRequests 'users/{userId}/requests'. Params: userId: {};", userId);

        return requestPrivateService.getRequests(userId);
    }

    @PostMapping("/{userId}/requests")
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipationRequestDto addRequest(@PathVariable Long userId, @RequestParam Long eventId) {
        log.info("POST addRequest 'users/{userId}/requests'. Params: userId: {}; eventId: {};", userId, eventId);

        return requestPrivateService.addRequest(userId, eventId);
    }

    @PatchMapping("/{userId}/requests/{requestId}/cancel")
    public ParticipationRequestDto cancelRequest(@PathVariable Long userId, @PathVariable Long requestId) {
        log.info("PATCH cancelRequest 'users/{userId}/requests/{requestId}/cancel'. Params: userId: {}; requestId: {};",
                userId, requestId);

        return requestPrivateService.cancelRequest(userId, requestId);
    }
}
