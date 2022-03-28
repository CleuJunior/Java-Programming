/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

class Bob{

    private boolean CheckIfAllLettersUppercase(String checkString) { return checkString.equals(checkString.toUpperCase()); }

    private boolean CheckStdString (String stdString, String checkString) { return stdString.trim().endsWith(checkString); }

    private boolean CalmDown(String talkToBob) {
        return talkToBob.endsWith("?") &&
                !CheckStdString(talkToBob, " ?") &&
                CheckIfAllLettersUppercase(talkToBob) &&
                !CheckStdString(talkToBob, "4?");
    }

    private boolean SureBob(String talkToBob) {
        return talkToBob.trim().replaceAll("\\d+", "").endsWith("?") ||
                CheckStdString(talkToBob, " ?");
    }

    private boolean ChillOut(String talkToBob) {
        return CheckIfAllLettersUppercase(talkToBob) && !CheckStdString(talkToBob, "3");
    }

    private boolean BeThatWay(String talkToBob) { return talkToBob.trim().equals("");
    }
    public String hey(String talkToBob) {
        return  BeThatWay(talkToBob) ? "Fine. Be that way!" :
                CalmDown(talkToBob) ? "Calm down, I know what I'm doing!" :
                SureBob(talkToBob)  ? "Sure." :
                ChillOut(talkToBob) ? "Whoa, chill out!" :
                "Whatever.";

    }






}