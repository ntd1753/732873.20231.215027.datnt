package lab1;

import java.util.Scanner;

public class bai6_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        String[] monthAbbreviations = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.",
                "Sep.", "Oct.", "Nov.", "Dec."};

        int daysInMonth = 0;
        int year = 0;

        while (true) {
            System.out.print("Enter a month (full name, abbreviation, 3 letters, or number): ");
            String monthInput = input.nextLine().trim();
            int month = -1;

            // Validate and parse month input
            for (int i = 0; i < 12; i++) {
                if (monthInput.equalsIgnoreCase(monthNames[i]) ||
                        monthInput.equalsIgnoreCase(monthAbbreviations[i]) ||
                        monthInput.equalsIgnoreCase(monthNames[i].substring(0, 3)) ||
                        monthInput.equals(Integer.toString(i + 1))) {
                    month = i + 1;
                    break;
                }
            }

            if (month == -1) {
                System.out.println("Invalid month input. Please enter a valid month.");
                continue;
            }

            // Validate and parse year input
            while (true) {
                System.out.print("Enter a year: ");
                String yearInput = input.nextLine().trim();

                try {
                    year = Integer.parseInt(yearInput);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid year input. Please enter a valid year.");
                    continue;
                }

                if (year < 0) {
                    System.out.println("Year must be a non-negative number.");
                } else {
                    break;
                }
            }

            // Calculate the number of days in the entered month
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    daysInMonth = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    daysInMonth = 30;
                    break;
                case 2:
                    if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                        daysInMonth = 29; // Leap year
                    } else {
                        daysInMonth = 28; // Common year
                    }
                    break;
            }

            System.out.println(monthNames[month - 1] + " " + year + " has " + daysInMonth + " days.");
            break;
        }
    }
}

