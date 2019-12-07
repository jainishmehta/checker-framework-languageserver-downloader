package org.checkerframework.languageserver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import net.lingala.zip4j.ZipFile;
import org.apache.commons.io.FilenameUtils;

public class CheckerFrameworkDownloader extends BaseDownloader {
    public CheckerFrameworkDownloader(File folder) {
        this(folder, "typetools", "checker-framework");
    }

    public CheckerFrameworkDownloader(File folder, String org, String repo) {
        super(org, repo, folder);
    }

    private File getUnzipped() throws IOException {
        File dest = getDestination();
        String cfzip = dest.getAbsolutePath();
        return Paths.get(FilenameUtils.getFullPath(cfzip), FilenameUtils.getBaseName(cfzip))
                .toFile();
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
