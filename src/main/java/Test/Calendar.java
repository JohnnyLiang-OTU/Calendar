package Test;

import java.util.ArrayList;

public class Calendar {
    public static ArrayList<Entry> entries;

    Calendar(){entries = new ArrayList<Entry>();} // Constructor

    public void addEvent(Entry newEntry)
    {
        entries.add(newEntry);
    }

    public boolean dateCollission(Entry newEntry) // Maybe won't need this.
    {
        boolean flag = false;
        for(int i = 0; i < entries.size(); i++)
        {
            if(entries.get(i).within(newEntry))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
