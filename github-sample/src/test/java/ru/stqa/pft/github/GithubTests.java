package ru.stqa.pft.github;

import com.jcabi.github.*;
import jersey.repackaged.com.google.common.collect.ImmutableBiMap;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("cdf4cd87059da18c074fe18969e2833f68d0484e");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("kruglovkn", "java_krug")).commits();
        for (RepoCommit commit: commits.iterate(new ImmutableBiMap.Builder<String,String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());

        }
    }
}
