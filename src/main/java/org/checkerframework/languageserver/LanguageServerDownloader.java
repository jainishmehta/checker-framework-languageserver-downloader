package org.checkerframework.languageserver;

import java.io.File;

public class LanguageServerDownloader extends BaseDownloader {
    public LanguageServerDownloader(File folder, String org, String repo) {
        super(org, repo, folder);
    }
}
