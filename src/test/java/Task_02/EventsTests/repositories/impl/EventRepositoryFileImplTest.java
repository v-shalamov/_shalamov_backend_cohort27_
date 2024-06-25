package Task_02.EventsTests.repositories.impl;

import Task_02.EventsTests.domains.Event;
import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("EventRepositoryFileImplTest is works ...")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class EventRepositoryFileImplTest {

    private static final String TEMP_EVENTS_FILE_NAME = "events_test.txt";

    private EventRepositoryFileImpl eventRepositoryFile;

    @BeforeEach
    public void setUp() throws Exception {
        createNewFileForTest(TEMP_EVENTS_FILE_NAME);

        eventRepositoryFile = new EventRepositoryFileImpl(TEMP_EVENTS_FILE_NAME);
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
            Event event = new Event("a", LocalDate.parse("01-06-2023"), LocalDate.parse("01-06-2023"));

            eventRepositoryFile.save(event);

            String expected = "1|a|01-06-2023|01-06-2023";

            BufferedReader reader = new BufferedReader(new FileReader(TEMP_EVENTS_FILE_NAME));

            String actual = reader.readLine();

            reader.close();

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