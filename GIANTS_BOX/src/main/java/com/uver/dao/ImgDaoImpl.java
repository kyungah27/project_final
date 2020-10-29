package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.vo.ImgVO;
import com.uver99.example.Level;
import com.uver99.example.User;


@Repository("imgDao")
public class ImgDaoImpl implements ImgDao {
	private static final Logger LOG = LoggerFactory.getLogger(ImgDaoImpl.class);
    
    private final JdbcTemplate jdbcTemplate;
    
    public ImgDaoImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }
    
    //---row mapper------------------------------------------------
    RowMapper<ImgVO> rowMapper= new RowMapper<ImgVO>() {
		@Override
		public ImgVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ImgVO outVO = new ImgVO(
						rs.getInt("img_seq"),
						rs.getString("origin_name"),
						rs.getString("server_name"),
						rs.getString("img_type"),
						rs.getInt("img_size"),
						rs.getString("is_thumbnail"),
						rs.getString("reg_dt"),
						rs.getString("reg_id")
						);
			
			return outVO;
		}
   }; //---row mapper end
    
    
    
   //---메서드----------------------------------------------------------
	@Override
	public int doInsert(ImgVO img) {
		int flag 	  = 0;	    
	    Object[] args = { 
	    				  img.getOriginName(),
	    				  img.getServerName(),
	    				  img.getImgType(),
	    				  img.getImgSize(),
	    				  img.getIsThumbnail(),
	    				  img.getRegId()
	    				};
	    
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO image (		\n");
		sb.append("    img_seq,             \n");
		sb.append("    origin_name,         \n");
		sb.append("    server_name,         \n");
		sb.append("    img_type,            \n");
		sb.append("    img_size,            \n");
		sb.append("    is_thumbnail,        \n");
		sb.append("    reg_dt,              \n");
		sb.append("    reg_id               \n");
		sb.append(") VALUES (               \n");
		sb.append("    IMAGE_SEQ.NEXTVAL,   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    SYSDATE,             \n");
		sb.append("    ?                    \n");
		sb.append(")                        \n");
		
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
		int flag 	  = 0;	    
	    Object[] args = { 
	    				  img.getImgSeq()
	    				};
	    
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM image \n");
		sb.append("WHERE             \n");
		sb.append("    img_seq = ?   \n");
		
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + img);
		LOG.debug("-----------------------------");			
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("[flag] "+flag);

		return flag;
	}

	@Override
	public ImgVO doSelectOne(int seq) {
		ImgVO 	 outVO = null;	    
	    Object[] args  = { seq };
	    
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT				\n");
		sb.append("    img_seq,         \n");
		sb.append("    origin_name,     \n");
		sb.append("    server_name,     \n");
		sb.append("    img_type,        \n");
		sb.append("    img_size,        \n");
		sb.append("    is_thumbnail,    \n");
		sb.append("    reg_dt,          \n");
		sb.append("    reg_id           \n");
		sb.append("FROM                 \n");
		sb.append("    image            \n");
		sb.append("WHERE img_seq = ?    \n");
		
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + seq);
		LOG.debug("-----------------------------");			
		
		outVO = (ImgVO) this.jdbcTemplate.queryForObject(sb.toString(), args, rowMapper);
		LOG.debug("[outVO]\n" + outVO);

		return outVO;
	}

	/**
	 * 중간 조인 단계 테이블에서 가져오므로 필요x
	 */
	@Override
	public List<ImgVO> doSelectList(ImgVO img) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 화면에서 사용자가 이미지를 삭제하고 업로드(삽입) 하기 때문에 필요x
	 */
	@Override
	public int doUpdate(ImgVO img) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * 중간 조인 단계 테이블에서 카운트하므로 필요x
	 */
	@Override
	public int count(ImgVO img) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
