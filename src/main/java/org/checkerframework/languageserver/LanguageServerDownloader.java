package org.checkerframework.languageserver;

import java.io.File;

public class LanguageServerDownloader extends BaseDownloader {
    public LanguageServerDownloader(File folder) {
        super("eisopux", "checker-framework-languageserver", folder);
    }
}
