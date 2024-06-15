package Task_02.EventsTests.controllers;

import Task_02.EventsTests.domains.Event;
import Task_02.EventsTests.services.EventService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class EventController {

    private final Scanner scanner;

    private final EventService eventService;

    public EventController(Scanner scanner, EventService eventService) {
        this.scanner = scanner;
        this.eventService = eventService;
    }

    public void addEvent() {

        out.println("Введите название мероприятия");
        String name = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate startDate;
        LocalDate expirationDate;

        try {
            out.println("Введите дату начала через \"-\" пример: (01-05-2003)");
            String startDateString = scanner.nextLine();
            startDate = LocalDate.parse(startDateString, formatter);

            out.println("Введите дату конца через \"-\" пример: (01-05-2003)");
            String expirationDateString = scanner.nextLine();
            expirationDate = LocalDate.parse(expirationDateString, formatter);

        } catch (DateTimeParseException e) {
            out.println("Неправильный формат даты. Пожалуйста, используйте формат dd-MM-yyyy.");
            throw e;
        }

        Event event = eventService.addEvent(name, startDate, expirationDate);

        out.println(event);
    }

    public void events() {
        List<Event> users = eventService.events();

        out.println(users);
    }
}
