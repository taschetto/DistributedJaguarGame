package jaguar.server.game;

import jaguar.common.Direction;

/**
 *
 * @author Guilherme Taschetto
 */
public class Jaguar extends Piece {

  public Jaguar(Board board) {
    super(board);
  }
  
  @Override
  public boolean canMove(Direction direction)
  {
    if (direction == null) return false;
    
    int x = this.position.getX(),
        y = this.position.getY();
    
    // Valida se a direção é válida a partir da posição atual.
    if (!this.board.isMoveValid(x, y, direction)) return false;
      
    // Se a direção é válida, calcula qual será a nova posição.
    Position next = this.board.getNextPosition(x, y, direction);
    
    // Se a nova posição está vazia, pode mover.
    if (next.isEmpty()) return true;
    
    // Do contrário...
    
    x = next.getX();
    y = next.getY();
    
    // Valida se a mesma direção é válida a partir da nova posição.
    if (!this.board.isMoveValid(x, y, direction)) return false;
    
    // Se a direção é válida, calcula a "nova nova" posição.
    Position nextNext = this.board.getNextPosition(x, y, direction);
    
    // Se a "nova nova" posição está vazia, pode mover.
    return nextNext.isEmpty();
  }

  @Override
  public void move(Direction direction) {
    // Ao iniciar este método, é GARANTIDO que o Jaguar pode mover-se na
    // direção, seja para andar ou para comer um cachorro.
    
    int x = this.position.getX(),
        y = this.position.getY();
    
    // Libera a posição atual.
    this.position.setPiece(null);

    // Calcula a nova posição da peça.
    Position next = this.board.getNextPosition(x, y, direction);
    
    // Se a próxima posição está vazia, o Jaguar simplesmente move-se para lá.
    if (next.isEmpty()) {
      next.setPiece(this);
    } else {
      // Se não, em 'next' há um cachorro que pode ser comido. Primeiro, devemos
      // devolver o cachorro ao lugar de onde nunca deveria ter saído: o céu.
      
      // Transforma o cachorro em HISTÓRIA.
      Dog dog = (Dog)next.getPiece();
      this.board.eatDog(dog.getId());
      next.setPiece(null);
      
      // Em seguida, calculamos a posição do Jaguar após comer o cachorro.
      x = next.getX();
      y = next.getY();
      Position nextNext = this.board.getNextPosition(x, y, direction);
      nextNext.setPiece(this);
    }
  }
  
  @Override
  public String toString() {
    return "JA";
  }
}
