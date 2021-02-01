package learn.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.hibernate.entity.Course;
import learn.hibernate.entity.Instructor;
import learn.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//Create Session Factory
		
		SessionFactory factory = new Configuration()
				                    .configure("Hibernate.cfg.xml")
				                    .addAnnotatedClass(Course.class)
				                    .addAnnotatedClass(Instructor.class)
				                    .addAnnotatedClass(InstructorDetail.class)
				                    .buildSessionFactory();
		
		//Create Session
		
		Session session = factory.getCurrentSession();
		
      try {		
    	  
    	  //create the object
    	  Instructor tempInstructor = 
					new Instructor("Susan", "Public", "susan.public@luv2code.com");
			
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Video Games");
			
			//associate the object
    	  tempInstructor.setInstructorDetail(tempInstructorDetail);
    	  
		// start a transaction
		session.beginTransaction();
		
		//save the object
		System.out.println("Saving instructor: " + tempInstructor);;
		session.save(tempInstructor);

		// commmit transaction
		session.getTransaction().commit();
		
		System.out.println("Done!!!");
      }
      
      finally {
    	  
    	  session.close();
    	  factory.close();
      }
      
      
	}

}
