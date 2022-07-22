package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if(getColor() == Color.WHITE){
            p.setValues(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // special move en passant white
            if(position.getRow() == 3){
                Position opponentPawnLeft = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(opponentPawnLeft) && isThereOpponentPiece(opponentPawnLeft) && getBoard().piece(opponentPawnLeft) == chessMatch.getEnPassantVulnerable()){
                    mat[opponentPawnLeft.getRow() - 1][opponentPawnLeft.getColumn()] = true;
                }
                Position opponentPawnRight = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(opponentPawnRight) && isThereOpponentPiece(opponentPawnRight) && getBoard().piece(opponentPawnRight) == chessMatch.getEnPassantVulnerable()){
                    mat[opponentPawnRight.getRow() - 1][opponentPawnRight.getColumn()] = true;
                }
            }
        }
        else{
            p.setValues(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            // special move en passant black
            if(position.getRow() == 4){
                Position opponentPawnLeft = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(opponentPawnLeft) && isThereOpponentPiece(opponentPawnLeft) && getBoard().piece(opponentPawnLeft) == chessMatch.getEnPassantVulnerable()){
                    mat[opponentPawnLeft.getRow() + 1][opponentPawnLeft.getColumn()] = true;
                }
                Position opponentPawnRight = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(opponentPawnRight) && isThereOpponentPiece(opponentPawnRight) && getBoard().piece(opponentPawnRight) == chessMatch.getEnPassantVulnerable()){
                    mat[opponentPawnRight.getRow() + 1][opponentPawnRight.getColumn()] = true;
                }
            }

        }

        return mat;
    }

    @Override
    public String toString(){
        return "P";
    }
    
}
