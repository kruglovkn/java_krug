package ru.stqa.pft.mantis.tests;

import biz.futureware.mantis.rpc.soap.client.IssueData;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase{

    @Test
    public void testGetProgects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
        for (Project project: projects) {
            System.out.println(project.getName());
        }
    }


    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soap().getProjects();
        Issue issue = new Issue().withSummery("Test Issue")
                .withDescription("Test Issue Description").withProject(projects.iterator().next());
        Issue created = app.soap().addIssue(issue);
        assertEquals(created.getSummery(), issue.getSummery());

    }

    @Test
    public void testGetIssues() throws RemoteException, ServiceException, MalformedURLException {
        int id = 0000001;
        skipIfNotFixed(id);
        IssueData issue = app.soap().getIssue(id);
        System.out.println("catch");
    }
}
