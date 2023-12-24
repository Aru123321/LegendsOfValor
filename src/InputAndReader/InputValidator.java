package InputAndReader;

import java.util.Scanner;

public class InputValidator {
    private Scanner scanner;

    public InputValidator() {
        scanner = new Scanner(System.in);
    }

    // This method checks for 'Y' or 'N' input
    public boolean checkYesNoInput() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            // Check for quit condition
            if (input.equals("Q")) {
                quitGame();
                return false;
            }
            if (input.equals("Y") || input.equals("N")) {
                return input.equals("Y");
            } else {
                System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No (or 'Q' to quit):");
            }
        }
    }

    public boolean checkContinueGame() {

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {

                return false;
            }
            return true;


    }

    public int marketChecker(String specific) {
        int number;
        while (true) {
            String input = scanner.nextLine();
            if (input.toUpperCase().equals("I")) {
                return -1;
            } else if (input.toUpperCase().equals(specific)) {
                return -2;
            } else {
                try {
                    number = Integer.parseInt(input);
                    if (number > 0) {
                        return number;
                    } else {
                        System.out.println("Please enter a positive integer.");
                    }
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }

            }
        }
    }

    public int monsterChecker(String specific) {
        int number;
        while (true) {
            String input = scanner.nextLine();
            if (input.toUpperCase().equals("M")) {
                return -1;
            } else {
                try {
                    number = Integer.parseInt(input);
                    if (number > 0) {
                        return number;
                    } else {
                        System.out.println("Please enter a positive integer.");
                    }
                } catch (Exception e) {
                    System.out.println("invalid input! please input a integer\n");
                    continue;
                }

            }
        }
    }

    // This method checks for 'W', 'A', 'S', 'D' inputs
    public char checkMovementInput() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Q")) {
                quitGame();
                return 'Q';
            }
            if (input.equals("W") || input.equals("A") || input.equals("S") || input.equals("D")) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter 'W', 'A', 'S', 'D' (or 'Q' to quit):");
            }
        }
    }

    public char checkBattleInput() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Q")) {
                quitGame();
                return 'Q';
            }
            if (input.equals("T") || input.equals("S") || input.equals("P") || input.equals("A") || input.equals("W") || input.equals("I") || input.equals("M")) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter 'T', 'S', 'P', 'A', 'W', 'I', 'M' (or 'Q' to quit):");
            }
        }
    }

        public char checkActionInput() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Q")) {
                quitGame();
                return 'Q';
            }
            if (input.equals("T") || input.equals("S") || input.equals("P") || input.equals("A") || input.equals("W") || input.equals("I") || input.equals("V")|| input.equals("O")|| input.equals("R")|| input.equals("M")) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter 'T', 'S', 'P', 'A', 'W', 'I', 'M', 'V', 'O', 'R' (or 'Q' to quit):");
            }
        }
    }

    public char checkHeroTypeInput() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Q")) {
                quitGame();
                return 'Q';
            }
            if (input.equals("W") || input.equals("P") || input.equals("S")) {
                return input.charAt(0);
            } else {
                System.out.println("Invalid input. Please enter 'W', 'P', 'S', (or 'Q' to quit):");
            }
        }
    }

    public boolean checkLeaveInput() {
        while (true) {
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Q")) {
                quitGame();
            }
            if (input.equals("LEAVE")) {
                return true;
            }
            return false;
        }
    }

    public int promptPositiveInteger() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine().trim());

                if (number > 0) {
                    return number; // Return the number if it's positive
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid integer. Please try again.");
            }
        }
    }
    public int promptInteger() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine().trim());

                if (number >= 0) {
                    return number;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid integer. Please try again.");
            }
        }
    }


    // This method is used to quit the game
    private void quitGame() {
        System.out.println("Quitting the game...");
        System.exit(0);
    }

    // Call this method to close the scanner when you're completely done with it
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }



}
