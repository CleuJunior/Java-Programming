class Robot {

    private GridPosition position;
    private Orientation orientation;
    private int x;
    private int y;

    public Robot(GridPosition initialPosition, Orientation initialOrientation) {
        this.position = initialPosition;
        this.orientation = initialOrientation;
        this.x = initialPosition.x;
        this.y = initialPosition.y;
    }

    public GridPosition getGridPosition() {
        return this.position;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void advance() {
        if (this.orientation == Orientation.NORTH) {
            this.y++;
            this.position = new GridPosition(this.x, this.y);
            return;
        }

        if (this.orientation == Orientation.SOUTH) {
            this.y--;
            this.position = new GridPosition(this.x, this.y);
            return;
        }

        if (this.orientation == Orientation.EAST) {
            this.x++;
            this.position = new GridPosition(this.x, this.y);
            return;
        }

        if (this.orientation == Orientation.WEST) {
            this.x--;
            this.position = new GridPosition(this.x, this.y);
        }
    }

    public void turnLeft() {
        switch (this.orientation) {
            case NORTH:
                this.orientation = Orientation.WEST;
                break;
            case WEST:
                this.orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.orientation = Orientation.EAST;
                break;
            case EAST:
                this.orientation = Orientation.NORTH;
                break;
        }
    }

    public void turnRight() {
        switch (this.orientation) {
            case NORTH:
                this.orientation = Orientation.EAST;
                break;
            case EAST:
                this.orientation = Orientation.SOUTH;
                break;
            case SOUTH:
                this.orientation = Orientation.WEST;
                break;
            case WEST:
                this.orientation = Orientation.NORTH;
                break;
        }
    }

    public void simulate(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    this.turnLeft();
                    break;
                case 'R':
                    this.turnRight();
                    break;
                case 'A':
                    this.advance();
                    break;
            }
        }
    }

}