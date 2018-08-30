public class OX {
    String table[][] = {
            {" ", "0", "1", "2"},
            {"0", "-", "-", "-"},
            {"1", "-", "-", "-"},
            {"2", "-", "-", "-"},
    };
    private String currentPlayer;

    public OX (){
        currentPlayer = "X";
    }
    public String getTableString() {
        String result = "";
        for(int i = 0;  i < table.length; i++){
            for(int j = 0; j<4; j++){
                result += table[i][j];
            }
            result += "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        if(currentPlayer.equals("X"))
            currentPlayer = "O";
        else
            currentPlayer = "X";
    }

    public boolean push(int col, int row) {
        try{
            if(!table[row+1][col+1].equals("-")){
                return false;
            }
            table[row+1][col+1] = currentPlayer;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

        return true;
    }

    public String get(int col, int row) {
        if(col > 2 || col < 0 || row > 2 || row < 0) {
            return null;
        }
        return table[row+1][col+1];
    }
}
