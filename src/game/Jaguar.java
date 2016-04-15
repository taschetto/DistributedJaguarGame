package game;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
 */
public class Jaguar extends Piece {
  
  public Jaguar(Board board) {
    super(board);
  }

  @Override
  public boolean canMove(Direction direction)
  {
    if (direction == null) return false;
    
    // Pega as coordenadas atuais do Jaguar.
    int x = this.position.getX(),
        y = this.position.getY();
    
    // Valida se a direção é válida.
    MoveValidator validator = MoveValidator.getInstance();
    if (!validator.validate(x, y, direction))
      return false;
    
    // Se a direção é válida, valida se a nova posição está disponível.
    Position nextPosition = this.board.getPosition(direction.getNextPosition(x, y));
    return nextPosition.getPiece() == null;
  }

  @Override
  public Key move(Direction direction) {
    // Libera a posição atual.
    this.getPosition().setPiece(null);

    // Calcula a chave da nova posição indo na direção.
    MoveValidator validator = MoveValidator.getInstance();
    Key nextKey = direction.getNextPosition(this.position.getX(), this.position.getY());
    
    // Busca a nova posição usando a chave calculada.
    Position position = this.board.getPosition(nextKey);
    
    // Coloca a peça na nova posição, de fato.
    position.setPiece(this);

    return nextKey;
  }
  
  @Override
  public String toString() {
    return "JA";
  }
}
