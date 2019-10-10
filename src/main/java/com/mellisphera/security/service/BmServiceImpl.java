package com.mellisphera.security.service;

import com.google.gson.Gson;
import com.mellisphera.entities.*;
import com.mellisphera.entities.bm.BmNote;
import com.mellisphera.repositories.*;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.web.header.Header;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.BmHive;
import com.mellisphera.entities.bm.BmSensor;
import com.mellisphera.security.entities.BmAuth;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BmServiceImpl implements BmService {
	
    @Value("${apiwatch.app.geoip.timeout}")
    private int timeout;
    @Value("${mellisphera.app.bmAuth.url}")
    private String bmUrl;
    @Value("${mellisphera.app.bmAuth.licenceKey}")
    private String licenceKey;
    
    private HttpEntity<MultiValueMap<String, String>> requestEntity;
    private HttpEntity<String> notePostRequestEntity;
    private HttpHeaders header;

    private String userId;
    
    @Autowired private ApiaryRepository apiaryRepository;
    @Autowired private HivesRepository hiveRepository;
    @Autowired private SensorRepository sensorRepository;
    @Autowired private NoteRepository noteRepository;
    @Autowired private UserRepository userRepository;
    
	@Override
	public BmAuth getBmAuth(String username, String password) {
		String urlRequest = this.bmUrl + "user/data";
		this.header = new HttpHeaders();
		this.header.add("Content-Type", "application/x-www-form-urlencoded");
		this.header.add("license_key", this.licenceKey);
		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<String, String>();
		bodyMap.add("username", username);
		bodyMap.add("password", password);
		this.requestEntity = new HttpEntity<>(bodyMap, this.header);
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		return restTemplate.postForObject(urlRequest, requestEntity, BmAuth.class);
	}

	@Override
	public void saveBmData(BmAuth bmData, String username) {
		try{
			this.userId = bmData.getPayload().getApiaries()[0].getUserId();
			for(BmApiary bmApiary: bmData.getPayload().getApiaries()) {
				this.apiaryRepository.insert(this.getNewApiary(bmApiary, username));
				for(BmHive bmHive: bmApiary.getHives()) {
					this.hiveRepository.insert(this.getNewHive(bmHive, username, this.userId));
					if (bmHive.getDevices() != null) {
						for(BmSensor bmSensor : bmHive.getDevices()) {
							this.sensorRepository.insert(this.getNewSensor(bmSensor, this.userId, bmHive));
						}
					}
					if (bmHive.getNotes() != null) {
						for (BmNote bmNote: bmHive.getNotes()) {
							this.noteRepository.insert(this.getNewNote(bmNote));
						}
					}
				}
				if (bmApiary.getNotes() != null) {
					for (BmNote bmNote: bmApiary.getNotes()) {
						this.noteRepository.insert(this.getNewNote(bmNote));
					}
				}
			}
		}catch (NullPointerException e){}
	}

	private String checkObsHiveOrApiary(BmNote note) {
		if (note.getHiveId() != null) {
			return "HiveObs";
		} else {
			return "ApiaryObs";
		}
	}

	@Override
	public void putNote(BmNote bmNote){
		String urlRequest = this.bmUrl = "notes";
		this.header = new HttpHeaders();
		this.header.add("Content-Type", "application/json");
		this.header.add("license_key", this.licenceKey);
		Gson gson = new Gson();
		String noteJson = gson.toJson(bmNote);
		this.notePostRequestEntity = new HttpEntity<>(noteJson, this.header);
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		restTemplate.put(urlRequest, requestEntity, BmNote.class);
	}

	private Note getNewNote(BmNote bmNote) {
		return new Note(bmNote.getNoteId(),
				this.convertTimestampToDate(bmNote.getCreateDate()),
				bmNote.getType(),
				bmNote.getTags(),
				bmNote.getDescription(),
				bmNote.getHiveId(),
				bmNote.getApiaryId(),
				this.checkObsHiveOrApiary(bmNote),
				this.convertTimestampToDate(bmNote.getOpsDate()),
				bmNote.getApiaryId());
	}

	private Hive getNewHive(BmHive bmHive, String username, String userId) {
		Hive newHive = new Hive();
		newHive.set_id(bmHive.getHiveId());
		newHive.setHivePosY(0);
		newHive.setHivePosX(0);
		newHive.setApiaryId(bmHive.getApiaryId());
		newHive.setUserId(userId);
		newHive.setCreateDate(this.convertTimestampToDate(bmHive.getCreateDate()));
		newHive.setHidden(bmHive.getHidden());
		newHive.setDataLastReceived(this.convertTimestampToDate(bmHive.getDataLastReceived()));
		newHive.setName(bmHive.getName());
		newHive.setUsername(username);
		newHive.setName(bmHive.getName());
		return newHive;
	}

	public Sensor getNewSensor(BmSensor bmSensor, String userId, BmHive bmHive) {
		Sensor sensor = new Sensor();
		sensor.set_id(bmSensor.getDevice().getDeviceId());
		sensor.setHiveId(bmHive.getHiveId());
		sensor.setCreateDate(this.convertTimestampToDate(bmSensor.getDevice().getCreateDate()));
		sensor.setDataLastReceived(this.convertTimestampToDate(bmSensor.getDevice().getDataLastReceived()));
		sensor.setSensorRef(bmSensor.getDevice().getDeviceAddress());
		sensor.setModel(bmSensor.getDevice().getModel());
		sensor.setName(bmSensor.getDevice().getName());
		sensor.setUserId(userId);
		sensor.setHiveName(bmHive.getName());
		sensor.setHivePositionId(bmSensor.getHivePositionId());
		sensor.setStart(this.convertTimestampToDate(bmSensor.getStart()));
		sensor.setApiaryId(bmHive.getApiaryId());
		sensor.setType(this.getTypeByRef(bmSensor.getDevice().getDeviceAddress()));

		return sensor;
	}

	private Apiary getNewApiary(BmApiary bmApiary, String username) {
		Apiary newApiary = new Apiary();
		newApiary.set_id(bmApiary.getApiaryId());
		newApiary.setZipCode(bmApiary.getZipCode());
		newApiary.setName(bmApiary.getName());
		newApiary.setUserId(bmApiary.getUserId());
		newApiary.setCreateDate(this.convertTimestampToDate(bmApiary.getCreateDate()));
		newApiary.setDataLastReceived(this.convertTimestampToDate(bmApiary.getDataLastReceived()));
		newApiary.setPrivateApiary(bmApiary.getPrivateApiary());
		newApiary.setCountryCode(bmApiary.getCountryCode());
		newApiary.setUsername(username);
		newApiary.setPhoto("./assets/imageClient/testAccount.png");
		return newApiary;
	}

	@Override
	public void getChangeLog(String userId, String username) {
		this.header = new HttpHeaders();
		this.header.add("Content-Type", "application/x-www-form-urlencoded");
		this.header.add("license_key", this.licenceKey);
		String urlRequest = this.bmUrl + "user/changeLog";
		HttpEntity entity = new HttpEntity(this.header);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlRequest)
				.queryParam("userId", userId);
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		HttpEntity<BmAuth> response  = restTemplate.exchange(builder.toUriString(),
				HttpMethod.GET,
				entity,
				BmAuth.class);
		System.out.println(response.getBody());
		this.saveChangeLog(response.getBody(), username, userId);
	}

	@Override
	public void deleteChangeLog(int modified, String userId) {
		String urlRequest = this.bmUrl +  "user/changeLog";
		HttpHeaders header = new HttpHeaders();
		this.header.add("Content-Type", "application/json");
		this.header.add("license_key", this.licenceKey);
		JSONObject params = new JSONObject();
		params.put("modified", modified);
		params.put("userId", userId);
		HttpEntity<String> requestEntity = new HttpEntity<>(params.toJSONString(), header);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(params.toString(),header);
		ResponseEntity resp = restTemplate.exchange(urlRequest, HttpMethod.DELETE, entity, String.class);
	}

	public String getUserId() {
		return this.userId;
	}

	@Override
	public BmNote postNote(BmNote bmNote){
		String urlRequest = this.bmUrl +  "user/changeLog";
		this.header = new HttpHeaders();
		this.header.add("Content-Type", "application/json");
		this.header.add("license_key", this.licenceKey);
		Gson gson = new Gson();
		String noteJson = gson.toJson(bmNote);
		this.notePostRequestEntity = new HttpEntity<>(noteJson, this.header);
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		BmNote note = restTemplate.postForObject(urlRequest, requestEntity, BmNote.class);
		return bmNote;
	}

	private void saveApiaryFromBmApiary(BmApiary[] bmApiary, String username) {
		Arrays.stream(bmApiary).map(_apiary -> this.getNewApiary(_apiary, username)).collect(Collectors.toList()).forEach(_newApiary -> {
			boolean apiaryExist = this.apiaryRepository.findById(_newApiary.get_id()).isPresent();
			if (apiaryExist) {
				this.apiaryRepository.save(_newApiary);
			} else {
				this.apiaryRepository.insert(_newApiary);
			}
		});
	}
	private void saveHiveFromBmHive(BmHive[] bmHive, String username) {
		Arrays.stream(bmHive).map(_hive -> this.getNewHive(_hive, username, userId)).collect(Collectors.toList()).forEach(_newHive -> {
			boolean hiveExist = this.hiveRepository.findById(_newHive.get_id()).isPresent();
			if (hiveExist) {
				this.hiveRepository.save(_newHive);
			} else {
				this.hiveRepository.insert(_newHive);
			}
		});
	}

	public void saveSensorFronBmSensor(BmSensor[] bmSensor) {
		/*Arrays.stream(bmSensor).map(_sensor -> this.getNewSensor(_sensor, userId)).collect(Collectors.toList()).forEach(_newHive -> {
			boolean hiveExist = this.hiveRepository.findById(_newHive.get_id()).isPresent();
			if (hiveExist) {
				this.hiveRepository.save(_newHive);
			} else {
				this.hiveRepository.insert(_newHive);
			}
		});*/
	}

	private void saveNoteFromBmNote(BmNote[] bmNote) {
		Arrays.stream(bmNote).map(_note -> this.getNewNote(_note)).collect(Collectors.toList()).forEach(_newNote -> {
			boolean noteExist = this.noteRepository.findById(_newNote.get_id()).isPresent();
			if (noteExist) {
				this.noteRepository.save(_newNote);
			} else {
				this.noteRepository.insert(_newNote);
			}
		});
	}


	public void saveChangeLog(BmAuth change, String username, String userId) {
		try{
			if (change.getPayload().getApiaries() != null) {
				this.saveApiaryFromBmApiary(change.getPayload().getApiaries(), username);
			}
			if (change.getPayload().getBmNote() != null) {
				this.saveNoteFromBmNote(change.getPayload().getBmNote());
			}
			if (change.getPayload().getBmHive() != null) {
				this.saveHiveFromBmHive(change.getPayload().getBmHive(), username);
			}
			this.deleteChangeLog(change.getPayload().getModified(), change.getPayload().getUserId());
		}catch (NullPointerException e) {

		}
	}


	@Override
	public Date convertTimestampToDate(long time){
		return new Date(time*1000);
	}


	private String getTypeByRef(String ref) {
		String prefix = ref.split(":")[0];
		if (prefix.equals("41")) {
			return "T2";
		} else if (prefix.equals("42")) {
			return "T_HR";
		} else if (prefix.equals("43")) {
			return "WEIGHT";
		} else {
			return "ALIEN";
		}
	}
	
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }
}
