package edu.eci.ieti.taskPlannerBack.Controllers;

import com.mongodb.client.gridfs.model.GridFSFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.taskPlannerBack.Entities.*;

@RestController
@CrossOrigin
public class ImageController {
    @Autowired
    GridFsTemplate gridfstemplate;

    @RequestMapping(value = "Image/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTaskById(@PathVariable("id") String imageId) {
		try {
            GridFSFile file= gridfstemplate.findOne(new Query().addCriteria(Criteria.where("filename").is(imageId)));
            GridFsResource resource = gridfstemplate.getResource(file.getFilename());
			return ResponseEntity.ok()
            .contentType(MediaType.valueOf(resource.getContentType()))
            .body(new InputStreamResource(resource.getInputStream()));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

    }
    @RequestMapping(value = "Image/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> InsertImage(@RequestParam("file") MultipartFile file,@PathVariable("id") String imageId) {
		try {
            gridfstemplate.store(file.getInputStream() , imageId, file.getContentType());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}

	}
}