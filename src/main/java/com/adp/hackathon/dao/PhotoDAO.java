package com.adp.hackathon.dao;

import java.util.List;
import com.adp.hackathon.model.Photo;


public interface PhotoDAO {
	public Photo createPhoto(Photo e);
	public void updatePhoto(Photo e);
	public List<Photo> getPhotos();
	public Photo getPhotoById(Long id);
	public boolean isIdExists(Long id);
}
