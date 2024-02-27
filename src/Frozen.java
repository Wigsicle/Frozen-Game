//Name: Richard Peters Aksarachai
//Adm No: 2303360
import java.util.Scanner;  // Import the Scanner class

public class Frozen {
    private Anna anna;
    private Elsa elsa;

    private Castle castle;

    public Frozen() {
        this.anna = new Anna();
        this.elsa = new Elsa();
        this.castle = new Castle();
    }

    public void setAnnaRows(int rows) {
        anna.setRowWins(rows);
    }

    public int getAnnaRows() {
        return anna.getRowWins();
    }

    public void setAnnaEnergy(int energy) {
        anna.setEnergyLevel(energy);
    }

    public int getAnnaEnergy() {
        return anna.displayEnergyInfo();
    }

    public void setAnnaMove(String move) {
        anna.setMove(move);
    }

    public String getAnnaMove() {
        return anna.getMove();
    }

    public void setAnnaScore(int score) {
        anna.setScoreCounter(score);
    }

    public int getAnnaScore() {
        return anna.getScoreCounter();
    }

    public void setElsaRows(int rows) {
        elsa.setRowWins(rows);
    }

    public int getElsaRows() {
        return elsa.getRowWins();
    }

    public void setElsaEnergy(int energy) {
        elsa.setEnergyLevel(energy);
    }

    public int getElsaEnergy() {
        return elsa.displayElsaInfo();
    }

    public void setElsaMove(String move) {
        elsa.setMove(move);
    }

    public String getElsaMove() {
        return elsa.getMove();
    }

    public void setElsaScore(int score) {
        elsa.setScoreCounter(score);
    }

    public int getElsaScore() {
        return elsa.getScoreCounter();
    }

    public void setCastleEnergy(int energy) {
        castle.setEnergyLevel(energy);
    }

    public int getCastleEnergy() {
        return castle.displayCastleInfo();
    }

    private boolean checkEnergy() {
        if (getElsaEnergy() <= 0 || getAnnaEnergy() <= 0) {
            System.out.println("Game Over!");
            return true;
        } else if (getCastleEnergy() >= 100) {
            System.out.println("Elsa wins! Castle is fully built");
            System.out.println("Game Over!");
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidMove(String move) {
        return move.matches("[rps]");
    }

    private void determineWinner() {
        String elsaMove = getElsaMove();
        String annaMove = getAnnaMove();

        if (elsaMove.equals(annaMove)) {
        } else if ((elsaMove.equals("r") && annaMove.equals("s")) ||
                (elsaMove.equals("p") && annaMove.equals("r")) ||
                (elsaMove.equals("s") && annaMove.equals("p"))) {
            setAnnaScore(getAnnaScore() + 1);
            setElsaEnergy(getElsaEnergy() - 5);
            setAnnaRows(getAnnaRows() + 1);
            printAnna();
            checkRows();
        } else {
            setElsaScore(getElsaScore() + 1);
            setAnnaEnergy(getAnnaEnergy() - 6);
            setElsaRows(getElsaRows() + 1);
            printElsa();
            checkRows();
        }

    }

    private void checkRows() {
        if (getAnnaRows() == 2) {
            setAnnaEnergy(getAnnaEnergy() + 10);
            System.out.println("Anna's energy recharged +10");
        } else if (getElsaRows() == 2) {
            setElsaEnergy(getElsaEnergy() + 8);
            System.out.println("Elsa's energy recharged +8");
        } else if (getAnnaRows() == 3) {
            anna.caringMagic(castle);
            setAnnaRows(0);
        } else if (getElsaRows() == 3) {
            elsa.icePower(castle);
            setElsaRows(0);
        }
    }

    private void printEnergy() {
        System.out.println("Elsa's Energy: " + getElsaEnergy());
        System.out.println("Anna's Energy: " + getAnnaEnergy());
        System.out.println("Castle's Energy: " + getCastleEnergy());
    }

    private void printAnna() {
        System.out.println("Anna wins! Elsa's energy decreased by 5 units.");
    }

    private void printElsa() {
        System.out.println("Elsa wins! Anna's energy decreased by 6 units.");
    }

    private void characterSelection() {
        System.out.println("Choose a character, 1 = Elsa, 2 = Anna, 3 = Olaf, 4 = Kristoff");
        Scanner scanObj = new Scanner(System.in);
        String userInput = scanObj.nextLine();
        System.out.println(userInput);
    }

    public static void main(String[] args) {

        Frozen frozen = new Frozen();

        if (args.length % 2 != 0 || args.length < 2) {
            System.out.println("Not enough inputs!");
            return;
        }
        while (!frozen.checkEnergy()) {
            int round = 1;
            for(int i = 0; i < args.length; i += 2) {
                String elsaMove = args[i];
                String annaMove = args[i + 1];

                if(frozen.isValidMove(elsaMove) && (frozen.isValidMove(annaMove))) {
                    frozen.setAnnaMove(elsaMove);
                    frozen.setElsaMove(annaMove);
                    frozen.determineWinner();
                    System.out.println("Round: " + round + " Elsa chose " + frozen.getElsaMove() +", Anna chose " + frozen.getAnnaMove());
                    frozen.printEnergy();
                } else {
                    System.out.println("Invalid moves entered!");
                }
                round++;
            }
        }

    }
}
