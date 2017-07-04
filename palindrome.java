public class palindrome{

  public static void main(String[] args) {

    String word = args[0];
    for(int i = 0; i < word.length()/2;i++){
      if(!(word.charAt(i) == word.charAt(word.length()-1-i))){
        System.out.println(word + " is not a palindrome");
        System.exit(0);
      }
      }
    System.out.println(word + " is a plaindrome");
  }
}
