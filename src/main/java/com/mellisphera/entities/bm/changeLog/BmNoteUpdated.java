package com.mellisphera.entities.bm.changeLog;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.entities.bm.ChangeLogUpdate;

public class BmNoteUpdated implements ChangeLogUpdate<BmNote, BmNote> {

    @JsonProperty("old")
    private BmNote oldNote;

    @JsonProperty("updated")
    private BmNote noteUpdated;


    public BmNoteUpdated() {}

    @Override
    public BmNote getOldData() {
        return oldNote;
    }

    @Override
    public BmNote getUpdatedData() {
        return noteUpdated;
    }
}
