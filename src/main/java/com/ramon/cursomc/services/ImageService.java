package com.ramon.cursomc.services;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ramon.cursomc.services.exceptions.FileException;

@Service
public class ImageService {

	public BufferedImage getJpgImageFromFile(MultipartFile uploadedFile) {
		String ext = FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
		if(!"png".equals(ext) && !"jpg".equals(ext)) {
			throw new FileException("Somente imagens PNG e JPG são permitidas");
		}
		
		try {
			BufferedImage img = ImageIO.read(uploadedFile.getInputStream());
			if("png".equals(ext)) {
				img = pngToJpg(img);
			}
			return img;
		} catch (IOException e) {
			throw new FileException("Erro ao ler arquivo!");
		}
		
	}

	public BufferedImage pngToJpg(BufferedImage img) {
		BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
		jpgImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
		return jpgImage;
	}
	
	public InputStream getInputStream(BufferedImage img, String extension) {
		try {
		    ByteArrayOutputStream os = new ByteArrayOutputStream();
		    ImageIO.write(img, extension, os);
		    return new ByteArrayInputStream(os.toByteArray());
		} catch (IOException e) {
			throw new FileException("Erro ao ler arquivo!");
		}	
	}
	
	public BufferedImage cropSquare(BufferedImage souceImg) {
		int min = (souceImg.getHeight() <= souceImg.getWidth()) ? souceImg.getHeight() : souceImg.getWidth();
		return Scalr.crop(
				souceImg,
				(souceImg.getWidth()/2) - (min/2),
				(souceImg.getHeight()/2) - (min/2),
				min,
				min);
	}
	
	public BufferedImage resize(BufferedImage souceImg, int size) {
		return Scalr.resize(souceImg, Scalr.Method.ULTRA_QUALITY, size);
	}
}
