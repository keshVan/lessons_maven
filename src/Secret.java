import java.util.Random;

public class Secret {
    private String secretText;
    private String keeper;
    private Secret previousKeeper, nextKeeper;


    public Secret(String secretText, String keeper) {
        this.secretText = secretText;
        System.out.println(secretText);
        this.keeper = keeper;
    }

    public Secret(Secret secret, String keeper){
        if (secret.nextKeeper != null)
            throw new IllegalArgumentException("secret can only be told to 1 person");

        Random r = new Random();
        StringBuilder builder = new StringBuilder();

        builder.append(secret.secretText);
        for(int i = 0; i < secret.secretText.length() * 0.1; i++) {
            int pos = r.nextInt(secret.secretText.length() + 1);
            char ch = (char)(r.nextInt(93) + 34);
            builder.insert(pos, ch);
        }

        this.secretText = builder.toString();
        this.previousKeeper = secret;
        this.keeper = keeper;

        secret.nextKeeper = this;
        System.out.println(secret.keeper + " сказал, что " + secret.secretText);
    }

    public String getKeeper() {
        return keeper;
    }

    public Secret getPreviousKeeper() {
        return previousKeeper;
    }

    public Secret getNextKeeper() {
        return nextKeeper;
    }

    public int whichInQueue() {
        int res = 1;
        Secret currKeeper = this;

        while(currKeeper.previousKeeper != null) {
            res++;
            currKeeper = currKeeper.previousKeeper;
        }
        return res;
    }

    public int nextKeepers() {
        int res = 0;
        Secret currKeeper = this;

        while(currKeeper.nextKeeper != null) {
            res++;
            currKeeper = currKeeper.nextKeeper;
        }
        return res;
    }

    public String getNthKeeper(int n) {
        if (n == 0) {
            return keeper;
        }
        else if (n > 0) {
            checkNext(this);
            return nextKeeper.getNthKeeper(n - 1);
        }
        else {
            checkPrevious(this);
            return previousKeeper.getNthKeeper(n + 1);
        }
    }

    public int diffWithNth(int n) {
         Secret nthKeeper = this;

         if (n > 0) {
             while (n > 0) {
                 checkNext(nthKeeper);
                 nthKeeper = nthKeeper.nextKeeper;
                 n--;
             }
         }
         else if (n < 0) {
             while (n < 0) {
                 checkPrevious(nthKeeper);
                 nthKeeper = nthKeeper.previousKeeper;
                 n++;
             }
         }

         return secretText.length() - nthKeeper.secretText.length();
    }

    public String toString() {
        return keeper + ": это секрет!";
    }

    private void checkPrevious(Secret secret) {
        if (secret.previousKeeper == null)
            throw new IllegalArgumentException("this keeper doesn't exist");
    }

    private void checkNext(Secret secret) {
        if (secret.nextKeeper == null)
            throw new IllegalArgumentException("this keeper doesn't exist");
    }

}
