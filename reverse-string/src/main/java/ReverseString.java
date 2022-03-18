class ReverseString {

    String reverse(String inputString) {
       if(inputString.isEmpty()) return inputString;
       String reversedString = "";

       for (int i = inputString.length()-1; i >= 0; i--) { reversedString += inputString.charAt(i); }
       return reversedString;
    }
  
}
