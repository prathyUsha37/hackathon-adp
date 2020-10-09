package com.adp.hackathon.service;

import java.util.List;

import com.adp.hackathon.model.Photo;

public interface PhotoService {
		public boolean createPhoto(Photo photo);
		public boolean updatePhoto(Photo photo);
		public List<Photo> getPhotos();
		public Photo getPhotoById(Long id);
}
