package com.net.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;

@RestController
public class ImageUploadController {
	@Autowired
	private ImageUploadService imageUploadService;
	
	@Autowired
	private TextAnalysisService textAnalysisService;
	
	//Multipartform/data 형식
	@RequestMapping(path = "/upload", method = RequestMethod.POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	//Swagger-ui에 등록 어노테이션
	@ApiOperation(value = "ImageUploadSample", tags="sample")
	public @ResponseBody ResultVO add(@RequestParam("image") MultipartFile file) throws Exception {
	    
		//파일 저장 서비스 호출
		if(imageUploadService.upload(file)) {
			System.out.println("이미지 업로드 성공");
		} else {
			System.out.println("이미지 업로드 실패");
		}
		
		
		//이미지 분석 서비스 호출
		ResultVO result = textAnalysisService.doImageAnalysis("임시이미지");
		
	    //Return
	    return result;
	}
}
