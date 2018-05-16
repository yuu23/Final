package f.bean;

import java.io.Serializable;

public class fCharacterBean implements Serializable {
	// cmdと同じ名前で書く
	private String no;
	private String name;
	private String job;
	private String ability;
	private String image;

	public fCharacterBean(String no,String name,String job,String ability,String image) {
		this.no = no;
		this.name = name;
		this.job = job;
		this.ability = ability;
		this.image = image;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public fCharacterBean() {

	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}
}