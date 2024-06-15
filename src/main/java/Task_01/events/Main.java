package Task_01.events;

import Task_01.events.controllers.EventController;
import Task_01.events.repositories.EventRepository;
import Task_01.events.repositories.impl.EventRepositoryFileImpl;
import Task_01.events.repositories.impl.EventRepositoryListImpl;
import Task_01.events.services.EventService;
import Task_01.events.services.impl.EventServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventRepository eventRepositoryList = new EventRepositoryListImpl();
        EventRepository eventRepositoryFile = new EventRepositoryFileImpl("events.txt");
        EventService eventService = new EventServiceImpl(eventRepositoryFile);
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
