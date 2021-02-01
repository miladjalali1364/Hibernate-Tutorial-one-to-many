package learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.hibernate.entity.Course;
import learn.hibernate.entity.Instructor;
import learn.hibernate.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		
		//Create Session factory
		SessionFactory factory = new Configuration()
				                    .configure()
				                    .addAnnotatedClass(Course.class)
				                    .addAnnotatedClass(Instructor.class)
				                    .addAnnotatedClass(InstructorDetail.class)
				                    .buildSessionFactory();
		
		
		//Create Session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor from db
			int theid = 3;
			Instructor tempInstructor = session.get(Instructor.class, theid);
			System.out.println("Print the Instructor : " + tempInstructor);
			
			//get courses for instructor
			System.out.println("Print the Courses : " + tempInstructor.getCourse());
			
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
		}
		finally {
			
			// add Clean up code
			session.close();
			factory.close();
		}

	}

}
