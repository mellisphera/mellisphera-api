package com.mellisphera.security.service;

import com.mellisphera.entities.User;
import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.security.entities.BmAuth;

import java.sql.Timestamp;
import java.util.Date;

public interface BmService {
	BmAuth getBmAuth(String username, String password);
	void saveBmData(BmAuth bmData, String username);

	public void getChangeLog(String userId, String username);

	public void deleteChangeLog(int modified, String userId);

	public Date convertTimestampToDate(long time);

	public BmNote postNote(BmNote bmNote);

	public void putNote(BmNote bmNote);


}
