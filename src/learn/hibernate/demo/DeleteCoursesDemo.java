package learn.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learn.hibernate.entity.Course;
import learn.hibernate.entity.Instructor;
import learn.hibernate.entity.InstructorDetail;

public class DeleteCoursesDemo {

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
			
			//get a course 
			int theid = 10;
			Course tempCourse = session.get(Course.class, theid);
			
			
			//delete course
			System.out.println("Deleting Course : " + tempCourse);
			
			session.delete(tempCourse);
			
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
