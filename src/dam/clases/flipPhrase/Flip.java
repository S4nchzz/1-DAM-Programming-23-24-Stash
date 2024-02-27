package dam.clases.flipPhrase;

public class Flip {
    private String phrase;
    private String [] arrPhrase;
    private String flippedPhrase;

    private int wordCount;


    public Flip (String phrase) {
        this.phrase = phrase;
        this.wordCount = 1;
        this.flippedPhrase = flipPhrase();
    }

    private void wordCount () {
        for (int i = 1; i < phrase.length(); i++) {
            if (phrase.charAt(i) != ' ' && phrase.charAt(i - 1) == ' ') {
                wordCount++;
            }
        }
    }

    private String flipPhrase () {
        StringBuilder sb = new StringBuilder();

        wordCount();
        this.arrPhrase = new String[this.wordCount];
        int arrPointer = arrPhrase.length - 1;

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) != ' ') {
                sb.append(phrase.charAt(i));
            } else {
                arrPhrase[arrPointer] = sb.toString();
                arrPointer--;
                sb.delete(0, sb.length());
            }

            if (i + 1 == phrase.length()) {
                arrPhrase[arrPointer] = sb.toString();
                arrPointer--;
                sb.delete(0, sb.length());
            }
        }

        StringBuilder sb2 = new StringBuilder() ;
        for (int i = 0; i < arrPhrase.length; i++) {
            sb2.append(arrPhrase[i]);
            sb2.append(" ");
        }
        return sb2.toString();
    }

    public String getFlippedPhrase() {
        return this.flippedPhrase;
    }
}
