package io.pivotal.pal.tracker;

import org.hibernate.validator.constraints.EAN;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private final Map<Long, TimeEntry> TIME_ENTRY_MAP = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry)
    {
        Long newIndex = TIME_ENTRY_MAP.keySet().size() + 1L;
        timeEntry.setId(newIndex);
        TIME_ENTRY_MAP.put(newIndex, timeEntry);
        return TIME_ENTRY_MAP.get(newIndex);
    }

    @Override
    public TimeEntry update(Long id, TimeEntry updatedTimeEntry) {
        TimeEntry returnValue = null;

        if (TIME_ENTRY_MAP.keySet().contains(id)) {
            TIME_ENTRY_MAP.put(id, updatedTimeEntry);
            updatedTimeEntry.setId(id);
            returnValue = TIME_ENTRY_MAP.get(id);
        }

        return returnValue;
    }

    @Override
    public void delete(Long id)
    {
        TIME_ENTRY_MAP.remove(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(TIME_ENTRY_MAP.values());
    }

    @Override
    public TimeEntry find(Long id)
    {
        TimeEntry returnValue = null;

        if (TIME_ENTRY_MAP.keySet().contains(id)) {
            returnValue = TIME_ENTRY_MAP.get(id);
        }

        return returnValue;
    }
}
