package Task_02.EventsTests;

import Task_02.EventsTests.controllers.EventController;
import Task_02.EventsTests.repositories.EventRepository;
import Task_02.EventsTests.repositories.impl.EventRepositoryFileImpl;
import Task_02.EventsTests.repositories.impl.EventRepositoryListImpl;
import Task_02.EventsTests.services.EventService;
import Task_02.EventsTests.services.impl.EventServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventRepository eventRepositoryList = new EventRepositoryListImpl();
        EventRepository eventRepositoryFile = new EventRepositoryFileImpl("events.txt");
        EventService eventService = new EventServiceImpl(eventRepositoryList);
        EventController eventController = new EventController(scanner, eventService);

        boolean isRun = true;

        while (isRun) {
            String command = scanner.nextLine();

            switch (command) {
                case "/addEvent" ->
                        eventController.addEvent();
                case "/events" ->
                        eventController.events();
                case "/exit" -> isRun = false;
            }
        }
    }
}
