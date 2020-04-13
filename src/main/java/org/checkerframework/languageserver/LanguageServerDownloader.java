package org.checkerframework.languageserver;

import java.io.File;

public class LanguageServerDownloader extends BaseDownloader {
    public LanguageServerDownloader(String org, String repo, File folder) {
        super(org, repo, folder);
    }
}
