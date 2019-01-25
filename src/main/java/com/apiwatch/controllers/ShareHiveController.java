package com.apiwatch.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.Hive;
import com.apiwatch.entities.ShareHive;
import com.apiwatch.entities.User;
import com.apiwatch.repositories.HivesRepository;
import com.apiwatch.repositories.ShareRepository;
import com.apiwatch.repositories.UserRepository;

@Service
@RestController
@RequestMapping("/share")
public class ShareHiveController {

	
	@Autowired private ShareRepository shareRepository;
	@Autowired private HivesRepository hivesRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private HiveController hiveController;
	
	private ShareHiveController() {
	}
	@RequestMapping(value="user/{idUser}", method=RequestMethod.GET)
	public ShareHive getHiveShare(@PathVariable String idUser){
		return this.shareRepository.findShareHiveByidUsername(idUser);
	}
	
	@DeleteMapping("/{idUser}/{idHive}")
	public void removeShareHive(@PathVariable String idUser, @PathVariable String idHive) {
		Hive hive = this.hivesRepository.findHiveById(idHive);
		this.shareRepository.findShareHiveByidUsername(idUser);
	}
	
	
	@RequestMapping(value="/sharing/{userShare}/{idHive}/{userTarget}",method=RequestMethod.GET)
	public Boolean shareHive(@PathVariable String idHive, @PathVariable String userTarget, @PathVariable String userShare) {
		List<User> user = this.userRepository.findAll();
		User userHiveOwner = null;
		User userTargetShare = null;
		ShareHive hiveShare = null;
		Hive hive = this.hivesRepository.findHiveById(idHive);
		if(hive != null) {
			for(User u : user) {
				if(u.getLogin().getUsername().equals(userTarget)) {
					userTargetShare = u;
				}
				if(u.getLogin().getUsername().equals(userShare)) {
					userHiveOwner = u;
				}
			}
			if(userHiveOwner != null && userTargetShare != null ) {
				hiveShare = this.shareRepository.findShareHiveByidUsername(userTargetShare.getId());
				hive.setShareStatus(true);
				System.out.println(userHiveOwner);
				if(hiveShare == null) {
					hiveShare = new ShareHive(null,userTargetShare.getId(),userTargetShare.getLogin().getUsername(),new HashMap<String, Hive>());
				}
				hiveShare.addHive(hive,userHiveOwner.getId());
				hive.addSharingUser(userTargetShare);
				this.hiveController.update(hive.getId(), hive);
				System.out.println(userTargetShare);
				System.out.println(hiveShare);
				this.shareRepository.save(hiveShare);
				return true;
			}
		}
		return false;
	}
	
}
