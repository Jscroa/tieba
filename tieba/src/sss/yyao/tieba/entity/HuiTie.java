package sss.yyao.tieba.entity;

import java.sql.Timestamp;

/**
 * HuiTie 回帖类
 * @author Administrator
 *
 */
public class HuiTie {

	private Integer id;
	private Integer userId;
	private String content;
	private Timestamp time;
	private int toUserId;
	private int finfTieId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getToUserId() {
		return toUserId;
	}
	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}
	public int getFinfTieId() {
		return finfTieId;
	}
	public void setFinfTieId(int finfTieId) {
		this.finfTieId = finfTieId;
	}

}
