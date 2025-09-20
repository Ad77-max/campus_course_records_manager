package edu.ccrm.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class AppConfig {
    private static final AppConfig INSTANCE = new AppConfig();
    
    private final Path dataDirectory = Paths.get("ccrm_data");
    private final Path backupDirectory = Paths.get("ccrm_backups");

    private AppConfig() {}

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public Path getDataDirectory() { return dataDirectory; }
    public Path getBackupDirectory() { return backupDirectory; }
}