package airport.airport.locations;

public enum RunwayDirection {
    L26, R26, L08, R08;
    private ControlPoint controlPoint;

    public void setControlPoint(final ControlPoint controlPoint)
    {
        this.controlPoint = controlPoint;
    }

    public ControlPoint getControlPoint()
    {
        return controlPoint;
    }

}

