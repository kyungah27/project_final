package com.uver.cmn;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.uver.vo.ImgVO;


@Component("imgView")
public class ImgView extends AbstractView {
	private static final Logger LOG = LoggerFactory.getLogger(ImgView.class);

//	View 렌더링 구현
//	1. request 준비 -> jsp: 모델 객체를 request attributes로 셋팅
//	2. View 렌더링 -> jsp: RequestDispatcher 이용
	@Override
	protected void renderMergedOutputModel
		(Map<String, Object> model,
		HttpServletRequest req,
		HttpServletResponse res) throws Exception {
		
		ImgVO img = (ImgVO) model.get("img");
		LOG.debug("[img] " + img);
		
		res.setContentLength(img.getImgSize());
		res.setContentType("image/" + img.getImgType());
		LOG.debug("[res] " + res);
		
		byte[] bytes = readFile(img);
		write(res, bytes);
	}
	
	
	/**
	 * 파일에서 bytes 배열 읽기
	 * 
	 * @param img
	 * @return
	 * @throws IOException
	 */
	private byte[] readFile(ImgVO img) throws IOException {
		
		String path = ImgVO.DIR + "\\" +img.getServerName() + "." + img.getImgType();
		LOG.debug("[path] " + path);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		int len = bis.available();
		byte[] bytes = new byte[len];
		bis.read(bytes);
		bis.close();
		
		return bytes;
	}
	
	/**
	 * 응답 OutputStream에 파일 내용 쓰기
	 * 
	 * @param res
	 * @param bytes
	 * @throws IOException
	 */
	private void write(HttpServletResponse res, byte[] bytes) throws IOException {
		
		OutputStream out = res.getOutputStream();
		out.write(bytes);
		out.flush();
	}
	
	
	
	

}
