package com.app.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@Value("${upload_image_path}")
	private String imagePath;

	// Usage of path variable
	@RequestMapping(value = "/{path}")
	public String showForm(@PathVariable String path) {
		System.out.println("in show upload form");
		return path;
	}

	@RequestMapping(value = "file_upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("contents") MultipartFile file, Model map, HttpServletRequest request) {
		String uploadLocation = imagePath;
				//request.getServletContext().getRealPath("/images");

		System.out.println(
				"in upload file " + file.getOriginalFilename() + " size " + file.getSize() + " " + uploadLocation);
		try {
			File dest=new File(uploadLocation, file.getOriginalFilename());
			//file transferred to server side folder 
			file.transferTo(dest);
			/*
			 * Here now u invoke
			 * service.saveProductImage(file.getOriginalFilename())
			 * i.e u are simply saving image name on DB
			 * Which u can retrieve later from DB.
			 */
		} catch (Exception e) {

			map.addAttribute("mesg", "File upload failed : " + e.getMessage());
			return "file_upload";
		}
		return "upload_succ";
	}

	// get list of images under the webapp
	@RequestMapping(value = "/list_images")
	public String listImages(Model map, HttpServletRequest request) {
		System.out.println("in list images " + imagePath);
		File uploadLocationDir = new File(imagePath);
		System.out.println(uploadLocationDir.exists() + " " + uploadLocationDir.isDirectory() + " "
				+ uploadLocationDir.getAbsolutePath());
		// new File(request.getServletContext().getRealPath("/images"));
		String[] files = uploadLocationDir.list();
		System.out.println("files " + Arrays.toString(files));
		map.addAttribute("image_list", files);
		return "list_images";
	}

	@RequestMapping(value = "/choose")
	public String chooseImage(Model map, @RequestParam String imgName) {
		System.out.println("in choose img name " + imgName);
		map.addAttribute("img_name", imgName);
		return "show_image";
	}

}
