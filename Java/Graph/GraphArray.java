package Graph;

import java.util.ArrayList;

// this will be an directional graph
public class GraphArray {
    // number of vertices and edges
    private int vCount, eCount;

    // each of the elements inside adjacents will be an arrayList
    private ArrayList[] adjacents;

    public GraphArray(int vCount){
        this.vCount = vCount;
        this.eCount = 0;
        this.adjacents = new ArrayList[vCount];

        for (int i = 0; i < vCount; i++){
            adjacents[i] = new ArrayList<Integer>();
        }
    }

    public int getVertexCount(){
        return vCount;
    }

    public int getEdgeCount(){
        return eCount;
    }

    // add the edge between each vertex
    public void addEdge(int src, int dest){
        adjacents[src].add(dest);
        eCount++;
    }

    // return all of the adjacent vertices
    public Object[] adj(int src){
        return adjacents[src].toArray();
    }


}
