package ar.edu.itba.ss.hourglass.utils;

import ar.edu.itba.ss.hourglass.models.Particle;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Provides {@link Particle}s to the system.
 */
public class ParticleProvider {

    /**
     * The min. radius of a {@link Particle}.
     */
    private final double minRadius;
    /**
     * The max. radius of a {@link Particle}.
     */
    private final double maxRadius;
    /**
     * The {@link Particle}s' mass.
     */
    private final double mass;
    /**
     * The min. value for a position ('x' component).
     */
    private final double xMin;
    /**
     * The max. value for a position ('x' component).
     */
    private final double xMax;
    /**
     * The min. value for a position ('y' component).
     */
    private final double yMin;
    /**
     * The max. value for a position ('y' component).
     */
    private final double yMax;


    /**
     * Constructor.
     *
     * @param minRadius The min. radius of a {@link Particle}.
     * @param maxRadius The max. radius of a {@link Particle}.
     * @param mass      The mass of a {@link Particle}.
     * @param xMin      The min. value for a position ('x' component).
     * @param xMax      The max. value for a position ('x' component).
     * @param yMin      The min. value for a position ('y' component).
     * @param yMax      The max. value for a position ('y' component).
     */
    public ParticleProvider(final double minRadius, final double maxRadius, final double mass,
                            final double xMin, final double xMax, final double yMin, final double yMax) {
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;
        this.mass = mass;
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    /**
     * Creates the needed {@link Particle}s.
     *
     * @return A {@link List} with the created {@link Particle}s.
     */
    public List<Particle> createParticles() {
        final List<Particle> particles = new LinkedList<>();
        boolean addMore = true;
        while (addMore) {
            final double xPosition = xMin + new Random().nextDouble() * (xMax - xMin);
            final double yPosition = yMin + new Random().nextDouble() * (yMax - yMin);
            final Vector2D position = new Vector2D(xPosition, yPosition);
            final double radius = minRadius + new Random().nextDouble() * (maxRadius - minRadius);
            if (particles.stream().noneMatch(p -> p.doOverlap(position, radius))) {
                particles.add(new Particle(this.mass, radius, position, Vector2D.ZERO, Vector2D.ZERO));
                addMore = canAddMore(particles); // Check if more particles can be added.
            }
        }
        return particles;
    }

    /**
     * Indicates whether more {@link Particle}s can be added into the given {@code particles} {@link List}.
     *
     * @param particles The {@link List} of {@link Particle}s.
     * @return {@code true} if more {@link Particle}s can be added, or {@code false} otherwise.
     */
    private boolean canAddMore(final List<Particle> particles) {
        return true; // TODO: check how to modify this.
    }
}
