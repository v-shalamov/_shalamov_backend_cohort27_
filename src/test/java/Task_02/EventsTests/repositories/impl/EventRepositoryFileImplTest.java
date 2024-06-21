package Task_02.EventsTests.repositories.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.File;
import java.io.IOException;

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