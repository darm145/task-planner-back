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
import edu.eci.ieti.taskPlannerBack.Entities.*;

@RestController
public class TaskController {
    @Autowired
    TaskService TaskService; 

    @RequestMapping(value="/Task",method = RequestMethod.GET)
	public ResponseEntity<?> allTasks(){
	    try {
	        return new ResponseEntity<>(TaskService.geTasksList(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }
}