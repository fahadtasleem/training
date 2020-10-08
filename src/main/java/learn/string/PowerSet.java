package learn.string;

public class PowerSet {

    static void powerSet(String s, int i,String curr){
        int n = s.length();
        if(i == n){
            System.out.println(curr);
            return;
        }
        powerSet(s,i+1, curr+ s.charAt(i));
        powerSet(s,i+1, curr);
    }

    static void printPowerSet(char []set,
                              int set_size)
    {

        /*set_size of power set of a set
        with set_size n is (2**n -1)*/
        long pow_set_size =
                (long)Math.pow(2, set_size);
        int counter, j;

        /*Run from counter 000..0 to
        111..1*/
        for(counter = 0; counter <
                pow_set_size; counter++)
        {
            for(j = 0; j < set_size; j++)
            {
                /* Check if jth bit in the
                counter is set If set then
                print jth element from set */
                if((counter & (1 << j)) > 0)
                    System.out.print(set[j]);
            }

            System.out.println();
        }
    }


    public static void main(String[] args) {
        String s1 = "abc";
        powerSet(s1, 0 , "");
        System.out.println("-----");
        printPowerSet(s1.toCharArray(),s1.length());
    }
}
