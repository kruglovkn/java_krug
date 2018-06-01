package ru.stqa.pft.rest.test;


import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Issue;

import java.io.IOException;

import java.util.Set;
import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {

    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = app.helper().getIssues();
        Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
        int issueId = app.helper().createIssue(newIssue);
        Set<Issue> newIssues = app.helper().getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(oldIssues,newIssues);
    }
}
