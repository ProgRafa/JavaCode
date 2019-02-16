package challenge.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.*;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.redis.core.index.GeoIndexed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe para mapear o bairro no MongoDB
 *
 */
@EntityScan
@Document(collection = "neighborhood")
public class NeighborhoodMongo {
    @Id
    private String id;
    private String name;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJson geometry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoJson getGeometry() {
        return geometry;
    }

    public void setGeometry(GeoJson geometry) {
        this.geometry = geometry;
    }
}
