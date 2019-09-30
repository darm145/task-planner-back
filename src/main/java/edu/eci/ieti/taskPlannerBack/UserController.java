package edu.eci.ieti.taskPlannerBack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.taskPlannerBack.Entities.User;
import edu.eci.ieti.taskPlannerBack.Entities.UserServices;

@RestController
public class UserController {
    @Autowired
	UserServices UserServices;
	
	
	
	@RequestMapping(value="/User",method = RequestMethod.GET)
	public ResponseEntity<?> listAllUsers(){
	    try {
	        return new ResponseEntity<>(UserServices.getUsersList(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }
    @RequestMapping(value = "User/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUserById(@PathVariable("id") String userId) {
		try {
			
			return new ResponseEntity<>(UserServices.getUserById(userId),HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

	}
	@RequestMapping(value = "/User", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User u) {
		try {
			UserServices.createUser(u);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

    }
    @RequestMapping(value = "/RUser/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> removeUser(@PathVariable("id") String userId) {
		try {
			UserServices.removeUser(userId);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

    }
    @RequestMapping(value = "/UUser", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody User u) {
		try {
			UserServices.updateUser(u);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

	}
}