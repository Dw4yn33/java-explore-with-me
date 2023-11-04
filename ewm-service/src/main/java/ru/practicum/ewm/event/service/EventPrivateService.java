package ru.practicum.ewm.event.service;

import org.springframework.data.domain.Pageable;
import ru.practicum.ewm.event.dto.EventFullDto;
import ru.practicum.ewm.event.dto.EventShortDto;
import ru.practicum.ewm.event.dto.NewEventDto;
import ru.practicum.ewm.request.dto.ParticipationRequestDto;
import ru.practicum.ewm.event.dto.UpdateEventDto;
import ru.practicum.ewm.event.dto.UpdateEventRequestStatusDto;
import ru.practicum.ewm.event.dto.UpdateEventRequestStatusResultDto;

import java.util.List;

public interface EventPrivateService {

    List<EventShortDto> getEvents(Long userId, Pageable pageable);

    EventFullDto addEvent(Long userId, NewEventDto newEventDto);

    EventFullDto getEvent(Long userId, Long eventId);

    EventFullDto updateEvent(Long userId, Long eventId, UpdateEventDto updateEventDto);

    List<ParticipationRequestDto> getEventRequests(Long userId, Long eventId);

    UpdateEventRequestStatusResultDto updateEventRequests(Long userId, Long eventId,
                                                          UpdateEventRequestStatusDto updateEventRequestStatusDto);

}
