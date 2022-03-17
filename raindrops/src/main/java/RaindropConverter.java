class RaindropConverter {

    String convert(int number) {
        
        String returnValueString = "";

        if(number % 3 == 0) returnValueString += "Pling";
        if(number % 5 == 0) returnValueString += "Plang";
        if(number % 7 == 0) returnValueString += "Plong";

        return (returnValueString == "")? String.valueOf(number): returnValueString;
    }

}
