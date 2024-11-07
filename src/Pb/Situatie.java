package Pb;

import java.io.Serializable;

/**
 * Situatiile posibile in care se poate afla un produs (echipament electronic)
 *
 * @author Lemnaru Alin-Gabriel
 * @version 1
 * @since 2024-11-07
 */
public enum Situatie implements Serializable {
    achizitionat,
    expus,
    vandut
}
