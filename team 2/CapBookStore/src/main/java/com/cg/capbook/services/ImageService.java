package com.cg.capbook.services;

import org.springframework.web.multipart.MultipartFile;
import com.cg.capbook.beans.Image;
import com.cg.capbook.beans.UserProfile;
import com.cg.capbook.exceptions.NoImageFoundException;

public interface ImageService {
	
	public Image getImage(int imageId)throws NoImageFoundException;
	
	public Image addImage(MultipartFile file, UserProfile user);
	public Image addAlbum(MultipartFile file, UserProfile user,String albumName);
}
