package sss.yyao.tieba.entity;

import java.sql.Timestamp;

/**
 * TieZi 帖子类
 * @author Administrator
 *
 */
public class TieZi {

	private Integer id;
	private Integer userId;
	private String title;
	private String theme;
	private Timestamp createTime;
	private Timestamp finalTime;
	private String essence;
	private String top;

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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getFinalTime() {
		return finalTime;
	}
	public void setFinalTime(Timestamp finalTime) {
		this.finalTime = finalTime;
	}
	public String getEssence() {
		return essence;
	}
	public void setEssence(String essence) {
		this.essence = essence;
	}
	public String getTop() {
		return top;
	}
	public void setTop(String top) {
		this.top = top;
	}

}
