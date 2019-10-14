package edu.eci.ieti.taskPlannerBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import edu.eci.ieti.taskPlannerBack.config.JwtFilter;

@SpringBootApplication
public class TaskPlannerBackApplication {
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskPlannerBackApplication.class, args);
	}

}
