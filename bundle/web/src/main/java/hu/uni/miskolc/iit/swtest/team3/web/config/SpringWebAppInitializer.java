package hu.uni.miskolc.iit.swtest.team3.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class SpringWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringWebConfig.class);

        // Manage the lifecycle of the root application context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Register and map the dispatcher servlet, in our case it can be the same as it is configured with the same class
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");

    }
}
