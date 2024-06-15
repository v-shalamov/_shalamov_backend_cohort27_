package Task_02.EventsTests.repositories.impl;

import Task_02.EventsTests.domains.Event;
import Task_02.EventsTests.repositories.EventRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventRepositoryFileImpl implements EventRepository {

    private final String fileName;

    public EventRepositoryFileImpl(String fileName) {
        this.fileName = fileName;
    }

    Long generatedId = 1L;

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public List<Event> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            return reader.lines()
                    .map(line -> line.split("\\|"))
                    .map(parsed -> new Event(
                            Long.parseLong(parsed[0]),
                            parsed[1],
                            LocalDate.parse(parsed[2]),
                            LocalDate.parse(parsed[3])))
                    .collect(Collectors.toList());

        } catch (IOException e)  {
            throw new IllegalStateException("Проблемы с чтением из файла: " + e.getMessage());
        }
    }

    @Override
    public void save(Event event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            event.setId(generatedId);

            writer.write(
                    event.getId() + "|"
                      + event.getName() + "|"
                      + event.getStartDate() + "|"
                      + event.getExpirationDate());
            writer.newLine();

        } catch (IOException e) {
            throw new IllegalStateException("Проблемы с записью в файл: " + e.getMessage());
        }
        generatedId++;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Event model) {

    }
}
