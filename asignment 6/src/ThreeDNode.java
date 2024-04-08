import java.util.ArrayList;
import java.util.Random;

public class ThreeDNode {
    public static void main(String []args) {


// Interface representing a node
        interface INode {
            int getX();
            int getY();
        }

// Class representing a 2D node
        class Node implements INode {
            private static final int MIN_COORDINATE = -100;
            private static final int MAX_COORDINATE = 100;

            private int x;
            private int y;

            public Node() {
                this(0, 0);
            }

            public Node(int x, int y) {
                setX(x);
                setY(y);
            }

            public Node(Node other) {
                this.x = other.x;
                this.y = other.y;
            }
            public int getX() {
                return x;
            }

            public void setX(int x) {
                if (x < MIN_COORDINATE || x > MAX_COORDINATE) {
                    throw new IllegalArgumentException("X coordinate out of range");
                }
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                if (y < MIN_COORDINATE || y > MAX_COORDINATE) {
                    throw new IllegalArgumentException("Y coordinate out of range");
                }
                this.y = y;
            }

            @Override
            public String toString() {
                return "(" + x + ", " + y + ")";
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof Node)) return false;
                Node other = (Node) obj;
                return this.x == other.x && this.y == other.y;
            }
        }

// Class representing a 3D node extending Node
        class threednode extends Node {
            private int z;

            public threednode() {
                this(0, 0, 0);
            }

            public threednode(int x, int y, int z) {
                super(x, y);
                setZ(z);
            }

            public threednode(threednode other) {
                this(other.getX(), other.getY(), other.getZ());
            }

            public int getZ() {
                return z;
            }

            public void setZ(int z) {
                if (z < Node.MIN_COORDINATE || z > Node.MAX_COORDINATE) {
                    throw new IllegalArgumentException("Z coordinate out of range");
                }
                this.z = z;
            }

            public void add(threednode other) {
                super.setX(super.getX() + other.getX());
                super.setY(super.getY() + other.getY());
                setZ(z + other.getZ());
            }

            @Override
            public String toString() {
                return "(" + getX() + ", " + getY() + ", " + z + ")";
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof threednode)) return false;
                threednode other = (threednode) obj;
                return super.equals(obj) && this.z == other.z;
            }
        }

// Class representing a list of nodes
        class Nodes {

            private ArrayList<INode> nodeList;
            private Random random;

            public Nodes() {
                nodeList = new ArrayList<>();
                random = new Random();
            }

            public void fill(int size) {
                nodeList.clear();
                for (int i = 0; i < size; i++) {
                    if (random.nextBoolean()) {
                        nodeList.add(new Node(random.nextInt(201) - 100, random.nextInt(201) - 100));
                    } else {
                        nodeList.add(new threednode(random.nextInt(201) - 100, random.nextInt(201) - 100, random.nextInt(201) - 100));
                    }
                }
            }

            public void clear() {
                nodeList.clear();
            }

            public int countNodes() {
                int count = 0;
                for (INode node : nodeList) {
                    if (node instanceof Node) {
                        count++;
                    }
                }
                return count;
            }

            public int countThreeDNodes() {
                int count = 0;
                for (INode node : nodeList) {
                    if (node instanceof threednode) {
                        count++;
                    }
                }
                return count;
            }

            public void sort() {
                nodeList.sort((node1, node2) -> {
                    int sum1 = node1.getX() + node1.getY();
                    if (node1 instanceof threednode) {
                        sum1 += ((threednode) node1).getZ();
                    }
                    int sum2 = node2.getX() + node2.getY();
                    if (node2 instanceof threednode) {
                        sum2 += ((threednode) node2).getZ();
                    }
                    return Integer.compare(sum1, sum2);
                });
            }

            @Override
            public String toString() {
                StringBuilder builder = new StringBuilder();
                for (INode node : nodeList) {
                    builder.append(node.toString()).append("\n");
                }
                return builder.toString();
            }
        }

// Class for sorting nodes
        class Sorter {
            // Implemented as a lambda expression in the sort method of Nodes
        }

// Class for driving the program
        class Driver {
            public static void main(String[] args) {
                Nodes nodes = new Nodes();
                while (true) {
                    // Display menu
                    System.out.println("Menu:");
                    System.out.println("1. Fill");
                    System.out.println("2. Clear");
                    System.out.println("3. Count Nodes");
                    System.out.println("4. Count ThreeDNodes");
                    System.out.println("5. Sort");
                    System.out.println("6. Display");
                    System.out.println("7. Exit");
                    System.out.print("Enter your choice: ");

                    // Get user choice
                    int choice = Integer.parseInt(System.console().readLine());

                    // Perform corresponding operation
                    switch (choice) {
                        case 1:
                            nodes.fill(20); // Example size, you can modify as needed
                            break;
                        case 2:
                            nodes.clear();
                            break;
                        case 3:
                            System.out.println("Number of Nodes: " + nodes.countNodes());
                            break;
                        case 4:
                            System.out.println("Number of ThreeDNodes: " + nodes.countThreeDNodes());
                            break;
                        case 5:
                            nodes.sort();
                            break;
                        case 6:
                            System.out.println(nodes.toString());
                            break;
                        case 7:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                }
            }
        }



    }

}
