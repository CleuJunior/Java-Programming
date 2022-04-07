import java.util.Map;

public class NucleotideCounter {

    private final String NUCLEOTIDE_COUNTER;

    public NucleotideCounter(String nucleotideCounter) {
        this.NUCLEOTIDE_COUNTER = nucleotideCounter;

        for(int i = 0; i < NUCLEOTIDE_COUNTER.length(); i++) {
            switch (NUCLEOTIDE_COUNTER.charAt(i)) {
                case 'A', 'C', 'G', 'T' : continue;
                default : throw  new IllegalArgumentException("Not a Nucleotide");
            }
        }

    }



    public Map<Character, Integer> nucleotideCounts() {

        String[] splitDNA = NUCLEOTIDE_COUNTER.split("");

        int nucleotideA = 0;
        int nucleotideC = 0;
        int nucleotideG = 0;
        int nucleotideT = 0;

        for (String countDNA : splitDNA) {
            if(countDNA.equals("A")) nucleotideA++;
            if(countDNA.equals("C")) nucleotideC++;
            if(countDNA.equals("G")) nucleotideG++;
            if(countDNA.equals("T")) nucleotideT++;
        }


       return Map.of('A', nucleotideA, 'C', nucleotideC, 'G', nucleotideG, 'T', nucleotideT);

    }
}