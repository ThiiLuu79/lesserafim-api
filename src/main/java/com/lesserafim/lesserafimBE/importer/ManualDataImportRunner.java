package com.lesserafim.lesserafimBE.importer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("manual-import")
public class ManualDataImportRunner implements CommandLineRunner {

    private final DataImporter dataImporter;
    private final ConfigurableApplicationContext context;

    public ManualDataImportRunner(DataImporter dataImporter, ConfigurableApplicationContext context) {
        this.dataImporter = dataImporter;
        this.context = context;
    }

    @Override
    public void run(String... args) {
        System.out.println("🔄 Starting manual data import...");
        dataImporter.importAllData();
        System.out.println("✅ Data import completed. Shutting down application...");
        SpringApplication.exit(context, () -> 0);
    }
}
