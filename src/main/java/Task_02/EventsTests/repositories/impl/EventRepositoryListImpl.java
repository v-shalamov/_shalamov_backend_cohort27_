package Task_02.EventsTests.repositories.impl;

import Task_02.EventsTests.domains.Event;
import Task_02.EventsTests.repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventRepositoryListImpl implements EventRepository {

    private final List<Event> events = new ArrayList<>();
    private Long generatedId = 1L;

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }

    @Override
    public void save(Event event) {
        events.add(event);

        event.setId(generatedId);

        generatedId++;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Event event) {

    }
}
