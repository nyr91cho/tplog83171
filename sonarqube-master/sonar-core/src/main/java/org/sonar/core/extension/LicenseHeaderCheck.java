package org.sonar.core.extension;

public class LicenseHeaderCheck {

    // On définit simplement les segments attendus (pour le test : "Licensed under ..." et "you may not use ...")
    private static final String LINE_1 = "Licensed under the XXX License, Version 2.0 (the \"License\");";
    private static final String LINE_2 = "you may not use this file except in compliance with the License.";

    /**
     * Vérifie la présence d'un en-tête de licence complet dans le code source fourni.
     */
    public boolean hasValidLicenseHeader(String sourceCode) {
        if (sourceCode == null) {
            return false;
        }
        // Ici on fait une vérification très simple :
        // on considère qu'un en-tête est "valide" si ces deux lignes apparaissent quelque part.
        return sourceCode.contains(LINE_1) && sourceCode.contains(LINE_2);
    }
}
