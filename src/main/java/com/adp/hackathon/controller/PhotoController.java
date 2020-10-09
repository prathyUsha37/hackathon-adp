package com.adp.hackathon.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adp.hackathon.service.PhotoService;
import com.adp.hackathon.model.Photo;
import java.util.List;


@RestController
@CrossOrigin
public class PhotoController {	
	
	PhotoService photoSerive;
	
	
	@Autowired(required=true)
	PhotoController(PhotoService photoSerive){
		this.photoSerive=photoSerive;
	}
	
	
	@RequestMapping(value = "/photo/create", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public boolean createEmployee(@RequestBody Photo photo) {
		System.out.println(photo);
		return this.photoSerive.createPhoto(photo);
	}

	
	
    @RequestMapping(value="/photo/update/{id}",method = RequestMethod.PUT,
			headers = "Accept=application/json")
    public void updateEmployee(@PathVariable("id") Long id, @RequestBody Photo photo){
    	this.photoSerive.updatePhoto(photo);
    }

    
    
    @RequestMapping(value="/photo/all",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public List<Photo> listPhotos(){
    	List<Photo> employees= this.photoSerive.getPhotos();
        return employees;
    }
	
    
    
    @RequestMapping(value="/photo/{id}",method = RequestMethod.GET,
			headers = "Accept=application/json")
    @ResponseBody
    public Photo getPhoto(@PathVariable("id") Long id){
    	Photo photo= this.photoSerive.getPhotoById(id);
        return photo;
    }
	
	
}

