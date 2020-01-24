/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera.security.service;

import com.mellisphera.entities.User;
import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.entities.bm.BmNoteCreate;
import com.mellisphera.entities.bm.changeLog.BmNoteUpdated;
import com.mellisphera.security.entities.BmAuth;

import java.sql.Timestamp;
import java.util.Date;

public interface BmService {

	BmAuth getBmAuth(String username, String password);

	BmAuth getUserData(String userId);

	void saveBmData(BmAuth bmData, String username, String countryCode);

	public void getChangeLog(String userId, String username, String countryCode);

	public void deleteChangeLog(long modified, String userId);

	public BmNoteCreate postNote(BmNote bmNote);

	public Object putNote(BmNote bmNote);


}
