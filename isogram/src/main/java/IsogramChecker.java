class IsogramChecker {

    private static int intToChar01 = 0;
    private static int intToChar02 = 0;

    private String standStringCase(String phrase){ return phrase.replaceAll(" ", "").toLowerCase(); }

    private boolean checkStringIsogram(String phrase) {
        phrase = standStringCase(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            for (int j = i+1; j < phrase.length(); j++) {

                intToChar01 = phrase.charAt(i);
                intToChar02 = phrase.charAt(j);
                if(intToChar01 == 45 && intToChar02 == 45) continue;
                if(intToChar01 == intToChar02) return false;
            }
        }

        return true;
    }
    boolean isIsogram(String phrase) { return (phrase.isEmpty()) ? true : checkStringIsogram(phrase); }
}