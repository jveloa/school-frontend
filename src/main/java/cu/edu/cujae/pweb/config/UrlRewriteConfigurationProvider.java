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

            .addRule(Join.path("/welcome").to("/pages/welcome/welcome.jsf"))
            .addRule(Join.path("/users").to("/pages/security/users/user-list.jsf"))
            .addRule(Join.path("/students").to("/pages/security/estudiantes/estudiantes-list.jsf"))
            .addRule(Join.path("/subjects").to("/pages/security/subjects/subject-list.jsf"))
            .addRule(Join.path("/evalution").to("/pages/security/notas/nota-list.jsf"))
            .addRule(Join.path("/groups").to("/pages/security/group/group-list.jsf"))
            .addRule(Join.path("/students_by_groups").to("/pages/security/reports/student-by-group/student-by-group.jsf"))
            .addRule(Join.path("/subjects_by_years").to("/pages/security/reports/subjects-by-year/subjects-by-year.jsf"))
            .addRule(Join.path("/evaluations_by_groups").to("/pages/security/reports/evaluations-by-group/evaluations-by-group.jsf"))
            .addRule(Join.path("/student_ladder").to("/pages/security/reports/student-ladder/student-ladder.jsf"));
    }

    @Override
    public int priority() {
        return 0;
    }
}
