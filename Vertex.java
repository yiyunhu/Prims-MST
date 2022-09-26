package PlasticConservation;

public class Vertex {
        Position pos;  // the position of this vertex
        Edge[] edges;  // the edges leaving this vertex
        Edge min_edge; // available for use by MST algorithm
        double min_length;
        int v;         // vertex number: its index in the original PlasticConservation.Position[] array
        int data;      // available for use by MST algorithm

        Vertex(Position[] positions, int index) {
                v = index;
                pos = positions[index];
                edges = new Edge[positions.length];
                min_edge = null;
                min_length = Double.POSITIVE_INFINITY;
        }

        // initialize edges from each vertex to all other vertices
        // you can ignore this function if you use make_graph() to convert
        // the array given to min_cost() into a graph
        public static void set_edges(Vertex[] vertices) {
                if (vertices.length < 1) return;
                for (int i = 0; i < vertices.length; i++) {
                        for (int j = 0; j < vertices.length; j++) {
                                Edge e ;
                                if (vertices[j].edges != null && vertices[j].edges[i] != null)
                                        e = vertices[j].edges[i];
                                else if (j != i)
                                        e = new Edge(vertices[i].pos,i,vertices[j].pos,j);
                                else
                                        e = null;
                                vertices[i].edges[j] = e;
                        }
                }
        }

        // initialize edge graph, which is the complete graph between all positions
        public static Vertex[] make_graph(Position[] positions) {
                if (positions == null) return new Vertex[0];
                Vertex[] vertices = new Vertex[positions.length];
                for (int i = 0 ; i < positions.length; i++) {
                        vertices[i] = new Vertex(positions,i) ;
                }
                Vertex.set_edges(vertices);
                return vertices;
        }
}
