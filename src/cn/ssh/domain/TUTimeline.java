package cn.ssh.domain;

import java.util.Date;

/**
 * TUTimeline entity. @author MyEclipse Persistence Tools
 */

public class TUTimeline implements java.io.Serializable {

	// Fields

	private Integer timelineId;
	private TUUser TUUser;
	private Integer type;
	private Integer sthId;
	private Date postTime;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String content;
	private String img5;
	private String img6;
	private String img7;

	// Constructors

	/** default constructor */
	public TUTimeline() {
	}

	/** minimal constructor */
	public TUTimeline(Integer type, Integer sthId) {
		this.type = type;
		this.sthId = sthId;
	}

	/** full constructor */
	public TUTimeline(TUUser TUUser, Integer type, Integer sthId,
			Date postTime, String img1, String img2, String img3, String img4,
			String content, String img5, String img6, String img7) {
		this.TUUser = TUUser;
		this.type = type;
		this.sthId = sthId;
		this.postTime = postTime;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.content = content;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
	}

	// Property accessors

	public Integer getTimelineId() {
		return this.timelineId;
	}

	public void setTimelineId(Integer timelineId) {
		this.timelineId = timelineId;
	}

	public TUUser getTUUser() {
		return this.TUUser;
	}

	public void setTUUser(TUUser TUUser) {
		this.TUUser = TUUser;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSthId() {
		return this.sthId;
	}

	public void setSthId(Integer sthId) {
		this.sthId = sthId;
	}

	public Date getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return this.img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return this.img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg5() {
		return this.img5;
	}

	public void setImg5(String img5) {
		this.img5 = img5;
	}

	public String getImg6() {
		return this.img6;
	}

	public void setImg6(String img6) {
		this.img6 = img6;
	}

	public String getImg7() {
		return this.img7;
	}

	public void setImg7(String img7) {
		this.img7 = img7;
	}

}