package PlasticConservation;

public class Edge {
        double length;
        int index1, index2; // indices into original PlasticConservation.Position[] array
        Edge(Position pos1, int idx1, Position pos2, int idx2) {
                index1 = idx1;
                index2 = idx2;
                double xsquared = (pos1.x - pos2.x) * (pos1.x - pos2.x) ;
                double ysquared = (pos1.y - pos2.y) * (pos1.y - pos2.y) ;
                length = Math.sqrt(xsquared + ysquared) ;
        }
}
