package com.uver.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.uver.cmn.Search;
import com.uver.vo.ImgVO;


@Repository("imgDao")
public class ImgDaoImpl {
	private static final Logger LOG = LoggerFactory.getLogger(ImgDaoImpl.class);
	
	private final String NAMESPACE = "com.uver.img";
	private final SqlSessionTemplate sqlSessionTemplate;
    
   private ImgDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


//---메서드----------------------------------------------------------
   /**
	* 이미지 등록
	* 생성된 seq 값 돌려받음
	* 
	* @param ImgVO
	* @return int imgSeq
	*/
   public int doInsert(ImgVO img) {
	   String statement = NAMESPACE + ".doInsert";
	   LOG.debug("[statement]" + statement);
	   
	   int flag = sqlSessionTemplate.insert(statement, img);
	   int seq = img.getImgSeq();

	   LOG.debug("[flag] " + flag);
	   LOG.debug("[seq] " + seq);
	   
	   return seq;
   }
   
   
   /**
    * 이미지 삭제
    * 
    * @param int imgSeq
    * @return flag (1:성공 / 0: 실패)
    */
	public int doDelete(int imgSeq) {
		int flag = 0;
		
		String statement = NAMESPACE + ".doDelete";
		LOG.debug("[imgSeq] " + imgSeq);
		LOG.debug("[statement] " + statement);
		
		flag = sqlSessionTemplate.delete(statement, imgSeq);

		return flag;
	}
	
	/**
	 * (테스트용) 이미지 전체 삭제
	 * 
	 * @return flag (1:성공 / 0: 실패)
	 */
	public int doDeleteAll() {
		int flag = 0;
		String statement = NAMESPACE +".doDeleteAll";
		LOG.debug("=statement="+statement);	
		
		flag = sqlSessionTemplate.delete(statement);
		LOG.debug("=flag="+flag);
		
		return flag;
	}
	
	/**
	 * 이미지 단건 조회
	 * 
	 * @param int imgSeq
	 * @return ImgVO
	 */
	public ImgVO doSelectOne(int imgSeq) {
		
		String statement = NAMESPACE +".doSelectOne";	
		LOG.debug("[statement] " + statement);
		LOG.debug("[imgSeq] " + imgSeq);
		
		ImgVO outVO = this.sqlSessionTemplate.selectOne(statement, imgSeq);
		LOG.debug("[outVO]" + outVO);
		
		return outVO;
	}
   
	
	/**
	 * 이미지 수정 (썸네일 여부만)
	 * 
	 * @param img
	 * @return flag (1: 성공 / 0: 실패)
	 */
	public int doUpdate(ImgVO img) {
		int flag = 0;
		
		String statement = NAMESPACE +".doUpdate";
		LOG.debug("[statement] "+statement);	
		LOG.debug("[param: img] "+statement);	
		
		flag = sqlSessionTemplate.update(statement, img);
		LOG.debug("[flag] "+flag);

		return flag;
	}
	
	/**
	 * 등록자ID 기준 이미지 다건 조회
	 * 
	 * @param String regId
	 * @return List<ImgVO>
	 */
	public List<ImgVO> doSelectList(Search search) {
		
		LOG.debug("[search] " + search);
		
		String statement = NAMESPACE + ".doSelectList";
		List<ImgVO> list = this.sqlSessionTemplate.selectList(statement, search);
		LOG.debug("[statement] " + statement);
		
		for (ImgVO vo : list) {
			LOG.debug("[vo] " + vo);
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//---이하 jdbcTemplate 이용한 dao 처리

	/*
	 *  
   private final JdbcTemplate jdbcTemplate;
    
    public ImgDaoImpl(JdbcTemplate jdbcTemplate) {
    	this.jdbcTemplate = jdbcTemplate;
    }
   
   RowMapper<ImgVO> rowMapper= new RowMapper<ImgVO>() {
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
   
   
   public int doInsert(ImgVO img) {
		int   flag 	  			  = 0;	    
	    final KeyHolder keyHolder = new GeneratedKeyHolder();
	    
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
		
		flag = this.jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(sb.toString(),
															new String[] {"IMG_SEQ"});
				ps.setString(1, img.getOriginName());
				ps.setString(2, img.getServerName());
				ps.setString(3, img.getImgType());
				ps.setInt(4, img.getImgSize());
				ps.setString(5, img.getIsThumbnail());
				ps.setString(6, img.getRegId());
				
				return ps;
			}
		}, keyHolder);
		
		
		int seq = keyHolder.getKey().intValue();
		
		LOG.debug("[flag] " + flag);
		LOG.debug("[seq] "+ seq);

		return seq;
	}
	
	
	public int doDelete(int imgSeq) {
		int flag 	  = 0;	    
	    Object[] args = { imgSeq };
	    
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM image \n");
		sb.append("WHERE             \n");
		sb.append("    img_seq = ?   \n");
		
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + imgSeq);
		LOG.debug("-----------------------------");			
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("[flag] "+flag);

		return flag;
	}
	
	
	
	
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

	public int doUpdate(ImgVO img) {
		int flag 	  = 0;	    
	    Object[] args = { 	img.getIsThumbnail(),
	    					img.getImgSeq()
	    				};
	    
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE image			\n");
		sb.append("SET                  \n");
		sb.append("    is_thumbnail = ? \n");
		sb.append("WHERE                \n");
		sb.append("    img_seq = ?      \n");
		
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + img);
		LOG.debug("-----------------------------");			
		
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("[flag] "+flag);

		return flag;
	}
	
	public List<ImgVO> doSelectList(String regId) {
		List<ImgVO> list = null;	    
	    Object[] args  = { regId };
	    
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
		sb.append("    IMAGE            \n");
		sb.append("WHERE reg_id = ?     \n");
		sb.append("ORDER BY reg_dt DESC \n");
		
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + regId);
		LOG.debug("-----------------------------");			
		
		list = (List<ImgVO>) this.jdbcTemplate.query(sb.toString(), args, rowMapper);
		LOG.debug("-----------------------------");
		for (ImgVO vo : list) {
			LOG.debug("[vo] " + list);
		}
		LOG.debug("-----------------------------");
		
		return list;
	}
	
	
	
	
	
	
	public int count(String regId) {
		int  cnt = 0;
	    Object[] args  = { regId };
		
		StringBuilder  sb=new StringBuilder();
		sb.append(" SELECT COUNT(*) cnt \n");
		sb.append(" FROM IMAGE          \n");
		sb.append(" WHERE reg_id = ?    \n");
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n"   + sb.toString());
		LOG.debug("[param]\n" + regId);
		LOG.debug("-----------------------------");		
		
		cnt = this.jdbcTemplate.queryForObject(sb.toString(), args, Integer.class);
		LOG.debug("-----------------------------");
		LOG.debug("[count] "+cnt);
		LOG.debug("-----------------------------");

    	return cnt;
	}
	
	
	
	*/
	

	
	
    
    
    

}
