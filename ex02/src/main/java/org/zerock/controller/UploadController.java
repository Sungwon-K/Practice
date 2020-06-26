package org.zerock.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController {
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile,Model model) {
		String uploadFolder = "c:\\upload";
			
		for(MultipartFile multipartFile : uploadFile) {
				
			log.info("-----------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());
		
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
		
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e){
				log.error(e.getMessage());
			}//end catch
		
		}//end for
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		
	}
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxPost(MultipartFile[] uploadFile) {
		
		String uploadFolder = "C:\\upload";
			
		for(MultipartFile multipartFile : uploadFile) {
				
			log.info("-----------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());
								
			//IE에서는 FileName에 Path가 붙기 때문에 Path를 제외하고 파일명만 추출
			String uploadFileName = multipartFile.getOriginalFilename();
			uploadFileName= uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			
			log.info("only file name: " + uploadFileName);
			
			File saveFile = new File(uploadFolder, uploadFileName);
		
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e){
				log.error(e.getMessage());
			}//end catch
		
		}//end for
	}
}
