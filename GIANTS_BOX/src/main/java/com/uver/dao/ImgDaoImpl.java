package com.uver.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uver.vo.ImgVO;
import com.uver99.example.User;


@Repository("imgDao")
public class ImgDaoImpl implements ImgDao {
	private static final Logger LOG = LoggerFactory.getLogger(ImgDaoImpl.class);
    
    private final JdbcTemplate jdbcTemplate;
    
    public ImgDaoImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public int doInsert(ImgVO img) {
		int flag 	  = 0;	    
	    Object[] args = { img.getImgSeq(),
	    				  img.getOriginName(),
	    				  img.getServerName(),
	    				  img.getType(),
	    				  img.getSize(),
	    				  img.getIsThumbnail(),
	    				  img.getRegDt(),
	    				  img.getRegId()
	    				};
	    
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO IMAGE          \n");
		sb.append("VALUES(IMAGE_SEQ.NEXTVAL,  \n");
		sb.append("            ?,       	  \n");
		sb.append("            ?,        	  \n");
		sb.append("            ?,        	  \n");
		sb.append("            ?,        	  \n");
		sb.append("            ?,         	  \n");
		sb.append("            SYSDATE,       \n");
		sb.append("            ?              \n");
		sb.append("            )              \n");
		
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + img);
		LOG.debug("-----------------------------");			
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("[flag] "+flag);

		return flag;
	}
	
	

	@Override
	public int doDelete(ImgVO img) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdate(ImgVO img) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User doSelectOne(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImgVO> doSelectList(ImgVO img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(ImgVO img) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
