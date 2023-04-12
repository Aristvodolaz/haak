package com.example.hakatonapp.data;

public class RoutesData {
    String startPoint;
    String endPoint;
    int countPassengers;
    String coast;
    String timeRoute;
    String dateRoute;

    public RoutesData(){

    }
    public RoutesData(String startPoint, String endPoint, int countPassengers,
                      String coast, String timeRoute, String dateRoute){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.countPassengers = countPassengers;
        this.coast = coast;
        this.timeRoute = timeRoute;
        this.dateRoute = dateRoute;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public int getCountPassengers() {
        return countPassengers;
    }

    public String getCoast() {
        return coast;
    }

    public String getTimeRoute() {
        return timeRoute;
    }

    public String getDateRoute() {
        return dateRoute;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public void setCoast(String coast) {
        this.coast = coast;
    }

    public void setTimeRoute(String timeRoute) {
        this.timeRoute = timeRoute;
    }

    public void setDateRoute(String dateRoute) {
        this.dateRoute = dateRoute;
    }
}
