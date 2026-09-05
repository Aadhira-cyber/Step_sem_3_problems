import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] preDefinedPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random();
        
        int rounds = 5;
        String[][] history = new String[rounds][4];
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < rounds; i++) {
            String playerMove = preDefinedPlayerMoves[i];
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            history[i][0] = String.valueOf(i + 1);
            history[i][1] = playerMove;
            history[i][2] = computerMove;
            history[i][3] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.printf("%-7s | %-11s | %-13s | %-13s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-7s | %-11s | %-13s | %-13s\n", history[i][0], history[i][1], history[i][2], history[i][3]);
        }
        
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("\nFinal Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}
