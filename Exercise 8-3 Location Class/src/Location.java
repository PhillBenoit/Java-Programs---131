
public class Location {
    public double maxValue;
    public int row, column, occurrences;
    
    public Location() {
        maxValue = 0;
        row = 0;
        column = 0;
        occurrences = 1;
    }
    
    public Location(double maxValue, int row, int column) {
        this.maxValue = maxValue;
        this.row = row;
        this.column = column;
        occurrences = 1;
    }
    
    private void Compare(Location testLocation) {
        if (maxValue < testLocation.maxValue) {
            maxValue = testLocation.maxValue;
            row = testLocation.row;
            column = testLocation.column;
            occurrences = 1;
        } else if (maxValue == testLocation.maxValue) {
            occurrences++;
        }
    }
    
    public static Location locateLargest(double[][] a) {
        Location greatest = new Location();
        for (int row = 0; row < a.length; row++) {
            for (int column = 0; column < a[row].length; column++) {
                Location testLocation = new Location(a[row][column], row, column);
                greatest.Compare(testLocation);
            }
        }
        return greatest;
    }

}
