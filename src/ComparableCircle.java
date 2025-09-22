class ComparableCircle extends Circle implements Comparable<GeometricObject> {
    public ComparableCircle(double radius) { super(radius); }

    @Override
    public int compareTo(GeometricObject other) {
        return Double.compare(this.getArea(), other.getArea());
    }
}
