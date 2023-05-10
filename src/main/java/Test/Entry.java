package Test;

import java.time.LocalDate;

public class Entry {
    LocalDate start;
    LocalDate end;

    Entry(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    Entry(LocalDate start, int dayDuration)
    {
        this.start = start;
        this.end = this.start.plusDays(dayDuration);
    }

    public boolean within(Entry newEntry) // Check whether 2 entries are ha ving clashing times
    {
        if(this.start.isBefore(newEntry.end) && this.end.isAfter(newEntry.start))
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return "DATE: " + this.start.toString()
                + "\nENDS: " + this.end.toString();
    }
}

