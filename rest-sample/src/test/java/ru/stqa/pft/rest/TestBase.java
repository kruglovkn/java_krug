package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.SkipException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class TestBase {


   /* public boolean isIssueOpen(int issueId) throws IOException {
        Set<Issue> issues = getIssues();
        Issue issue = issues.stream().filter((i)-> i.equals())
        String closed = "closed";

        String resolution = (issueId).getStatus().getName();
        if (resolution!=closed){
            return true;
        } else {return false;}
    }


    private Set<Issue> getIssues() throws IOException {
        String json = getExecutor().execute(Request.Get("http://bugify.stqa.ru/api/issues.json"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
    }
    private Executor getExecutor() {
        return Executor.newInstance().auth("278bac5e81d71a7490f9adcf001a7032", "");
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
*/
}
