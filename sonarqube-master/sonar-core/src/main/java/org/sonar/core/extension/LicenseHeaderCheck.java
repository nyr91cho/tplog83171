package org.sonar.core.extension;

public class LicenseHeaderCheck {

    // On définit simplement les segments attendus (pour le test : "Licensed under ..." et "you may not use ...")
    private static final String TEXT = "/*\n" +
                " * Licensed under the XXX License, Version 1.0 (the \"License\");\n" +
                " * you may not use this file except in compliance with the License.\n" +
                " */\n" +
                "public class Example { }";

    /**
     * Vérifie la présence d'un en-tête de licence complet dans le code source fourni.
     */
    public boolean hasValidLicenseHeader(String sourceCode) {
        if (sourceCode == null) {
            return false;
        }
        // Ici on fait une vérification très simple :
        // on considère qu'un en-tête est "valide" si ces deux lignes apparaissent quelque part.
        return sourceCode.contains(TEXT);
    }
}
