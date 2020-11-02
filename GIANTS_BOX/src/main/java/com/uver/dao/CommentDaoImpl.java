package com.uver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.uver.vo.CommentVO;

@Repository("commentDao")
public class CommentDaoImpl {
	private static final Logger LOG = LoggerFactory.getLogger(CommentDaoImpl.class);

	private final JdbcTemplate jdbcTemplate;

	public CommentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// -----row mapper
	RowMapper<CommentVO> rowMapper = new RowMapper<CommentVO>() {
		public CommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommentVO outVO = new CommentVO(rs.getInt("comment_seq"), rs.getInt("seq"), rs.getString("div"),
					rs.getString("content"), rs.getString("reg_dt"), rs.getString("reg_dt"), rs.getString("mod_dt"));
			return outVO;
		}

	}; // ---row mapper end

	// -----메서드
	public int doInsert(CommentVO comment) {
		int flag = 0;
		Object[] args = { comment.getSeq(), comment.getDiv(), comment.getContent(), comment.getRegId() };

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO comment_tb (	\n");
		sb.append("    comment_seq,         \n");
		sb.append("    seq,                 \n");
		sb.append("    div,                 \n");
		sb.append("    content,             \n");
		sb.append("    reg_dt,              \n");
		sb.append("    reg_id,              \n");
		sb.append("    mod_dt               \n");
		sb.append(") VALUES (               \n");
		sb.append("    COMMENT_SEQ.NEXTVAL, \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    ?,                   \n");
		sb.append("    SYSDATE,             \n");
		sb.append("    ?,                   \n");
		sb.append("    SYSDATEe             \n");
		sb.append(")                        \n");
		LOG.debug("-----------------------------");
		LOG.debug("[SQL]\n" + sb.toString());
		LOG.debug("[param]\n" + comment);
		LOG.debug("-----------------------------");

		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("[flag] " + flag);

		return flag;
	}

	public int doDelete(CommentVO vo) {
		int flag = 0;

		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM comment_tb  \n");
		sb.append("WHERE                   \n");
		sb.append("    comment_seq = ?     \n");

		Object[] args = { vo.getCommentSeq() };
		flag = this.jdbcTemplate.update(sb.toString(), args);
		LOG.debug("=flag=" + flag);

		return flag;
	}

}
