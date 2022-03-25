import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    private Map<String, String> proteinMap = new HashMap<>();
    private final String UAA = "UAA";
    private final String UAG = "UAG";
    private final String UGA = "UGA";
    private List<String> listProtein = new ArrayList<>();

    ProteinTranslator() {
        proteinMap.put("AUG", "Methionine");
        proteinMap.put("UUU", "Phenylalanine");
        proteinMap.put("UUC", "Phenylalanine");
        proteinMap.put("UUA", "Leucine");
        proteinMap.put("UUG", "Leucine");
        proteinMap.put("UCU", "Serine");
        proteinMap.put("UCC", "Serine");
        proteinMap.put("UCA", "Serine");
        proteinMap.put("UCG", "Serine");
        proteinMap.put("UAU", "Tyrosine");
        proteinMap.put("UAC", "Tyrosine");
        proteinMap.put("UGU", "Cysteine");
        proteinMap.put("UGC", "Cysteine");
        proteinMap.put("UGG", "Tryptophan");
    }

    private boolean CheckStopRNA(String rnaStand, int index) {

        return  rnaStand.startsWith(UAA, index) ||
                rnaStand.startsWith(UAG, index) ||
                rnaStand.startsWith(UGA, index);
    }

    private void addListProtein(String rnaSequence){
        for (int index = 0; index < rnaSequence.length(); index+=3) {
            if(CheckStopRNA(rnaSequence, index)) break;
            listProtein.add(proteinMap.get(rnaSequence.substring(index, index+3)));
        }
    }

    List<String> translate(String rnaSequence) {
        if(rnaSequence.length() == 3 && CheckStopRNA(rnaSequence, 0)) return List.of();
        if(rnaSequence.length() == 3) return List.of(proteinMap.get(rnaSequence));

        addListProtein(rnaSequence);
        return listProtein;
    }
}
