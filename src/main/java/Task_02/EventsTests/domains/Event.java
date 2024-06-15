package Task_02.EventsTests.domains;
import java.time.LocalDate;
public class Event {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate expirationDate;

    public Event(Long id, String name, LocalDate startDate, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.expirationDate = expirationDate;
    }

    public Event() {

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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Event event = (Event) object;
        return java.util.Objects.equals(id, event.id) && java.util.Objects.equals(name, event.name) && java.util.Objects.equals(startDate, event.startDate) && java.util.Objects.equals(expirationDate, event.expirationDate);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, name, startDate, expirationDate);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name=" + name +
                ", startDate=" + startDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
