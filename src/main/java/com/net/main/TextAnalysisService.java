package com.net.main;

import org.springframework.stereotype.Service;

@Service
public class TextAnalysisService {

	public ResultVO doImageAnalysis(String img) {
		System.out.println("이미지 객체 불러오기 성공");
		
		ResultVO result = new ResultVO();
		result.setBizno("111-45-84729");
		result.setMerchant("옥돌상회");
		result.setType("유통업");
		
		return result;
	}
}
