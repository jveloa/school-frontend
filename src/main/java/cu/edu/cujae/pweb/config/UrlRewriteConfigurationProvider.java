package cu.edu.cujae.pweb.config;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;

@RewriteConfiguration
public class UrlRewriteConfigurationProvider extends HttpConfigurationProvider {
    @Override
    public Configuration getConfiguration(ServletContext context) {
        return ConfigurationBuilder.begin()

            .addRule(Join.path("/bienvenido").to("/pages/welcome/welcome.jsf"))
            .addRule(Join.path("/usuarios").to("/pages/security/users/user-list.jsf"))
            .addRule(Join.path("/estudiantes").to("/pages/security/estudiantes/estudiantes-list.jsf"))
            .addRule(Join.path("/asignaturas").to("/pages/security/subjects/subject-list.jsf"))
            .addRule(Join.path("/notas").to("/pages/security/notas/nota-list.jsf"));
    }

    @Override
    public int priority() {
        return 0;
    }
}
