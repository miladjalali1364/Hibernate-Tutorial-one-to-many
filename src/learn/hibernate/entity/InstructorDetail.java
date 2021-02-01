package learn.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	
	//annotated the class as an entity and map to db table
	
	@Id //Annotate for pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") //name column table
	private int id;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	@OneToOne(mappedBy = "instructorDetail" 
			 , cascade = { CascadeType.DETACH 
					      ,CascadeType.MERGE
					      ,CascadeType.PERSIST
					      ,CascadeType.REFRESH })
	private Instructor instructor;

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + ", instructor=" + instructor
				+ "]";
	}

	
	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}
	
	
	public InstructorDetail() {}
}
