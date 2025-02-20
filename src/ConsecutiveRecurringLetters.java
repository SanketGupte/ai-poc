public class ConsecutiveRecurringLetters {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");
        String s = "Hello Na Puuublic";
        int i=0;
        int j=0;
        String newString = "";
        while(j<s.length()){
//            If both elements are same then skip
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
//            If both elements are not same then append new element
            else if (s.charAt(j) != s.charAt(i) || j==s.length()) {
                newString += s.charAt(i);

//                After appending, slide over the window
                i=j;
                j++;
            }
        }
        newString += s.charAt(j-1);
        System.out.println(newString);
    }
}