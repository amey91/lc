package javasolutions.divideandconquer;

import java.util.LinkedList;
import java.util.List;

public class IntegerToEnglishWords {
    private static final int BILLION = 1_000_000_000;
    private static final int MILLION = 1_000_000;
    private static final int THOUSAND = 1_000;
    private static final int ONE = 1;


    // we divide the num into 4 chings of 3 digits each. WE process the chunks the same way, the only difference being the denomination we add at the 
    // end of each chunk e.g. million billion etc.
    public String numberToWords(int num) {

        // IMPORTANT: use a list and then join instead of passing string builder since spaces get tricky to handle!
        List<String> result = new LinkedList<>();

        if (num == 0) {
            return "Zero";
        }

        // 1,111,111,111
        group3(num, result, BILLION);
        num = num % BILLION;
        group3(num, result, MILLION);
        num = num % MILLION;
        group3(num, result, THOUSAND);
        num = num % THOUSAND;
        group3(num, result, ONE);

        return String.join(" ", result);
    }

    private void group3(int num, List<String> result, int unit) {
        int quotient = num / unit;

        if (quotient == 0) { // this group has no string value in result
            return;
        }

        three(quotient, unit, result);
    }


    // THIS IS THE BASIS OF OUR DIVIDE AND CONQUER
    private void three(int num, int unit, List<String> result) {

        // whether we contributed to the result for this method call
        boolean added = false;

        // extract hundreds digit first
        if (num / 100 != 0) {
            result.add(one(num / 100));
            result.add("Hundred");
            added = true;
        }

        // extract tens and units
        num = num % 100;
        if (num != 0) {
            added = true;
            if (num < 10) {
                result.add(one(num));
            } else if (num < 20) {
                result.add(twoLessThan20(num));
            } else {

                // else two digits need to be processed separately
                result.add(ten(num / 10));

                if (num % 10 != 0) {
                    result.add(one(num % 10));
                }
            }
        }

        // group3 is also responsible for adding appropriate dnomination string if it contributed to result
        if (added) {
            String d = unit == BILLION ? "Billion" : unit == MILLION ? "Million" : unit == THOUSAND ? "Thousand" : null;
            if (d != null) {
                result.add(d);
            }
        }
    }


    private String one(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }

    private String twoLessThan20(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private String ten(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }

}