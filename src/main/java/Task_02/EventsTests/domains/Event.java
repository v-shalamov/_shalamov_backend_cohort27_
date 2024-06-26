package Task_02.EventsTests.domains;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate expirationDate;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Event(Long id, String name, LocalDate startDate, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public Event(String name, LocalDate startDate, LocalDate expirationDate) {
        this.name = name;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate.format(formatter) +
                ", expirationDate=" + expirationDate.format(formatter) +
                '}';
    }
}
