package GameBoard;

import GameBoard.util.Type;
import GameBoard.util.Position;
import GameBoard.util.Couleur;
import java.util.ArrayList;

public class Damier {

    private Case[][] lesCases;
    private int taille;

    public Damier(int taille) {
        this.taille = taille;
        assert (taille > 0);
        this.lesCases = new Case[taille][taille];
    }

    public Case getCase(int ligne, int colonne) {
        return this.lesCases[ligne][colonne];
    }

    public void initialise() {
        int taille = this.lesCases.length;
        for (int ligne = 0; ligne < taille; ligne++) {
            for (int colonne = 0; colonne < taille; colonne++) {
                this.lesCases[ligne][colonne] = new Case(new Position(ligne, colonne));
                Case current_case = this.lesCases[ligne][colonne];
                if (ligne < (taille / 2 - 1)) {
                    if ((ligne % 2 == 0 && colonne % 2 == 1) || (ligne % 2 == 1 && colonne % 2 == 0)) {
                        //DEBUG
                        //System.out.println(ligne + " " + colonne);
                        Piece piece = new Piece(Couleur.White);
                        current_case.setPiece(piece);
                    }
                } else if (ligne >= (taille / 2 + 1)) {
                    if ((ligne % 2 == 0 && colonne % 2 == 1) || (ligne % 2 == 1 && colonne % 2 == 0)) {
                        Piece piece = new Piece(Couleur.Black);
                        current_case.setPiece(piece);
                    }
                }
            }
        }
    }

    public boolean mouvementPossible(Position p1, Position p2) {
        boolean aDroite = false;
        boolean aLavant = false;
        if (lesCases[p1.getX()][p1.getY()].getPiece() != null && lesCases[p2.getX()][p2.getY()].getPiece() == null) {
            if (lesCases[p1.getX()][p1.getY()].getPiece().getType() == Type.Pion) {
                if (lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() == Couleur.White) {
                    if (p1.getY() > p2.getY()) {
                        System.out.println("A droite");
                        aDroite = true;
                    } else {
                        System.out.println("A gauche");

                        aDroite = false;
                    }
                    if (p1.getX() > p2.getX()) {
                        aLavant = false;
                    } else {
                        aLavant = true;
                    }

                    if ((p1.getY() > p2.getY() && p1.getY() - p2.getY() == 1 || (p1.getY() < p2.getY() && p2.getY() - p1.getY() == 1)) && p1.getX() - p2.getX() == -1) {
                        System.out.println(p1.getX() + " " + p2.getX() + " " + p1.getY() + " " + p2.getY());
                        return true;
                    } else if ((p1.getY() > p2.getY() && p1.getY() - p2.getY() == 2 || (p1.getY() < p2.getY() && p2.getY() - p1.getY() == 2))
                            && (p1.getX() - p2.getX() == -2 || p1.getX() - p2.getX() == 2)) {
                        System.out.println("Possible to maybe eat");
                        if (aDroite && aLavant && lesCases[p1.getX() + 1][p1.getY() - 1].getPiece() != null && lesCases[p1.getX() + 1][p1.getY() - 1].getPiece().getCouleur() == Couleur.Black) {
                            return true;
                        } else if (aDroite && !aLavant && lesCases[p1.getX() - 1][p1.getY() - 1].getPiece() != null && lesCases[p1.getX() - 1][p1.getY() - 1].getPiece().getCouleur() == Couleur.Black) {
                            return true;
                        } else if (!aDroite && aLavant && lesCases[p1.getX() + 1][p1.getY() + 1].getPiece() != null && lesCases[p1.getX() + 1][p1.getY() + 1].getPiece().getCouleur() == Couleur.Black) {
                            return true;
                        } else if (!aDroite && !aLavant && lesCases[p1.getX() - 1][p1.getY() + 1].getPiece() != null && lesCases[p1.getX() - 1][p1.getY() + 1].getPiece().getCouleur() == Couleur.Black) {
                            return true;
                        } else {
                            System.out.println("Oh Fuck");
                            return false;
                        }
                    } else {
                        System.out.println(p1.getX() + " " + p2.getX() + " " + p1.getY() + " " + p2.getY());
                        return false;
                    }
                } else if (lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() == Couleur.Black) {
                    if (p1.getY() > p2.getY()) {
                        aDroite = false;
                    } else {
                        aDroite = true;
                    }
                    if (p1.getX() > p2.getX()) {
                        aLavant = true;
                    } else {
                        aLavant = false;
                    }

                    if ((p1.getY() > p2.getY() && p1.getY() - p2.getY() == 1 || (p1.getY() < p2.getY() && p2.getY() - p1.getY() == 1)) && p1.getX() - p2.getX() == 1) {
                        return true;
                    } else if ((p1.getY() > p2.getY() && p1.getY() - p2.getY() == 2 || (p1.getY() < p2.getY() && p2.getY() - p1.getY() == 2))
                            && (p1.getX() - p2.getX() == 2 || p1.getX() - p2.getX() == -2)) {
                        if (aDroite && aLavant && lesCases[p1.getX() - 1][p1.getY() + 1].getPiece() != null && lesCases[p1.getX() - 1][p1.getY() + 1].getPiece().getCouleur() == Couleur.White) {
                            return true;
                        } else if (aDroite && !aLavant && lesCases[p1.getX() + 1][p1.getY() + 1].getPiece() != null && lesCases[p1.getX() + 1][p1.getY() + 1].getPiece().getCouleur() == Couleur.White) {
                            return true;
                        } else if (!aDroite && aLavant && lesCases[p1.getX() - 1][p1.getY() - 1].getPiece() != null && lesCases[p1.getX() - 1][p1.getY() - 1].getPiece().getCouleur() == Couleur.White) {
                            return true;
                        } else if (!aDroite && !aLavant && lesCases[p1.getX() + 1][p1.getY() - 1].getPiece() != null && lesCases[p1.getX() + 1][p1.getY() - 1].getPiece().getCouleur() == Couleur.White) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                //A CODER POUR LES DAMES !!!
                int size;
                if (p1.getY() > p2.getY()) {
                    aDroite = false;
                    size = p1.getY() - p2.getY();
                } else {
                    aDroite = true;
                    size = p2.getY() - p1.getY();
                }
                if (p1.getX() > p2.getX()) {
                    aLavant = true;
                } else {
                    aLavant = false;
                }
                boolean oppositeColorFound = false;
                boolean problemFound = false;
                for (int i = 0; i < size; i++) {
                    if (aLavant) {
                        if (aDroite) {
                            if (lesCases[p1.getX() - size][p1.getY() + size].getPiece() != null
                                    && (lesCases[p1.getX() - size][p1.getY() + size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())
                                    || (lesCases[p1.getX() - size][p1.getY() + size].getPiece().getCouleur() != lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() && oppositeColorFound)) {
                                problemFound = true;
                            } else if (lesCases[p1.getX() - size][p1.getY() + size].getPiece() != null
                                    && (lesCases[p1.getX() - size][p1.getY() + size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())) {
                                oppositeColorFound = true;
                            }
                        } else {
                            if (lesCases[p1.getX() - size][p1.getY() - size].getPiece() != null
                                    && (lesCases[p1.getX() - size][p1.getY() - size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())
                                    || (lesCases[p1.getX() - size][p1.getY() - size].getPiece().getCouleur() != lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() && oppositeColorFound)) {
                                problemFound = true;
                            } else if (lesCases[p1.getX() - size][p1.getY() - size].getPiece() != null
                                    && (lesCases[p1.getX() - size][p1.getY() - size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())) {
                                oppositeColorFound = true;
                            }
                        }
                    } else {
                        if (aDroite) {
                            if (lesCases[p1.getX() + size][p1.getY() + size].getPiece() != null
                                    && (lesCases[p1.getX() + size][p1.getY() + size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())
                                    || (lesCases[p1.getX() + size][p1.getY() + size].getPiece().getCouleur() != lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() && oppositeColorFound)) {
                                problemFound = true;
                            } else if (lesCases[p1.getX() + size][p1.getY() + size].getPiece() != null
                                    && (lesCases[p1.getX() + size][p1.getY() + size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())) {
                                oppositeColorFound = true;
                            }
                        } else {
                            if (lesCases[p1.getX() + size][p1.getY() - size].getPiece() != null
                                    && (lesCases[p1.getX() + size][p1.getY() - size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())
                                    || (lesCases[p1.getX() + size][p1.getY() - size].getPiece().getCouleur() != lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() && oppositeColorFound)) {
                                problemFound = true;
                            } else if (lesCases[p1.getX() + size][p1.getY() - size].getPiece() != null
                                    && (lesCases[p1.getX() + size][p1.getY() - size].getPiece().getCouleur() == lesCases[p1.getX()][p1.getY()].getPiece().getCouleur())) {
                                oppositeColorFound = true;
                            }
                        }

                    }

                }

                return false;
            }
        } else {
            return false;
        }
    }

    public Position mouvement(Position p1, Position p2) {
        int value = 0;
        Position eatenPiece = null;
        if (p2.getX() > p1.getX()) {
            value = 1;
        } else {
            value = -1;
        }

        if (mouvementPossible(p1, p2)) {
            if ((p1.getX() - p2.getX() > 1 || p1.getX() - p2.getX() < 1)) {
                if (p2.getY() > p1.getY()) {
                    eatenPiece = new Position(p1.getX() + value, p1.getY() + 1);
                    lesCases[p1.getX() + value][p1.getY() + 1].setPiece(null);
                } else {
                    eatenPiece = new Position(p1.getX() + value, p1.getY() - 1);
                    lesCases[p1.getX() + value][p1.getY() - 1].setPiece(null);
                }

            }
            lesCases[p2.getX()][p2.getY()].setPiece(lesCases[p1.getX()][p1.getY()].getPiece());
            lesCases[p1.getX()][p1.getY()].setPiece(null);
            if ((p2.getX() == 0 || p2.getX() == lesCases.length - 1) && lesCases[p2.getX()][p2.getY()].getPiece().getType() == Type.Pion) {
                lesCases[p2.getX()][p2.getY()].getPiece().setType(Type.Dame);
                System.out.println("I Have a DAME");
            }
        }
        return eatenPiece;
    }

    public int getTaille() {
        return taille;
    }

    /**
     *
     * @param selectedCase
     * @param listePositions
     * @return
     */
    public boolean oneMoreMouvementPossible(Case selectedCase, ArrayList<Position> listePositions, Couleur currentColor) {
        boolean return_state = false;
        switch (selectedCase.getPiece().getType()) {
            case Dame:
                break;
            case Pion:
                if (PionMoreMouvementPossible(selectedCase, listePositions, currentColor)) {
                    return_state = true;
                } else {
                    System.out.println("Not more pieces eaten");
                }
                break;


        }

        return return_state;
    }

    private boolean PionMoreMouvementPossible(Case selectedCase, ArrayList<Position> listePositions, Couleur currentColor) {
        boolean return_state = false;
        if ((selectedCase.getPosition().getX() + 2 < taille) && (selectedCase.getPosition().getY() + 2 < taille)
                && (mouvementPossible(selectedCase.getPosition(), this.getCase(selectedCase.getPosition().getX() + 2, selectedCase.getPosition().getY() + 2).getPosition()))) {
            System.out.println("test1");
            return_state = true;
            for (Position p : listePositions) {
                if (p.getX() == selectedCase.getPosition().getX() + 2 && p.getY() == selectedCase.getPosition().getY() + 2) {
                    return_state = false;
                }
            }
            if (return_state) {
                return return_state;
            }
        }
        if ((selectedCase.getPosition().getX() + 2 < taille) && (selectedCase.getPosition().getY() - 2 > 0)
                && (mouvementPossible(selectedCase.getPosition(), this.getCase(selectedCase.getPosition().getX() + 2, selectedCase.getPosition().getY() - 2).getPosition()))) {
            return_state = true;
            for (Position p : listePositions) {
                if (p.getX() == selectedCase.getPosition().getX() + 2 && p.getY() == selectedCase.getPosition().getY() - 2) {
                    return_state = false;
                }
            }
            System.out.println(return_state);
            if (return_state) {
                return return_state;
            }
        }
        if ((selectedCase.getPosition().getX() - 2 > 0) && (selectedCase.getPosition().getY() + 2 < taille)
                && (mouvementPossible(selectedCase.getPosition(), this.getCase(selectedCase.getPosition().getX() - 2, selectedCase.getPosition().getY() + 2).getPosition()))) {
            return_state = true;
            System.out.println("test3");
            for (Position p : listePositions) {

                if (p.getX() == selectedCase.getPosition().getX() - 2 && p.getY() == selectedCase.getPosition().getY() + 2) {
                    return_state = false;
                }
            }
            if (return_state) {
                return return_state;
            }
        }
        if ((selectedCase.getPosition().getX() - 2 > 0) && (selectedCase.getPosition().getY() - 2 > 0)
                && (mouvementPossible(selectedCase.getPosition(), this.getCase(selectedCase.getPosition().getX() - 2, selectedCase.getPosition().getY() - 2).getPosition()))) {
            return_state = true;
            System.out.println("test4");
            for (Position p : listePositions) {
                if (p.getX() == selectedCase.getPosition().getX() - 2 && p.getY() == selectedCase.getPosition().getY() - 2) {
                    return_state = false;
                }
            }
            if (return_state) {
                return return_state;
            }
        }
        return return_state;
    }
}
