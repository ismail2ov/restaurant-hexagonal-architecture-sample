package com.github.ismail2ov.restaurant;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

public class LayerDependencyRulesTest {

    public static final String BASE_PACKAGE = "com.github.ismail2ov.restaurant";

    public static final String APPLICATION_PACKAGE = BASE_PACKAGE + ".application..";

    public static final String DOMAIN_PACKAGE = BASE_PACKAGE + ".domain..";

    private final JavaClasses importedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);

    private static final String JAVA_STANDARD_LIBRARY = "java..";

    private static final String LOMBOK = "lombok..";

    @Test
    void applicationLayerShouldDependOnDomainLayerAndJavaStandardLibrary() {

        ArchRule rule = noClasses().that()
            .resideInAPackage(APPLICATION_PACKAGE)
            .should()
            .dependOnClassesThat()
            .resideOutsideOfPackages(APPLICATION_PACKAGE, DOMAIN_PACKAGE, JAVA_STANDARD_LIBRARY, LOMBOK);

        rule.check(importedClasses);
    }

    @Test
    void domainLayerShouldDependOnlyOnJavaStandardLibrary() {

        ArchRule rule = noClasses().that()
            .resideInAPackage(DOMAIN_PACKAGE)
            .should()
            .dependOnClassesThat()
            .resideOutsideOfPackages(DOMAIN_PACKAGE, JAVA_STANDARD_LIBRARY, LOMBOK);

        rule.check(importedClasses);
    }

}
