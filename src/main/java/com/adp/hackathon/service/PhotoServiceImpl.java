package com.adp.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adp.hackathon.dao.PhotoDAO;
import com.adp.hackathon.model.Photo;


@Repository
public class PhotoServiceImpl implements PhotoService{

	private PhotoDAO photoDAO;
	
	@Autowired
	public void setPhotoDAO(PhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}
	
	@Override
	@Transactional
	public boolean createPhoto(Photo photo) {
			Photo photo1=this.photoDAO.createPhoto(photo);
			return true;
	}

	@Override
	@Transactional
	public boolean updatePhoto(Photo photo) {
		if(this.photoDAO.isIdExists(photo.getId())) {
			this.photoDAO.updatePhoto(photo);
			return true;
		}
		return false;
	}
	

	@Override
	@Transactional
	public Photo getPhotoById(Long id) {
		return this.photoDAO.getPhotoById(id);
	}

	
	
	@Override
	@Transactional
	public List<Photo> getPhotos() {
		return this.photoDAO.getPhotos();
	}

}
