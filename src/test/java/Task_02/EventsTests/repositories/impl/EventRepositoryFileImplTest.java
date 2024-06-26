package Task_02.EventsTests.repositories.impl;

import Task_01.events.repositories.EventRepository;
import Task_02.EventsTests.domains.Event;
import org.junit.jupiter.api.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EventRepositoryFileImplTest is works ...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class EventRepositoryFileImplTest {

    private static final String TEMP_EVENTS_FILE_NAME = "events_test.txt";

    private EventRepositoryFileImpl eventRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @BeforeEach
    public void setUp() throws Exception {
        createNewFileForTest(TEMP_EVENTS_FILE_NAME);

        eventRepository = new EventRepositoryFileImpl(TEMP_EVENTS_FILE_NAME);
    }

    @AfterEach
    public void tearDown() throws Exception {
        deleteFileAfterTest(TEMP_EVENTS_FILE_NAME);
    }

    @DisplayName("save():")
    @Nested
    class Save {

        @Test
        public void writes_correct_line_to_file() throws Exception {
            Event event = new Event("a", LocalDate.parse("01-06-2023", formatter), LocalDate.parse("01-06-2023", formatter));

            eventRepository.save(event);

            String expected = "1|a|01-06-2023|01-06-2023";

            BufferedReader reader = new BufferedReader(new FileReader(TEMP_EVENTS_FILE_NAME));

            String actual = reader.readLine();

            reader.close();

            assertEquals(expected, actual);
        }
    }

    @DisplayName("findAll():")
    @Nested
    class FindAll {

        @Test
        public void returns_correct_list_of_events() throws Exception {

            BufferedWriter writer = new BufferedWriter(new FileWriter("TEMP_EVENTS_FILE_NAME"));

            writer.write("1|a|01-06-2023|01-06-2023");
            writer.newLine();
            writer.write("2|b|01-06-2023|01-06-2023");
            writer.newLine();
            writer.close();

            List<Event> expected = Arrays.asList(
                    new Event(1L, "a", LocalDate.parse("01-06-2023", formatter), LocalDate.parse("01-06-2023", formatter)),
                    new Event(2L, "b", LocalDate.parse("01-06-2023", formatter), LocalDate.parse("01-06-2023", formatter))
            );

            List<Event> actual = eventRepository.findAll();

            assertEquals(expected, actual);
        }
    }

    private static void createNewFileForTest(String fileName) throws IOException {
        File file = new File(fileName);

        deleteIfExists(file);

        boolean result = file.createNewFile();

        if (!result) {
            throw new IllegalStateException("Problems this file create");
        }
    }

    private static void deleteFileAfterTest(String fileName) {
        File file = new File(fileName);

        deleteIfExists(file);
    }

    private static void deleteIfExists(File file) {
        if (file.exists()) {
            boolean result = file.delete();

            if (!result) {
                throw new IllegalStateException("Problems this file delete");
            }
        }
    }
}