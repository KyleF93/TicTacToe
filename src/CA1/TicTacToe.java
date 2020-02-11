/*

TicTacToe Game
by Kyle Fox

Programming Fundamentals Continuous Assessment 1

**BUG** Lines 80 - 100 somewhere. Vertical Line wont Center in winning cells.

 */



package CA1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

//Sprint1: Create main class TicTacToe
public class TicTacToe extends Application
{
    //Sprint1: Creates and Initializes Cells. 2D array
    private Cell[][] cell = new Cell[3][3];

    //Sprint1: Creates gridPane for Cells
    private GridPane pane = new GridPane();

    //Sprint2: Creates a field for the status label, X will start.
    private Label status = new Label("X's Turn");

    //Sprint2: Creates a field for Whose Turn it is, X will start
    private char whoseTurn = 'X';

    //Sprint3: Variable for cells filled
    private int nFilled = 0;

    //GameOver Status
    public boolean gameOver = false;



    @Override
    public void start(Stage primaryStage)
    {
        //for loop adding 3 x 3 cells to the gridPane
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                pane.add(cell[i][j] = new Cell(), i, j);
            }
        }

        //Border pane assigns position of pane and status label on gridPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setTop(status);

        //Create a scene and set size/title for display window. also makes it visible
        Scene scene = new Scene(borderPane, 900,900);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //Sprint3: Check if all cells are full, its True if 9 or more are full. More can't happen.
    public boolean isBoardFull() {
        return nFilled >= 9;
    }

    //Sprint3: Check if game is won & Draw Lines Through winning cells.
    public boolean isGameWon(char token) {
        for (int i = 0; i < 3; i++){
            if (cell[i][0].getToken() == token &&
                    cell [i][1].getToken() == token &&
                    cell [i][2].getToken() == token){
                double w = cell[i][0].getWidth(), h = cell[i][0].getHeight();
                Line line1 = new Line(w/2, 0, w/2, h);
                line1.setStroke(Color.RED);
                line1.setFill(Color.RED);
                line1.setStrokeWidth(10);
                Line line2 = new Line(w/2, 0, w/2, h); //VERTICAL LINE WONT CENTER
                line2.setStroke(Color.RED);
                line2.setFill(Color.RED);
                line2.setStrokeWidth(10);
                Line line3 = new Line(w/2, 0, w/2, h);
                line3.setStroke(Color.RED);
                line3.setFill(Color.RED);
                line3.setStrokeWidth(10);
                pane.add(line1, i,0) ;
                pane.add(line2, i,1) ;
                pane.add(line3, i,2) ;
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (cell[0][j].getToken() == token &&
                    cell[1][j].getToken() == token &&
                    cell[2][j].getToken() == token) {
                double w = cell[0][j].getWidth(), h = cell[0][j].getHeight();
                Line line1 = new Line(0, h/2, w, h/2);
                line1.setStroke(Color.RED);
                line1.setFill(Color.RED);
                line1.setStrokeWidth(10);
                Line line2 = new Line(0, h/2, w, h/2);
                line2.setStroke(Color.RED);
                line2.setFill(Color.RED);
                line2.setStrokeWidth(10);
                Line line3 = new Line(0, h/2, w, h/2);
                line3.setStroke(Color.RED);
                line3.setFill(Color.RED);
                line3.setStrokeWidth(10);
                pane.add(line1, 0,j) ;
                pane.add(line2, 1,j) ;
                pane.add(line3, 2,j) ;
                return true;
            }
        }
        if (cell[0][0].getToken() == token &&
                cell[1][1].getToken() == token &&
                cell[2][2].getToken() == token){
            double w = cell[0][0].getWidth(), h = cell[0][0].getHeight();
            Line line1 = new Line(0, 0, w, h);
            line1.setStroke(Color.RED);
            line1.setFill(Color.RED);
            line1.setStrokeWidth(10);
            Line line2 = new Line(0, 0, w, h );
            line2.setStroke(Color.RED);
            line2.setFill(Color.RED);
            line2.setStrokeWidth(10);
            Line line3 = new Line(0, 0, w, h);
            line3.setStroke(Color.RED);
            line3.setFill(Color.RED);
            line3.setStrokeWidth(10);
            pane.add(line1,0,0) ;
            pane.add(line2, 1,1) ;
            pane.add(line3, 2,2) ;
            return true;}
        if (cell[0][2].getToken() == token &&
                cell[1][1].getToken() == token &&
                cell[2][0].getToken() == token){
            double w = cell[0][2].getWidth(), h = cell[0][2].getHeight();
            Line line1 = new Line(0, 500, w, h);
            line1.setStroke(Color.RED);
            line1.setFill(Color.RED);
            line1.setStrokeWidth(10);
            Line line2 = new Line(0, 500, w, h);
            line2.setStroke(Color.RED);
            line2.setFill(Color.RED);
            line2.setStrokeWidth(10);
            Line line3 = new Line(0, 500, w, h);
            line3.setStroke(Color.RED);
            line3.setFill(Color.RED);
            line3.setStrokeWidth(10);
            pane.add(line1,0,2) ;
            pane.add(line2, 1,1) ;
            pane.add(line3, 2,0) ;
            return true;}
        return false;
    }

    //Sprint 4: Inner Class Cell extending Pane
    //Border Color / cell size
    //Calls handleMouseClick method when a cell is clicked
    public class Cell extends Pane {
        public Cell() {
            setStyle("-fx-border-color: black");
            setPrefSize(300, 300);
            setOnMouseClicked(event -> handleMouseClick());
        }
        //Declare character field token
        private char token = ' ';

        // return value of token. Getter
        public char getToken() {
            return token;
        }

        //Draw 2 lines to create the X
        public void drawX() {
            double w = getWidth(), h = getHeight();
            Line line1 = new Line(10, 10, w - 10 , h - 10);
            Line line2 = new Line(10, h - 10, w -10, 10);
            getChildren().addAll(line1, line2);
        }

        //Draw a circle for O
        public void drawO() {
            double w = getWidth(), h = getHeight();
            Ellipse ellipse = new Ellipse(w/2, h/2, w/2 - 10, h/2 - 10);
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.WHITE);
            getChildren().add(ellipse);
        }

        //Setter for Token and calls Draw methods. Increments number of cells filled.
        public void setToken(char c) {
            token = c;
            if (token == 'X')
                drawX();
            else
                drawO();
            nFilled++;
        }

        //Sprint5:Alternate Players Turns using conditional operator
        //Same as if (whoseTurn == 'X') { whoseTurn = 'O'} else { whoseTurn = X; }
        public void changeTurn() {
            whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
        }

        //Sprint5: Handles mouseClicks on cells
        private void handleMouseClick() {
            String s = "";
            if (token == ' ' && whoseTurn != ' ') {
                setToken(whoseTurn);
                if (isGameWon(whoseTurn)) {
                    gameOver = true;
                    s = whoseTurn + " won! Game over";
                    whoseTurn = ' ';
                } else if (isBoardFull()) {
                    gameOver = true;
                    s = "Draw! Game Over";
                } else {
                    changeTurn();
                    s = whoseTurn + " 's turn";
                }
                status.setText(s);
            }
        }
    }

    //Main method required by IDE
    public static void main(String[] args)
    {
        launch(args);
    }
}
