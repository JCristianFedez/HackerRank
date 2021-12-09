package Advanced.JavaVisitorPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 *
 * Input:
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
 *
 * Output:
24
40
15
 *
 */

enum Color {
    RED, GREEN
}

abstract class Tree {

    private final int value;
    private final Color color;
    private final int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private final ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    private int sumInLeaves = 0;

    public int getResult() {
        return sumInLeaves;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        this.sumInLeaves += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if(node.getColor().equals(Color.RED)) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor().equals(Color.RED)) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int evenDepthNonLeavesSum = 0;
    private int greenLeavesSum = 0;

    public int getResult() {
        return Math.abs(evenDepthNonLeavesSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() % 2 == 0){
            evenDepthNonLeavesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor().equals(Color.GREEN)){
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class Solution {

    private static int[] nodeValues = null;
    private static Color[] nodeColors = null;
    private static Map<Integer, Set<Integer>> nodesMap = null;

    public static Tree solve() {
        final Scanner scanner = new Scanner(System.in);
        int numberOfNodes = scanner.nextInt();

        nodesMap = new HashMap<>();
        nodeValues = new int[numberOfNodes];
        nodeColors = new Color[numberOfNodes];

        for(int index = 0; index < numberOfNodes; index++) {
            nodeValues[index] = scanner.nextInt();
        }

        for(int index = 0; index < numberOfNodes; index++) {
            nodeColors[index] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
        }

        Tree rootNode;
        if(numberOfNodes == 1) {
            rootNode = new TreeLeaf(nodeValues[0], nodeColors[0], 0);
        }
        else {
            for(int index = 0; index < (numberOfNodes - 1); index++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                Set<Integer> uEdges = nodesMap.get(u);
                if(uEdges == null) {
                    uEdges = new HashSet<>();
                }
                uEdges.add(v);
                nodesMap.put(u, uEdges);
                Set<Integer> vEdges = nodesMap.get(v);
                if(vEdges == null) {
                    vEdges = new HashSet<>();
                }
                vEdges.add(u);
                nodesMap.put(v, vEdges);
            }

            rootNode = new TreeNode(nodeValues[0], nodeColors[0], 0);
            Set<Integer> rootEdges = nodesMap.get(1);
            Iterator<Integer> rootIterator = rootEdges.iterator();
            while(rootIterator.hasNext()) {
                Integer nodeIdentifier = rootIterator.next();
                nodesMap.get(nodeIdentifier).remove(1);
                createEdge(rootNode, nodeIdentifier);
            }
        }
        return rootNode;
    }

    private static void createEdge(Tree parentNode, Integer nodeIdentifier) {

        Set<Integer> nodeEdges = nodesMap.get(nodeIdentifier);
        boolean hasChild = false;
        if (nodeEdges != null && !nodeEdges.isEmpty())
            hasChild = true;

        if (hasChild) {
            TreeNode node = new TreeNode(nodeValues[nodeIdentifier - 1], nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
            ((TreeNode) parentNode).addChild(node);
            Iterator<Integer> nodeIterator = nodeEdges.iterator();
            while (nodeIterator.hasNext()) {
                Integer neighborNodeIdentifier = nodeIterator.next();
                nodesMap.get(neighborNodeIdentifier).remove(nodeIdentifier);
                createEdge(node, neighborNodeIdentifier);
            }
        } else {
            TreeLeaf leaf = new TreeLeaf(nodeValues[nodeIdentifier - 1], nodeColors[nodeIdentifier - 1], parentNode.getDepth() + 1);
            ((TreeNode) parentNode).addChild(leaf);
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}