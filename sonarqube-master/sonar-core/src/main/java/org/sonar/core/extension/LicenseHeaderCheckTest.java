package org.sonar.core.extension;

import org.junit.Test;
import static org.junit.Assert.*;

public class LicenseHeaderCheckTest {

    // Instance de la classe qui effectue la vérification de l'en-tête de licence.
    private LicenseHeaderCheck check = new LicenseHeaderCheck();

    /**
     * Teste qu'un fichier contenant un en-tête de licence complet et conforme passe la vérification.
     */
    @Test
    public void testFileWithValidLicenseHeader() {
        String sourceCode = 
                "/*\n" +
                " * Licensed under the XXX License, Version 1.0 (the \"License\");\n" +
                " * you may not use this file except in compliance with the License.\n" +
                " */\n" +
                "public class Example { }";
        boolean result = check.hasValidLicenseHeader(sourceCode);
        assertTrue("Un fichier avec un en-tête de licence valide doit être accepté.", result);
    }

    /**
     * Teste qu'un fichier sans en-tête de licence est correctement signalé comme non conforme.
     */
    @Test
    public void testFileWithoutLicenseHeader() {
        String sourceCode = "public class Example { }";
        boolean result = check.hasValidLicenseHeader(sourceCode);
        assertFalse("Un fichier sans en-tête de licence doit être rejeté.", result);
    }

    /**
     * Teste qu'un fichier avec un en-tête incomplet ou incorrect est considéré comme non conforme.
     */
    @Test
    public void testFileWithIncompleteLicenseHeader() {
        String sourceCode = 
                "/*\n" +
                " * Licensed under the XXX License, Version 1.0\n" +
                " */\n" +
                "public class Example { }";
        boolean result = check.hasValidLicenseHeader(sourceCode);
        // Ici, on attend que l'en-tête incomplet ne soit pas validé.
        assertFalse("Un fichier avec un en-tête de licence incomplet doit être rejeté.", result);
    }
}
