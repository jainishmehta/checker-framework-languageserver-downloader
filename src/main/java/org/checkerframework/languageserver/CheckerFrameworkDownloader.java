package org.checkerframework.languageserver;

import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class CheckerFrameworkDownloader extends BaseDownloader {
    public CheckerFrameworkDownloader(File folder) {
        this("typetools", "checker-framework", folder);
    }

    public CheckerFrameworkDownloader(String author, String repo, File folder) {
        super(author, repo, folder);
    }

    private File getUnzipped() throws IOException {
        File dest = getDestination();
        String cfzip = dest.getAbsolutePath();
        return Paths.get(FilenameUtils.getFullPath(cfzip), FilenameUtils.getBaseName(cfzip)).toFile();
    }

    @Override
    public File download() throws IOException {
        File unzipped = getUnzipped();
        if (!unzipped.exists()) {
            File dest = doDownload();
            String cfzip = dest.getAbsolutePath();
            new ZipFile(cfzip).extractAll(folder.getAbsolutePath());
        }
        return unzipped;
    }
}
