package a5;

public class node {
    public static void main(String[] args){

        class Node {
            private static final int MIN_COORDINATE = -100;
            private static final int MAX_COORDINATE = 100;

            private int x;
            private int y;

            /**
             * Default constructor. Sets x and y to zero.
             */
            public Node() {
                this(0, 0);
            }

            /**
             * Constructor with given x and y coordinates.
             * @param x The x coordinate.
             * @param y The y coordinate.
             * @throws IllegalArgumentException if x or y is out of range.
             */
            public Node(int x, int y) {
                setX(x);
                setY(y);
            }

            /**
             * Copy constructor.
             * @param other The Node object to copy.
             */
            public Node(Node other) {
                this(other.x, other.y);
            }

            /**
             * Get the x coordinate of the Node.
             * @return The x coordinate.
             */
            public int getX() {
                return x;
            }

            /**
             * Set the x coordinate of the Node.
             * @param x The new x coordinate.
             * @throws IllegalArgumentException if x is out of range.
             */
            public void setX(int x) {
                if (x < MIN_COORDINATE || x > MAX_COORDINATE) {
                    throw new IllegalArgumentException("X coordinate out of range");
                }
                this.x = x;
            }

            /**
             * Get the y coordinate of the Node.
             * @return The y coordinate.
             */
            public int getY() {
                return y;
            }

            /**
             * Set the y coordinate of the Node.
             * @param y The new y coordinate.
             * @throws IllegalArgumentException if y is out of range.
             */
            public void setY(int y) {
                if (y < MIN_COORDINATE || y > MAX_COORDINATE) {
                    throw new IllegalArgumentException("Y coordinate out of range");
                }
                this.y = y;
            }

            /**
             * Add another Node to this Node.
             * @param other The Node to add.
             * @throws IllegalArgumentException if the resulting coordinates are out of range.
             */
            public void add(Node other) {
                int newX = this.x + other.x;
                int newY = this.y + other.y;
                if (newX < MIN_COORDINATE || newX > MAX_COORDINATE ||
                        newY < MIN_COORDINATE || newY > MAX_COORDINATE) {
                    throw new IllegalArgumentException("Resulting coordinates out of range");
                }
                this.x = newX;
                this.y = newY;
            }

            /**
             * Overrides toString method to return a string that represents the Node.
             * @return String representation of the Node.
             */
            @Override
            public String toString() {
                return "(" + x + ", " + y + ")";
            }

            /**
             * Overrides equals method to check for nodes equality.
             * Two nodes are equal if they have the same values for x and y.
             * @param obj The object to compare.
             * @return True if the objects are equal, false otherwise.
             */
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (!(obj instanceof Node)) return false;
                Node other = (Node) obj;
                return this.x == other.x && this.y == other.y;
            }
        }




        }

}
