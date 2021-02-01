package learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.hibernate.entity.Course;
import learn.hibernate.entity.Instructor;
import learn.hibernate.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory = new Configuration()
				                     .configure()
				                     .addAnnotatedClass(Course.class)
				                     .addAnnotatedClass(Instructor.class)
				                     .addAnnotatedClass(InstructorDetail.class)
				                     .buildSessionFactory();
		
		
		//Create Session
		 Session session = factory.getCurrentSession();
		 
		 
		 try {
		
			 //start transaction
			 session.beginTransaction();
			 
			 //get the instructor from db
			 int theid = 3;
			 Instructor tempInstructor = session.get(Instructor.class, theid);
			 			 
			 //create some courses
			 Course tempCourse1 = new Course("Air Guitar - the Ultimate Guide");
			 Course tempCourse2 = new Course("the Pinball Masterclass");
			 
			 //add courses to instructor
			 tempInstructor.add(tempCourse1);
			 tempInstructor.add(tempCourse2);
			 
			 //save the courses
			 session.save(tempCourse1);
			 session.save(tempCourse2);
			 			 
			 //commit transaction
			 session.getTransaction().commit();
			 System.out.println("Done!!!");
			 
		 }
		 
		 
		 finally
		  {
			 session.close();
			 factory.close();
		 }
		
		

	}

}
