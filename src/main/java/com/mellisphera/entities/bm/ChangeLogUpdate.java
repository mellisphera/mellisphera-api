package com.mellisphera.entities.bm;

public interface ChangeLogUpdate<Old, Update> {

    public Old getOldData();

    public Update getUpdatedData();

}
