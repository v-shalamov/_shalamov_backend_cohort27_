package Task_02.EventsTests.services.impl;

import Task_02.EventsTests.domains.Event;
import Task_02.EventsTests.repositories.EventRepository;
import Task_02.EventsTests.services.EventService;

import java.time.LocalDate;
import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event addEvent(String name, LocalDate startDate, LocalDate expirationDate) {

        if (name == null || name.isEmpty() || name.equals("") || name.equals(" ")) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }

        if (startDate == null || startDate.equals("") || startDate.equals(" ")) {
            throw new IllegalArgumentException("Дата начала ивента не может быть пустой");
        }

        if (expirationDate == null || expirationDate.equals("") || expirationDate.equals(" ")) {
            throw new IllegalArgumentException("Дата окончания ивента не может быть пустой");
        }


        int startDayOfMonth = startDate.getDayOfMonth();
        int startMonthValue = startDate.getMonthValue();

        int expirationDayOfMonth = expirationDate.getDayOfMonth();
        int expirationMonthValue = expirationDate.getMonthValue();

        if (startMonthValue == expirationMonthValue) {
            if (startDayOfMonth > expirationDayOfMonth) {
                throw new IllegalArgumentException("Начало ивента не может быть после его конца");
            }

        } else if (startMonthValue > expirationMonthValue) {
            throw new IllegalArgumentException("Начало ивента не может быть после его конца");
        }


        Event event = new Event(name, startDate, expirationDate);

        eventRepository.save(event);

        return event;
    }

    @Override
    public List<Event> events() {
        return eventRepository.findAll();
    }
}
