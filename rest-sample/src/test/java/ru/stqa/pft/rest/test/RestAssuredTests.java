package ru.stqa.pft.rest.test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.rest.model.Issue;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTests extends TestBase {

    @BeforeClass
    public void init() {
        RestAssured.authentication = RestAssured.basic("278bac5e81d71a7490f9adcf001a7032", "");
    }

    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = app.helper().getAssuredIssues();
        Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
        int issueId = app.helper().createAssuredIssue(newIssue);
        Set<Issue> newIssues = app.helper().getAssuredIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(oldIssues,newIssues);

    }



}
