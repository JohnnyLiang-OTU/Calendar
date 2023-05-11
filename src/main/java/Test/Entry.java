package Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Entry {
    LocalDateTime start;
    LocalDateTime end;
    String description;

    Entry(LocalDateTime start, int durationHours, String description)
    {
        this.start = start;
        this.end = start.plusHours(durationHours);
        this.description = description;
    }

    public boolean within(Entry newEntry) // Check whether 2 entries are having clashing times
    {
        if(this.start.isBefore(newEntry.end) && this.end.isAfter(newEntry.start))
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return "DATE: " + this.start
                + "\nENDS: " + this.end;
    }
}

