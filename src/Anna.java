public class Anna {

    private int rowWins = 0;
    private int scoreCounter = 0;

    private String move;

    private int energyLevel = 100;
    //Getter and Setters

    public int getRowWins() {
        return rowWins;
    }

    public void setRowWins(int rows) {
        this.rowWins = rows;
    }
    public int displayEnergyInfo() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }
    public int getScoreCounter() {
        return scoreCounter;
    }

    public void setScoreCounter(int scoreCounter) {
        this.scoreCounter = scoreCounter;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public void caringMagic(Castle castle) {
        System.out.println("Anna use caringMagic! Castle energy: +30");
        castle.setEnergyLevel(castle.displayCastleInfo() + 30);
    }
}
