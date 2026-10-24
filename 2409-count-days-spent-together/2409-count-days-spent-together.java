class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // no or days  in every month
        int days[] ={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // common days dono k
          int start = Math.max(getDay(arriveAlice, days),
                             getDay(arriveBob, days));

        int end = Math.min(getDay(leaveAlice, days),
                           getDay(leaveBob, days));

        return Math.max(0, end - start + 1);
    }//  string ko interger  m convert krna 
    private int getDay(String date, int[] days) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
        
    }
}