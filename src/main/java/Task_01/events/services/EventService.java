package Task_01.events.services;

import Task_01.events.domains.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    Event addEvent(String name, LocalDate startDate, LocalDate expirationDate);

    List<Event> events();
}
