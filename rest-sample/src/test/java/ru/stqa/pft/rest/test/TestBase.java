package ru.stqa.pft.rest.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.rest.appmanager.ApplicationManager;
import ru.stqa.pft.rest.model.Issue;

import java.io.IOException;
import java.util.Set;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

   public boolean isIssueOpen(int issueId) throws IOException {
        Set<Issue> issues = app.helper().getIssues();
        for (Issue issue: issues) {
            if (issue.getId() == issueId) {
                return true;
            }
        } return false;
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
