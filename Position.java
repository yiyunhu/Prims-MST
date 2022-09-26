package PlasticConservation;

public class Position {
        short x, y;
        Position(int x_pos, int y_pos) { x = (short)x_pos; y = (short)y_pos ; }
        Position(Position pos) { x = pos.x ; y = pos.y ; }
}
