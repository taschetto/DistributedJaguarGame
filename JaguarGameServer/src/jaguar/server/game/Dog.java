package jaguar.server.game;

/**
 *
 * @author Guilherme Taschetto
 */
public class Dog extends Piece {
  private final int id;
  
  public Dog(int id, Board board) {
    super(board);
    this.id = id;
  }
  
  public int getId() {
    return this.id;
  }

  @Override
  public boolean canMove(Direction direction) {
    
    if (direction == null) return false;
    
    int x = this.position.getX(),
        y = this.position.getY();
    
    // Valida se a direção é válida a partir da posição atual.
    if (!this.board.isMoveValid(x, y, direction)) return false;
    
    // Depois verifica se a nova posição está vazia.
    Position next = this.board.getNextPosition(x, y, direction);
    return next.isEmpty();
  }

  @Override
  public void move(Direction direction) {
    // Ao iniciar este método, é GARANTIDO que o cachorro pode mover-se na
    // direção.
    
    int x = this.position.getX(),
        y = this.position.getY();

    // Libera a posição atual.
    this.position.setPiece(null);

    // Calcula a nova posição da peça.
    Position next = this.board.getNextPosition(x, y, direction);
    
    // Move a peça de fato.
    next.setPiece(this);
  }
  
  @Override
  public String toString() {
    return String.format("%02d", this.id);
  }
}
