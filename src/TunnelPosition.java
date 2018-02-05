import java.lang.Math;

public class TunnelPosition {
    private double pos;

    public TunnelPosition(double initial) {
        pos = initial;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } 

        if (!(o instanceof TunnelPosition)) {
            return false;
        } 
        
        TunnelPosition other = (TunnelPosition)o;
        return (Math.abs(other.pos - this.pos) < Constants.TUNNEL_SIZE);
    }
}