package PlasticConservation;

public class Plastic {
        static double min_cost(Position[] positions) {
                Vertex [] vertices = Vertex.make_graph(positions);

                // edge case
                if (vertices == null) {
                        return 0.0;
                }

                int size = vertices.length;
                boolean []visited = new boolean[size];
                double res = 0.0;
                double minDist;
                int curNode = 0;
                int nextNode = 0;

                // visit every node
                for (int i = 0; i < size - 1; i++) {
                        // mark node as visited
                        visited[curNode] = true;
                        minDist = Double.MAX_VALUE;
                        // visit each node connect with the current node
                        for (int index = 0; index < size; index++) {
                                // if already visited, continue
                                if(visited[index]) {
                                        continue;
                                }
                                // edge connect current node with other nodes
                                Edge edge = new Edge(vertices[curNode].pos, curNode, vertices[index].pos, index);
                                vertices[index].min_length = Math.min(edge.length, vertices[index].min_length);
                                if (vertices[index].min_length < minDist) {
                                        minDist = vertices[index].min_length;
                                        // after we find the min distance, this is the node we need to look for min distance in the next round
                                        nextNode = index;
                                }
                        }
                        res += minDist;
                        curNode = nextNode;
                }
                return res;

        }
}
