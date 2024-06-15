package Task_02.EventsTests.services;

import Task_02.EventsTests.domains.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    Event addEvent(String name, LocalDate startDate, LocalDate expirationDate);

    List<Event> events();
}
