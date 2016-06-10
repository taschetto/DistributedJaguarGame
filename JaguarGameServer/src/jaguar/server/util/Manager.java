package jaguar.server.util;

import jaguar.common.Direction;
import jaguar.common.PlayerType;

/**
 *
 * @author Guilherme Taschetto
 */
public class Manager {
  
  private PreRegistry preRegistry;
  private PlayerRegistry players;
  private GameRegistry games;

  public Manager(int maxPlayers) {
    this.preRegistry = new PreRegistry();
    this.players = new PlayerRegistry(maxPlayers);
    this.games = new GameRegistry();
  }
  
  public int preRegister(String playerName1, int playerId1, String playerName2, int playerId2) {
    this.preRegistry.add(playerName1, playerId1, playerName2, playerId2);
    
    return 0;
  }
  
  public int registerPlayer(String playerName) throws InterruptedException {
    if (this.players.isPlayerRegistered(playerName)) return -1;
    if (this.players.isMaxPlayersReached()) return -2;
    
    Player newPlayer = null;
    Game g = null;

    Record record = this.preRegistry.get(playerName);
    if (record != null) {
      int id = record.getPlayerId1();
      if (record.getPlayerName2().equals(playerName)) id = record.getPlayerId2();
      newPlayer = this.players.addPlayer(playerName, id);
      g = this.games.getGame(record);
    } else {
      newPlayer = this.players.addPlayer(playerName);
      g = this.games.getGame();
    }

    System.out.println("Registered player '" + newPlayer.getName() + "' with ID " + newPlayer.getId() + ".");
    newPlayer.setGame(g);
    
    return newPlayer.getId();
  }
  
  public int endGame(int playerId) throws InterruptedException {
    Player p = this.players.getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;
    
    this.endGame(p);

    return 0;
  }
  
  public int hasGame(int playerId) throws InterruptedException {
    Player p = this.players.getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;
    
    if (g.matchmakingTimeout()) {
      this.endGame(p);
      return -2;
    }
    
    if (g.hasPlayer1() && g.hasPlayer2()) {
      if (g.getPlayer1().equals(p)) return 1; // Player is JAGUAR!
      if (g.getPlayer2().equals(p)) return 2; // Player is DOGS!
      return -1; // Unexpected error
    }
    
    return 0; // No game available yet.
  }
  
  private void endGame(Player p) throws InterruptedException {
    Game g = p.getGame();
    if (g.isPlayer1(p)) {
      this.players.removePlayer(g.getPlayer1().getId());
      g.setPlayer1(null);
    }
    if (g.isPlayer2(p)) {
      this.players.removePlayer(g.getPlayer2().getId());
      g.setPlayer2(null);
    }
    
    if (!g.hasPlayer1() && !g.hasPlayer2()) this.games.endGame(g);
  }
  
  public int isMyTurn(int playerId) throws InterruptedException {
    Player p = this.players.getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;
    
    if (!g.hasPlayer1() || !g.hasPlayer2()) return -2;
    
    g.checkWinner();
    
    if (g.hasWinner()) {
      if (g.isWinnerByTimeout()) {
        if (g.isWinner(p)) {
          //this.endGame(p);
          return 5;
        }
        else {
          //this.endGame(p);
          return 6;
        }
      }
      else {
        if (g.isWinner(p)) {
          //this.endGame(p);
          return 2;
        }
        else {
          //this.endGame(p);
          return 3;
        }
      }
    }
    else {
      if (g.isPlayer1(p) && g.getTurn() == PlayerType.Jaguar) return 1;
      if (g.isPlayer2(p) && g.getTurn() == PlayerType.Dog) return 1;
      
      return 0;
    }    
  }
  
  public String getGrid(int playerId) throws InterruptedException {
    Player p = this.players.getPlayer(playerId);
    if (p == null) return "";
    Game g = p.getGame();
    if (g == null) return "";
    
    return g.getGrid();
  }
  
  public int sendMove(int playerId, int dogId, Direction direction) throws InterruptedException {
    Player p = this.players.getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;
    
    // Valida se é a vez do player
    if (g.getTurn() == PlayerType.Dog && p == g.getPlayer1()) return -3;
    if (g.getTurn() == PlayerType.Jaguar && p == g.getPlayer2()) return -3;
    
    // Valida se usou o animal certo
    if (dogId == -1 && p == g.getPlayer2()) return -4;
    if (dogId != -1 && p == g.getPlayer1()) return -4;
    
    return g.move(dogId, direction);
  }
  
  public String getOpponent(int playerId) throws InterruptedException {
    Player p = this.players.getPlayer(playerId);
    if (p == null) return "";
    Game g = p.getGame();
    if (g == null) return "";

    if (g.isPlayer1(p)) return g.getPlayer2().getName();
    else return g.getPlayer1().getName();
  }
}
