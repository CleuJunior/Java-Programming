class RnaTranscription {
    String transcribe(String dnaStrand) {
        if (dnaStrand.isEmpty() || dnaStrand.isBlank()){
            return dnaStrand;
        }

        StringBuilder sb = new StringBuilder();

        for (char c : dnaStrand.toCharArray()) {
            sb.append(this.baseChange(c));
        }

        return sb.toString();
    }

    private char baseChange(char c) {
        return switch (c) {
            case 'A' -> 'U';
            case 'C' -> 'G';
            case 'G' -> 'C';
            case 'T' -> 'A';
            default -> c;
        };
    }
}

