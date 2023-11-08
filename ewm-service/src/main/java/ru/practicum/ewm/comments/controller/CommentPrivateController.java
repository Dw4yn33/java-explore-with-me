package ru.practicum.ewm.comments.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.comments.dto.CommentDto;
import ru.practicum.ewm.comments.dto.NewCommentDto;
import ru.practicum.ewm.comments.dto.UpdateCommentDto;
import ru.practicum.ewm.comments.service.CommentPrivateService;

import javax.validation.Valid;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class CommentPrivateController {

    private final CommentPrivateService commentPrivateService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{userId}/events/{eventId}/comments")
    public CommentDto add(@PathVariable Long userId, @PathVariable Long eventId,
                                 @Valid @RequestBody NewCommentDto newCommentDto) {
        return commentPrivateService.addComment(userId, eventId, newCommentDto);
    }

    @PatchMapping("/{userId}/events/{eventId}/comments")
    public CommentDto update(@PathVariable Long userId, @PathVariable Long eventId,
                                    @Valid @RequestBody UpdateCommentDto updateCommentDto) {
        return commentPrivateService.updateComment(userId, eventId, updateCommentDto);
    }

}
