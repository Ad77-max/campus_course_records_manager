package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class BackupService {
    private final Path dataDir = AppConfig.getInstance().getDataDirectory();
    private final Path backupBaseDir = AppConfig.getInstance().getBackupDirectory();

    public void createBackup() throws IOException {
        if (!Files.exists(dataDir)) {
            System.out.println("-> Data directory not found. Nothing to backup.");
            return;
        }
        String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").format(LocalDateTime.now());
        Path targetBackupDir = backupBaseDir.resolve("backup-" + timestamp);
        Files.createDirectories(targetBackupDir);

        try (Stream<Path> files = Files.walk(dataDir)) {
            files.forEach(source -> {
                try {
                    Files.copy(source, targetBackupDir.resolve(dataDir.relativize(source)), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException("Backup failed for file: " + source, e);
                }
            });
        }
        System.out.println("-> Backup created successfully: " + targetBackupDir);
    }
}