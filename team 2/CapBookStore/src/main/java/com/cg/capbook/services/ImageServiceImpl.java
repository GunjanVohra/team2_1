package com.cg.capbook.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.beans.Image;
import com.cg.capbook.beans.UserProfile;
import com.cg.capbook.daoservices.ImageDao;
import com.cg.capbook.exceptions.NoImageFoundException;
@Component("imageService")
public class ImageServiceImpl implements ImageService{

	private static String UPLOADED_FOLDER = "C:\\Users\\ADM-IG-HWDLAB1D\\git\\CapBookRemoteRepoTeam2\\CapBookStore\\src\\main\\resources\\static\\images\\";
	
	@Autowired
	public ImageDao imageDao;
	
	@Override
	public Image addImage(MultipartFile file, UserProfile user) {
	   
	    try {
	    	System.out.println("try strt");
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println("Email---"+user.getEmailId());
            String imageUrl=""+"resources\\images\\"+file.getOriginalFilename();
           Image  image= new Image(imageUrl,"profilePic", user);
             System.out.println("Image");
            imageDao.save(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

			return null;
	}

	@Override
	public Image getImage(int imageId) throws NoImageFoundException {
		Image image=imageDao.findById(imageId).orElseThrow(()-> new NoImageFoundException("df"));
		return image;
	}

	@Override
	public Image addAlbum(MultipartFile file, UserProfile user, String albumName) {
		
		 try {
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	            String imageUrl=""+"resources\\images\\"+file.getOriginalFilename();
	           Image  image= new Image(imageUrl,albumName, user);
	            imageDao.save(image);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return null;
	}

}
